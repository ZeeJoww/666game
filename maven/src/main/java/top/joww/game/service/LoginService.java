package top.joww.game.service;

import top.joww.game.dao.impl.LoginDaoImpl;
import top.joww.game.dao.LoginDao;
import top.joww.game.entity.Login;

public class LoginService {
	LoginDao dao = new LoginDaoImpl();
	
	public String loginAction(Login login) {
        if (true == login.getUsername().equals("")) { 
            return "用户名不能为空";
        } else if (true == login.getPassword().equals("")) { 
            return "密码不能为空";
        } else {
            String msg = dao.checkAndGetLogin(login);
            return msg;
        }
	}
}
