package cl.inacap.authjwt.jwtauth.SolicitudRetiro;

import java.util.List;
import java.util.Optional;

public interface ReciclajeService {

    Reciclaje crearReciclaje (Reciclaje reciclaje);

    Reciclaje actualizarReciclaje (Integer id, Reciclaje reciclaje);

    Optional <Reciclaje> obtenerReciclajeporId (Integer id);

    List<Reciclaje> obtenerTodosReciclajes();

    void eliminarReciclaje (Integer id);
}
