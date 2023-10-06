package br.com.fujideia.iesp.tecback.service;

import br.com.fujideia.iesp.tecback.model.Avaliacao;
import br.com.fujideia.iesp.tecback.model.Filme;
import br.com.fujideia.iesp.tecback.repository.AvaliacaoRepository;
import jakarta.ws.rs.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Slf4j
@Service
public class AvaliacaoService {

    @Autowired
    private AvaliacaoRepository repository;
    public Avaliacao salvar(Avaliacao avaliacao){
        avaliacao = repository.save(avaliacao);
        return avaliacao;
    }

    public Avaliacao alterar(Avaliacao avaliacao){
        if(Objects.nonNull(avaliacao.getId())){
            avaliacao = repository.save(avaliacao);
        }else{
            throw new NotFoundException();
        }
        return avaliacao;
    }

    public List<Avaliacao> listar(){
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

    public Avaliacao consultarPorId(Integer id){
        return repository
                .findById(id)
                .orElseThrow(NotFoundException::new);
    }
}
