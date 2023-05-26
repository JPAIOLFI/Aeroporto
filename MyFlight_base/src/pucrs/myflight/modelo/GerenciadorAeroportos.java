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
    public void carregarDados()throws Exception {
        Path path1 = Paths.get("airports.dat");
        int erros = 0;

        //Path path3 = Paths.get("countries.dat");
        try (BufferedReader reader = Files.newBufferedReader(path1, Charset.forName("utf8"))) {
            String line = null;
            line = reader.readLine();
            while ((line = reader.readLine()) != null) {

                String[] dados = line.split(";");
                double latitude = Double.parseDouble(dados[1]);
                double longitude = Double.parseDouble(dados[2]);

                Geo loc = new Geo(latitude, longitude);
                Aeroporto aeroporto = new Aeroporto(dados[0], dados[3],loc);


            }
        }
        catch (IOException x) {
            erros++;
        }
        if(erros > 0) {
            System.out.println(erros); 
        }   
    }
    
    

}


