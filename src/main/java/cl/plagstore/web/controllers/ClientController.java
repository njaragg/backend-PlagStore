package cl.plagstore.web.controllers;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.plagstore.web.services.ClientService;




@RestController
@RequestMapping("/clients")
@CrossOrigin(origins = "*")
public class ClientController {

    @Autowired
    private ClientService clientService;


    @GetMapping("/sales")
    public ArrayList<Object[]> promedioVentasPorCliente() {
        return clientService.promedioVentasPorCliente();
    }
}
