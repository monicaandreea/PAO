package users;

public class Admin extends User{
    AuthorityLevel level;
    // high - can delete users/change information about users (email, nickname) (delete them if they arent at least 16 yo)
    // medium - can add new books
    // low - can change information about existing books
}
