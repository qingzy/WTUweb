<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>书籍页面</title>
	<style>
		table{
			width: 600px;
			margin: auto;
			text-align: center;
		}
		div{
			font-size: 16px;
			width: 600px;
			margin: auto;
		}
		input{
			display: inline-block;
			width: 100px;
		}
		.ss{
			width: 45px;
			float: right;
		}
		#footer{
			text-align: center;
		}
		#form2{
			width: 595px;
			display: inline-block;
		}
		#checkboxAll{
			width: 41px;
		}
	</style>
</head>
<body>

<div>

	<h1>书籍管理系统</h1>
	<h2>
		<c:if test="${empty user.uname}">
			请您登录后再进行借书操作
		</c:if>
		<c:if test="${not empty user.uname}">
			欢迎您${user.uname}
		</c:if>

	</h2>
	<h2>
		<a href="user.do?uid=${user.uid}">个人中心</a>
		<a href="index.do?uid=${user.uid}">返回主页</a>
		<a href="toupdateUser.do?uid=${user.uid}">修改用户信息</a>

	</h2>
	<!--  搜索框表单 -->
	<form action="bookList.do" method="post" id="form1">

		作者名称：<input type="text" value="${bauthor}" name="bauthor">
		&emsp;&emsp;
		书籍名称：<input type="text" value="${bname}" name="bname">
		&emsp;&emsp;

		<input type="submit" value="搜索" class="ss">
		<input type="hidden" name="pageNum" value="1" id="pageNum" />
	</form>

	<table border="1" cellpadding="4" cellspacing="0" >
		<tr>
			<td>书籍id</td>
			<td>书籍名称</td>
			<td>作者</td>
			<td>出版社</td>
			<td>剩余数量</td>
			<td>操作</td>
		</tr>
		<form action="DelWpglsServlet" method="post" name="from">
			<%--<c:if test="${empty requestScope.pb.list}">
				<script>
                    window.onload=function(){
                        if(confirm("查询结果为空，即将返回首页！")){
                            location.href="list.do";

                        }
                    }

				</script>
			</c:if>--%>
			<c:if test="${not empty books}">
				<c:forEach items="${books}" var="book">
					<tr>
						<td>${book.bid}</td>
						<td>${book.bname}</td>
						<td>${book.bauthor}</td>
						<td>${book.bcbs}</td>
						<td>${book.bnum}</td>
						<td>
							<input type="button" value="借书" class="ss" onclick="jieshu(${book.bid},${book.bnum},${user.uid})">
						</td>
					</tr>
				</c:forEach>
			</c:if>
		</form>

		<tr>
			<td colspan="8">
				<a href="javascript:pageNos(1)">首页</a>
				<c:if test="${pageNum>1}">
					<a href="javascript:pageNos(${pageNum-1})">上一页</a>
				</c:if>
				<!--  显示十页数据 -->
				<c:forEach var="i" begin="${pageNum}" end="${total}">
					<c:choose>
						<c:when test="${i==pageNum}">
							[ ${i} ]
						</c:when>
						<c:otherwise>
							<a href="javascript:pageNos(${i})">${i}</a>
						</c:otherwise>
					</c:choose>

				</c:forEach>
				<c:if test="${pageNum<total}">
					<a href="javascript:pageNos(${pageNum+1})">下一页</a>
				</c:if>

				<a href="javascript:pageNos(${total})">尾页</a>

			</td>
		</tr>
	</table>


</div>
</body>
<
<script !src="">
    function jieshu(bid,bnum,uid){
        if(uid==null){
            alert("请先登录再借书")
		}else {
            location.href="jieshu.do?bid="+bid+"&bnum="+bnum+"&uid="+uid;
		}

    }

    function pageNos(pageNo){
        document.getElementById("pageNum").value = pageNo;
        document.getElementById("form1").submit();
    }
</script>

</html>