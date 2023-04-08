package top.joww.game.dao;

import top.joww.game.entity.Login;

public interface LoginDao {
    Login checkAndGetLogin(String username, String password);
    boolean registerLogin(Login login);
    boolean updateLogin(Login login);
}
