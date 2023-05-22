<%@page contentType="text/html;charset=UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false" %>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title> 注册 - 666小游戏 </title>
    <link type="text/css" rel="stylesheet" href="dist/css/bootstrap.min.css">
    <script type="text/javascript" src="dist/js/jquery-1.11.3.js"></script>
    <script type="text/javascript" src="dist/js/bootstrap.min.js"></script>
</head>

<body>
<%@ include file="header.jsp" %>

<div class="container" style="margin-top: 50px;">
    <h3>注册</h3><hr>
    <div class="row">
        <div class="col-md-3">
        </div>
        <div class="col-md-6">
            <form class="form-horizontal" action="register" method="post">
                <div class="form-group">
                    <label for="inputUsername" class="col-sm-2 control-label">用户名</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" name="inputUsername" id="inputUsername" placeholder="请输入用户名">
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputNickname" class="col-sm-2 control-label">昵称</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" name="inputNickname" id="inputNickname" placeholder="请输入昵称">
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputPassword" class="col-sm-2 control-label">密码</label>
                    <div class="col-sm-10">
                        <input type="password" class="form-control" name="inputPassword" id="inputPassword" placeholder="请输入密码">
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputPasswordAgain" class="col-sm-2 control-label">确认密码</label>
                    <div class="col-sm-10">
                        <input type="password" class="form-control" name="inputPasswordAgain" id="inputPasswordAgain" placeholder="请再次输入密码">
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputEmail" class="col-sm-2 control-label">邮箱</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" name="inputEmail" id="inputEmail" placeholder="请输入邮箱">
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputVerificationCode" class="col-sm-2 control-label">验证码</label>
                    <div class="col-sm-7">
                        <input type="text" class="form-control" name="inputVerificationCode" id="inputVerificationCode" placeholder="请输入验证码">
                    </div>
                    <div class="col-sm-3">
                        <button type="submit" class="btn btn-info">发送验证码</button>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-success">注册</button>
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
