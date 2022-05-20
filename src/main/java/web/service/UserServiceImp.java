package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserRepository;
import web.models.User;

import java.util.List;


@Service
@Transactional
public class UserServiceImp implements UserService {

    private UserRepository userRepository;

    @Autowired
    public void setUserDao(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void addUser(User user) {
        userRepository.addUser(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteUser(id);
    }

    @Override
    public void editUser(User user) {
        userRepository.editUser(user);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.getUserById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }
}

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//import web.dao.UserDAO;
//import web.models.User;
//
//import javax.validation.Valid;
//import java.util.List;
//
//
//@Service
//@Transactional
//public class UserServiceImpl implements UserService {
//    private final UserDAO userDAO;
//
//    @Autowired
//    public UserServiceImpl(UserDAO userDAO)  {
//        this.userDAO = userDAO;
//    }
//
//    @Override
//    public List<User> index() {
//        return userDAO.index();
//    }
//
//    @Override
//    public User show(int id) {
//        return userDAO.show(id);
//    }
//
//    @Override
//    public void save(User user) {
//        userDAO.save(user);
//    }
//
//    @Override
//    public void update(
////            int id, Person updatedPerson
//            @Valid User user
//    ) {
//        userDAO.update(user);
//    }
//
//    @Override
//    public void delete(int id) {
//        userDAO.delete(id);
//    }
//}
