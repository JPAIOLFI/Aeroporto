package pucrs.myflight.modelo;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
    public boolean carregarDados(String nomeArq) {
        Path path2 = Paths.get("airports.dat", "countries.dat")
        ;
        //Path path3 = Paths.get("countries.dat");
        try (BufferedReader reader = Files.newBufferedReader(path2, Charset.forName("utf8"))) {
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
