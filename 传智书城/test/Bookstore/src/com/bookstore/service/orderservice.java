package com.bookstore.service;

import java.util.ArrayList;
import java.util.List;

import com.bookstore.*;
import com.bookstore.dao.BaseDao;
import com.bookstore.dao.orderdao;
import com.bookstore.po.Order;
import com.bookstore.po.OrderItem;
import com.bookstore.util.Expression;
import com.bookstore.util.PageBean;
import com.bookstore.util.PageConstants;

public class orderservice {
	BaseDao b = new BaseDao();
	orderdao o = new orderdao();
	public PageBean<Order> findall(int pc){
		List<Expression> list = new ArrayList<Expression>();
		return findByCriteria(list,pc);
	}
	private PageBean<Order> findByCriteria(List<Expression> exprList, int pc){
		/*
		 * 1. 得到ps
		 * 2. 得到tr
		 * 3. 得到beanList
		 * 4. 创建PageBean，返回
		 */
		/*
		 * 1. 得到ps
		 */
		int ps = PageConstants.ORDER_PAGE_SIZE;//每页记录数
		/*
		 * 2. 通过exprList来生成where子句
		 */
		StringBuilder whereSql = new StringBuilder(" where 1=1"); 
		List<Object> params = new ArrayList<Object>();//SQL中有问号，它是对应问号的值
		for(Expression expr : exprList) {
			/*
			 * 添加一个条件上，
			 * 1) 以and开头
			 * 2) 条件的名称
			 * 3) 条件的运算符，可以是=、!=、>、< ... is null，is null没有值
			 * 4) 如果条件不是is null，再追加问号，然后再向params中添加一与问号对应的值
			 */
			whereSql.append(" and ").append(expr.getName())
				.append(" ").append(expr.getOperator()).append(" ");
			// where 1=1 and bid = ?
			if(!expr.getOperator().equals("is null")) {
				whereSql.append("?");
				params.add(expr.getValue());
			}
		}

		/*
		 * 3. 总记录数 
		 */
		String sql = "select count(*) from t_order" + whereSql;
		Object[] param = params.toArray();
		Number number = b.getCount(sql, param);
		int tr = number.intValue();//得到了总记录数
		/*
		 * 4. 得到beanList，即当前页记录
		 */
		sql = "select * from t_order" + whereSql + " order by ordertime desc limit ?,?";
		params.add((pc-1) * ps);//当前页首行记录的下标
		params.add(ps);//一共查询几行，就是每页记录数
		Object[] param1 = params.toArray();
		List<Order> beanList = b.query(sql, Order.class, param1);
		// 虽然已经获取所有的订单，但每个订单中并没有订单条目。
		// 遍历每个订单，为其加载它的所有订单条目
		for(Order order : beanList) {
			loadOrderItem(order);
		}
		
		/*
		 * 5. 创建PageBean，设置参数
		 */
		PageBean<Order> pb = new PageBean<Order>();
		/*
		 * 其中PageBean没有url，这个任务由Servlet完成
		 */
		pb.setBeanList(beanList);
		pb.setPc(pc);
		pb.setPs(ps);
		pb.setTr(tr);
		
		return pb;
	}

	/*
	 * 为指定的order载它的所有OrderItem
	 */
	private void loadOrderItem(Order order){
		/*
		* 1. 给sql语句select * from t_orderitem where oid=?
		* 2. 执行之，得到List<OrderItem>
		* 3. 设置给Order对象
		*/
		String sql = "select * from t_orderitem where oid=?";
		Object[] params = {order.getOid()};
		List<OrderItem> orderItemList = b.query(sql, OrderItem.class, params);
		order.setOrderItemList(orderItemList);
	}
	
	public PageBean<Order> findbystatus(int status,int pc){
		List<Expression> list = new ArrayList<Expression>();
		list.add(new Expression("status","=",status+""));	
		return findByCriteria(list,pc);
	}
	
	public Order load(String oid) {
		String sql = "select * from t_order where oid = ?";
		Object[] params = {oid};
		Order oo = (Order) o.get(sql, Order.class, params);
		loadOrderItem(oo);
		return oo;
	}
	public int findstatus(String oid) {
		String sql = "select status from t_order where oid = ? ";
		Object[] params= {oid};
		Order order =(Order) o.get(sql, Order.class, params);
		return order.getStatus();
	}
	public void updatestatus(String oid,int status) {
		String sql = "update t_order set status = ? where oid =?";
		Object[] params= {status,oid};
		o.update(sql, params);
	}
}
