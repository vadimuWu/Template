package web.dao;



import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import web.models.User;


@Repository
public class UserRepositoryImp implements UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    protected EntityManager getEntityManager() {
        return this.entityManager;
    }

    @Override
    public void addUser(User user) {
        getEntityManager().persist(user);
    }

    @Override
    public void deleteUser(Long id) {
        getEntityManager()
                .createQuery("delete from User where id=: id")
                .setParameter("id", id)
                .executeUpdate();
    }

    @Override
    public void editUser(User user) {
        getEntityManager().merge(user);
    }

    @Override
    public User getUserById(Long id) {
        return getEntityManager().find(User.class, id);
    }

    @Override
    public List<User> getAllUsers() {
        return getEntityManager().createQuery("From User").getResultList();
    }
}

//import org.springframework.stereotype.Component;
//import org.springframework.transaction.annotation.Transactional;
//import web.models.User;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import java.util.List;
//
//@Component
//@Transactional
//public class UserRepositoryImp implements UserDAO {
//
//    @PersistenceContext
//    private EntityManager entityManager;
////    private final JdbcTemplate jdbcTemplate;
////
////    @Autowired
////    public PersonDAOImpl(JdbcTemplate jdbcTemplate) {
////        this.jdbcTemplate = jdbcTemplate;
////    }
//
//    @Override
//    public List<User> index() {
////        return jdbcTemplate.query("SELECT * FROM Person",
////        new BeanPropertyRowMapper<>(Person.class));
//        return entityManager.createQuery("select u from Person u", User.class).getResultList();
//    }
//
//    @Override
//    public User show(int id) {
////        return jdbcTemplate.query("SELECT * FROM Person WHERE id=?",
////                        new Object[]{id}, new BeanPropertyRowMapper<>(Person.class))
////                .stream().findAny().orElse(null);
//        return entityManager.find(User.class,id);
//    }
//
//    @Override
//    public void save(User user) {
////        jdbcTemplate.update("INSERT INTO Person VALUES(5, ?, ?, ?)",
////                person.getName(), person.getAge(), person.getEmail());
//        entityManager.persist(user);
//    }
//
//    @Override
//    public void update(
////            int id, Person updatedPerson
//            User user
//    ) {
////        jdbcTemplate.update("UPDATE Person SET name=?, age=?, email=? WHERE id=?",
////                updatedPerson.getName(), updatedPerson.getAge(),
////                updatedPerson.getEmail(), id);
//        entityManager.merge(user);
//    }
//
//    @Override
//    public void delete(int id) {
////        jdbcTemplate.update("DELETE FROM Person WHERE id=?", id);
//        entityManager.remove(show(id));
//    }
//}
