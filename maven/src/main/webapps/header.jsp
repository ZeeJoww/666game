<%@page contentType="text/html;charset=UTF-8" language="java" import="java.net.URLDecoder"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false" %>

<head>
    <link type="text/css" rel="stylesheet" href="dist/css/bootstrap.min.css">
    <script type="text/javascript" src="dist/js/jquery-1.11.3.js"></script>
    <script type="text/javascript" src="dist/js/bootstrap.min.js"></script>
</head>

<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="index.jsp">666</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
        
            <ul class="nav navbar-nav">
                <li><a href="index.jsp">首页</a></li>
            </ul>
            
            <form class="navbar-form navbar-left" action="search" method="post">
                <div class="form-group">
                    <input type="text" name="inputKeywords" id="inputKeywords" class="form-control" placeholder="输入关键字">
                </div>
                <button type="submit" class="btn btn-default">查找游戏</button>
            </form>
            
            <ul class="nav navbar-nav navbar-right">
            
         		<!-- get "id" and "nickname" -->
         		<%
				    request.setCharacterEncoding("utf-8");
				    request.setAttribute("id", null);
			    	request.setAttribute("nickname", null);
				    Cookie[] cookies = request.getCookies();
				    if (cookies != null) {
			        	for (Cookie c : cookies) {
				        	if (c.getValue() != null) {
				            	request.setAttribute(c.getName(), URLDecoder.decode(c.getValue(), "utf-8"));
				        	}
					    }
				    }
				%>
			    
            	<!-- before login -->
               	<c:if test="${ nickname == null }">
	                <li class="dropdown">
	                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">菜单<span class="caret"></span></a>
	                    <ul class="dropdown-menu">
			                <li><a href="login.jsp">登录</a></li>
			                <li><a href="register.jsp">注册</a></li>
                			<li role="separator" class="divider"></li>
                			<li><a href="about.jsp">关于</a></li>
	                    </ul>
	                </li>
	        </c:if>
	            
            	<!-- after login -->
               	<c:if test="${ nickname != null }">
	                <li class="dropdown">
	                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
	                    	欢迎回来，${nickname}
	                    </a>
	                    <ul class="dropdown-menu">
	                        <li><a href="center.jsp">个人中心</a></li>
                			<li><a href="feedback.jsp">问题反馈</a></li>
                			
	                        <!-- administrator (id == 1) -->
	                        <c:if test="${id == 1}">
	                        	<li role="separator" class="divider"></li>
	                			<li><a href="manage">后台管理</a></li>
	                        </c:if>
	                        
	                        <li role="separator" class="divider"></li>
	                		<li><a href="logout">退出登录</a></li>

							<li role="separator" class="divider"></li>
							<li><a href="about.jsp">关于</a></li>
	                    </ul>
	                </li>
	            </c:if>
	            
            </ul>
            
        </div> <!-- /.navbar-collapse -->
    </div> <!-- /.container-fluid -->
</nav>
