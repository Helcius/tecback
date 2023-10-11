package br.com.fujideia.iesp.tecback.repository;

import br.com.fujideia.iesp.tecback.model.Catalogo;
import br.com.fujideia.iesp.tecback.model.Avaliacao;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CatalogoRepository extends JpaRepository<Catalogo,Integer > {
}