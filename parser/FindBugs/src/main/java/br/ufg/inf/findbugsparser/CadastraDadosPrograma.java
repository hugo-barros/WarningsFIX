/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.inf.findbugsparser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.EventFilter;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.events.XMLEvent;

/**
 * Programa principal responsável por ler o arquivo XML gerado pela FindBugs e
 * extrair as informações dos warnings inserindo-os em um banco de dados
 * relacional.
 *
 * Neste caso, está sendo usado um banco MySQL.
 *
 * @author Auri Marcelo Rizzo Vincenzi
 */
public class CadastraDadosPrograma {

    public static void main(String[] args) {
        try {
            if (args.length == 7) {
                // Parse the data, filtering out the start elements
                XMLInputFactory xmlif = XMLInputFactory.newInstance();
                FileReader fr = new FileReader(args[0]);
                XMLEventReader xmler = xmlif.createXMLEventReader(fr);
                EventFilter filter = new EventFilter() {
                    @Override
					public boolean accept(XMLEvent event) {
                        return event.isStartElement();
                    }
                };
                XMLEventReader xmlfer = xmlif.createFilteredReader(xmler, filter);

                String nomePrograma = args[1];
                String versao = args[2];
                String nomeArquivo = args[3];
                String username = args[4];
                String password = args[5];
                String diretorio = args[6];

                // Parse into typed objects
                JAXBContext ctx = JAXBContext.newInstance("br.ufg.inf.findbugsparser");
                Unmarshaller um = ctx.createUnmarshaller();

                int bugs = 0;
                BugInstance bi = null;



                Connection conn = ConexaoBD.getConnection(username, password);

                /* Verificando se a ferramenta existe na tabela */
                String sql5 = "select * from ferramenta where nome='findbugs'";


                Statement stmt = conn.createStatement();
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
                    PreparedStatement stat3 = conn.prepareStatement(sql6);
                    stat3.setString(1, "FB0002");
                    stat3.setString(2, "");
                    stat3.setString(3, "java");
                    stat3.setString(4, "findbugs");
                    stat3.setString(5, "bytecode");
                    stat3.setString(6, "");
                    stat3.executeUpdate();
                }



                /**
                 * Cadastrar Unidades do Arquivo
                 */
                if (xmlfer.peek() != null) {
                    Object o = um.unmarshal(xmler);

                    if (o instanceof BugCollection) {
                        BugCollection bc = (BugCollection) o;

                        List bl = bc.getBugInstance();

                        for (Iterator<BugInstance> it = bl.iterator(); it.hasNext();) {
                            bi = it.next();
                            // InsertWarnings warning = new InsertWarnings();
                            // boolean resultado = warning.insertWarning(connection, bi, username, password);

                            List<Object> itens = bi.getClazzOrTypeOrMethod();
                            Method met = null;
                            SourceLine sl = null;
                            for (Iterator<Object> ctm = itens.iterator(); ctm.hasNext();) {
                                Object item = ctm.next();  // No downcasting required.

                                if (item instanceof Method) {
                                    if (met == null) {
                                        met = (Method) item;
                                    }
                                }

                                if (item instanceof SourceLine) {
                                    if (sl == null) {
                                        sl = (SourceLine) item;
                                    }
                                }
                            }


                            String sql3 = "insert into warning"
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
                                    + "ruleset ) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
                            PreparedStatement stat3 = conn.prepareStatement(sql3);
                            stat3.setString(1, "FB0002");
                            stat3.setString(2, nomePrograma);
                                String replace2 = null;
                                String replace3 = null;

                            try {
                                BufferedReader in = new BufferedReader(new FileReader(diretorio+"/"+ nomePrograma + "-java.txt"));
                                String str;
                                while ((str = in.readLine()) != null) {
                                    if (str.indexOf(sl.sourcefile) != -1) {
                                        replace2 = str.replace(nomePrograma + "/source/", "");
                                        replace3 = replace2.replace(".java", "");
                                    }
                                }

                                in.close();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }


                            String replace4=replace3.replace("/", ".");
                          

                            if (met == null) {
                                stat3.setString(3, replace4);
                                stat3.setString(4, "<no name>");
                            } else {
                                stat3.setString(3, replace4);
                                stat3.setString(4, met.getName());

                            }

                            if (sl.getStart() == null) {
                                stat3.setInt(5, -1);
                            } else {
                                stat3.setInt(5, sl.getStart());
                            }

                            if (sl.getEnd() == null) {
                                stat3.setInt(6, -1);
                            } else {
                                stat3.setInt(6, sl.getEnd());
                            }
                            stat3.setInt(7, -1);
                            stat3.setInt(8, -1);
                            stat3.setString(9, bi.getType());
                            stat3.setString(10, bi.getLongMessage());
                            stat3.setInt(11, bi.getPriority());
                            stat3.setString(12, "");
                            stat3.setString(13, "");

                            stat3.executeUpdate();
                            bugs++;

                            //System.out.println("BUG: " + bugs + "\tAbreviation: " + bi.getAbbrev());
                            //System.out.println("\tType: " + bi.getType());
                            //System.out.println("\tPriority: " + bi.getPriority());
                            //System.out.println("\tCategory: " + bi.getCategory());
                            if (met == null) {
                                //System.out.println("\tClass Name: <no name>");
                                //System.out.println("\tMethod Name:  <no name>");
                            } else {
                                //System.out.println("\tClass Name: " + met.getClassname());
                                //System.out.println("\tMethod Name: " + met.getName());
                            }
                            if (sl.getStart() == null) {
                                // System.out.println("\tSource Line Start: -1");
                                // System.out.println("\tSource Line End: -1");
                            } else {
                                // System.out.println("\tSource Line Start: " + sl.getStart());
                                //  System.out.println("\tSource Line End: " + sl.getEnd());
                            }
                            //  System.out.println("\tShort Message: " + bi.getShortMessage());
                            //System.out.println("\tLong Message: " + bi.getLongMessage());
                            bugs++;
                        }

                    }
                   // System.out.println(o.toString());
                }
                fr.close();
                conn.close();
            } else {
                System.out.println("Uso: br.ufg.inf.findbugsparser.CadastraDadosPrograma <xml_findbugs> <nome_programa> <nome_classe> <db_username> <db_password>");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
