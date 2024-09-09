package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {
    private final SessionFactory sessionFactory;

    public UserDaoImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(User user) {
        this.sessionFactory.getCurrentSession().save(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> getUserId(String model, int series) {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery(
                "select u from User u where u.userCars.model=:model and u.userCars.series=:series");
        query.setParameter("model", model);
        query.setParameter("series", series);
        return query.getResultList();
    }

}

//@Repository
//public class UserDaoImp implements UserDao {
//
//
//    private final SessionFactory sessionFactory;
//
//    public UserDaoImp(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//    }
//
//    @Override
//    public void add(User user) {
//        sessionFactory.getCurrentSession().save(user);
//    }
//
//    @Override
//    @SuppressWarnings("unchecked")
//    public List<User> listUsers() {
//        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
//        return query.getResultList();
//    }
//
//    @Override
//    @SuppressWarnings("unchecked")
//    public User getUserByCarModelAndSeries(String model, int series) {
//        TypedQuery<User> query = sessionFactory.getCurrentSession()
//                .createQuery("select u from  User u where u.car.model = :model and u.car.series = :series");
//        query.setParameter("model", model);
//        query.setParameter("series", series);
//        return query.setMaxResults(1).getSingleResult();
//    }

//  @Override
//  @SuppressWarnings("unchecked")
//   public void deleteAllUsers(){
//      List<User> users = listUsers();
//      for(User user : users){
//         sessionFactory.getCurrentSession().delete(user);
//      }
//  }
//
//  @Override
//   public User findOwner(String car_name, String car_series){
//      TypedQuery<Car> findCarOuery = sessionFactory.getCurrentSession().createQuery("from Car where model = :car_name and series = :car_series")
//              .setParameter("car_name", car_name)
//              .setParameter("car_series", car_series);
//      List<Car> findCarList = findCarOuery.getResultList();
//      if(!findCarList.isEmpty()){
//         Car findCar = findCarList.get(0);
//         List<User> ListUser = listUsers();
//         User FindUser = ListUser.stream()
//                 .filter(user -> user.getCar().equals(findCar))
//                 .findAny()
//                 .orElse(null);
//         return FindUser;
//      }
//      return null;
//  }


