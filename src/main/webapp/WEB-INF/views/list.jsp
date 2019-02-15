<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전체보기</title>
<!-- bootstrap -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- jquery -->
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
</head>

	<script>
		//페이지 시작과 동시에 실행
		window.onload = function(){
			getData(${pageNum});

		};
		//페이지 시작과 동시에 리스트 뿌리기
		function getData(pageNum){
			$("#container").load("list",
					{"pageNum": pageNum},
					function(data){
						$("#container").html(data);
					}
			);
		}
		
		$(document).ready(function(){	
			$("#btnSearch").click(function(){
				if($("#word").val()==""){
					$("#container").load("list");
					return false;
				}
				
				$.get(
						"search",
						{"field": $("#field").val(), "word" : $("#word").val()},
						function(data){
							var htmlStr = "<table class='table table-striped'>";
							//htmlStr += "<tr><th>아이디</th><th>성명</th><th>주소</th><th>메모</th><th>삭제</th></tr>";
							htmlStr += data;
							htmlStr += "</table>";
							$("#container").html(htmlStr);
						}
				);//get
					
			}); //btnSearch
			
		});//ready
	
		
		
	</script>
<body>
	<div id="container">
	<h1>회원 목록보기</h1>
	<h3><a href="insert">회원가입</a></h3>
		<table class="table table-striped">
			<tr>
				<th>아이디</th>
				<th>성명</th>
				<th>주소</th>
				<th>메모</th>
				<th>삭제</th>
			</tr>
			<c:forEach items="${userList}" var="userList" varStatus="status">
			<tr>
				<td>${userList.id}</td>
				<td><a href="detail?id=${userList.id}">${userList.name}</a></td>
				<td>${userList.addr}</td>
				<td>${userList.memo}</td>
				<td><a href="delete?id=${userList.id}">삭제</a></td>
			</tr>
			</c:forEach>
		</table>
		
		<!-- 찾기영역 -->
			<div align="center">	
				<form name="search" id="search">
					<select name="field" id="field">
						<option value="name">이름</option>
						<option value="id">아이디</option>
					</select>
					<input type="text" name="word" id="word"/>
					<input type="button" value="찾기" id="btnSearch" class="btn btn-primary"/>
				</form>
			</div>
			
			<!-- 상세검색 뿌려지는 영역 -->
			<div id="result_search">
			
			</div>
		${pageHtml }
	</div>
	
	

</body>
</html>