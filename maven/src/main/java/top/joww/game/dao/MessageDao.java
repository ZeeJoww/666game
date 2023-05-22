package top.joww.game.dao;

import top.joww.game.entity.Message;

import java.sql.Date;
import java.util.List;

public interface MessageDao {
    List<Message> getLatestMessageList(Date date);
    List<Message> findGameByName(String name);
    boolean sendMessage(Message msg);
}
