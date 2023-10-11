package br.com.fujideia.iesp.tecback.service;


import br.com.fujideia.iesp.tecback.model.Comentario;
import br.com.fujideia.iesp.tecback.repository.ComentarioRepository;
import jakarta.ws.rs.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Slf4j
@Service
public class ComentarioService {
    @Autowired
    private ComentarioRepository repository;

    public Comentario salvar(Comentario comentario){
        comentario = repository.save(comentario);
        return comentario;
    }

    public Comentario alterar(Comentario comentario){
        if(Objects.nonNull(comentario.getId())){
            comentario = repository.save(comentario);
        }else{
            throw new NotFoundException();
        }
        return comentario;
    }

    public List<Comentario> listar(){
        return repository.findAll();
    }

    public Boolean excluir(Integer id){
        try {
            repository.deleteById(id);
        }catch (Exception e ){
            log.info("Erro ao realizar Exclusão : {}", e);
            return false;

        }
        return true;
    }

    public Comentario consultarPorId(Integer id){
        return repository
                .findById(id)
                .orElseThrow(NotFoundException::new);
    }

}