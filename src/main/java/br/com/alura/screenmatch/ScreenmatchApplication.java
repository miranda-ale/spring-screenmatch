package br.com.alura.screenmatch;

import model.DadosEpisodio;
import model.DadosSerie;
import model.DadosTemporada;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import services.ConsumoAPI;
import services.ConverteDados;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var consumoAPI = new ConsumoAPI();
		var json = consumoAPI.obterDados("https://www.omdbapi.com/?t=gilmore+girls&apikey=6585022c");
		System.out.println(json);
//		json = consumoAPI.obterDados("https://coffee.alexflipnote.dev/random.json");
//		System.out.println(json);

		ConverteDados conversor = new ConverteDados();
		DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
		System.out.println(dados);


		json = consumoAPI.obterDados("https://www.omdbapi.com/?t=gilmore+girls&episode=10&season=3&apikey=6585022c");
		DadosEpisodio episodio = conversor.obterDados(json, DadosEpisodio.class);
		System.out.println(episodio);

		List<DadosTemporada> listaTemporadas = new ArrayList<>();

		for (int i = 1; i <= dados.totalTemporadas(); i++) {

			json = consumoAPI.obterDados("https://www.omdbapi.com/?t=gilmore+girls&season="+ i +"&apikey=6585022c");
			DadosTemporada temporada = conversor.obterDados(json, DadosTemporada.class);
			listaTemporadas.add(temporada);

		}

		listaTemporadas.forEach(System.out::println);
		

	}
}
