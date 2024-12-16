package model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosEpisodio(@JsonAlias("Title") String titulo,
                            @JsonAlias("Episode") Integer numero,
                            @JsonAlias("imdbRating") String avaliacao,
                            @JsonAlias("Released") String dataLancamento) {

    @Override
    public String toString() {
        return "\nDados do Episódio: \n" +
                "Título: " + titulo + "\n" +
                "Episódio: " + numero + "\n" +
                "Avaliação: " + avaliacao + "\n" +
                "Data de Lançamento: " + dataLancamento + "\n";
    }
}
