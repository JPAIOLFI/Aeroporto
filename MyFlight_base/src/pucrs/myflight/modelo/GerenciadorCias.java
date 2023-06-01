package pucrs.myflight.modelo;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class GerenciadorCias {
	
	private HashMap<String, CiaAerea> cias;
	private static GerenciadorCias instance = GerenciadorCias.getInstance();
	
	public GerenciadorCias() {
		cias = new HashMap<>();
	}

	public void adicionar(CiaAerea cia){
		cias.put(cia.getNome(), cia);
	}

	public HashMap<String, CiaAerea> ListarTodas(){
		return cias;

	}

	// public CiaAerea buscarCodigo(String Cod){

	// 	 return this.cias.get(Cod);
	// }

	public CiaAerea BuscarNome(String nome){

		return cias.get(nome);
	}
	
	public boolean carregarDados() {
        Path path2 = Paths.get("MyFlight_base/src/pucrs/myflight/data/airlines.dat");

        
        //Path path3 = Paths.get("countries.dat");
        try (BufferedReader reader = Files.newBufferedReader(path2, Charset.forName("utf8"))) {
            String line = null;
            while ((line = reader.readLine()) != null) {

				String[] dados = line.split(";");
				
				CiaAerea empresa = new CiaAerea(dados[0], dados[1]);
				this.adicionar(empresa);
                
            }
        }
        catch (IOException x) {
            System.err.format("Erro de E/S: %s%n", x);
        }
        return true;
    }
    public static GerenciadorCias getInstance() {
        if(instance == null){
			instance = new GerenciadorCias();
		}
		return instance;
    }
}
