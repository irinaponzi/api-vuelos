package codoacodo.vuelosapi;

import codoacodo.vuelosapi.model.Vuelo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Utils {

    public static List<Vuelo> listaDeVuelos() {

        List<Vuelo> lista = new ArrayList<>();

        lista.add(new Vuelo(1L, "AP", "USU",
                LocalDateTime.of(2024, 3, 20, 22, 30),
                LocalDateTime.of(2024, 3, 21, 1, 15),
                150000, "diario"));

        lista.add(new Vuelo(2L, "EZE", "LOND",
                LocalDateTime.of(2024, 5, 10, 8, 30),
                LocalDateTime.of(2024, 5, 10, 17, 0),
                1050000, "semanal"));

        lista.add(new Vuelo(3L, "EZE", "BARC",
                LocalDateTime.of(2024, 3, 3, 16, 0),
                LocalDateTime.of(2024, 3, 3, 23, 40),
                960000, "semanal"));

        lista.add(new Vuelo(4L, "EZE", "BERL",
                LocalDateTime.of(2024, 6, 19, 20, 0),
                LocalDateTime.of(2024, 6, 20, 7, 20),
                970000, "semanal"));

        return lista;

    }
}
