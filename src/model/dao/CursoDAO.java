package model.dao;

import java.util.List;

import model.entities.Curso;

public interface CursoDAO {
	
	void insert(Curso obj);
	
	void update(Curso obj);
	
	void deleteById(int id);
	
	Curso findById(int id);
	
	List<Curso> findAll();
	
}
