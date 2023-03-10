package cl.plagstore.web.services;

import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.plagstore.web.repositories.ClientRepository;

@Service
public class ClientService { 
    
    @Autowired
    private ClientRepository clientRepository;
    
//    public ArrayList<Client> obtenerClientes(){
//		return clientRepository.obtenerClientes();
//    	
//    }
//    public ArrayList<Client> obtenerClientesJpa(){
//    	return clientRepository.findAll(); 
//    }
    public ArrayList<Object[]> promedioVentasPorCliente(){
    	return clientRepository.promedioVentasPorCliente(); 
    }
    
    
}


