package mapper;

import entity.AuthorEntity;
import entity.NovelEntity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class NovelEntityMapper implements  RowMapper<NovelEntity>{
    public NovelEntity mapRow(ResultSet rs) throws SQLException {
        int id  = rs.getInt("id");
        int id_n = rs.getInt("novelist_id");
        String name = rs.getString("name");
        String country = rs.getString("country");
        String title = rs.getString("title");
        String language = rs.getString("language");
        int ch  = rs.getInt("chapters");
        int pag = rs.getInt("pages");

        return new NovelEntity(id, id_n, name, country, title, language, ch, pag);
    }
}
