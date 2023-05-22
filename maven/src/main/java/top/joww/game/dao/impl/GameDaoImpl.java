package top.joww.game.dao.impl;

import top.joww.game.dao.GameDao;
import top.joww.game.entity.Game;
import top.joww.game.util.JDBCUtil;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GameDaoImpl implements GameDao {
    private static final String[] sqlKeys = { "`id`", "`name`", "`cover_url`", "`created_at`", "`updated_at`" };

    @Override
    public List<Game> getHottestGameList(int start, int count) {
        List<Game> list = new ArrayList<>();
        Connection conn = JDBCUtil.getConnection();
        Statement stmt = null;
        String sql = "SELECT " + String.join(",", sqlKeys) + " FROM `game` LIMIT " + start + "," + count;
        try {
            stmt = conn.createStatement();
            System.out.println("mysql> " + sql + ";");
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Game game = new Game();
                game.setId(rs.getLong("id"));
                game.setName(rs.getString("name"));
                game.setCoverUrl(rs.getString("cover_url"));
                game.setCreatedAt(rs.getDate("created_at"));
                game.setUpdatedAt(rs.getDate("updated_at"));
                list.add(game);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    @Override
    public List<Game> getLatestGameList(int start, int count) {
        return null;
    }

    @Override
    public List<Game> findGameByName(String name) {
        return null;
    }

    @Override
    public boolean addGamePlayNumById(long id) {
        return false;
    }

    @Override
    public Game findGameById(long id) {
        return null;
    }

	@Override
	public List<Game> getGameList(int start, int count) {
    	Connection connection = JDBCUtil.getConnection();
    	String sql = "SELECT `id`, `name`, `cover_url`, `created_at`, `updated_at` FROM `game` ORDER BY `id` LIMIT ?, ?";
        PreparedStatement pstatement = null;
        ResultSet resultSet = null;
        List<Game> list = new ArrayList<>();
        
        try {
        	pstatement = connection.prepareStatement(sql);
        	pstatement.setInt(1, start);
        	pstatement.setInt(2, count);
            resultSet = pstatement.executeQuery();
            while (resultSet.next()) {
            	long id = resultSet.getLong("id");
            	String name = resultSet.getString("name");
            	String coverUrl = resultSet.getString("cover_url");
            	Date createdAt = resultSet.getDate("created_at");
            	Date updatedAt = resultSet.getDate("updated_at");
            	Game game = new Game(id, name, coverUrl, createdAt, updatedAt);
            	list.add(game);
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
}
