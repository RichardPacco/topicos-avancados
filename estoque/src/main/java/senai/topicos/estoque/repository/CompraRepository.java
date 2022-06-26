package senai.topicos.estoque.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import senai.topicos.estoque.domain.entity.Compra;

import java.util.List;

public interface CompraRepository extends JpaRepository<Compra, Long> {

    List<Compra> findAll();

    Compra save(Compra compra);


}
