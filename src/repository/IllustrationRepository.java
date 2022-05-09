package repository;

import entity.ComicsEntity;
import entity.IllustrationEntity;
import mapper.ComicsEntityMapper;
import mapper.IllustrationEntityMapper;
import service.DatabaseService;

import java.util.ArrayList;
import java.util.List;

public class IllustrationRepository {
    public static List<IllustrationEntity> findAll(){
        List<Object> objects = DatabaseService.readQuery("select * from illustrations;", new IllustrationEntityMapper());
        List<IllustrationEntity> result = new ArrayList<>();

        for (Object object : objects){
            if(object instanceof IllustrationEntity){
                result.add((IllustrationEntity) object);
            }
            else{
                throw new RuntimeException("Expected other instance.");
            }
        }

        return result;
    }

    public static IllustrationEntity findById(int id){
        List<Object> objects = DatabaseService.readQuery("select * from illustrations where id = " + id, new IllustrationEntityMapper());
        IllustrationEntity result = new IllustrationEntity();

        for (Object object : objects){
            if(object instanceof IllustrationEntity){
                result = (IllustrationEntity) object;
            }
            else{
                throw new RuntimeException("Expected other instance.");
            }
        }

        return result;
    }
}
