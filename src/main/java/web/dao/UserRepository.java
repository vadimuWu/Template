package web.dao;

import web.models.User;

import java.util.List;

public interface UserRepository {
    void addUser(User user);

    void deleteUser(Long id);

    void editUser(User user);

    User getUserById(Long id);

    List<User> getAllUsers();
}

//import web.models.User;
//
//import java.util.List;
//
//public interface UserDAO {
//    List<User> index();
//
//    User show(int id);
//
//    void save(User user);
//
//    void update(
////            int id, Person updatedPerson
//            User user
//    );
//
//    void delete(int id);
//}
