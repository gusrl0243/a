<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="kr.or.ddit.rangers.model.RangerVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Dashboard Template for Bootstrap</title>

<!-- Bootstrap core CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- Custom styles for this template -->
<link
	href="${pageContext.servletContext.contextPath }/css/dashboard.css"
	rel="stylesheet">



</head>

<body>

	<%@ include file="/module/header.jsp"%>
	<div class="col-sm-3 col-md-2 sidebar">
		<%@ include file="/module/left.jsp"%>
	</div>

	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
		<h3 class="page-header">게시판 생성</h3>
		<!-- userList 정보를 화면에 출력하는 로직 작성 -->


			<form id="frm" action="/boardC" method="post">
				<label>게시판 이름</label> <input id="new_board_name" type="text"
					name="new_board_name"> <select name="Y_N">
					<option value="Y">사용</option>
					<option value="N">미사용</option>
				</select>
				<button type="submit">생성</button>
				<br>
			</form>

			<c:forEach items="${boardList}" var="vo">
				<label>게시판 이름</label>
				<input type="text" name="board_name" value="${vo.board_name }"
					disabled="disabled">
				<select name="y_n">
					<option value="Y">사용</option>
					<option value="N">미사용</option>
				</select>
				<button type="button" name="modifyBtn">수정</button>
				<br>
			</c:forEach>

	</div>








	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>






	<form id="frm"
		action="${pageContext.servletContext.contextPath }/boarC" method="get">
		<input type="hidden" id="board_name" name="board_name" />
	</form>

</body>
</html>








