package mapper;

import entity.ReadingListEntity;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReadingListEntityMapper implements RowMapper<ReadingListEntity>{
    public ReadingListEntity mapRow(ResultSet rs) throws SQLException {
        int id  = rs.getInt("id");
        int id_m = rs.getInt("member_id");
        int id_b = rs.getInt("book_id");
        String status = rs.getString("status");
        int amount  = rs.getInt("amount");
        String score = rs.getString("score");
        Date start_date = rs.getDate("start_date");
        Date end_date = rs.getDate("end_date");
        String type = rs.getString("type");


        return new ReadingListEntity(id,id_m, id_b, status, amount, score, start_date, end_date, type);
    }
}
