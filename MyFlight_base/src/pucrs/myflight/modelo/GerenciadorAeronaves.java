package pucrs.myflight.modelo;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class GerenciadorAeronaves {

    private HashMap<String, Aeronave> aeronaves;
    private static GerenciadorAeronaves instance = GerenciadorAeronaves.getInstance();

    public GerenciadorAeronaves(){
        this.aeronaves = new HashMap<>();

    }
    public void adicionar(Aeronave aviao){
        this.aeronaves.put(aviao.getCodigo(), aviao);

    }
    public HashMap<String, Aeronave> ListarTodas(){
        return aeronaves;

    }
    public Aeronave BuscaPorCodigo(String Cod){

        return aeronaves.get(Cod);

    }
    public void carregarDados() {
        Path path1 = Paths.get("MyFlight_base/src/pucrs/myflight/data/equipment.dat");
        int erros = 0;

        try (BufferedReader reader = Files.newBufferedReader(path1, Charset.forName("utf8"))) {
            String line = null;

            line = reader.readLine();

            while ((line = reader.readLine()) != null) {

                String[] dados = line.split(";");
                Aeronave aeronave = new Aeronave(dados[0],dados[1],Integer.parseInt(dados[2]));

                adicionar(aeronave);

            }
        }
        catch (IOException x) {
            
        }
        if(erros > 0) {
            System.out.println(erros); 
        }
    }

    public static GerenciadorAeronaves getInstance() {
        if(instance == null){
			instance = new GerenciadorAeronaves();
		}
		return instance;
    }


}
