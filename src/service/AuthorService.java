package service;

import entity.AuthorEntity;
import entity.TypeEntity;
import model.Author;
import model.AuthorType;
import repository.AuthorRepository;
import repository.TypeRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AuthorService {
    public static List<Author> getAllAuthors(){
        List<AuthorEntity> authorEntities = AuthorRepository.findAll();
        List<Author> authors = new ArrayList<>();

        for(AuthorEntity authorEntity:authorEntities) {
            List<AuthorType> author_type = TypeRepository.findTypes(authorEntity.getId());

            authors.add(new Author(authorEntity.getId(), (ArrayList<AuthorType>) author_type, authorEntity.getName(), authorEntity.getCountry()));
        }

        return authors;
    }

    public static Author getAuthorById(int id){
        AuthorEntity authorEntity = AuthorRepository.findById(id);

        List<AuthorType> author_type = TypeRepository.findTypes(authorEntity.getId());
        Author author = new Author(authorEntity.getId(), (ArrayList<AuthorType>) author_type, authorEntity.getName(), authorEntity.getCountry());

        return author;
    }

    public static Integer getAuthorIdByName(String name){
        AuthorEntity authorEntity = AuthorRepository.findByName(name);

        return authorEntity.getId();
    }

    public static void addAuthor(Author author){
        DatabaseService.insertQuery("insert into author(name, country) values ('"+author.getName()+"','"+author.getCountry()+"')");
    }

}
