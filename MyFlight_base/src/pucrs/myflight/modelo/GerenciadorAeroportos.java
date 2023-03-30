package pucrs.myflight.modelo;

import java.util.*;

public class GerenciadorAeroportos {
    private ArrayList<Aeroporto> aeroportos;

    public GerenciadorAeroportos() {
        this.aeroportos = new ArrayList<>();
    }

    public void adicionar(Aeroporto AEroportos) {
        aeroportos.add(AEroportos);

    }

    public ArrayList<Aeroporto> listarTodos() {
        return aeroportos;

    }

    public Aeroporto BuscarPorCodigo(String cod) {

        for (Aeroporto R : aeroportos) {
            if (R.getCodigo().equals(cod))
                return R;

        }
        return null;

    }


    //oi
}
