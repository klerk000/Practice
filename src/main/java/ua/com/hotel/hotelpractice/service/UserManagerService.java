package ua.com.hotel.hotelpractice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ua.com.hotel.hotelpractice.entity.Client;
import ua.com.hotel.hotelpractice.entity.Role;
import ua.com.hotel.hotelpractice.entity.Users;
import ua.com.hotel.hotelpractice.repository.ClientRepository;
import ua.com.hotel.hotelpractice.repository.UserRepository;

import java.util.Collections;
import java.util.List;

@Service
public class UserManagerService implements UserDetailsService {

    private final UserRepository userRepository;
    private final ClientRepository clientRepository;

    @Autowired
    public UserManagerService(UserRepository userRepository, ClientRepository clientRepository) {
        this.userRepository = userRepository;
        this.clientRepository = clientRepository;
    }


    public boolean getLogicByUser(String username) {
        return !userRepository.findAllByUsername(username).isEmpty();
    }


    public Users saveNewUserToDB(Users user) {

        user.setRoles(Collections.singleton(new Role(1L, "ROLE_User")));
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));

        return userRepository.save(user);
    }

    public List<Client> getRoomsList() {
        return clientRepository.findAll();
    }

    @Override
    public Users loadUserByUsername(String username) throws UsernameNotFoundException {

        Users user1 = userRepository.findByUsername(username);

        if (user1 == null) {
            throw new UsernameNotFoundException("User not found!!!");
        }

        return user1;
    }
}