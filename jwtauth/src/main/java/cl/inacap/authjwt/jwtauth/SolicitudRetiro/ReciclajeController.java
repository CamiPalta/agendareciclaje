package cl.inacap.authjwt.jwtauth.SolicitudRetiro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping ("/recycle")
public class ReciclajeController {

    @Autowired
    private ReciclajeService reciclajeService;

    @PostMapping("/solicitar")
    public Reciclaje crearReciclaje (@RequestBody Reciclaje reciclaje) {
        return reciclajeService.crearReciclaje(reciclaje);
    }

    @PatchMapping("/update/{id}")
    public Reciclaje actualizarReciclaje (@PathVariable Integer id, @RequestBody Reciclaje reciclaje) {
        return reciclajeService.actualizarReciclaje(id, reciclaje);
    }

    @GetMapping("/getRecycle/{id}")
    public Optional <Reciclaje> optionalReciclaje (@PathVariable Integer id) {
        return reciclajeService.obtenerReciclajeporId(id);
    }

    @GetMapping("/listRecycle")
    public List<Reciclaje> obtenerReciclajes() {
        return reciclajeService.obtenerTodosReciclajes();
    }

    @DeleteMapping("/delete/{id}")
    public void eliminarReciclaje(@PathVariable Integer id) {
        reciclajeService.eliminarReciclaje(id);
    }

}
