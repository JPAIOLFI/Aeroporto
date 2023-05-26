package pucrs.myflight.modelo;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class GerenciadorRotas {

    private ArrayList<Rota> rotas;

    public GerenciadorRotas(){
        this.rotas = new ArrayList<>();

    }
     public void adicionar(Rota rota){
        rotas.add(rota);

     }
     public ArrayList<Rota> ListarTodos(){
        return rotas;
     } 
     public ArrayList<Rota> BuscarPorOrigem(Aeroporto origem){
        
        ArrayList<Rota> aux = new ArrayList<>();
        for(Rota R : rotas){
            if(origem == R.getOrigem()){
                aux.add(R);

            }

        }
        return aux;
     }

     public void carregarDados() {
        Path path1 = Paths.get("equipment.dat");
        int erros = 0;

        try (BufferedReader reader = Files.newBufferedReader(path1, Charset.forName("utf8"))) {
            String line = null;
            while ((line = reader.readLine()) != null) {

                String[] dados = line.split(";");
               

            }
        }
        catch (IOException x) {
            
        }
        if(erros > 0) {
            System.out.println(erros); 
        }
    }

}
