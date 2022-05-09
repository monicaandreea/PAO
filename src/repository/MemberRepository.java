package repository;

import entity.ComicsEntity;
import entity.MemberEntity;
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
}
