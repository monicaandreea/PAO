package mapper;

import entity.ComicsEntity;
import entity.IllustrationEntity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class IllustrationEntityMapper implements RowMapper<IllustrationEntity>{
    public IllustrationEntity mapRow(ResultSet rs) throws SQLException {
        int id  = rs.getInt("id");
        int id_i = rs.getInt("illust_id");
        int pag = rs.getInt("pages");
        String title = rs.getString("title");
        String language = rs.getString("language");

        return new IllustrationEntity(id, id_i, title, language, pag);
    }
}
