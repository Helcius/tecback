package br.com.fujideia.iesp.tecback.repository;

import br.com.fujideia.iesp.tecback.model.Catalogo;
import br.com.fujideia.iesp.tecback.model.Catalogo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatalogoRepository extends JpaRepository<Catalogo,Integer> {

}