package model.dao;

import java.util.List;

import model.entities.Aluno;

public interface AlunoDAO {
	
	void insert(Aluno obj);
	
	void update(Aluno obj);
	
	void deleteById(int id);
	
	Aluno findById(int id);
	
	List<Aluno> findAll();
}
