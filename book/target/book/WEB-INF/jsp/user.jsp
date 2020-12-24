<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人中心</title>
	<style>
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
	</style>
</head>
<body>

<div>
	<c:if test="${empty user}">
		<script type="text/javascript">
            alert("您尚未登录，请先去首页登录！")
			window.location.href="index.do";
		</script>
	</c:if>
	<h1>欢迎您${user.uname}</h1>
	借书请进入 <a href="list.do?uid=${user.uid}">书籍列表</a>
	<a href="index.do?uid=${user.uid}">返回主页</a>
	<a href="toupdateUser.do?uid=${user.uid}">修改用户信息</a>
	<!--  搜索框表单 -->

	已借书籍清单如下：
	<table border="1" cellpadding="4" cellspacing="0" >
		<tr>
			<td>书籍id</td>
			<td>书籍名称</td>
			<td>作者</td>
			<td>出版社</td>
			<td>借书日期</td>
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
			<c:if test="${empty records}">
				<script type="text/javascript">
                    alert("无借书记录")
				</script>
			</c:if>
			<c:if test="${not empty records}">
				<c:forEach items="${records}" var="record">
					<tr>

							<c:forEach items="${books}" var="book">
									<c:if test="${record.rbid eq book.bid}">
										<td>${record.rbid}</td>
										<td>${book.bname}</td>
										<td>${book.bauthor}</td>
										<td>${book.bcbs}</td>
										<td>${record.rdate}</td>
										<td>
											<input type="button" value="还书" class="ss" onclick="huanshu(${record.rid},${book.bid},${user.uid})">
										</td>
									</c:if>
							</c:forEach>
					</tr>
				</c:forEach>
			</c:if>
		</form>
	</table>

	<div id="footer">
		<a href="javascript:pageNos(1)">首页</a>
		<c:if test="${requestScope.pb.pageNos > 1}">
			<a href="javascript:pageNos(${requestScope.pb.pageNos-1})">上一页</a>
		</c:if>

		<!--  显示十页数据 -->
		<c:forEach var="i" begin="${requestScope.pb.start}" end="${requestScope.pb.end}">
			<c:choose>
				<c:when test="${i==requestScope.pb.pageNos}">
					[ ${i} ]
				</c:when>
				<c:otherwise>
					<a href="javascript:pageNos(${i})">${i}</a>
				</c:otherwise>
			</c:choose>

		</c:forEach>

		<c:if test="${requestScope.pb.pageNos<requestScope.pb.page}">
			<a href="javascript:pageNos(${requestScope.pb.pageNos+1})">下一页</a>
		</c:if>

		<a href="javascript:pageNos(${requestScope.pb.page})">尾页</a>
		${requestScope.pb.pageNos}/ ${requestScope.pb.page}页
	</div>
</div>
</body>
<
<script !src="">
    function huanshu(rbid,bid,uid){
        location.href="huanshu.do?rbid="+rbid+"&bid="+bid+"&uid="+uid;
    }
</script>

</html>