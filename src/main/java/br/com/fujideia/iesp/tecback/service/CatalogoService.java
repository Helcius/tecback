package br.com.fujideia.iesp.tecback.service;

import br.com.fujideia.iesp.tecback.model.Catalogo;
import br.com.fujideia.iesp.tecback.repository.CatalogoRepository;
import jakarta.ws.rs.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Slf4j
@Service
public class CatalogoService {
    @Autowired
    private CatalogoRepository repository;

    public Catalogo salvar(Catalogo catalogo){
        catalogo = repository.save(catalogo);
        return catalogo;
    }

    public Catalogo alterar(Catalogo catalogo){
        if(Objects.nonNull(catalogo.getId())){
            catalogo = repository.save(catalogo);
        }else{
            throw new NotFoundException();
        }
        return catalogo;
    }

    public List<Catalogo> listar(){
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

    public Catalogo consultarPorId(Integer id){
        return repository
                .findById(id)
                .orElseThrow(NotFoundException::new);
    }

}
