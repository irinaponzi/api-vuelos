package codoacodo.vuelosapi.service;

import codoacodo.vuelosapi.model.Vuelo;
import org.springframework.stereotype.Service;

import java.util.List;

import static codoacodo.vuelosapi.Utils.listaDeVuelos;

@Service
public class VueloService {

    public List<Vuelo> listarVuelos() {
        return listaDeVuelos();
    }
}
