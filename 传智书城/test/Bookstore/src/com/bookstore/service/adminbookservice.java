package com.bookstore.service;

import java.util.ArrayList;
import java.util.List;

import com.bookstore.dao.BaseDao;
import com.bookstore.dao.adminbookdao;
import com.bookstore.po.Book;
import com.bookstore.util.*;

public class adminbookservice {
	adminbookdao a = new adminbookdao();

	public int findbookcountbyparent(String cid) {
		String sql = "select count(*) from t_book where cid = ?";
		Object[] params = { cid };
		Number num = a.getCount(sql, params);
		return num == null ? 0 : num.intValue();
	}

	public PageBean<Book> findbycombination(Book book, int pc) {
		List<Expression> list = new ArrayList();
		if (book.getBname() != null && !book.getBname().equals("")) {
			list.add(new Expression("bname", "like", "%" + book.getBname() + "%"));
		}
		if (book.getPid() != null && !book.getPid().equals("")) {
			list.add(new Expression("pid", "=", book.getPid()));
		}
		if (book.getCid() != null && !book.getCid().equals("")) {
			list.add(new Expression("b.cid", "=", book.getCid()));
		}
		if (book.getPress() != null && !book.getPress().equals("")) {
			list.add(new Expression("press", "like", "%" + book.getPress() + "%"));
		}
		if (book.getAuthor() != null && !book.getAuthor().equals("")) {
			list.add(new Expression("author", "like", "%" + book.getAuthor() + "%"));
		}
		return findByCriteria(list, pc);
	}

	/**
	 * 通用的查询方法
	 * 
	 * @param exprList
	 * @param pc
	 * @return
	 * @throws SQLException
	 */
	private PageBean<Book> findByCriteria(List<Expression> exprList, int pc) {
		/*
		 * 1. 得到ps 2. 得到tr 3. 得到beanList 4. 创建PageBean，返回
		 */
		/*
		 * 1. 得到ps
		 */
		int ps = PageConstants.BOOK_PAGE_SIZE;// 每页记录数
		/*
		 * 2. 通过exprList来生成where子句
		 */
		StringBuilder whereSql = new StringBuilder("where 1=1");
		List<Object> params = new ArrayList<Object>();// SQL中有问号，它是对应问号的值
		for (Expression expr : exprList) {
			/*
			 * 添加一个条件上， 1) 以and开头 2) 条件的名称 3) 条件的运算符，可以是=、!=、>、< ... is null，is null没有值 4)
			 * 如果条件不是is null，再追加问号，然后再向params中添加一与问号对应的值
			 */
			whereSql.append(" and ").append(expr.getName()).append(" ").append(expr.getOperator()).append(" ");
			// where 1=1 and bid = ?
			if (!expr.getOperator().equals("is null")) {
				whereSql.append("?");
				params.add(expr.getValue());
			}
		}

		/*
		 * 3. 总记录数
		 */
		adminbookdao b = new adminbookdao();
		String sql = "select count(*) from t_book b join t_category c on b.cid = c.cid " + whereSql;
		Object[] param = params.toArray();
		Number number = b.getCount(sql, param);
		int tr = number.intValue();// 得到了总记录数
		/*
		 * 4. 得到beanList，即当前页记录
		 */
		sql = "select * from t_book b join t_category c on b.cid = c.cid " + whereSql + " order by b.orderBy limit ?,?";
		params.add((pc - 1) * ps);// 当前页首行记录的下标
		params.add(ps);// 一共查询几行，就是每页记录数
		Object[] param1 = params.toArray();
		List<Book> beanList = b.query(sql, Book.class, param1);
		/*
		 * 5. 创建PageBean，设置参数
		 */
		PageBean<Book> pb = new PageBean<Book>();
		/*
		 * 其中PageBean没有url，这个任务由Servlet完成
		 */
		pb.setBeanList(beanList);
		pb.setPc(pc);
		pb.setPs(ps);
		pb.setTr(tr);
		return pb;
	}

	public void add(Book book) {
		String sql = "insert into t_book (bid,bname,author,price,currprice,discount,press,publishtime,edition,pagenum,wordNum,printtime,booksize,paper,cid,image_w,image_b) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Object[] params = { book.getBid(), book.getBname(), book.getAuthor(), book.getPrice(), book.getDiscount(),
				book.getDiscount(), book.getPress(), book.getPublishtime(), book.getEdition(), book.getPageNum(),
				book.getWordNum(), book.getPrinttime(), book.getBooksize(), book.getPaper(), book.getCid(),
				book.getImage_w(), book.getImage_b() };
		a.update(sql, params);
	}

	public Book load(String bid) {
		String sql = "select * from t_book b,t_category c where b.cid = c.cid and b.bid = ?";
		Object[] params = { bid };
		return a.get(sql, Book.class, params);
	}

	public void edit(Book book) {
		String sql = "update t_book set bname=?,author=?,price=?,currprice=?,discount=?,press=?,publishtime=?,edition=?,pagenum=?,wordNum=?,printtime=?,booksize=?,paper=?,cid=?,image_w=?,image_b=? where bid=?";
		Object[] params = { book.getBname(), book.getAuthor(), book.getPrice(), book.getDiscount(), book.getDiscount(),
				book.getPress(), book.getPublishtime(), book.getEdition(), book.getPageNum(), book.getWordNum(),
				book.getPrinttime(), book.getBooksize(), book.getPaper(), book.getCid(), book.getImage_w(),
				book.getImage_b(), book.getBid() };
		a.update(sql, params);
	}
	public void delete(String bid) {
		String sql = "delete from t_book where bid = ?";
		Object[] params = {bid};
		a.update(sql, params);
	}
}
