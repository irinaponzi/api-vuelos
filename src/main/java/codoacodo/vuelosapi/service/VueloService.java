package codoacodo.vuelosapi.service;

import codoacodo.vuelosapi.model.Vuelo;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import static codoacodo.vuelosapi.Utils.listaDeVuelos;

@Service
public class VueloService {

    private List<Vuelo> vuelos = listaDeVuelos();

    public List<Vuelo> listarVuelos() {
        return vuelos;
    }

    public Vuelo vueloPorId(Long id) {

        return vuelos.stream()
                .filter(vuelo -> vuelo.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public String crearVuelo(Vuelo vuelo) {
        vuelos.add(vuelo);
        return "El vuelo se ha creado exitosamente";
    }

    public String modificarVuelo(Long id, Vuelo vuelo) {

        Vuelo vueloModificar = vueloPorId(id);
        if(vueloModificar != null) {
            vuelos.remove(vueloModificar);
            vuelos.add(vuelo);
            return "El vuelo " + id + " ha sido moficado";
        }
        else
            return "El vuelo " + id + " no ha sido encontrado";
    }

    public String modificarPrecioVuelo(Long id, double precio) {

        Vuelo vueloModificar = vueloPorId(id);
        if(vueloModificar != null) {
            vueloModificar.setPrecio(precio);
            return "El precio del vuelo " + id + " ha sido moficado";
        }
        else
            return "El vuelo " + id + " no ha sido encontrado";
    }

    public String modificarFechaVuelo(Long id, LocalDateTime fechaHoraSalida, LocalDateTime fechaHoraLlegada) {

        Vuelo vueloModificar = vueloPorId(id);
        if(vueloModificar != null) {
            vueloModificar.setFechaHoraSalida(fechaHoraSalida);
            vueloModificar.setFechaHoraLlegada(fechaHoraLlegada);
            return "La fecha del vuelo " + id + " ha sido moficada";
        }
        else
            return "El vuelo " + id + " no ha sido encontrado";
    }

    public String eliminarVueloPorId(Long id) {

        Vuelo vueloEliminar = vueloPorId(id);
        if(vueloEliminar != null) {
            vuelos.remove(vueloEliminar);
            return "El vuelo " + id + " ha sido eliminado";
        }
        else
            return "El vuelo " + id + " no ha sido encontrado";
    }
}
