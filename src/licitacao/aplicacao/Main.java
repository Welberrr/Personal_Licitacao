package licitacao.aplicacao;

import empresa.model.Empresa;
import licitacao.DAO.EmpresaDAO;

public class Main {

	public static void main(String[] args) {
		
		Empresa empresa = new Empresa();
		EmpresaDAO empresaDAO = new EmpresaDAO();
		
		empresa.setIdEmpr(1);
		empresa.setCNPJ(1234567890);
		empresa.setNomePJ(1234567890);
		empresa.setNome("Welber Tecnology");
		empresa.setEmail("welbertecnology@gmail.com");
		
		empresaDAO.save(empresa);
		
		for(Empresa e : empresaDAO.getEmpresas()) {
			System.out.println("Empresa: " + e.getNome());
		}
	}

}
