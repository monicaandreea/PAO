package mapper;

import entity.ComicsEntity;
import entity.NovelEntity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ComicsEntityMapper implements RowMapper<ComicsEntity>{
    public ComicsEntity mapRow(ResultSet rs) throws SQLException {
        int id  = rs.getInt("id");
        int id_n = rs.getInt("writer_id");
        int id_i = rs.getInt("illust_id");
        String title = rs.getString("title");
        String language = rs.getString("language");
        int vol  = rs.getInt("volumes");
        int ch = rs.getInt("chapters");

        return new ComicsEntity(id, id_n, id_i, title, language, vol, ch);
    }
}
