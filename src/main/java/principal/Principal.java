package principal;

import model.DadosEpisodio;
import model.DadosSerie;
import model.DadosTemporada;
import services.ConsumoAPI;
import services.ConverteDados;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    private Scanner scan = new Scanner(System.in);
    private ConsumoAPI consumoApi = new ConsumoAPI();
    private ConverteDados conversor = new ConverteDados();
    private final String ENDERECO = "https://www.omdbapi.com/?t=";
    private final String TEMPORADA = "&season=";
    private final String API_KEY = "&apikey=6585022c";


    public void exibirMenu() {
        System.out.println("Digite o nome da série: ");
        String nomeSerie = scan.nextLine();
        var json = consumoApi.obterDados(ENDERECO + (nomeSerie.replace(" ", "+")) + API_KEY);


        DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
        System.out.println(dados);


        List<DadosTemporada> listaTemporadas = new ArrayList<>();

        for (int i = 1; i <= dados.totalTemporadas(); i++) {
            json = consumoApi.obterDados(ENDERECO + (nomeSerie.replace(" ", "+"))
                    + TEMPORADA + i + API_KEY);
            DadosTemporada temporada = conversor.obterDados(json, DadosTemporada.class);
            listaTemporadas.add(temporada);
        }

        listaTemporadas.forEach(System.out::println);

//        for (int i = 0; i < dados.totalTemporadas(); i++) {
//            List<DadosEpisodio> episodiosTemporada = listaTemporadas.get(i).episodios();
//            System.out.println("- Temporada " + i);
//            for (int j = 0; j < episodiosTemporada.size(); j++) {
//                System.out.println("-- Episódio " + j + " :" + episodiosTemporada.get(j).titulo());
//            }
//        }

        listaTemporadas.forEach(t -> t.episodios().forEach(e -> System.out.println("Episódio " + e.numero() + " - " + e.titulo())));

    }
}
