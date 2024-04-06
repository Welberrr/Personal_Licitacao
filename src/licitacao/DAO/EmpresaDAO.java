package licitacao.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import empresa.model.Empresa;
import factory.ConnectionFactory;

public class EmpresaDAO {

    public void save(Empresa empresa) {

        String sql = "INSERT INTO empresa(IdEmpr, CNPJ, nomePJ, nome, email) VALUES (?,?,?,?,?)";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareCall(sql);

            pstm.setInt(1, empresa.getIdEmpr());
            pstm.setInt(2, empresa.getCNPJ());
            pstm.setInt(3, empresa.getNomePJ());
            pstm.setString(4, empresa.getNome());
            pstm.setString(5, empresa.getEmail());

            pstm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            try {
                if (pstm != null) {
                    pstm.close();
                }

                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    public List<Empresa> getEmpresas() {
        String sql = "SELECT * FROM empresa";

        List<Empresa> empresas = new ArrayList<Empresa>();

        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;

        try {
            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = (PreparedStatement) conn.prepareStatement(sql);

            rset = pstm.executeQuery();

            while (rset.next()) {
                Empresa empresa = new Empresa();

                empresa.setIdEmpr(rset.getInt("IdEmpr"));
                empresa.setNome(rset.getString("nome"));
                empresa.setCNPJ(rset.getInt("CNPJ"));
                empresa.setNomePJ(rset.getInt("nomePJ"));
                empresa.setEmail(rset.getString("email"));

                empresas.add(empresa);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rset != null) {
                    rset.close();
                }

                if (pstm != null) {
                    pstm.close();
                }

                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return empresas;
    }
}
