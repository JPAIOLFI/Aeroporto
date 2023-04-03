package pucrs.myflight.modelo;
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
    public Aeronave
    
    
    
     BuscaPorCodigo(String Cod){

        for (Aeronave A : aeronaves) {
            if(A.getCodigo().equals(Cod))
                return A;

            
        }
       return null;

    }

}
