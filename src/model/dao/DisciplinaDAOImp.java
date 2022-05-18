package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.db.DB;
import model.entities.Disciplina;

public class DisciplinaDAOImp implements DisciplinaDAO {

	private Connection con = DB.getConexao();

	public DisciplinaDAOImp(Connection con) {
		this.con = con;
	}

	@Override
	public void insert(Disciplina obj) {

		PreparedStatement pst = null;
		ResultSet rs = null;

		try {

			String sql = "INSERT INTO disciplina (nomedisciplina, cargahoraria) VALUES (?, ?)";
			pst = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pst.setString(1, obj.getNomedisciplina());
			pst.setInt(2, obj.getCargahoraria());

			int linhas = pst.executeUpdate();

			if(linhas > 0) {
				rs = pst.getGeneratedKeys();
				rs.next();

				obj.setIddisciplina(1);

				System.out.println("Disciplina inserida com sucesso!");
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
	public void update(Disciplina obj) {

		PreparedStatement pst = null;

		try {

			String sql = "UPDATE disciplina SET nomedisciplina WHERE iddisciplina = ?";

			pst = con.prepareStatement(sql);

			pst.executeUpdate();

			System.out.println("Disciplina atualizada com sucesso!\n");

		}
		catch(Exception e) {
			System.out.println("Erro: " + e);
		}
	}

	@Override
	public void deleteById(int id) {

		PreparedStatement pst = null;

		try {

			String sql = "DELETE FROM disciplina WHERE iddisciplina = ?";

			pst = con.prepareStatement(sql);
			pst.setInt(1, id);
			pst.executeUpdate();

			System.out.println("Disciplina de ID = " + id + " excluido.\n");

		}
		catch (Exception e) {
			System.out.println("Erro: " + e);
		}

	}

	@Override
	public Disciplina findById(int id) {

		Disciplina disciplina = new Disciplina();

		try {

			String sql = "SELECT * FROM disciplina WHERE iddisciplina = ?";
			PreparedStatement pst = con.prepareStatement(sql);

			pst.setInt(1, id);
			pst.executeQuery();

		}
		catch(Exception e) {
			System.out.println("Erro: " + e);
		}

		return disciplina;
	}

	@Override
	public List<Disciplina> findAll() {

		List<Disciplina> disciplinaList = new ArrayList<>();

		try {

			String sql = "SELECT * FROM disciplina";
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				Disciplina disciplina = new Disciplina(rs.getInt(1), rs.getString(2), rs.getInt(3));

				disciplinaList.add(disciplina);
			}

		}
		catch(Exception e) {
			System.out.println("Erro: " + e);
		}
		return disciplinaList;
	}
}
