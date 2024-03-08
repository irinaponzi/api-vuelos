package codoacodo.vuelosapi.service;

import codoacodo.vuelosapi.model.Vuelo;
import codoacodo.vuelosapi.repository.IVueloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
public class VueloService {

    @Autowired
    private IVueloRepository vueloRepository;

    public List<Vuelo> listarVuelos() {
        return vueloRepository.findAll();
    }

    public Vuelo vueloPorId(Long id) {
        Optional<Vuelo> vueloBuscado = vueloRepository.findById(id);
        return vueloBuscado.orElse(null);
    }

    public List<Vuelo> vuelosPorOrigen(String origen) {
        return vueloRepository.findAllByOrigenIgnoreCase(origen);
    }

    public String crearVuelo(Vuelo vuelo) {
        vueloRepository.save(vuelo);
        return "El vuelo se creó con éxito";
    }

    public String modificarVuelo(Long id, Vuelo vuelo) {
        Optional<Vuelo> vueloBuscado = vueloRepository.findById(id);
        if (vueloBuscado.isPresent()) {
            vuelo.setId(id);
            vueloRepository.save(vuelo);
            return "El vuelo " + id + " se actualizó con éxito";
        } else {
            return "El vuelo " + id + " no se encontró";
        }
    }

    public String modificarPrecioVuelo(Long id, double precio) {
        Optional<Vuelo> vueloBuscado = vueloRepository.findById(id);
        if (vueloBuscado.isPresent()) {
            Vuelo vueloEncontrado = vueloBuscado.get();
            vueloEncontrado.setPrecio(precio);
            vueloRepository.save(vueloEncontrado);
            return "El vuelo " + id + " se actualizó con éxito";
        } else {
            return "El vuelo " + id + " no se encontró";
        }
    }

    public String modificarFechaVuelo(Long id, LocalDateTime fechaHoraSalida, LocalDateTime fechaHoraLlegada) {
        Optional<Vuelo> vueloBuscado = vueloRepository.findById(id);
        if (vueloBuscado.isPresent()) {
            Vuelo vueloEncontrado = vueloBuscado.get();
            vueloEncontrado.setFechaHoraSalida(fechaHoraSalida);
            vueloEncontrado.setFechaHoraLlegada(fechaHoraLlegada);
            vueloRepository.save(vueloEncontrado);
            return "El vuelo " + id + " se actualizó con éxito";
        } else {
            return "El vuelo " + id + " no se encontró";
        }
    }

    public String eliminarVueloPorId(Long id) {
        Optional<Vuelo> vuelo = vueloRepository.findById(id);

        if(vuelo.isPresent()) {
            vueloRepository.deleteById(id);
            return "El vuelo " + id + " se eliminó con éxito";
        } else
            return "El vuelo " + id + " no se encontró";
    }
}
