package pucrs.myflight.modelo;
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

}
