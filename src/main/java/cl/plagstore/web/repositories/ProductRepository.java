package cl.plagstore.web.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import cl.plagstore.web.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query(value = "SELECT c.name ,p.name  , SUM(sp.quantity) as cantidad "
    		+ "from sales_products sp "
    		+ "left join products p ON sp.product_id =p.id "
    		+ "left join categories c on p.category_id =c.id "
    		+ "left join sales s ON sp.sale_id = s.id "
    		+ "WHERE s.status = 0 "
    		+ "GROUP BY p.id "
    		+ "ORDER by cantidad DESC;", nativeQuery = true)
    List<Object[]> obtenerProductoMasVendidoDesc();
}
