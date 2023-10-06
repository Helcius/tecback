package br.com.fujideia.iesp.tecback.repository;

import br.com.fujideia.iesp.tecback.model.Avaliacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvaliacaoRepository extends JpaRepository<Avaliacao,Integer > {
}
