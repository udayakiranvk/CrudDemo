package com.uday.springjpa.CrudDemo.dao.impl;

import com.uday.springjpa.CrudDemo.dao.StudentDAO;
import com.uday.springjpa.CrudDemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl  implements StudentDAO {

    private EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    /**
     * @param student
     */

    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    /**
     * @return
     */
    @Override
    public List<Student> findAll() {

        TypedQuery<Student> theQuery = entityManager.createQuery("From Student order by lastName", Student.class);
        return theQuery.getResultList();
    }

    /**
     * @param lastName
     * @return
     */
    @Override
    public List<Student> findByLastName(String lastName) {
        TypedQuery<Student> theQry = entityManager.createQuery("From Student where lastName = :theData", Student.class);
        theQry.setParameter("theData", lastName);

        return theQry.getResultList();
    }

    /**
     * @param student
     */
    @Override
    @Transactional
    public void update(Student student) {
        entityManager.merge(student);
    }
}
