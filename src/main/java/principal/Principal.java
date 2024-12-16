package principal;

import services.ConsumoAPI;

import java.util.Scanner;

public class Principal {
    private Scanner scan = new Scanner(System.in);
    private ConsumoAPI consumoApi = new ConsumoAPI();
    private final String ENDERECO = "https://www.omdbapi.com/?t=" ;
    private final String API_KEY = "6585022c";

    public void exibirMenu() {
        System.out.println("Digite o nome da série: ");
        String nomeSerie = scan.nextLine();
        var json = consumoApi.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + API_KEY);

    }
}
