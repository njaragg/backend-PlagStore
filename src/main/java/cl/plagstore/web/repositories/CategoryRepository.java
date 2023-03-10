package cl.plagstore.web.repositories;

import java.util.ArrayList;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import cl.plagstore.web.models.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
	@Query(nativeQuery = true, value = "SELECT c.id, c.name as categoria, COUNT(*) as ventas, SUM(sp.quantity) as total_productos_vendidos, SUM(sp.quantity* p.price) as total_dinero "
			+ "from categories c "
			+ "left join products p on c.id = p.category_id "
			+ "left join sales_products sp on p.id = sp.product_id "
			+ "left join sales s on sp.sale_id  = s.id "
			+ "where s.status = 0 "
			+ "GROUP by c.id "
			+ "order by c.id asc;")
	ArrayList<Object[]> obtenerVentasPorCategoria();
	    
	    
}
