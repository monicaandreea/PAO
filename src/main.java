import books.*;
import users.*;
import utilities.*;


public class main {

    public static void main(String[] args){
        System.out.println("Hello");

        AuthorType[] mangaka = new AuthorType[]{AuthorType.writer, AuthorType.illustrator};

        Author sui = new Author(mangaka, "Ishida Sui", "Japan" );
    }
}
