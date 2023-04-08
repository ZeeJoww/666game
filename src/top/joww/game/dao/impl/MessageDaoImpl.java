package top.joww.game.dao.impl;

import top.joww.game.dao.MessageDao;
import top.joww.game.entity.Message;

import java.sql.Date;
import java.util.List;

public class MessageDaoImpl implements MessageDao {
    @Override
    public List<Message> getLatestMessageList(Date date) {
        return null;
    }

    @Override
    public List<Message> findGameByName(String name) {
        return null;
    }

    @Override
    public boolean sendMessage(Message msg) {
        return false;
    }
}
