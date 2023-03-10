package cl.plagstore.web.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.plagstore.web.models.Sale;
import cl.plagstore.web.repositories.SaleRepository;

@Service
public class SaleService {
    @Autowired
    private SaleRepository saleRepository;

    public List<Sale> findLast15Sales() {
        return saleRepository.findTop15ByOrderByDateDesc();
    }
    public ArrayList<Object[]> obetener15UltimosRegistros() {
        return saleRepository.obtener15UltimosRegistros();
    }
}