package ru.zaletaev.springcourse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.zaletaev.springcourse.dao.PersonDAO;
import ru.zaletaev.springcourse.models.Person;

import java.util.List;


@Service
@Transactional
public class PersonServiceImpl implements PersonService {
    private final PersonDAO personDAO;

    @Autowired
    public PersonServiceImpl(PersonDAO personDAO)  {
        this.personDAO = personDAO;
    }

    @Override
    public List<Person> index() {
        return personDAO.index();
    }

    @Override
    public Person show(int id) {
        return personDAO.show(id);
    }

    @Override
    public void save(Person person) {
        personDAO.save(person);
    }

    @Override
    public void update(int id, Person updatedPerson) {
        personDAO.update(id, updatedPerson);
    }

    @Override
    public void delete(int id) {
        personDAO.delete(id);
    }
}
