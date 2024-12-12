package cl.inacap.authjwt.jwtauth.SolicitudRetiro;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class ReciclajeServiceImpl implements ReciclajeService  {

    @Autowired
    private ReciclajeRepository reciclajeRepository;


    @Override
    public Reciclaje crearReciclaje(Reciclaje reciclaje) {
        return reciclajeRepository.save(reciclaje);
    }

    @Override
    public Reciclaje actualizarReciclaje(Integer id, Reciclaje reciclaje) {
        reciclaje.setId(id);
        return reciclajeRepository.save(reciclaje);
    }

    @Override
    public Optional<Reciclaje> obtenerReciclajeporId(Integer id) {
        return reciclajeRepository.findById(id);
    }

    @Override
    public List<Reciclaje> obtenerTodosReciclajes() {
        return reciclajeRepository.findAll();
    }

    @Override
    public void eliminarReciclaje(Integer id) {
        reciclajeRepository.deleteById(id);
    }
}
