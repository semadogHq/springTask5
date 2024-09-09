package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
//      AnnotationConfigApplicationContext context = 
//            new AnnotationConfigApplicationContext(AppConfig.class);
//
////      CarService carService = context.getBean(CarService.class);
////
////
////      carService.add(new Car("BMW", 3));
////      carService.add(new Car("Audi", 2));
////      carService.add(new Car("Mercedes", 1));
////      carService.add(new Car("Ford", 3));
////
////      UserService userService = context.getBean(UserService.class);
////      userService.deleteAllUsers();
////      List<Car> cars = carService.listCars();
//
////      User user1 = new User("User1", "Lastname1", "user1@mail.ru" );
////      User user2 = new User("User2", "Lastname2", "user2@mail.ru" );
////      User user3 = new User("User3", "Lastname3", "user3@mail.ru" );
////      User user4 = new User("User4", "Lastname4", "user4@mail.ru" );
//
//      UserService userService = context.getBean(UserService.class);
//
//      Car car1 = new Car("ModelX", 2024);
//      Car car2 = new Car("ModelY", 2023);
//      Car car3 = new Car("ModelZ", 2022);
//      Car car4 = new Car("ModelU", 2021);
//
//
//      userService.add(new User("User1", "Lastname1", "user1@mail.ru", car1));
//      userService.add(new User("User2", "Lastname2", "user2@mail.ru", car2));
//      userService.add(new User("User3", "Lastname3", "user3@mail.ru", car3));
//      userService.add(new User("User4", "Lastname4", "user4@mail.ru", car4));
//
//      List<User> users = userService.listUsers();
//      for (User user : users) {
//         System.out.println("Id = "+user.getId());
//         System.out.println("First Name = "+user.getFirstName());
//         System.out.println("Last Name = "+user.getLastName());
//         System.out.println("Email = "+user.getEmail());
//         System.out.println();
//      }
//
////      User usersByCar = userService.getUserByCarModelAndSeries("ModelX", 2024);
////      System.out.println("Found Users by Car:");
////      for (User user : usersByCar) {
////         System.out.println("Id = " + user.getId());
////         System.out.println("First Name = " + user.getFirstName());
////         System.out.println("Last Name = " + user.getLastName());
////         System.out.println("Email = " + user.getEmail());
////         System.out.println();
////      }
//
//
//      System.exit(0);
     // context.close();
      AnnotationConfigApplicationContext context =
              new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);


      User user1 = new User("User1", "Lastname1", "user1@mail.ru");
      user1.setUserCars(new Car("VAZ", 2109));
      userService.add(user1);
      User user2 = new User("User2", "Lastname2", "user2@mail.ru");
      user2.setUserCars(new Car("VAZ", 2108));
      userService.add(user2);
      User user3 = new User("User3", "Lastname3", "user3@mail.ru");
      user3.setUserCars(new Car("VAZ", 2114));
      userService.add(user3);
      User user4 = new User("User4", "Lastname4", "user4@mail.ru");
      user4.setUserCars(new Car("VAZ", 2115));
      userService.add(user4);


      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = " + user.getId());
         System.out.println("First Name = " + user.getFirstName());
         System.out.println("Last Name = " + user.getLastName());
         System.out.println("Email = " + user.getEmail());
         System.out.println("Car = " + user.getUserCars());
         System.out.println();
      }

      System.out.println(userService.getUserId("VAZ",2108));

      System.exit(0);//Закрывает контекст и все остальные хрени

   }
}
