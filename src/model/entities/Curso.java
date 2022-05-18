package model.entities;

import java.util.Objects;

public class Curso {
	
	private int idCurso;
	private String nomeCurso;
	
	public Curso() {
		
	}
	
	public Curso(int idCurso, String nomeCurso) {
		this.idCurso = idCurso;
		this.nomeCurso = nomeCurso;
	}
	
	public int getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}

	public String getNomeCurso() {
		return nomeCurso;
	}

	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}

	@Override
	public String toString() {
		return "";
	}

	@Override
	public int hashCode() {
		return Objects.hash(nomeCurso);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Curso other = (Curso) obj;
		return Objects.equals(nomeCurso, other.nomeCurso);
	}
	
}
