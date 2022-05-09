package mapper;

import entity.AuthorEntity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthorEntityMapper implements RowMapper<AuthorEntity> {
    public AuthorEntity mapRow(ResultSet rs) throws SQLException {
        int id  = rs.getInt("id");
        String name = rs.getString("name");
        String country = rs.getString("country");

        return new AuthorEntity(id, name, country);
    }
}
