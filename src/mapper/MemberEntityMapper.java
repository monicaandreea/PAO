package mapper;

import entity.ComicsEntity;
import entity.MemberEntity;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberEntityMapper implements RowMapper<MemberEntity>{
    public MemberEntity mapRow(ResultSet rs) throws SQLException {
        int id  = rs.getInt("id");
        String email = rs.getString("email");
        String nickname = rs.getString("nickname");
        String password = rs.getString("password");
        Date bday = rs.getDate("birthday");
        int age = rs.getInt("age");

        return new MemberEntity(id, email, nickname, password, bday, age);
    }
}
