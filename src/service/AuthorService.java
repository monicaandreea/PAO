package service;

import entity.AuthorEntity;
import entity.TypeEntity;
import model.Author;
import model.AuthorType;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AuthorService {
    public static List<Author> getAllAuthors(){
        List<AuthorEntity> authorEntities = DatabaseService.readAuthorsQuery();
        List<TypeEntity> typeEntities = DatabaseService.readTypesQuery();
        List<Author> authors = new ArrayList<>();

        for(AuthorEntity authorEntity:authorEntities){
            ArrayList<AuthorType> author_type = new ArrayList<AuthorType>();
            for(TypeEntity typeEntity:typeEntities)
                if(Objects.equals(typeEntity.getAuthor_id(), authorEntity.getId())){
                    if (Objects.equals(typeEntity.getType_id(), 1)) author_type.add(AuthorType.novelist);
                    if (Objects.equals(typeEntity.getType_id(), 2)) author_type.add(AuthorType.poet);
                    if (Objects.equals(typeEntity.getType_id(), 3)) author_type.add(AuthorType.illustrator);
                }
            authors.add(new Author(authorEntity.getId(), author_type, authorEntity.getName(), authorEntity.getCountry()));
        }

        System.out.println(authors);
        return authors;
    }
}
