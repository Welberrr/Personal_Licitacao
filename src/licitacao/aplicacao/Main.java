package licitacao.aplicacao;

import java.util.Scanner;
import empresa.model.Empresa;
import licitacao.DAO.EmpresaDAO;

public class Main {

    public static void main(String[] args) {

        Empresa empresa = new Empresa();
        EmpresaDAO empresaDAO = new EmpresaDAO();

        Scanner sc = new Scanner(System.in);

        int rep;
        do {

            System.out.println("O que deseja fazer? ");
            System.out.println("Digite 1 para cadastrar sua empresa, 2 para atualizar dados, 3 para deletar e 4 para listar todas as empresas e seus respectivos dados");

            int escolha = sc.nextInt();
            switch (escolha) {
                case 1:
                    System.out.println("Digite o ID da empresa: ");
                    int Id = sc.nextInt();
                    empresa.setIdEmpr(Id);

                    System.out.println("Digite o CNPJ da empresa: ");
                    int CNPJ = sc.nextInt();
                    empresa.setCNPJ(CNPJ);

                    System.out.println("Digite o nomePJ da empresa: ");
                    int nomePj = sc.nextInt();
                    empresa.setNomePJ(nomePj);

                    System.out.println("Digite o nome da empresa: ");
                    String nome = sc.next();
                    empresa.setNome(nome);

                    System.out.println("Digite o email da empresa: ");
                    String email = sc.next();
                    empresa.setEmail(email);

                    System.out.println("Empresa cadastrada com sucesso!");
                    empresaDAO.save(empresa);
                    break;

                case 2:
                    Empresa em1 = new Empresa();

                    System.out.println("Digite o ID da empresa que deseja atualizar: ");
                    int Idn = sc.nextInt();
                    em1.setIdEmpr(Idn);

                    System.out.println("Digite o CNPJ atualizado da empresa: ");
                    int CNPJn = sc.nextInt();
                    em1.setCNPJ(CNPJn);

                    System.out.println("Digite o nomePJ atualizado da empresa: ");
                    int nomePjn = sc.nextInt();
                    em1.setNomePJ(nomePjn);

                    System.out.println("Digite o nome atualizado da empresa: ");
                    String nomen = sc.next();
                    em1.setNome(nomen);

                    System.out.println("Digite o email atualizado da empresa: ");
                    String emailn = sc.next();
                    em1.setEmail(emailn);

                    System.out.println("Empresa atualizada com sucesso!");
                    empresaDAO.update(em1);
                    break;

                case 3:
                    System.out.println("Digite o ID da empresa que deseja deletar: ");
                    int IdD = sc.nextInt();
                    empresaDAO.deleteById(IdD);

                    System.out.println("Empresa deletada com sucesso!!");
                    break;

                case 4:
                    for(Empresa e : empresaDAO.getEmpresas()) {
                        System.out.println("ID empresa: " + e.getIdEmpr());
                        System.out.println("Empresa: " + e.getNome());
                        System.out.println("CNPJ: " + e.getCNPJ());
                        System.out.println("Nome PJ: " + e.getNomePJ());
                        System.out.println("Email: " + e.getEmail());
                        System.out.println("----------------------");
                    }
                    break;
            }

            do {
                System.out.println("Digite 1 para voltar ao menu ou 2 para encerrar: ");
                rep = sc.nextInt();

                if (rep != 1 && rep != 2) {
                    System.out.println("Opção inválida!");
                }
                if (rep == 2) {
                	System.out.println("Programa terminado :) ");
                }
                
            } while (rep != 1 && rep != 2);

        } while (rep == 1);

        sc.close();
    }
}
