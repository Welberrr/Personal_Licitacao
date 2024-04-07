package licitacao.aplicacao;

import empresa.model.Empresa;
import licitacao.DAO.EmpresaDAO;

public class Main {

	public static void main(String[] args) {
		
		Empresa empresa = new Empresa();
		EmpresaDAO empresaDAO = new EmpresaDAO();
		
		empresa.setIdEmpr(2);
		empresa.setCNPJ(1234567890);
		empresa.setNomePJ(1234567890);
		empresa.setNome("Tesla");
		empresa.setEmail("tesla@gmail.com");
		
		//empresaDAO.save(empresa);
		
		Empresa em1 = new Empresa();
		em1.setIdEmpr(0);
		em1.setCNPJ(123);
		em1.setNomePJ(123);
		em1.setNome("Microsoft");
		em1.setEmail("microsoft@gmail.com");
		
		//empresaDAO.update(em1);
		
		empresaDAO.deleteById(0);
		
		for(Empresa e : empresaDAO.getEmpresas()) {
			System.out.println("ID empresa: " + e.getIdEmpr());
			System.out.println("Empresa: " + e.getNome());
			System.out.println("CNPJ: " + e.getCNPJ());
			System.out.println("Nome PJ: " + e.getNomePJ());
			System.out.println("Email: " + e.getEmail());
		}
	}
}
