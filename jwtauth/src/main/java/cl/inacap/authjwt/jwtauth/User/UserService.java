package cl.inacap.authjwt.jwtauth.User;

import java.util.Optional;

public interface UserService {

    Optional <User> autenticarUser (String id, String password);
}
