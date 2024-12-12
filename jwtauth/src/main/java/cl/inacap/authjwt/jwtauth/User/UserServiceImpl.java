package cl.inacap.authjwt.jwtauth.User;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class UserServiceImpl implements  UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Optional <User> autenticarUser (String username, String password) {
        return userRepository.findByUsername(username);
    }

}
