package top.joww.game.service;

import top.joww.game.dao.impl.LoginDaoImpl;
import top.joww.game.dao.LoginDao;
import top.joww.game.dao.impl.VeriCodeDaoImpl;
import top.joww.game.dao.VeriCodeDao;
import top.joww.game.entity.Login;
import top.joww.game.entity.VeriCode;

public class RegisterService {
	LoginDao dao = new LoginDaoImpl();
	VeriCodeDao veri = new VeriCodeDaoImpl();
	
	public String registerAction(Login login, String passwordAgain, String veriCode) {
        if (true == login.getUsername().equals("")) { 
            return "用户名不能为空";
        } else if (true == login.getNickname().equals("")) { 
            return "昵称不能为空";
        } else if (true == login.getPassword().equals("")) { 
            return "密码不能为空";
        } else if (true == passwordAgain.equals("")) { 
            return "确认密码不能为空";
        } else if (true == login.getEmail().equals("")) {
            return "邮箱不能为空";
        } else if (true == veriCode.equals("")) { 
            return "验证码不能为空";
        } else if (false == login.getUsername().equals(passwordAgain)) { 
            return "两次密码不一致";
        } else {
        	VeriCode vc = new VeriCode(login.getEmail());
        	String msg = veri.checkVeriCode(vc);
        	if (msg != null) {
        		return msg;
        	}
        	return dao.registerLogin(login);
        }
	}
}
