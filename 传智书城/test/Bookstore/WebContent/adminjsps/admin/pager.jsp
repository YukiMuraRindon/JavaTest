<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
	function _go() {
		var pc = $("#pageCode").val();//获取文本框中的当前页码
		if(!/^[1-9]\d*$/.test(pc)) {//对当前页码进行整数校验
			alert('请输入正确的页码！');
			return;
		}
		if(pc > ${pb.tp}) {//判断当前页码是否大于最大页
			alert('请输入正确的页码！');
			return;
		}
		location = "${pb.url}&pc=" + pc;
	}
</script>
<nav aria-label="...">
  <ul class="pager">
  	<c:choose>
		<c:when test="${pb.pc eq 1 }">
			<li><a href="#">上一页</a></li>
		</c:when>
		<c:otherwise>
			<li><a href="${pb.url }&pc=${pb.pc-1}">上一页</a></li>
		</c:otherwise>
	</c:choose>
	<li>
		<ul class="pagination">
			<li><a href="#">&laquo;</a></li>
			<li><a href="#">1</a></li>
			<li><a href="#">2</a></li>
			<li><a href="#">3</a></li>
			<li><a href="#">4</a></li>
			<li><a href="#">5</a></li>
			<li><a href="#">&raquo;</a></li>
		</ul>
	</li>
    <c:choose>
		<c:when test="${pb.pc eq 1 }">
			<li><a href="#">上一页</a></li>
		</c:when>
		<c:otherwise>
			<li><a href="${pb.url }&pc=${pb.pc-1}">上一页</a></li>
		</c:otherwise>
	</c:choose>
	<li><span>共${pb.tp }页</span></li>
    <li>
	    <span>到</span>
	    <input type="text" class="input-sm" id="pageCode" value="${pb.pc }"/>
	    <span>页</span>
	    <a href="javascript:_go();" class="btn btn-primary">确定</a>
    </li>
  </ul>
</nav>
<%-- 	

<div class="divBody">
  <div class="divContent">
    上一页
<c:choose>
	<c:when test="${pb.pc eq 1 }"><span class="spanBtnDisabled">上一页</span></c:when>
	<c:otherwise><a href="${pb.url }&pc=${pb.pc-1}" class="aBtn bold">上一页</a></c:otherwise>
</c:choose>
        
        

我们需要计算页码列表的开始和结束位置，即两个变量begin和end
计算它们需要通过当前页码！
1. 总页数不足6页--> begin=1, end=最大页
2. 通过公式设置begin和end，begin=当前页-1，end=当前页+3
3. 如果begin<1，那么让begin=1，end=6
4. 如果end>tp, 让begin=tp-5, end=tp

 <c:choose>
 	<c:when test="${pb.tp <= 6 }">
 		<c:set var="begin" value="1"/>
 		<c:set var="end" value="${pb.tp }"/>
 	</c:when>
 	<c:otherwise>
 		<c:set var="begin" value="${pb.pc-2 }"/>
 		<c:set var="end" value="${pb.pc + 3}"/>
 		<c:if test="${begin < 1 }">
 		  <c:set var="begin" value="1"/>
 		  <c:set var="end" value="6"/>
 		</c:if>
 		<c:if test="${end > pb.tp }">
 		  <c:set var="begin" value="${pb.tp-5 }"/>
 		  <c:set var="end" value="${pb.tp }"/>
 		</c:if> 		
 	</c:otherwise>
 </c:choose>
 
 <c:forEach begin="${begin }" end="${end }" var="i">
   <c:choose>
   	  <c:when test="${i eq pb.pc }">
   	    <span class="spanBtnSelect">${i }</span>
   	  </c:when>
   	  <c:otherwise>
   	    <a href="${pb.url }&pc=${i}" class="aBtn">${i }</a>
   	  </c:otherwise>
   </c:choose>
           
          	
 </c:forEach>
    计算begin和end
      如果总页数<=6，那么显示所有页码，即begin=1 end=${pb.tp}
        设置begin=当前页码-2，end=当前页码+3
          如果begin<1，那么让begin=1 end=6
          如果end>最大页，那么begin=最大页-5 end=最大页


    
    显示点点点
    <c:if test="${end < pb.tp }">
      <span class="spanApostrophe">...</span>
    </c:if> 

    
     下一页
<c:choose>
	<c:when test="${pb.pc eq pb.tp }"><span class="spanBtnDisabled">下一页</span></c:when>
	<c:otherwise><a href="${pb.url }&pc=${pb.pc+1}" class="aBtn bold">下一页</a></c:otherwise>
</c:choose>
        
        
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    
    共N页 到M页
    <span>共${pb.tp }页</span>
    <span>到</span>
    <input type="text" class="inputPageCode" id="pageCode" value="${pb.pc }"/>
    <span>页</span>
    <a href="javascript:_go();" class="aSubmit">确定</a>
  </div>
</div> --%>