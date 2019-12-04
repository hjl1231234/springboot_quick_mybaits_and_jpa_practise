package myJPA;

public class TestUserDao {
    public static void main(String[] args) {
        UserDao userDao = new UserDao();
        User user = new User("hst", 20);
        userDao.add(user);
    }
}
