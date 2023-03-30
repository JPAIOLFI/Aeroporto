package pucrs.myflight.modelo;

import java.util.*;

public class GerenciadorCias {
	private ArrayList<CiaAerea> empresas;
	
	public GerenciadorCias() {
		empresas = new ArrayList<>();
	}
	public void adicionar(CiaAerea cia){
		empresas.add(cia);
	}
	public ArrayList<CiaAerea> ListarTodas(){
		return empresas;

	}
	public CiaAerea buscarCodigo(String codigo){

		for (CiaAerea cia : empresas) {
			if(cia.getCodigo().equals(codigo))
				return cia;
		}
		return null;
	}
	public CiaAerea BuscarNome(String nome){

		for (CiaAerea cia : empresas) {
			if(cia.getNome().equals(nome)){
				return cia;

			}
		}
		return null;
	}
	
}
