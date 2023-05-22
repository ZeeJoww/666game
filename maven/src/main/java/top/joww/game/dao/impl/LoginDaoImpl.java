package top.joww.game.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.List;
import java.util.ArrayList;

import top.joww.game.dao.LoginDao;
import top.joww.game.entity.Login;
import top.joww.game.util.JDBCUtil;

public class LoginDaoImpl implements LoginDao {
    @Override
    public String checkAndGetLogin(Login login) {
    	Connection connection = JDBCUtil.getConnection();
    	String sql = "SELECT `id`, `password`, `nickname`, `email` FROM `login` WHERE `username` = ?";
        PreparedStatement pstatement = null;
        ResultSet resultSet = null;
        String msg = null;
        try {
        	pstatement = connection.prepareStatement(sql);
        	pstatement.setString(1, login.getUsername());
            resultSet = pstatement.executeQuery();
            if (false == resultSet.next()) {
            	msg = "用户不存在";
            } else if (false == login.getPassword().equals(resultSet.getString("password"))) {
            	msg = "密码错误";
            } else {
            	long id = resultSet.getLong("id");
            	String nickname = resultSet.getString("nickname");
            	String email = resultSet.getString("email");
            	login.setId(id);
            	login.setNickname(nickname);
            	login.setEmail(email);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(">> [checkAndGetLogin] e: " + e.getStackTrace());
            msg = "Oops! 发生了未知错误，请联系 zeejoww@foxmail.com";
        } finally {
            try {
            	if (pstatement != null) {
            		pstatement.close();
            	}
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return msg;
    }

    @Override
    public String registerLogin(Login login) {
    	Connection connection = JDBCUtil.getConnection();
    	String sql = "INSERT INTO `login`(`username`, `nickname`, `password`, `email`) VALUES(?, ?, ?, ?)";
        PreparedStatement pstatement = null;
        String msg = null;
        try {
        	pstatement = connection.prepareStatement(sql);
        	pstatement.setString(1, login.getUsername());
        	pstatement.setString(2, login.getNickname());
        	pstatement.setString(3, login.getPassword());
        	pstatement.setString(4, login.getEmail());
            if (0 == pstatement.executeUpdate()) {
            	msg = "未知错误";
            }
        } catch (Exception e) {
            e.printStackTrace();
            msg = e.getLocalizedMessage();
            if (msg.matches("Duplicate entry '.*' for key 'login.username'")) {
        		msg = "该用户名已被注册";
            } else if (msg.matches("Duplicate entry '.*' for key 'login.email'")) {
            	msg = "该邮箱已被注册";
            } else {
        		msg = "Oops! 发生了未知错误，请联系 zeejoww@foxmail.com";
            }
        } finally {
            try {
            	if (pstatement != null) {
            		pstatement.close();
            	}
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return msg;
    }

    @Override
    public boolean updateLoginInformation(Login login) {
        return true;
    }

	@Override
	public List<Login> getUserList(int start, int count) {
    	Connection connection = JDBCUtil.getConnection();
    	String sql = "SELECT `id`, `username`, `nickname`, `email` FROM `login` ORDER BY `id` LIMIT ?, ?";
        PreparedStatement pstatement = null;
        ResultSet resultSet = null;
        List<Login> list = new ArrayList<>();
        
        try {
        	pstatement = connection.prepareStatement(sql);
        	pstatement.setInt(1, start);
        	pstatement.setInt(2, count);
            resultSet = pstatement.executeQuery();
            while (resultSet.next()) {
            	long id = resultSet.getLong("id");
            	String username = resultSet.getString("username");
            	String nickname = resultSet.getString("nickname");
            	String email = resultSet.getString("email");
            	Login login = new Login(username, nickname, "", email);
            	login.setId(id);
            	list.add(login);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
            	if (pstatement != null) {
            		pstatement.close();
            	}
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        return list;
	}

	@Override
	public boolean deleteUserById(int id) {
		// TODO Auto-generated method stub
		return true;
	}
}
