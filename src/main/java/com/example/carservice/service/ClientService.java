package com.example.carservice.service;

import com.example.carservice.entity.Client;
import com.example.carservice.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ClientService implements UserDetailsService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Client save(Client client)
    {
        return clientRepository.save(client);
    }

    public void registerClient(Client client)
    {
        Client clientFromDB=clientRepository.findClientByTelephoneNumber(client.getTelephoneNumber());
        if (clientFromDB!=null)
        {
            return;
        }
        client.setPassword(passwordEncoder.encode(client.getPassword()));
        save(client);
    }


    public String validateRegister(Client client) {

        if (clientRepository.findClientByTelephoneNumber(client.getTelephoneNumber()) != null) {
            return "/register";
        }
        try {
            registerClient(client);
            return "redirect:/login";
        } catch (Exception e) {
            return "/register";
        }
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Client client=clientRepository.findClientByTelephoneNumber(username);
        if (client==null)
        {
            throw new UsernameNotFoundException("User not found");
        }
        return client;
    }
}
