package util;


import modelo.dao.VeiculoDAO;
import modelo.entities.Veiculo;

public class TesteDB {
	public static void main(String[] args) {
		Veiculo v = new Veiculo();
		v.setMarca("Lamborghini");
		v.setModelo("Urus");
		v.setAno(2020);
		v.setPreco(2_000_000);	
		//v.setImagem("lamborghini.jpg");
		VeiculoDAO dao = new VeiculoDAO();
		dao.salvar(v);
		System.out.println("Veículo cadastrado!");
	}


}