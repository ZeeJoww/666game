package top.joww.game.dao;

import top.joww.game.entity.Game;

import java.util.List;

public interface GameDao {
    List<Game> getHottestGameList(int start, int count);
    List<Game> getLatestGameList(int start, int count);
    List<Game> findGameByName(String name);
    boolean addGamePlayNumById(long id);
    Game findGameById(long id);
}
