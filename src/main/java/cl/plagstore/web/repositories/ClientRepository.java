package cl.plagstore.web.repositories;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import cl.plagstore.web.models.Client;



@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
//	Las 2 funciones siguientes hacen lo mismo, uno mediante Query y otro con JPA
//	@Query(nativeQuery = true, value = "SELECT * from clients c")
//	ArrayList<Client> obtenerClientes();
//
//	ArrayList<Client> findAll();
//	
	@Query(nativeQuery = true, value = "SELECT c.name as NombreCliente, SUM(sp.quantity * p.price) AS TotalVendido, COUNT(c.name) as CantidadVentas, AVG(sp.quantity * p.price) as PromedioDeVentas "
			+ "FROM clients c "
			+ "left join sales s ON c.id = s.client_id "
			+ "left join sales_products sp on s.id = sp.sale_id "
			+ "left join products p on sp.product_id = p.id "
			+ "GROUP BY c.name "
			+ "order by PromedioDeVentas asc;")
	ArrayList<Object[]> promedioVentasPorCliente();
	
}
