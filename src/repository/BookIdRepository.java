package repository;

import entity.BookIdEntity;
import mapper.BookIdEntityMapper;
import service.DatabaseService;

import java.util.List;

public class BookIdRepository {
    public static BookIdEntity findByName(String title){
        List<Object> objects = DatabaseService.readQuery("select id,  title, 'novel' as type from novel where title = '"+
                        title +"' union select id, title, 'illustration' as type from illustrations where title = '" +
                        title +"' union select id,  title, 'comics' as type from comics where title = '"+
                        title +"' union select id,  title, 'poetry' as type from poetry where title = '"+
                        title +"'"
                , new BookIdEntityMapper());

        BookIdEntity result = new BookIdEntity();

        for (Object object : objects){
            if(object instanceof BookIdEntity){
                result = (BookIdEntity) object;
            }
            else{
                throw new RuntimeException("Expected other instance.");
            }
        }

        return result;
    }
}
