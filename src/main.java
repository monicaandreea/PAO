import books.*;
import users.*;
import utilities.*;

import javax.swing.plaf.metal.MetalMenuBarUI;
import java.text.ParseException;
import java.util.Date;
import java.util.Objects;
import java.util.Scanner;

// member function 3 and 4
// add MemberService and replace admin with Account class

public class main {

    public static void main(String[] args) throws ParseException {
        Scanner read = new Scanner(System.in);
        boolean run = true;
        Admin admin = Admin.getInstance();
        admin.addMember(admin);

        while(run){
            System.out.println("Hello! What would you like to do?");
            System.out.println("1. Create account -- 2. Login -- 3. Exit");
            String menu_action = read.nextLine();
            if(Objects.equals(menu_action, "1")){
                admin.createAccount();
                continue;
            }
            if(Objects.equals(menu_action, "2")) {
                admin.login();
                User user = admin.getLoggedUser();
                if (user instanceof Admin user_admin) {
                    boolean logged_in = true;
                    while (logged_in) {
                        System.out.println("What would you like to do?");
                        System.out.println("1. Add book -- 2. Add author -- 3. See data -- 4. Log out");
                        String action = read.nextLine();
                        if (Objects.equals(action, "1")) {
                            System.out.println("What kind of book would you like to add?");
                            System.out.println("1. Comic -- 2. Illustration -- 3. Novel -- 4. Poetry");
                            String book_kind = read.nextLine();
                            if (Objects.equals(book_kind, "1")){
                                admin.addComic();
                            }
                            if (Objects.equals(book_kind, "2")){
                                admin.addIllustration();
                            }
                            if (Objects.equals(book_kind, "3")){
                                admin.addNovel();
                            }
                            if (Objects.equals(book_kind, "4")){
                                admin.addPoetry();
                            }
                            continue;
                        }
                        if (Objects.equals(action, "2")) {
                            admin.CreateAuthor();
                            continue;
                        }
                        if (Objects.equals(action, "3")) {
                            System.out.println("What kind of data would you like to see?");
                            System.out.println("1. Members -- 2. Books -- 3. Authors");
                            String data_kind = read.nextLine();
                            if (Objects.equals(data_kind, "1")){
                                System.out.println(admin.getMembers());
                            }
                            if (Objects.equals(data_kind, "2")){
                                System.out.println(admin.getBooks());
                            }
                            if (Objects.equals(data_kind, "3")){
                                System.out.println(admin.getAuthors());
                            }
                            continue;
                        }
                        if (Objects.equals(action, "4")) {
                            admin.logout();
                            logged_in = false;
                        }
                    }
                }
                if (user instanceof Member member) {
                    boolean logged_in = true;
                    while (logged_in) {
                        System.out.println("What would you like to do?");
                        System.out.println("1. Add book -- 2. Update book -- 3. Show list -- 4. See stats -- 5. Log out");
                        String action = read.nextLine();
                        if (Objects.equals(action, "1")) {
                            //member.addBook(tokyoGhoul, null, 0, null, null, null);
                            continue;
                        }
                        if (Objects.equals(action, "2")) {
                            member.updateAmountRead("Tokyo Ghoul", 5);
                            continue;
                        }
                        if (Objects.equals(action, "3")) {
                            System.out.println(member.getList());
                            continue;
                        }
                        if (Objects.equals(action, "4")) {
                            // time spent reading (2 minutes per page)
                            // how many books they are reading
                            // how many books they completed
                            // how many books they dropped
                            // how many books they plan to read
                        }
                        if (Objects.equals(action, "5")) {
                            admin.logout();
                            logged_in = false;
                        }
                    }
                }
            }
            if (Objects.equals(menu_action, "3")) {
                run = false;
                return;
            }
        }


        /*

                //AuthorType[] mangaka = new AuthorType[]{AuthorType.writer, AuthorType.illustrator};
        //Author sui = new Author( mangaka, "Ishida Sui", "Japan" );
        //Comics tokyoGhoul = new Comics("Tokyo Ghoul", "japanese", sui, sui, 20, 100);
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
        System.out.println(user.getList()); */
    }
}
