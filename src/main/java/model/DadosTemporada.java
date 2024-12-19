package model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosTemporada(@JsonAlias("Season") Integer temporada,
                             @JsonAlias("Episodes") List<DadosEpisodio> episodios) {

    @Override
    public String toString() {
        return "Dados do Episódio: \n" +
                "Temporada: " + temporada + "\n" +
                "Episódios: "+ "\n" + episodios;
    }
}