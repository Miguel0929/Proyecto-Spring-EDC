package uttt.edu.mx.edc.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import uttt.edu.mx.edc.model.DetallePedido;

@Repository
public interface DetallePedidoRepository extends JpaRepository<DetallePedido, Long>{

	@Query(value="select * from detalles where fk_pedido=:fk_pedido", nativeQuery = true)
	List<DetallePedido> findAllDetalle(Long fk_pedido);
	
	
}
