package senai.topicos.estoque.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import senai.topicos.estoque.domain.entity.Produto;

import java.util.List;

public interface EstoqueRepository extends JpaRepository<Produto, Long> {

    Produto save(Produto produto);

    Produto findById(Integer id);

    List<Produto> findAll();

    void deleteById(Integer id);
}
