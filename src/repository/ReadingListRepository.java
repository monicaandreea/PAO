package repository;

import entity.PoetryEntity;
import entity.ReadingListEntity;
import mapper.PoetryEntityMapper;
import mapper.ReadingListEntityMapper;
import model.ReadingList;
import service.DatabaseService;

import java.util.ArrayList;
import java.util.List;

public class ReadingListRepository {
    public static List<ReadingListEntity> findAll(){
        List<Object> objects = DatabaseService.readQuery("select * from reading_list;", new ReadingListEntityMapper());
        List<ReadingListEntity> result = new ArrayList<>();

        for (Object object : objects){
            if(object instanceof ReadingListEntity){
                result.add((ReadingListEntity) object);
            }
            else{
                throw new RuntimeException("Expected other instance.");
            }
        }

        return result;
    }

    public static List<ReadingListEntity> findByMember(int id){
        List<Object> objects = DatabaseService.readQuery("select * from reading_list where member_id = " +id , new ReadingListEntityMapper());
        List<ReadingListEntity> result = new ArrayList<>();

        for (Object object : objects){
            if(object instanceof ReadingListEntity){
                result.add((ReadingListEntity) object);
            }
            else{
                throw new RuntimeException("Expected other instance.");
            }
        }

        return result;
    }
}
