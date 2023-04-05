package pucrs.myflight.consoleApp;

import java.nio.channels.NetworkChannel;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

import pucrs.myflight.modelo.*;

public class App {
    public static void main(String[] args) {
        Geo Congas = new Geo(-23.6267, -46.6553);
        Geo Salgado = new Geo(-29.9942, -51.1714);

        Aeroporto congonhas = new Aeroporto("CGH", "Congonhas", Congas);
        Aeroporto SalgadoFilho = new Aeroporto("POA", "Salgado Filho", Salgado);

        Aeronave Aviao = new Aeronave("2588", "PR‑GGD");

        CiaAerea gol = new CiaAerea("69", "GOL");

        Rota rota1 = new Rota(gol, congonhas, SalgadoFilho, Aviao);

        Voo v1 = new Voo(rota1, LocalDateTime.of(2022, 4, 22, 22, 00, 00), Duration.ofMinutes(80));

        Aeroporto Aero;
        CiaAerea cia;
        GerenciadorAeronaves GAN = new GerenciadorAeronaves();
        GerenciadorAeroportos GAP = new GerenciadorAeroportos();
        GerenciadorCias Gcia = new GerenciadorCias();
        GerenciadorRotas grotas = new GerenciadorRotas();
        GerenciadorVoos Gvoo = new GerenciadorVoos();

        grotas.adicionar(rota1);
        Gvoo.adicionar(v1);
        System.out.println(Gvoo.ListarTodos());
        System.out.println(Gvoo.buscarData(LocalDate.of(2022, 4, 22)));;
    }

}
