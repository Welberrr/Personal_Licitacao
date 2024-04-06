package empresa.model;

public class Empresa {

	private int IdEmpr, CNPJ, nomePJ;
	private String nome, email;
	
	

	public int getCNPJ() {
		return CNPJ;
	}
	public void setCNPJ(int cNPJ) {
		CNPJ = cNPJ;
	}
	public int getNomePJ() {
		return nomePJ;
	}
	public void setNomePJ(int nomePJ) {
		this.nomePJ = nomePJ;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getIdEmpr() {
		return IdEmpr;
	}
	public void setIdEmpr(int idEmpr) {
		IdEmpr = idEmpr;
	}
	
	
}
