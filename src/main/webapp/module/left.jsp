<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<ul class="nav nav-sidebar">


	<li><a href="<%=request.getContextPath()%>/boardC">게시판 생성${boardList_Y.size()}</a></li>

	<c:forEach items="${boardList_Y}" var="vo">
		<li>
				<tr class="boardTr" data-board_name="${vo.board_name }">
					<a href="<%=request.getContextPath()%>/boardWritingList?board_name=${vo.board_name }">
				<td>${vo.board_name }</td><br>
			</a>
				</tr>
		</li>
	</c:forEach>

</ul>
<script>
	//boardTr 태그 클릭시 이벤트 핸들러
	$(".boardTr").on("click", function(){
		console.log("boardTr click");
	
		var board_name = $(this).data("board_name");
				
		$("#board_name").val(userId);
		
		$("#frm").submit();
</script>
<form id="frm" action="${pageContext.servletContext.contextPath }/boardWritingList" method="get">
	<input type="hidden" id="board_name" name="board_name"/>
</form>