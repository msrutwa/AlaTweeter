import dao.UserDao;
import dao.dao.impl.AppUserDao;
import model.AppUser;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Test {


    public static void main(String[] args) {

        UserDao userDao = new AppUserDao();
        AppUser user1 = new AppUser();
        AppUser user2 = new AppUser();
        AppUser user3 = new AppUser();
        AppUser user4 = new AppUser();

        user1.setName("Jan");
        user1.setLastName("Kowalski");
        user1.setLogin("jan78");
        user1.setEmail("jan78@gmail.com");
        user1.setPassword("34ad");
        user1.setDateOfRegistration(new Date());
        userDao.saveUser(user1);


        user2.setName("Adam");
        user2.setLastName("Nowak");
        user2.setLogin("adam80");
        user2.setEmail("adam80@gmail.com");
        user2.setPassword("1234");
        user2.setDateOfRegistration(new Date());
        userDao.saveUser(user2);


        user3.setName("A");
        user3.setLastName("B");
        user3.setLogin("ab");
        user3.setEmail("ab@mail.com");
        user3.setPassword("1");
        user3.setDateOfRegistration(new Date());
        userDao.saveUser(user3);

        user4.setName("A");
        user4.setLastName("C");
        user4.setLogin("ac");
        user4.setEmail("ab@mail.com");
        user4.setPassword("1");
        user4.setDateOfRegistration(new Date());
        userDao.saveUser(user4);


        userDao.follow("jan78", "adam80");
        AppUser adam80 = userDao.getUserByLogin("adam80");
        Set<AppUser> followers = adam80.getFollowers();
        userDao.stopFollowing("jan78", "adam80");
        AppUser adam801 = userDao.getUserByLogin("adam80");
        HashSet<AppUser> followers1 = userDao.getFollowers(adam801.getLogin());

        System.out.println(followers1.size());
        userDao.saveUser(adam801);



    }
}
