package prjempresa.dal;
import java.sql.*;


public class ModuloConexao {
    
    public static Connection conector(){
        java.sql.Connection conexao = null;
        // chamando o drive
        String driver = "com.mysql.jdbc.Driver";
        // armazenando informações referentes ao banco
        String url = "jdbc:mysql://localhost:3306/dbempresa";
        String user = "root";
        String password = "";
        //estabelecendo a conexao com o banco
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, user, password);
            return conexao;
        } catch (Exception e) {
            // a linha a baixo ajuda a saber qual o erro da conexao para o dev
            System.out.println(e);
            return null;
        }   
    }
}
