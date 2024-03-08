package codoacodo.vuelosapi.controller;

import codoacodo.vuelosapi.model.Vuelo;
import codoacodo.vuelosapi.service.VueloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/vuelos")
public class VueloController {

    @Autowired
    private VueloService vueloService;

    @GetMapping("/obtenerTodos")
    public List<Vuelo> getVuelos() {
        return vueloService.listarVuelos();
    }

    @GetMapping("/obtenerVuelo/{id}")
    public Vuelo getVueloPorId(@PathVariable Long id) {
        return vueloService.vueloPorId(id);
    }

    @GetMapping("/obtenerVueloPorOrigen/{origen}")
    public List<Vuelo> getVueloPorOrigen(@PathVariable String origen) {
        return vueloService.vuelosPorOrigen(origen);
    }

    @PostMapping("/crearVuelo")
    public String crearVuelo(@RequestBody Vuelo vuelo) {
        return vueloService.crearVuelo(vuelo);
    }

    @PutMapping("/modificarVuelo/{id}")
    public String modificarVuelo(@PathVariable Long id, @RequestBody Vuelo vuelo) {
        return vueloService.modificarVuelo(id, vuelo);
    }

    @PatchMapping("/modificarPrecioVuelo/{id}")
    public String modificarPrecioVuelo(@PathVariable Long id, @RequestParam double precio) {
        return vueloService.modificarPrecioVuelo(id, precio);
    }

    @PatchMapping("/modificarFechaVuelo/{id}")
    public String modificarFechaVuelo(@PathVariable Long id, @RequestParam LocalDateTime fechaHoraSalida, @RequestParam LocalDateTime fechaHoraLlegada) {
        return vueloService.modificarFechaVuelo(id, fechaHoraSalida, fechaHoraLlegada);
    }

    @DeleteMapping("/eliminarVuelo/{id}")
    public String eliminarVueloPorId(@PathVariable Long id) {
        return vueloService.eliminarVueloPorId(id);
    }

}
