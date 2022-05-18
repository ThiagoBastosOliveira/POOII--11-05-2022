package model.entities;

import java.util.Date;

public class Aluno {
	
	private int idAluno;
	private String nome;
	private String sexo;
	private Date dt_nasc;
	private float nota;
	
	public Aluno() {
		
	}

	public Aluno(int idAluno, String nome, String sexo, Date dt_nasc, float nota) {
		this.idAluno = idAluno;
		this.nome = nome;
		this.sexo = sexo;
		this.dt_nasc = dt_nasc;
		this.nota = nota;
	}

	public int getIdAluno() {
		return idAluno;
	}

	public void setIdAluno(int idAluno) {
		this.idAluno = idAluno;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Date getDt_nasc() {
		return dt_nasc;
	}

	public void setDt_nasc(Date dt_nasc) {
		this.dt_nasc = dt_nasc;
	}

	public float getNota() {
		return nota;
	}

	public void setNota(float nota) {
		this.nota = nota;
	}
	
	@Override
	public String toString() {
		return "";
	}
	
}
