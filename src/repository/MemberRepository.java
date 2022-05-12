package repository;

import entity.AuthorEntity;
import entity.ComicsEntity;
import entity.MemberEntity;
import mapper.AuthorEntityMapper;
import mapper.ComicsEntityMapper;
import mapper.MemberEntityMapper;
import service.DatabaseService;

import java.util.ArrayList;
import java.util.List;

public class MemberRepository {
    public static List<MemberEntity> findAll(){
        List<Object> objects = DatabaseService.readQuery("select * from member;", new MemberEntityMapper());
        List<MemberEntity> result = new ArrayList<>();

        for (Object object : objects){
            if(object instanceof MemberEntity){
                result.add((MemberEntity) object);
            }
            else{
                throw new RuntimeException("Expected other instance.");
            }
        }

        return result;
    }

    public static MemberEntity findByName(String name){
        List<Object> objects = DatabaseService.readQuery("select * from member where nickname = '"+ name+"'", new MemberEntityMapper());
        MemberEntity result = new MemberEntity();

        for (Object object : objects){
            if(object instanceof MemberEntity){
                result = (MemberEntity) object;
            }
            else{
                throw new RuntimeException("Expected other instance.");
            }
        }

        return result;
    }

    public static void updateList(String column, String value, int member_id, int book_id){
        DatabaseService.updateQuery("update reading_list set"+column+"= "+ value+
                " where member_id = "+member_id+" and book_id="+book_id);
    }
}
