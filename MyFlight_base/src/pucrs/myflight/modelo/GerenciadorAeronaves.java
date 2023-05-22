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
    public boolean carregarDados(String nomeArq) {
        Path path1 = Paths.get("airlines.dat", "equipment.dat");

        try (BufferedReader reader = Files.newBufferedReader(path1, Charset.forName("utf8"))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                String[] dados = line.split(";");
            }
        }
        catch (IOException x) {
            System.err.format("Erro de E/S: %s%n", x);
        }
        return true;
    }


}
