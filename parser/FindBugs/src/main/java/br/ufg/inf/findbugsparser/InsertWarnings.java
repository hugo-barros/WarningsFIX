package br.ufg.inf.findbugsparser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InsertWarnings {

    public boolean insertWarning(Connection con, BugInstance bi, String username, String password) throws SQLException {
        boolean resultado = false;

        String query = "SELECT tipoWarning from warning_findbugs where tipoWarning = ?";
        PreparedStatement pstmt = con.prepareStatement(query);
        pstmt.setString(1, bi.getType());
        ResultSet rs = pstmt.executeQuery();
        if (rs.next() == false) {
            String sql = "insert into warning_findbugs (tipoWarning, nomeFerramenta, codigoWarning, descricaoCurtaWarning, classeWarning, prioridade) values (?,?,?,?,?,?)";
            //Statement st = con.createStatement();
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, bi.getType());
            st.setString(2, "FindBugs");
            st.setString(3, bi.getAbbrev());
            st.setString(4, bi.getShortMessage());
            st.setString(5, bi.getCategory());
            st.setInt(6, bi.getPriority());

            st.execute();
            st.close();
            resultado = true;
            //System.out.println("1 row affected");
        }
        return resultado;
    }
}
