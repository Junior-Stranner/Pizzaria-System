package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import conection.Conexao;
import model.Pedido;

public class PedidoRepository {
	public void insere(Pedido pedido) {
		
		Conexao conexao = new Conexao();
		Connection conn = conexao.conectar();
		

		try {
			String consulta = "INSERT INTO PEDIDO (codigo,produto,qtd,preco) " + "VALUES (NEXTVAL('PEDIDO_SEQ'),?,?,?)";

			PreparedStatement stm;
			stm = conn.prepareStatement(consulta);
			
			System.out.println(consulta);

			stm.setString(1,pedido.getProduto());
			stm.setInt(2, pedido.getQtd());
			stm.setDouble(3, pedido.getPreco());
			
			stm.execute();

		} catch (Exception e) {

		} finally {
			conexao.desconectar(conn);
		}
	}

	public ArrayList<Pedido> consulta() throws SQLException {
		Conexao conexao = new Conexao();
		Connection conn = conexao.conectar();
		ArrayList<Pedido> pedidos = new ArrayList<>();

		String consulta = "SELECT * FROM PEDIDO";

		Statement stm = conn.createStatement();
		ResultSet resultado = stm.executeQuery(consulta);

		try {
			while (resultado.next()) {
				Pedido pedido = new Pedido();
				pedido.setCodigo(Integer.parseInt(resultado.getString("codigo")));
				pedido.setProduto(resultado.getString("produto"));
				pedido.setQtd(Integer.parseInt(resultado.getString("qtd")));
				pedido.setPreco(Double.parseDouble(resultado.getString("preco")));
				
				System.out.println("Finalizar Pedido");
				System.out.println("\n"+pedido.getProduto());
				System.out.println("\n"+pedido.getQtd());
				System.out.println("\n"+pedido.getPreco());
				
				
				pedidos.add(pedido);
			}

		} catch (Exception e) {
			System.out.println("Nao conseguiu consultar a tabela Pedido");

		} finally {
			conexao.desconectar(conn);
		}

		return pedidos;
	}

	public void excluir(int codigo) throws Exception {
		Conexao conexao = new Conexao();
		Connection conn = conexao.conectar();

		String consulta = "DELETE FROM PEDIDO WHERE CODIGO= ?";

		PreparedStatement stm;
		stm = conn.prepareStatement(consulta);
		stm.setInt(1, codigo);
		stm.execute();

		try {
		} catch (Exception e) {
			System.out.println("Nao foi possivel excluir");

		} finally {
			conexao.desconectar(conn);
		}

	}
	public Pedido findByCodigo (int codigo) throws Exception {
		Pedido pedido = new Pedido();
		Conexao conexao = new Conexao();
		Connection conn = conexao.conectar();
		
		String consulta = "SELECT * PEDIDO WHERE ID="+codigo;
				
		Statement stm = conn.createStatement();
		ResultSet resultado = stm.executeQuery(consulta);

		try {
			while (resultado.next()) {
				
				pedido.setCodigo(Integer.parseInt(resultado.getString("codigo")));
				pedido.setProduto(resultado.getString("produto"));
				pedido.setQtd(Integer.parseInt(resultado.getString("qtd")));
				pedido.setPreco(Double.parseDouble(resultado.getString("preco")));
								
			}

		} catch (Exception e) {
			System.out.println("Nao conseguiu consultar a tabela Pedido");

		} finally {
			conexao.desconectar(conn);
		}
		return pedido;
	}
}


