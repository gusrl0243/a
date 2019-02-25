<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="kr.or.ddit.rangers.model.RangerVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>	
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
<link href="${pageContext.servletContext.contextPath }/css/dashboard.css"
	rel="stylesheet">



</script>

</head>

<body>

	<%@ include file="/module/header.jsp"%>

	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3 col-md-2 sidebar">
				<%@ include file="/module/left.jsp"%>
			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<h3 class="page-header">게시글 작성</h3>


				<div class="table-responsive">
				
				
					<form id="frm" action="/boardWrite" method="post">
						
						<label >제목</label>
						<input width="100" height="10" id="title" type="text" name="title"><br>
						<label>내용</label><br>
						<textarea rows="10" cols="10" id="con" name="con"></textarea><br>
						<input id="file" type="text" name="file" disabled="disabled"><br>
						<label>첨부 파일</label>
						<button>첨부</button>
						<button>저장</button>
					</form> 


				</div>
			</div>
		</div>
	</div>








	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
		
	<script>
	$("#create").on("click", function(){
		if($("#board_name").vla().trim() ==""){
			alert("게시판 이름을 입력해주세요");
			$("#board_name").focus();
			return false;
		}
		$("#frm").submit();
	});
	
	</script>	




	<form id="frm" action="${pageContext.servletContext.contextPath }/boarC" method="get">
		<input type="hidden" id="board_name" name="board_name" />
	</form>

</body>
</html>








