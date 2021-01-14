package uttt.edu.mx.edc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uttt.edu.mx.edc.model.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

}
