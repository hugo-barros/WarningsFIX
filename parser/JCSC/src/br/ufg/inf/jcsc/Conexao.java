package br.ufg.inf.jcsc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexao {

    public static Connection cn;

    public static void open() throws SQLException, ClassNotFoundException {
        final String url = "jdbc:postgresql://localhost:5432/conquest";
        final String usuario = "postgres";
        final String senha = "postgres";
        Class.forName("org.postgresql.Driver");
        cn = DriverManager.getConnection(url, usuario, senha);

    }

    public static void insert(String prog, String classe, String nome) throws SQLException, ClassNotFoundException {
        open();
        String[] nometmp = nome.split(":");
        String line, column, description, typeofwarning, severity;
        
           String sql5 = "select * from ferramenta where nome ='jcsc'";


                Statement stmt = cn.createStatement();
                ResultSet rs3 = stmt.executeQuery(sql5);


                /* Inserindo classe se não existir */

                if (!rs3.next()) {
                    String sql6 = "insert into ferramenta "
                    + "(id,"
                    + "descricao, "
                    + "linguagem, "
                    + "nome,"
                    + "tipo,"
                    + "versao) "
                    + "values (?,?,?,?,?,?)";
                    PreparedStatement stat3 = cn.prepareStatement(sql6);
                    stat3.setString(1, "JC0003");
                    stat3.setString(2, "");
                    stat3.setString(3, "java");
                    stat3.setString(4, "jcsc");
                    stat3.setString(5, "codigo fonte");
                    stat3.setString(6, "");
                    stat3.executeUpdate();
                }
        
        
        
        
        if (nometmp.length == 6) {
            line = nometmp[1].toString();
            column = nometmp[2].toString();
            description = nometmp[3].toString();
            typeofwarning = nometmp[4].toString();
            severity = nometmp[5].toString();

            try {
                PreparedStatement ps = cn.prepareStatement("insert into warning"
                        + "(tool, "
                        + "nameprogram, "
                        + "nameclass, "
                        + "namemethod, "
                        + "beginline, "
                        + "endline,"
                        + "begincolumn, "
                        + "endcolumn,"
                        + "typewarning,"
                        + "description,"
                        + "priority,"
                        + "externalinfourl,"
                        + "ruleset ) values (?,?,?,?,?,?,?,?,?,?,?,?,?)");
                ps.setString(1, "JC0003");
                ps.setString(2, prog);
                ps.setString(3, classe);
                ps.setString(4, "");
                ps.setInt(5, Integer.parseInt(line));
                ps.setInt(6, Integer.parseInt(line));
                ps.setInt(7, Integer.parseInt(column));
                ps.setInt(8, Integer.parseInt(column));
                ps.setString(9, typeofwarning);
                ps.setString(10, description);
                ps.setInt(11, Integer.parseInt(severity));
                ps.setString(12, "");
                ps.setString(13, "");

                ps.execute();
                ps.close();

            } catch (SQLException ex) {
                System.out.println("erro:" + ex);
            }

        }

        if (nometmp.length == 7) {
            line = nometmp[1].toString();
            column = nometmp[2].toString();
            description = nometmp[3].toString();
            String concatdescription = description.concat(nometmp[4].toString());
            typeofwarning = nometmp[5].toString();
            severity = nometmp[6].toString();


            try {
PreparedStatement ps = cn.prepareStatement("insert into warning"
                        + "(tool, "
                        + "nameprogram, "
                        + "nameclass, "
                        + "namemethod, "
                        + "beginline, "
                        + "endline,"
                        + "begincolumn, "
                        + "endcolumn,"
                        + "typewarning,"
                        + "description,"
                        + "priority,"
                        + "externalinfourl,"
                        + "ruleset ) values (?,?,?,?,?,?,?,?,?,?,?,?,?)");
                ps.setString(1, "JC0003");
                ps.setString(2, prog);
                ps.setString(3, classe);
                ps.setString(4, "");
                ps.setInt(5, Integer.parseInt(line));
                ps.setInt(6, Integer.parseInt(line));
                ps.setInt(7, Integer.parseInt(column));
                ps.setInt(8, Integer.parseInt(column));
                ps.setString(9, typeofwarning);
                ps.setString(10, concatdescription);
                ps.setInt(11, Integer.parseInt(severity));
                ps.setString(12, "");
                ps.setString(13, "");

                ps.execute();
                ps.close();                 
            } catch (SQLException ex) {
                System.out.println("erro:" + ex);
            }
        }





    }
}
