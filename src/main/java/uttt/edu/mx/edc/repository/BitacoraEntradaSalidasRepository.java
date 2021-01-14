package uttt.edu.mx.edc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uttt.edu.mx.edc.model.BitacoraEntradaSalida;


@Repository
public interface BitacoraEntradaSalidasRepository extends JpaRepository<BitacoraEntradaSalida, Long>{

}
