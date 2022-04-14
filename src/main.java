import books.*;
import users.*;
import utilities.*;

import javax.swing.plaf.metal.MetalMenuBarUI;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

// member function 3 and 4
// de mutat toate functiile de adaugare/update in service
// de mutat functiile din main de aici intr-un class menu
// add date joined to member as current date when initialising
// check if book/author already exists when admin adds it
// check that member email is unique and change password if they forgot it?
// check that email and dates are valid (end date>start date and smaller than current date?)
// change end date to today when book status is completed (la update)
// "book succesfully added/updated" message

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
                        System.out.println("1. Add book -- 2. Update book -- 3. Show list -- 4. See stats -- 5. See books -- 6. Log out");
                        String action = read.nextLine();
                        if (Objects.equals(action, "1")) {
                            System.out.println("What book would you like to add to your list? (title)");
                            String book_name = read.nextLine();

                            member.createBookEntry(book_name);

                            continue;
                        }
                        if (Objects.equals(action, "2")) {
                            System.out.println("What book would you like to update? (title)");
                            String book_name = read.nextLine();
                            System.out.println("What would you like to update?");
                            System.out.println("1. Score  -- 2. Status -- 3. Amount Read -- 4. Start/End Date");
                            String update_action = read.nextLine();

                            if (Objects.equals(update_action, "1")) {
                                System.out.println("What is the new score?");
                                System.out.println("1- masterpiece -- 2. good -- 3. average -- 4. bad -- 5. horrible");
                                String new_value = read.nextLine();
                                member.updateScore(book_name, ReadingScore.forInt(parseInt(new_value)));
                                continue;
                            }
                            if (Objects.equals(update_action, "2")) {
                                System.out.println("What is the new status?");
                                System.out.println("1- completed -- 2. reading -- 3. dropped -- 4. plan to read");
                                String new_value = read.nextLine();
                                member.updateStatus(book_name, ReadingState.forInt(parseInt(new_value)));
                                if(Objects.equals(new_value, "1")){
                                    member.updateAmountRead(book_name, -1);
                                }
                                if(Objects.equals(new_value, "4")){
                                    member.updateAmountRead(book_name, 0);
                                }
                                continue;
                            }
                            if (Objects.equals(update_action, "3")) {
                                System.out.println("How much have you read?");
                                String new_value = read.nextLine();
                                member.updateAmountRead(book_name, parseInt(new_value));
                                continue;
                            }
                            if (Objects.equals(update_action, "4")) {
                                member.updateDates(book_name);
                            }
                            continue;
                        }
                        if (Objects.equals(action, "3")) {
                            System.out.println(member.getList());
                            continue;
                        }
                        if (Objects.equals(action, "4")) {
                            // date joined
                            // age
                            // time spent reading (2 minutes per page)
                            // how many books they are reading
                            // how many books they completed
                            // how many books they dropped
                            // how many books they plan to read
                        }
                        if (Objects.equals(action, "5")){
                            System.out.println(admin.getBooks());
                        }
                        if (Objects.equals(action, "6")) {
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
    }
}
