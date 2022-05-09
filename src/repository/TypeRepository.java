package repository;

import entity.AuthorEntity;
import entity.TypeEntity;
import mapper.*;
import model.AuthorType;
import service.DatabaseService;

import java.util.ArrayList;
import java.util.List;

public class TypeRepository {

    public static List<TypeEntity> findAll(){
        List<Object> objects = DatabaseService.readQuery("select * from author_type", new TypeEntityMapper());
        List<TypeEntity> result = new ArrayList<>();

        for (Object object : objects){
            if(object instanceof TypeEntity){
                result.add((TypeEntity) object);
            }
            else{
                throw new RuntimeException("Expected other instance.");
            }
        }

        return result;
    }

    public static List<AuthorType> findTypes(int id){
        List<Object> objects = DatabaseService.readQuery("select * from author_type where author_id = " + id, new TypeEntityMapper());
        List<AuthorType> result = new ArrayList<>();

        for (Object object : objects){
            if(object instanceof TypeEntity){
                if (((TypeEntity) object).getType_id() == 1) result.add(AuthorType.novelist);
                if (((TypeEntity) object).getType_id() == 2) result.add(AuthorType.poet);
                if (((TypeEntity) object).getType_id() == 3) result.add(AuthorType.illustrator);
            }
            else{
                throw new RuntimeException("Expected other instance.");
            }
        }

        return result;
    }

}
