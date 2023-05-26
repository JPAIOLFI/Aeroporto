package pucrs.myflight.modelo;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
	
	public boolean carregarDados(String nomeArq) {
        Path path2 = Paths.get("airlines.dat");
        ArrayList<String> cias= new ArrayList<>();
        //Path path3 = Paths.get("countries.dat");
        try (BufferedReader reader = Files.newBufferedReader(path2, Charset.forName("utf8"))) {
            String line = null;
            while ((line = reader.readLine()) != null) {

				String[] dados = line.split(";");
				
				CiaAerea empresa = new CiaAerea(dados[0], dados[1]);
                
            }
        }
        catch (IOException x) {
            System.err.format("Erro de E/S: %s%n", x);
        }
        return true;
    }
