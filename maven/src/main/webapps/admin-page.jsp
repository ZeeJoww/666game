<%@page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title> 后台管理 - 666小游戏 </title>
	<link type="text/css" rel="stylesheet" href="dist/css/bootstrap.min.css">
	<script type="text/javascript" src="dist/js/jquery-1.11.3.js"></script>
	<script type="text/javascript" src="dist/js/bootstrap.min.js"></script>
	<script> $(function () { $('[data-toggle="tooltip"]').tooltip() }) </script>
</head>

<body>
<%@ include file="header.jsp" %>


<div class="container">

	<c:if test="${info!=null}">
		<div class="alert alert-${info_type}" role="alert">
			${info}
		</div>
	</c:if>

	<h3>游戏列表</h3><hr>

	<table class="table table-striped table-bordered table-hover text-center">
		<tr>
			<th class="text-center">游戏ID</th>
			<th class="text-center">游戏名</th>
			<th class="text-center">上传日期</th>
			<th class="text-center">是否发布</th>
			<th class="text-center">操作</th>
		</tr>
		
		<c:forEach items="${gameList}" var="game">
			<tr>
				<td>${game.getId()}</td>
				<td>${game.getName()}</td>
				<td>${game.getCreatedAt()}</td>
				<td>是</td>
				<td>
					<button type="button" class="btn btn-info btn-xs">更新信息</button>
					<button type="button" class="btn btn-success btn-xs">隐藏</button>
				</td>
			</tr>
		</c:forEach>
	</table>
	
	<div class="text-center">
		<nav aria-label="Page navigation">
			<ul class="pagination">
				<li>
					<a href="#" aria-label="Previous">
						<span aria-hidden="true">&laquo;</span>
					</a>
				</li>
				<li><a href="#">1</a></li>
				<li><a href="#">2</a></li>
				<li><a href="#">3</a></li>
				<li><a href="#">4</a></li>
				<li><a href="#">5</a></li>
				<li>
					<a href="#" aria-label="Next">
						<span aria-hidden="true">&raquo;</span>
					</a>
				</li>
			</ul>
		</nav>
	</div>
	

	<h3>用户列表</h3><hr>
	<table class="table table-striped table-bordered table-hover text-center">
		<tr>
			<th class="text-center">用户ID</th>
			<th class="text-center">用户名</th>
			<th class="text-center">昵称</th>
			<th class="text-center">操作</th>
		</tr>
		
		<c:forEach items="${userList}" var="user">
			<tr>
				<td>${user.getId()}</td>
				<td>${user.getUsername()}</td>
				<td>${user.getNickname()}</td>
				<td>
					<button type="button" class="btn btn-info btn-xs" data-toggle="tooltip" 
					data-placement="top" title="Email: ${user.getEmail()}"> 查看详情 </button>
					
					<button type="button" class="btn btn-success btn-xs"> 发送消息 </button>
					
					<!-- Button trigger modal -->
					<button type="button" class="btn btn-primary btn-xs" 
					data-toggle="modal" data-target="#userDetailModal"
					data-userid="${user.getId()}" data-username="${user.getUsername()}" 
					data-nickname="${user.getNickname()}" data-email="${user.getEmail()}">
						更新信息
					</button>
					
					<a href="userDelete?id=${user.getId()}">
						<button type="button" class="btn btn-danger btn-xs">删除用户</button>
					</a>
					
				</td>
			</tr>
		</c:forEach>
	</table>
	
	
	<div class="text-center">
		<nav aria-label="Page navigation">
			<ul class="pagination">
				<li>
					<a href="#" aria-label="Previous">
						<span aria-hidden="true">&laquo;</span>
					</a>
				</li>
				<li><a href="#">1</a></li>
				<li><a href="#">2</a></li>
				<li><a href="#">3</a></li>
				<li><a href="#">4</a></li>
				<li><a href="#">5</a></li>
				<li>
					<a href="#" aria-label="Next">
						<span aria-hidden="true">&raquo;</span>
					</a>
				</li>
			</ul>
		</nav>
	</div>
</div>

					
	<!-- Modal -->
	<div class="modal fade" id="userDetailModal" tabindex="-1" role="dialog" aria-labelledby="userDetailModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="userDetailModalLabel">TITLE</h4>
	      </div>
	        <form action="userUpdate" method="post">
	          <div class="modal-body">
	            <div class="form-group">
	              <label for="inputUserId" class="control-label">用户ID:</label>
	              <input type="text" class="form-control" id="inputUserId" name="inputUserId" readonly="readonly">
	            </div>
	            <div class="form-group">
	              <label for="inputUsername" class="control-label">用户名:</label>
	              <input type="text" class="form-control" id="inputUsername" name="inputUsername" readonly="readonly">
	            </div>
	            <div class="form-group">
	              <label for="inputNickname" class="control-label">昵称:</label>
	              <input type="text" class="form-control" id="inputNickname" name="inputNickname">
	            </div>
	            <div class="form-group">
	              <label for="inputEmail" class="control-label">邮箱:</label>
	              <input type="text" class="form-control" id="inputEmail" name="inputEmail">
	            </div>
	        </div>
	        <div class="modal-footer">
	          <button type="submit" class="btn btn-primary"> 保存更改 </button>
	          <button type="button" class="btn btn-default" data-dismiss="modal"> 取消 </button>
	        </div>
	      </form>
	    </div>
	  </div>
	</div>
	
	<script>
	$('#userDetailModal').on('show.bs.modal', function (event) {
	  var button = $(event.relatedTarget)
	  
	  var userId = button.data('userid')
	  var username = button.data('username')
	  var nickname = button.data('nickname')
	  var email = button.data('email')
	  
	  $('.modal-title').text('修改信息 - ' + username)
	  $('#inputUserId').val(userId)
	  $('#inputUsername').val(username)
	  $('#inputNickname').val(nickname)
	  $('#inputEmail').val(email)
	})
	</script>

<%@ include file="footer.jsp" %>
</body>
</html>
