package ps2.restapidb;

import javax.persistence.*;

@Entity
@Table(name="Disciplinas")
public class Disciplina {
	@Id @GeneratedValue
	private long id;
	private String nome;
	private int cargaHoraria;
	private int quantidadeAlunos;
		
	public Disciplina() {
		super();
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getcargaHoraria() {
		return cargaHoraria;
	}
	public void setQuantidadeAlunos(int qtdAlunos) {
		this.quantidadeAlunos = qtdAlunos;
	}

}