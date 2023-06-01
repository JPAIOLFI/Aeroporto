package pucrs.myflight.modelo;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class GerenciadorAeroportos {

    private HashMap<String, Aeroporto> aeroportos;
    private static GerenciadorAeroportos instance = GerenciadorAeroportos.getInstance();

    public GerenciadorAeroportos() {
        this.aeroportos = new HashMap<>();
    }

    public void adicionar(Aeroporto aeroporto) {
        this.aeroportos.put(aeroporto.getCodigo(), aeroporto);

    }

    public HashMap<String, Aeroporto> listarTodos() {
        return aeroportos;

    }

    public Aeroporto BuscarPorCodigo(String cod) {

        return aeroportos.get(cod);

    }

    public void carregarDados() throws Exception {
        Path path1 = Paths.get("MyFlight_base/src/pucrs/myflight/data/airports.dat");
        int erros = 0;

        // Path path3 = Paths.get("countries.dat");
        try (BufferedReader reader = Files.newBufferedReader(path1, Charset.forName("utf8"))) {
            String line = null;
            line = reader.readLine();
            while ((line = reader.readLine()) != null) {

                String[] dados = line.split(";");
                double latitude = Double.parseDouble(dados[1]);
                double longitude = Double.parseDouble(dados[2]);

                Geo loc = new Geo(latitude, longitude);
                Aeroporto aeroporto = new Aeroporto(dados[0], dados[3], loc);

                adicionar(aeroporto);

            }
        } catch (IOException x) {
            erros++;
        }
        if (erros > 0) {
            System.out.println(erros);
        }
    }

    public static GerenciadorAeroportos getInstance() {
        if (instance == null) {
            instance = new GerenciadorAeroportos();
        }
        return instance;
    }

}
