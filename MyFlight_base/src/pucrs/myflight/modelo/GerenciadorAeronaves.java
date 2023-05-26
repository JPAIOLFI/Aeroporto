package pucrs.myflight.modelo;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class GerenciadorAeronaves {
    private ArrayList<Aeronave> aeronaves;

    public GerenciadorAeronaves(){
        this.aeronaves = new ArrayList<>();

    }
    public void adicionar(Aeronave aviao){
        aeronaves.add(aviao);

    }
    public ArrayList<Aeronave> ListarTodas(){
        return aeronaves;

    }
    public Aeronave BuscaPorCodigo(String Cod){

        for (Aeronave A : aeronaves) {
            if(A.getCodigo().equals(Cod))
                return A;

            
        }
       return null;

    }
    public void carregarDados() {
        Path path1 = Paths.get("equipment.dat");
        int erros = 0;

        try (BufferedReader reader = Files.newBufferedReader(path1, Charset.forName("utf8"))) {
            String line = null;
            while ((line = reader.readLine()) != null) {

                String[] dados = line.split(";");
                Aeronave aeronave = new Aeronave(dados[0],dados[1],Integer.parseInt(dados[2]));

                aeronaves.add(aeronave);

            }
        }
        catch (IOException x) {
            
        }
        if(erros > 0) {
            System.out.println(erros); 
        }
    }


}
