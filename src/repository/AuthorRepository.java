package repository;

import entity.AuthorEntity;
import mapper.AuthorEntityMapper;
import mapper.TypeEntityMapper;
import model.AuthorType;
import service.DatabaseService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AuthorRepository {

    public static List<AuthorEntity> findAll(){
        List<Object> objects = DatabaseService.readQuery("select * from author", new AuthorEntityMapper());
        List<AuthorEntity> result = new ArrayList<>();

        for (Object object : objects){
            if(object instanceof AuthorEntity){
                result.add((AuthorEntity) object);
            }
            else{
                throw new RuntimeException("Expected other instance.");
            }
        }

        return result;
    }

    public static AuthorEntity findById(int id){
        List<Object> objects = DatabaseService.readQuery("select * from author where id = "+ id, new AuthorEntityMapper());
        AuthorEntity result = new AuthorEntity();

        for (Object object : objects){
            if(object instanceof AuthorEntity){
                result = (AuthorEntity) object;
            }
            else{
                throw new RuntimeException("Expected other instance.");
            }
        }

        return result;
    }

}
