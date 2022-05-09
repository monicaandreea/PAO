package repository;

import entity.ComicsEntity;
import entity.NovelEntity;
import mapper.ComicsEntityMapper;
import mapper.NovelEntityMapper;
import service.DatabaseService;

import java.util.ArrayList;
import java.util.List;

public class ComicsRepository {

    public static List<ComicsEntity> findAll(){
        List<Object> objects = DatabaseService.readQuery("select * from comics;", new ComicsEntityMapper());
        List<ComicsEntity> result = new ArrayList<>();

        for (Object object : objects){
            if(object instanceof ComicsEntity){
                result.add((ComicsEntity) object);
            }
            else{
                throw new RuntimeException("Expected other instance.");
            }
        }

        return result;
    }

    public static ComicsEntity findById(int id){
        List<Object> objects = DatabaseService.readQuery("select * from comics where id = " + id, new ComicsEntityMapper());
        ComicsEntity result = new ComicsEntity();

        for (Object object : objects){
            if(object instanceof ComicsEntity){
                result = (ComicsEntity) object;
            }
            else{
                throw new RuntimeException("Expected other instance.");
            }
        }

        return result;
    }
}
