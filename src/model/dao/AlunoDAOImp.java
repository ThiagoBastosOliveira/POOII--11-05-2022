package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.db.DB;
import model.entities.Aluno;

public class AlunoDAOImp implements AlunoDAO {

	private Connection con = DB.getConexao();

	public AlunoDAOImp(Connection con) {
		this.con = con;
	}

	@Override
	public void insert(Aluno obj) {

		PreparedStatement pst = null;
		ResultSet rs = null;

		try {

			String sql = "INSERT INTO aluno (nome, sexo, dt_nasc, nota) VALUES (?, ?, ?, ?)";
			pst = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pst.setString(1, obj.getNome());
			pst.setString(2, obj.getSexo());
			
			Date dataSql = new Date(obj.getDt_nasc().getTime());
			pst.setDate(3, dataSql);
			
			pst.setFloat(4, obj.getNota());

			int linhas = pst.executeUpdate();

			if(linhas > 0) {
				rs = pst.getGeneratedKeys();
				rs.next();

				obj.setIdAluno(rs.getInt(1));

				System.out.println("Aluno inserido com sucesso!");
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
	public void update(Aluno obj) {

		PreparedStatement pst = null;

		try {

			String sql = "UPDATE aluno SET nome WHERE idAluno = ?";

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

			String sql = "DELETE FROM aluno WHERE idAluno = ?";

			pst = con.prepareStatement(sql);
			pst.setInt(1, id);
			pst.executeUpdate();

			System.out.println("Aluno de ID = " + id + " excluido.\n");

		}
		catch (Exception e) {
			System.out.println("Erro: " + e);
		}

	}

	@Override
	public Aluno findById(int id) {

		Aluno aluno = new Aluno();

		try {

			String sql = "SELECT * FROM aluno WHERE idAluno = ?";
			PreparedStatement pst = con.prepareStatement(sql);

			pst.setInt(1, id);
			pst.executeQuery();

		}
		catch(Exception e) {
			System.out.println("Erro: " + e);
		}

		return aluno;
	}

	@Override
	public List<Aluno> findAll() {

		List<Aluno> alunoList = new ArrayList<>();

		try {

			String sql = "SELECT * FROM aluno";
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				Aluno aluno = new Aluno(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getFloat(5));

				alunoList.add(aluno);
			}

		}
		catch(Exception e) {
			System.out.println("Erro: " + e);
		}
		return alunoList;
	}

}
