import books.*;
import users.*;
import utilities.*;

import java.text.ParseException;
import java.util.Date;


public class main {

    public static void main(String[] args) throws ParseException {
        Admin admin = new Admin();
        AuthorType[] mangaka = new AuthorType[]{AuthorType.writer, AuthorType.illustrator};

        // print("What do you want to do?")
        // input(Create account, Login)
        // while( loggedUser != null )
        // input( log out, addBooK, updateIDK)
        // when logged out, rerun main

        Author sui = new Author( mangaka, "Ishida Sui", "Japan" );
        Comics tokyoGhoul = new Comics("Tokyo Ghoul", "japanese", sui, sui, 20, 100);

        admin.addAuthor(sui);
        admin.addBook(tokyoGhoul);

        //Member membru = new Member("monica@gmail.com", "monica", new Date(2001, 6, 4), "123456");

        admin.createAccount();

        System.out.println(admin.getMembers());
        System.out.println(admin.getAuthors());
        System.out.println(admin.getBooks());
        admin.login();

        System.out.println(admin.getLoggedUser());

        Member user = (Member) admin.getLoggedUser();
        user.addBook(tokyoGhoul, null, 0, null, null, null);

        System.out.println(user.getList());

        user.updateScore("Tokyo ghoul", ReadingScore.masterpiece);
        user.updateStatus("Tokyo ghoul", ReadingState.reading);
        user.updateAmountRead("Tokyo ghoul", 5);
        System.out.println(user.getList());
    }
}
