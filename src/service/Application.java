package service;

import entity.AuthorEntity;

public class Application {
    public static void main(String[] args) {
        AuthorService.getAllAuthors();
        //BookService.getAllNovels();
        //BookService.getAllComics();
        //BookService.getAllIllustrations();
        //BookService.getAllPoetry();
        //MemberService.getAllMembers();
        String name = "Yana Toboso";
        String country = "Japan";
        int author_id = AuthorService.getAuthorIdByName(name);
        int type_id = 3;

        //DatabaseService.insertQuery("insert into author(name, country) values ('"+name+"','"+country+"')");
        //DatabaseService.insertQuery("insert into author_type(author_id, type_id) values ("+author_id+","+type_id+")");
       // DatabaseService.insertQuery("insert into comics(writer_id, illust_id, title, language, volumes, chapters) values ("+
         //       writer_id+","+illust_id+","+")");
        System.out.println("after update");
        AuthorService.getAllAuthors();

    }
}
