package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.db.DB;
import model.entities.Curso;

public class CursoDAOImp implements CursoDAO {

	private Connection con = DB.getConexao();
	
	public CursoDAOImp(Connection con) {
		this.con = con;
	}

	@Override
	public void insert(Curso obj) {
		
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			
			String sql = "INSERT INTO curso (nomecurso) VALUES (?)";
			pst = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pst.setString(1, obj.getNomeCurso());
			
			int linhas = pst.executeUpdate();
			
			if(linhas > 0) {
				rs = pst.getGeneratedKeys();
				rs.next();
				
				obj.setIdCurso(rs.getInt(1));
				
				System.out.println("Curso inserido com sucesso!");
			}
			else {
				System.out.println("Não foi possível cadastrar o curso!");
			}
			
		}
		catch (Exception e) {
			System.out.println("Erro: " + e);
		}
	}

	@Override
	public void update(Curso obj) {
		
		PreparedStatement pst = null;
		
		try {
			
			String sql = "UPDATE curso SET nomeCurso WHERE idcurso = ?";

			pst = con.prepareStatement(sql);

			pst.executeUpdate();

			System.out.println("Aluno atualizado com sucesso!\n");

		}
		catch(Exception e) {
			System.out.println("Erro: " + e);
		}
	}

	@Override
	public void deleteById(int id) {
		
		PreparedStatement pst = null;
		
		try {

			String sql = "DELETE FROM curso WHERE idcurso = ?";

			pst = con.prepareStatement(sql);
			pst.setInt(1, id);
			pst.executeUpdate();

			System.out.println("Curso de ID = " + id + " excluido.\n");

		}
		catch (Exception e) {
			System.out.println("Erro: " + e);
		}
		
	}

	@Override
	public Curso findById(int id) {
		
		Curso curso = new Curso();
		
		try {

			String sql = "SELECT * FROM curso WHERE idcurso = ?";
			PreparedStatement pst = con.prepareStatement(sql);
			
			pst.setInt(1, id);
			pst.executeQuery();
			
		}
		catch(Exception e) {
			System.out.println("Erro: " + e);
		}
		
		return curso;
	}

	@Override
	public List<Curso> findAll() {
		
		List<Curso> cursoList = new ArrayList<>();
		
		try {
		
			String sql = "SELECT * FROM curso";
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
				Curso curso = new Curso(rs.getInt(1), rs.getString(2));
				
				cursoList.add(curso);
			}
			
		}
		catch(Exception e) {
			System.out.println("Erro: " + e);
		}
		return cursoList;
	}

}
