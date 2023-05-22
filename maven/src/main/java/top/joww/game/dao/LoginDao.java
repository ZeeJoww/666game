package top.joww.game.dao;

import java.util.List;
import top.joww.game.entity.Login;

public interface LoginDao {
    String checkAndGetLogin(Login login);
    String registerLogin(Login login);
    boolean updateLoginInformation(Login login);
    boolean deleteUserById(int id);
    List<Login> getUserList(int start, int count);
}
