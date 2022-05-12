package mapper;

import entity.AuthorEntity;
import entity.BookIdEntity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookIdEntityMapper implements RowMapper<BookIdEntity>{
    public BookIdEntity mapRow(ResultSet rs) throws SQLException {
        int id  = rs.getInt("id");
        String title = rs.getString("title");
        String type = rs.getString("type");

        return new BookIdEntity(id, title, type);
    }
}
