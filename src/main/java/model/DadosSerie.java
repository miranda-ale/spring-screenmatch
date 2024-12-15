package model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosSerie(@JsonAlias("Title") String titulo,
                         @JsonAlias("totalSeasons") Integer totalTemporadas,
                         @JsonAlias("imdbRating") String avaliacao) {

    @Override
    public String toString() {
        return "Dados da Serie: \n" +
                "Título: " + titulo + "\n" +
                "Total de Temporadas: " + totalTemporadas + "\n" +
                "Avaliação: " + avaliacao + "\n";
    }
}
