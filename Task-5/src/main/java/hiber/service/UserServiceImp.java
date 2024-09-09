package hiber.service;

import hiber.dao.UserDao;
import hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

   @Autowired
   private UserDao userDao;

   @Transactional
   @Override
   public void add(User user) {
      userDao.add(user);
   }

   @Transactional(readOnly = true)
   @Override
   public List<User> listUsers() {
      return userDao.listUsers();
   }

   @Transactional
   @Override
   public List<User> getUserId(String model, int series) {
      return userDao.getUserId(model, series);
   }


//   @Transactional(readOnly = true)
//   @Override
//   public void deleteAllUsers(){
//      userDao.deleteAllUsers();
//   }
//
//   @Transactional
//   @Override
//   public User findOwner(String car_name, String car_series){
//      return userDao.findOwner(car_name, car_series);
//   }
}
