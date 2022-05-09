package mapper;

import entity.AuthorEntity;
import entity.TypeEntity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TypeEntityMapper implements RowMapper<TypeEntity> {

        public TypeEntity mapRow(ResultSet rs) throws SQLException {
            int id_a  = rs.getInt("author_id");
            int id_t = rs.getInt("type_id");

            return new TypeEntity(id_a, id_t);
        }
}

