package br.com.fujideia.iesp.tecback.repository;

import br.com.fujideia.iesp.tecback.model.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentario,Integer> {
}
