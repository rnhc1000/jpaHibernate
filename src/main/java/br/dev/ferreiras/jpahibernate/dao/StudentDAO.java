package br.dev.ferreiras.jpahibernate.dao;

import java.util.List;

import br.dev.ferreiras.jpahibernate.entity.Student;

public interface StudentDAO {
	void save(Student student);
	Student findById(Integer id);
	List<Student> findAll();
}
