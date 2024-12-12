package cl.inacap.authjwt.jwtauth.SolicitudRetiro;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReciclajeRepository extends JpaRepository <Reciclaje, Integer>  {
}
