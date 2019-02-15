<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- bootstrap -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<title>회원가입</title>

<style>
	#container{
		margin : 0 auto;
	}
</style>

</head>
<body>
	<div id="container"></div>
	<h1>회원가입</h1>
	<hr>
	<form name="form" action="insert" method="post">
		<table class="table table-striped">
			<tr>
				<td><label for="id">아이디</label></td>
				<td><input type="text" id="id" name="id" placeholder="아이디를 입력해주세요!" class="form-control"/></td>
			</tr>
			
			<tr>
				<td><label for="password">비밀번호</label></td>
				<td><input type="password" id="password" name="password" placeholder="비밀번호를 입력하세요!" class="form-control"/></td>
			</tr>
			
			<tr>
				<td><label for="name">이름</label></td>
				<td><input type="text" id="name" name="name" placeholder="이름을 입력해주세요!" class="form-control"/></td>
			</tr>
			
			<tr>
				<td><label for="addr">주소</label></td>
				<td><input type="text" id="addr" name="addr" placeholder="주소를 입력해주세요!" class="form-control"/></td>
			</tr>
			
			<tr>
				<td><label for="memo">메모</label></td>
				<td><textarea id="memo" name="memo" rows="5" cols="40" class="form-control"></textarea></td>
			</tr>
			
			<tr>
				<td colspan="2"><tr>
			</tr>
			
			<tr>
				<td colspan="2"> <input type="submit" value="가입" align="center" class="btn btn-primary"/> </td>
			</tr>
		</table>
	</form>

</body>
</html>