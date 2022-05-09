package repository;

import entity.ComicsEntity;
import entity.PoetryEntity;
import mapper.ComicsEntityMapper;
import mapper.PoetryEntityMapper;
import service.DatabaseService;

import java.util.ArrayList;
import java.util.List;

public class PoetryRepository {
    public static List<PoetryEntity> findAll(){
        List<Object> objects = DatabaseService.readQuery("select * from poetry;", new PoetryEntityMapper());
        List<PoetryEntity> result = new ArrayList<>();

        for (Object object : objects){
            if(object instanceof PoetryEntity){
                result.add((PoetryEntity) object);
            }
            else{
                throw new RuntimeException("Expected other instance.");
            }
        }

        return result;
    }

    public static PoetryEntity findById(int id){
        List<Object> objects = DatabaseService.readQuery("select * from poetry where id = "+ id, new PoetryEntityMapper());
        PoetryEntity result = new PoetryEntity();

        for (Object object : objects){
            if(object instanceof PoetryEntity){
                result = (PoetryEntity) object;
            }
            else{
                throw new RuntimeException("Expected other instance.");
            }
        }

        return result;
    }
}
