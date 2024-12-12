package cl.inacap.authjwt.jwtauth.SolicitudRetiro;

//aqui representaría a los usuarios que pueden tener el rol de admin o user


import cl.inacap.authjwt.jwtauth.User.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table (name = "Reciclaje")

public class Reciclaje {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column (nullable = false)
    private String email;

    @Column (nullable = false)
    private String direccion;

    @Column (nullable = false)
    private LocalDateTime fecha;

    @Column (nullable = false)
    private String tipoReciclaje;

    @ManyToOne
    @JoinColumn (name = "user_id", nullable = false)
    @JsonBackReference
    private User user;





}
