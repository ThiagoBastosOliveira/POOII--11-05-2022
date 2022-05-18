package model.entities;

import java.util.Objects;

public class Disciplina {
	
	private int iddisciplina;
	private String nomedisciplina;
	private int cargahoraria;
	
	public Disciplina() {
		
	}
	
	public Disciplina(int iddisciplina, String nomedisciplina, int cargahoraria) {
		this.iddisciplina = iddisciplina;
		this.nomedisciplina = nomedisciplina;
		this.cargahoraria = cargahoraria;
	}

	public int getIddisciplina() {
		return iddisciplina;
	}

	public void setIddisciplina(int iddisciplina) {
		this.iddisciplina = iddisciplina;
	}

	public String getNomedisciplina() {
		return nomedisciplina;
	}

	public void setNomedisciplina(String nomedisciplina) {
		this.nomedisciplina = nomedisciplina;
	}

	public int getCargahoraria() {
		return cargahoraria;
	}

	public void setCargahoraria(int cargahoraria) {
		this.cargahoraria = cargahoraria;
	}
	
	@Override
	public String toString() {
		return "";
	}

	@Override
	public int hashCode() {
		return Objects.hash(nomedisciplina);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Disciplina other = (Disciplina) obj;
		return Objects.equals(nomedisciplina, other.nomedisciplina);
	}
	
}
