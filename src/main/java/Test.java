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


        userDao.follow("jan78", "adam80");
        AppUser adam80 = userDao.getUserByLogin("adam80");
        Set<AppUser> followers = adam80.getFollowers();
        userDao.stopFollowing("jan78", "adam80");
        AppUser adam801 = userDao.getUserByLogin("adam80");
        HashSet<AppUser> followers1 = userDao.getFollowers(adam801.getLogin());

        System.out.println(followers1.size());
        userDao.saveUser(adam801);
        returnTest();



    }

    public static void returnTest(){
        if(true){
            System.out.println("IN if");
            return;
        }
        System.out.println("outside");
    }


}
