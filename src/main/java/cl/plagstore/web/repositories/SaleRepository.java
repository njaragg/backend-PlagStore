package cl.plagstore.web.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import cl.plagstore.web.models.Sale;


@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {
    List<Sale> findTop15ByOrderByDateDesc();
	@Query(nativeQuery = true, value = "SELECT s.date as Fecha, c.name as Cliente, p.name as Producto, sp.quantity as Cantidad, p.price as PrecioUnitario, (p.price*sp.quantity) as Total, cat.name as Categoria, s.status as EstadoDelPago "
			+ "FROM sales s "
			+ "left join clients c ON s.client_id = c.id "
			+ "left join sales_products sp on s.id = sp.sale_id "
			+ "left join products p on sp.product_id = p.id "
			+ "left join categories cat on p.category_id = cat.id "
			+ "order by s.date DESC limit 15 ;")
	ArrayList<Object[]> obtener15UltimosRegistros();
	
	
	
	
	
}
