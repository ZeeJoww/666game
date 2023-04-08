package top.joww.game.dao.impl;

import top.joww.game.dao.LoginDao;
import top.joww.game.entity.Login;

public class LoginDaoImpl implements LoginDao {
    @Override
    public Login checkAndGetLogin(String username, String password) {
        return null;
    }

    @Override
    public boolean registerLogin(Login login) {
        return false;
    }

    @Override
    public boolean updateLogin(Login login) {
        return false;
    }
}
