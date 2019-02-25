<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="kr.or.ddit.user.model.UserVo"%>
    
<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> 
				<span class="icon-bar"></span> 
				<span class="icon-bar"></span> 
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">
				<%	
					UserVo userVo = (UserVo)session.getAttribute("userVo");
					String userId = userVo == null ? "" : userVo.getUserId(); 
				%>
				사용자id : <%=userId %>
			</a>
		</div>
		</div>
	</div>
</nav>