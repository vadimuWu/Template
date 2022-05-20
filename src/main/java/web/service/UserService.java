package web.service;


import web.models.User;

import java.util.List;

public interface UserService {
    void addUser(User user);

    void deleteUser(Long id);

    void editUser(User user);

    User getUserById(Long id);

    List<User> getAllUsers();
}
//
//import web.models.User;
//
//import javax.validation.Valid;
//import java.util.List;
//
//public interface UserService {
//    List<User> index();
//
//    User show(int id);
//
//    void save(User user);
//
//    void update(
////            int id, Person updatedPerson
//            @Valid User user
//    );
//
//    void delete(int id);
//}
