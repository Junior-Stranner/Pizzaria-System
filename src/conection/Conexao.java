package conection;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;

	public class Conexao {
	    public static void main(String[] args) {
	        Conexao conexao = new Conexao();
	        Connection conn = conexao.conectar();
	        conexao.desconectar(conn);
	    }

	    public Connection conectar() {
	        Connection conn = null;
	        try {
	            Class.forName("org.postgresql.Driver");
	            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ProjetoPizzaria", "postgres", "212321");
	            System.out.println("Conectou no banco de dados.");
	        } catch (SQLException ex) {
	            System.out.println("Erro: Nao conseguiu conectar no BD.");
	        } catch (ClassNotFoundException ex) {
	            System.out.println("Erro: Nao encontrou o driver do BD.");
	        }

	        return conn;
	    }

	    public void desconectar(Connection conn) {
	        try {
	            if (conn != null && !conn.isClosed()) {
	                conn.close();
	                System.out.println("Desconectou do banco de dados.");
	            }
	        } catch (SQLException ex) {
	            System.out.println("Nao conseguiu desconectar do BD.");
	        }
	    }
	}



