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
    private static GerenciadorRotas instance = GerenciadorRotas.getInstance();
    public GerenciadorRotas (){
        this.rotas = new ArrayList<>();
    }
    public static GerenciadorRotas getInstance(){
        
        if( instance == null){
            instance = new GerenciadorRotas();
        }
        return instance;
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

     public void carregarDados() throws IOException{
        GerenciadorCias empresas = GerenciadorCias.getInstance();
        GerenciadorAeroportos aeroporto = GerenciadorAeroportos.getInstance();
        GerenciadorAeronaves aeronaves = GerenciadorAeronaves.getInstance();
        Path path1 = Paths.get("MyFlight_base/src/pucrs/myflight/data/routes.dat");
        int erros = 0;

        try (BufferedReader reader = Files.newBufferedReader(path1, Charset.forName("utf8"))) {
            String line = null;
            while ((line = reader.readLine()) != null) {

                String[] dados = line.split(";");

                CiaAerea cia = empresas.BuscarNome(dados[0]);
                Aeroporto origem = aeroporto.BuscarPorCodigo(dados[1]);
                Aeroporto destino = aeroporto.BuscarPorCodigo(dados[2]);
                Aeronave aeronave = aeronaves.BuscaPorCodigo(dados[5]);

                

                Rota rota = new Rota(cia, origem, destino, aeronave);
                adicionar(rota);
               

            }
        }
        catch (IOException x) {
            
        }
        if(erros > 0) {
            System.out.println(erros); 
        }
    }

}
