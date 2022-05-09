package mapper;

import entity.ComicsEntity;
import entity.PoetryEntity;
import org.h2.result.Row;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PoetryEntityMapper implements RowMapper<PoetryEntity> {
    public PoetryEntity mapRow(ResultSet rs) throws SQLException {
        int id  = rs.getInt("id");
        int id_p = rs.getInt("poet_id");
        String title = rs.getString("title");
        String language = rs.getString("language");
        int poems = rs.getInt("poems");

        return new PoetryEntity(id, id_p,title, language, poems);
    }
}
