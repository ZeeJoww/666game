package top.joww.game.service;

import java.util.List;

import top.joww.game.dao.impl.GameDaoImpl;
import top.joww.game.dao.GameDao;
import top.joww.game.entity.Game;

public class GameService {
	GameDao dao = new GameDaoImpl();
	
	public List<Game> getGameList(int begin, int count) {
		return dao.getGameList(begin, count);
	}
}
