package cl.plagstore.web.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.plagstore.web.repositories.ProductRepository;


@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Object[]> obtenerProductoMasVendidoDesc() {
        return productRepository.obtenerProductoMasVendidoDesc();
    }

}

