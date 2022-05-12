package service;

import entity.*;
import mapper.AuthorEntityMapper;
import mapper.BookIdEntityMapper;
import model.*;
import repository.*;


import java.util.ArrayList;
import java.util.List;

public class BookService {
    public static List<Novel> getAllNovels(){
        List<NovelEntity> novelEntities = NovelRepository.findAll();
        List<Novel> novels = new ArrayList<>();
        for(NovelEntity novelEntity:novelEntities) {
            Author author = AuthorService.getAuthorById(novelEntity.getNovelist_id());
            novels.add(new Novel(novelEntity.getTitle(), novelEntity.getLanguage(), author, novelEntity.getChapters(), novelEntity.getPages()));
        }

        return novels;
    }

    public static Novel getNovelsById(int id){
        NovelEntity novelEntity = NovelRepository.findById(id);

        Author author = AuthorService.getAuthorById(novelEntity.getNovelist_id());
        Novel novel = new Novel(novelEntity.getTitle(), novelEntity.getLanguage(), author, novelEntity.getChapters(), novelEntity.getPages());

        return novel;
    }

    public static List<Comics> getAllComics(){
        List<ComicsEntity> comicsEntities = ComicsRepository.findAll();
        List<Comics> comics = new ArrayList<>();
        for(ComicsEntity comicsEntity:comicsEntities) {
            Author writer = AuthorService.getAuthorById(comicsEntity.getWriter_id());
            Author illust = AuthorService.getAuthorById(comicsEntity.getIllust_id());
            comics.add(new Comics(comicsEntity.getTitle(), comicsEntity.getLanguage(), writer, illust, comicsEntity.getVolumes(), comicsEntity.getChapters()));
        }

        return comics;
    }

    public static Comics getComicsById(int id){
        ComicsEntity comicsEntity = ComicsRepository.findById(id);

        Author writer = AuthorService.getAuthorById(comicsEntity.getWriter_id());
        Author illust = AuthorService.getAuthorById(comicsEntity.getIllust_id());
        Comics comics = new Comics(comicsEntity.getTitle(), comicsEntity.getLanguage(), writer, illust, comicsEntity.getVolumes(), comicsEntity.getChapters());

        return comics;
    }

    public static List<Illustrations> getAllIllustrations(){
        List<IllustrationEntity> illustrationEntities = IllustrationRepository.findAll();
        List<Illustrations> illusts = new ArrayList<>();
        for(IllustrationEntity illustrationEntity:illustrationEntities) {
            Author illust = AuthorService.getAuthorById(illustrationEntity.getIllust_id());
            illusts.add(new Illustrations(illustrationEntity.getTitle(), illustrationEntity.getLanguage(), illust, illustrationEntity.getPages()));
        }

        return illusts;
    }

    public static Illustrations getIllustrationById(int id){
        IllustrationEntity illustrationEntity = IllustrationRepository.findById(id);

        Author illust = AuthorService.getAuthorById(illustrationEntity.getIllust_id());
        Illustrations illusts = new Illustrations(illustrationEntity.getTitle(), illustrationEntity.getLanguage(), illust, illustrationEntity.getPages());

        return illusts;
    }

    public static List<Poetry> getAllPoetry(){
        List<PoetryEntity> poetryEntities = PoetryRepository.findAll();
        List<Poetry> poems = new ArrayList<>();
        for(PoetryEntity poetryEntity:poetryEntities) {
            Author poet = AuthorService.getAuthorById(poetryEntity.getPoet_id());
            poems.add(new Poetry(poetryEntity.getTitle(), poetryEntity.getLanguage(), poet, poetryEntity.getPoems()));
        }

        return poems;
    }

    public static Poetry getPoetryById(int id){
        PoetryEntity poetryEntity = PoetryRepository.findById(id);

        Author poet = AuthorService.getAuthorById(poetryEntity.getPoet_id());
        Poetry poem = new Poetry(poetryEntity.getTitle(), poetryEntity.getLanguage(), poet, poetryEntity.getPoems());

        return poem;
    }

    public static List<Book> getAllBooks(){
        List<Book> books = new ArrayList<>();
        List<Novel> novels = getAllNovels();
        List<Comics> comics = getAllComics();
        List<Illustrations> illusts = getAllIllustrations();
        List<Poetry> poems = getAllPoetry();

        books.addAll(novels);
        books.addAll(comics);
        books.addAll(illusts);
        books.addAll(poems);

        return books;
    }

    public static BookIdEntity getBookByName(String title){
        BookIdEntity bookIdEntity = BookIdRepository.findByName(title);

        return bookIdEntity;
    }
}
