package pucrs.myflight.modelo;


import java.time.LocalDate;
import java.util.*;

public class GerenciadorVoos {

    private ArrayList<Voo> voos;

    public GerenciadorVoos() {
        this.voos = new ArrayList<>();

    }

    public void adicionar(Voo voo) {
        voos.add(voo);

    }

    public ArrayList<Voo> ListarTodos() {
        return voos;
    }

    public ArrayList<Voo> buscarData(LocalDate data) {

        ArrayList<Voo> aux = new ArrayList<>();

        for (Voo voo : voos) {

            if (voo.getDatahora().toLocalDate().equals(data)) {
                aux.add(voo);
            }
        }
        return aux;
    }

}
