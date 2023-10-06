package br.com.fujideia.iesp.tecback.repository;

import br.com.fujideia.iesp.tecback.model.Assinatura;
import br.com.fujideia.iesp.tecback.model.Avaliacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssinaturaRepository extends JpaRepository<Assinatura,Integer > {
}
