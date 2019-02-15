<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- bootstrap -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<title>상세보기</title>
</head>
<body>
	<div align="center">
		<h1>상세보기</h1>
		<h3><a href="list">목록으로가기</a></h3>
		<form name="form" action="update" method="post">
		<input type="hidden" id="id" name="id" value="${user.id}"/> 
		<table class="table table-striped">
			<tr>
				<td><label for="id">아이디</label></td>
				<td><input type="text" value="${user.id}" disabled="disabled" class="form-control"/></td>
			</tr>
			
			<tr>
				<td><label for="password">비밀번호</label></td>
				<td><input type="password" id="password" name="password" value="${user.password}" placeholder="비밀번호를 입력하세요!" class="form-control"/></td>
			</tr>
			
			<tr>
				<td><label for="name">이름</label></td>
				<td><input type="text" id="name" name="name" value="${user.name}" placeholder="이름을 입력해주세요!" class="form-control"/></td>
			</tr>
			
			<tr>
				<td><label for="addr">주소</label></td>
				<td><input type="text" id="addr" name="addr" value="${user.addr}" placeholder="주소를 입력해주세요!" class="form-control"/></td>
			</tr>
			
			<tr>
				<td><label for="memo">메모</label></td>
				<td><textarea id="memo" name="memo" rows="5" cols="40" class="form-control"> ${user.memo}</textarea></td>
			</tr>
			
			<tr>
				<td colspan="2"><tr>
			</tr>
			
			<tr>
				<td colspan="2"> <input type="submit" value="수정" class="btn btn-primary"/> </td>
			</tr>
		</table>
	</form>
	</div>

</body>
</html>