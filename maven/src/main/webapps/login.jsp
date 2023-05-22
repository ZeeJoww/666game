<%@page contentType="text/html;charset=UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false" %>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title> 登录 - 666小游戏 </title>
    <link type="text/css" rel="stylesheet" href="dist/css/bootstrap.min.css">
    <script type="text/javascript" src="dist/js/jquery-1.11.3.js"></script>
    <script type="text/javascript" src="dist/js/bootstrap.min.js"></script>
</head>

<body>
<%@ include file="header.jsp" %>

<div class="container" style="margin-top: 50px;">
    <h3>登录</h3><hr>
    <div class="row">
        <div class="col-md-3"></div>
        <div class="col-md-6">
            <form class="form-horizontal" action="login" method="post">
            
                <div class="form-group">
                    <label for="inputEmail3" class="col-sm-2 control-label">用户名</label>
                    <div class="col-sm-10">
                        <input type="text" name="inputUsername" class="form-control" id="inputUsername" placeholder="请输入用户名">
                    </div>
                </div>
                
                <div class="form-group">
                    <label for="inputPassword3" class="col-sm-2 control-label">密码</label>
                    <div class="col-sm-10">
                        <input type="password" name="inputPassword" class="form-control" id="inputPassword" placeholder="请输入密码">
                    </div>
                </div>
                
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-success">　登录　</button>
                        <button type="submit" class="btn btn-success" style="background-color:green;">忘记密码</button>
                    </div>
                </div>
                
                <span style="color:red;">${info}</span>
            </form>
        </div>
    </div>
</div>

<%@ include file="footer.jsp" %>
</body>
</html>
