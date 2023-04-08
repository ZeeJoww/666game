<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title> 后台管理 - 666小游戏 </title>
	    <link type="text/css" rel="stylesheet" href="dist/css/bootstrap.min.css">
	    <script type="text/javascript" src="dist/js/jquery-1.11.3.js"></script>
	    <script type="text/javascript" src="dist/js/bootstrap.min.js"></script>
	</head>
	<body>

    <%@ include file="header.jsp" %>
		
		<div class="container">
			<h3>游戏列表</h3><hr>
			
			<table class="table table-striped table-bordered table-hover text-center">
				<tr>
					<th class="text-center">游戏ID</th>
					<th class="text-center">游戏名</th>
					<th class="text-center">上传日期</th>
					<th class="text-center">是否发布</th>
					<th class="text-center">操作</th>
				</tr>
				
				<tr class="success">
					<td>1</td>
					<td>微笑大作战</td>
					<td>2023-03-19</td>
					<td>是</td>
					<td>
						<button type="button" class="btn btn-info btn-xs">更新信息</button>
						<button type="button" class="btn btn-success btn-xs">隐藏</button>
					</td>
				</tr>
				
				<tr class="danger">
					<td>2</td>
					<td>微笑大作战</td>
					<td>2023-03-19</td>
					<td>否</td>
					<td>
						<button type="button" class="btn btn-info btn-xs">更新信息</button>
						<button type="button" class="btn btn-success btn-xs">隐藏</button>
					</td>
				</tr>
				
				<tr class="danger">
					<td>3</td>
					<td>微笑大作战</td>
					<td>2023-03-20</td>
					<td>否</td>
					<td>
						<button type="button" class="btn btn-info btn-xs">更新信息</button>
						<button type="button" class="btn btn-success btn-xs">隐藏</button>
					</td>
				</tr>
				
				<tr class="success">
					<td>4</td>
					<td>大笑大作战</td>
					<td>2023-03-21</td>
					<td>是</td>
					<td>
						<button type="button" class="btn btn-info btn-xs">更新信息</button>
						<button type="button" class="btn btn-success btn-xs">隐藏</button>
					</td>
				</tr>
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
					<th class="text-center">邮箱</th>
					<th class="text-center">操作</th>
				</tr>
				
				<tr class="success">
					<td>1</td>
					<td>zee_joww</td>
					<td>zz</td>
					<td>zeejoww@foxmail.com</td>
					<td>
						<button type="button" class="btn btn-danger btn-xs">封禁</button>
						<button type="button" class="btn btn-primary btn-xs">发送消息</button>
					</td>
				</tr>
				
				<tr class="info">
					<td>2</td>
					<td>zee_joww2</td>
					<td>zz2</td>
					<td>zeejoww2@foxmail.com</td>
					<td>
						<button type="button" class="btn btn-danger btn-xs">封禁</button>
						<button type="button" class="btn btn-primary btn-xs">发送消息</button>
					</td>
				</tr>
				
				<tr class="danger">
					<td>3</td>
					<td>zee_joww3</td>
					<td>zz3</td>
					<td>zeejoww3@foxmail.com</td>
					<td>
						<button type="button" class="btn btn-danger btn-xs">封禁</button>
						<button type="button" class="btn btn-primary btn-xs">发送消息</button>
					</td>
				</tr>
				
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
		
    <%@ include file="footer.jsp" %>
	</body>
</html>
