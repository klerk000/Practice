package ua.com.hotel.hotelpractice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.hotel.hotelpractice.entity.Client;
import ua.com.hotel.hotelpractice.repository.ClientRepository;

@Service
public class ClientManagerService {
    private final ClientRepository clientRepository;

    @Autowired
    public ClientManagerService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client getClientById(Long id) {
        return clientRepository.getClientById(id);
    }

    public void saveClientToDB(Client client) {
        clientRepository.save(client);
    }
}
