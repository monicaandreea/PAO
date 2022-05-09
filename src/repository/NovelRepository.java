package repository;

import entity.AuthorEntity;
import entity.NovelEntity;
import mapper.AuthorEntityMapper;
import mapper.NovelEntityMapper;
import service.DatabaseService;

import java.util.ArrayList;
import java.util.List;

public class NovelRepository {

    public static List<NovelEntity> findAll(){
        List<Object> objects = DatabaseService.readQuery("select novel.id, author.id as novelist_id, author.name, author.country, novel.title, novel.language, novel.chapters, novel.pages from novel join author\n" +
                "where novel.novelist_id = author.id;", new NovelEntityMapper());
        List<NovelEntity> result = new ArrayList<>();

        for (Object object : objects){
            if(object instanceof NovelEntity){
                result.add((NovelEntity) object);
            }
            else{
                throw new RuntimeException("Expected other instance.");
            }
        }

        return result;
    }

    public static NovelEntity findById(int id){
        List<Object> objects = DatabaseService.readQuery("select novel.id, author.id as novelist_id, author.name, author.country, novel.title, novel.language, novel.chapters, novel.pages from novel join author\n" +
                "where novel.novelist_id = author.id and novel.id =" + id, new NovelEntityMapper());
        NovelEntity result = new NovelEntity();

        for (Object object : objects){
            if(object instanceof NovelEntity){
                result = (NovelEntity) object;
            }
            else{
                throw new RuntimeException("Expected other instance.");
            }
        }

        return result;
    }
}
