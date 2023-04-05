package pucrs.myflight.modelo;

public class Aeroporto {
	private String codigo;
	private String nome;
	private Geo loc;
	
	public Aeroporto(String codigo, String nome, Geo loc) {
		this.codigo = codigo;
		this.nome = nome;
		this.loc = loc;
	}
	
	public String getCodigo() {
		return codigo;
	}
	
	public String getNome() {
		return nome;
	}
	
	@Override
	public String toString() {
		return "Aeroporto (codigo = " + codigo + ", nome = " + nome + ")";
	}

	public Geo getLocal() {
		return loc;
	}
}
