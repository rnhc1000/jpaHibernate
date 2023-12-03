package br.dev.ferreiras.jpahibernate.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.dev.ferreiras.jpahibernate.dao.StudentDAO;
import br.dev.ferreiras.jpahibernate.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class StudentDAOService implements StudentDAO{
	
	// define field for entity manager
	private EntityManager entityManager;
	
	//inject entity manager via constructor
	@Autowired
	public StudentDAOService(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	public void save(Student student) {
		entityManager.persist(student);
		
	}

	@Override
	public Student findById(Integer id) {
		// TODO Auto-generated method stub
		return entityManager.find(Student.class, id);
	}

	@Override
	public List<Student> findAll() {

		TypedQuery<Student> query = entityManager.createQuery("FROM Student order by lastName desc", Student.class);
		
		return query.getResultList();
	}

}
