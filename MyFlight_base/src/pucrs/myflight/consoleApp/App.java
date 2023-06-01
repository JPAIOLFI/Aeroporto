package pucrs.myflight.consoleApp;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import javax.management.relation.Role;
import javax.xml.transform.Source;

import pucrs.myflight.modelo.*;

public class App {
    public static void main(String[] args) throws Exception {


        GerenciadorAeronaves GAero = GerenciadorAeronaves.getInstance();
        GerenciadorAeroportos GAP = GerenciadorAeroportos.getInstance();
        GerenciadorCias Gcia = GerenciadorCias.getInstance();
        GerenciadorRotas Grotas = GerenciadorRotas.getInstance();
        

        GAero.carregarDados();
        GAP.carregarDados();
        Gcia.carregarDados();
        Grotas.carregarDados();

        System.out.println("Começando a busca ...");

        System.out.println(GAero.BuscaPorCodigo("142").getCodigo());
        System.out.println(GAP.BuscarPorCodigo("AAE").getCodigo());
        System.out.println(Gcia.BuscarNome("Jubba Airways Ltd").getNome());
        

       
        

        // Aeroporto n = GAP.BuscarPorCodigo("AAA");

        // GAero.adicionar(Aviao);
        // GAero.adicionar(Aviao2);
        // GAero.adicionar(Aviao3);

        // GAP.adicionar(SantosDumont);
        // GAP.adicionar(congonhas);
        // GAP.adicionar(SalgadoFilho);
        // GAP.adicionar(HugoCartegiani);

        // Gcia.adicionar(gol);
        // Gcia.adicionar(Emirates);
        // Gcia.adicionar(latam);

        // Grotas.adicionar(rota1);
        // Grotas.adicionar(rota2);
        // Grotas.adicionar(rota3);
        // Grotas.adicionar(rota4);

        // Gvoo.adicionar(v1);
        // Gvoo.adicionar(v2);
        // Gvoo.adicionar(v3);
        // Gvoo.adicionar(v4);

    }
}


