package ua.com.hotel.hotelpractice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.hotel.hotelpractice.entity.Client;
import ua.com.hotel.hotelpractice.entity.Users;
import ua.com.hotel.hotelpractice.repository.ClientRepository;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client getClientByUser(Users users){
        return clientRepository.findByUsers(users);
    }
}
