package model;

public class Pedido {
	
	private int codigo;
	private String produto;
	private int qtd;
	private double preco;
		
	public String getProduto() {
		return produto;
	}
	public double getPreco() {
		return preco;
	}
	public int getQtd() {
		return qtd;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setProduto(String produto) {
		this.produto = produto;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public void setQtd(int qtd) {
		this.qtd = qtd;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
}
	
	
	
	


