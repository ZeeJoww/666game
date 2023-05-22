package top.joww.game.service;

import java.util.List;

import top.joww.game.dao.impl.LoginDaoImpl;
import top.joww.game.dao.LoginDao;
import top.joww.game.entity.Login;

public class UserService {
	LoginDao dao = new LoginDaoImpl();
	
	public List<Login> getUserList(int begin, int count) {
		return dao.getUserList(begin, count);
	}
	
	public boolean deleteUserById(int id) {
		return dao.deleteUserById(id);
	}
	
	public boolean updateUserInformation(Login login) {
		return dao.updateLoginInformation(login);
	}
}
