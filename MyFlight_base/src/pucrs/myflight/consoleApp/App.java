package pucrs.myflight.consoleApp;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import javax.management.relation.Role;

import pucrs.myflight.modelo.*;

public class App {
    public static void main(String[] args) {

        Geo Congas = new Geo(-23.6267, -46.6553);
        Geo Salgado = new Geo(-29.9942, -51.1714);
        Geo santosD = new Geo(-22.9103, -43.1631);
        Geo HugoC = new Geo(-29.1669, -51.1875);

        Aeroporto SantosDumont = new Aeroporto("SDU", "Santos Dumont", santosD);
        Aeroporto congonhas = new Aeroporto("CGH", "Congonhas", Congas);
        Aeroporto SalgadoFilho = new Aeroporto("POA", "Salgado Filho", Salgado);
        Aeroporto HugoCartegiani = new Aeroporto("CXJ","Hugo Cartegiani", HugoC);

        Aeronave Aviao = new Aeronave("2588", "PR‑GGD", 120);
        Aeronave Aviao2 =  new Aeronave("777", "Boeing", 430);
        Aeronave Aviao3 = new Aeronave("A321", "Airbus", 500);


        CiaAerea gol = new CiaAerea("GOL", "GOL");
        CiaAerea Emirates = new CiaAerea("EM", "Emirates");
        CiaAerea latam = new CiaAerea("LA", "LATAM");

        Rota rota1 = new Rota(gol, congonhas, SalgadoFilho, Aviao);
        Rota rota2 = new Rota(latam, SalgadoFilho, SantosDumont, Aviao3);
        Rota rota3 = new Rota(Emirates, congonhas, SantosDumont, Aviao2);
        Rota rota4 = new Rota(Emirates, HugoCartegiani, SantosDumont, Aviao2);


        Voo v1 = new Voo(rota1, LocalDateTime.of(2022, 4, 22, 22, 00, 00), Duration.ofMinutes(80));
        Voo v2 = new Voo(rota4, LocalDateTime.of(1978, 2, 10, 21, 30, 00), Duration.ofMinutes(200));
        Voo v3 = new Voo(rota2, LocalDateTime.of(2022, 10, 28, 15, 15, 00), Duration.ofMinutes(0));
        Voo v4 = new Voo(rota3, LocalDateTime.of(1985, 7, 4, 14, 30, 00),Duration.ofMinutes(60));



        GerenciadorAeronaves GAero = new GerenciadorAeronaves();
        GerenciadorAeroportos GAP = new GerenciadorAeroportos();
        GerenciadorCias Gcia = new GerenciadorCias();
        GerenciadorRotas Grotas = new GerenciadorRotas();
        GerenciadorVoos Gvoo = new GerenciadorVoos();

        

        GAero.adicionar(Aviao);
        GAero.adicionar(Aviao2);
        GAero.adicionar(Aviao3);

        GAP.adicionar(SantosDumont);
        GAP.adicionar(congonhas);
        GAP.adicionar(SalgadoFilho);
        GAP.adicionar(HugoCartegiani);

        Gcia.adicionar(gol);
        Gcia.adicionar(Emirates);
        Gcia.adicionar(latam);

        Grotas.adicionar(rota1);
        Grotas.adicionar(rota2);
        Grotas.adicionar(rota3);
        Grotas.adicionar(rota4);

        Gvoo.adicionar(v1);
        Gvoo.adicionar(v2);
        Gvoo.adicionar(v3);
        Gvoo.adicionar(v4);

        System.out.println(Gvoo.ListarTodos());

    }

}
