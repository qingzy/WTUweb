<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>所有借阅记录</title>
	<style>
		div{
			font-size: 16px;
			width: 1024px;
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
	</style>
</head>
<body>

<div>
	<h1>所有借阅记录</h1>
	<h2>
		<a href="user.do?uid=${user.uid}">个人中心</a>
		<a href="index.do?uid=${user.uid}">返回主页</a>
		<a href="toupdateUser.do?uid=${user.uid}">修改用户信息</a>

	</h2>
	<table border="1" cellpadding="4" cellspacing="0" >
		<tr>
			<td>书籍id</td>
			<td>借阅人id</td>
			<td>借阅日期</td>
		</tr>
		<form action="" method="post" name="from">
			<%--<c:if test="${empty requestScope.pb.list}">
				<script>
                    window.onload=function(){
                        if(confirm("查询结果为空，即将返回首页！")){
                            location.href="list.do";

                        }
                    }

				</script>
			</c:if>--%>
			<c:if test="${not empty records}">
				<c:forEach items="${records}" var="record">
					<tr>
						<td>${record.rbid}</td>
						<td>${record.ruid}</td>
						<td>${record.rdate}</td>
					</tr>
				</c:forEach>
			</c:if>
		</form>
	</table>

</div>
</body>
<
<script !src="">
    function jieshu(bid,bnum,uid){
        location.href="jieshu.do?bid="+bid+"&bnum="+bnum+"&uid="+uid;
    }
</script>

</html>