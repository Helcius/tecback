package br.com.fujideia.iesp.tecback.service;

import br.com.fujideia.iesp.tecback.model.Assinatura;
import br.com.fujideia.iesp.tecback.model.Avaliacao;
import br.com.fujideia.iesp.tecback.repository.AssinaturaRepository;
import br.com.fujideia.iesp.tecback.repository.AvaliacaoRepository;
import jakarta.ws.rs.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Slf4j
@Service
public class AssinaturaService {

    @Autowired
    private AssinaturaRepository repository;
    public Assinatura salvar(Assinatura assinatura){
        assinatura = repository.save(assinatura);
        return assinatura;
    }

    public Assinatura alterar(Assinatura assinatura){
        if(Objects.nonNull(assinatura.getId())){
            assinatura = repository.save(assinatura);
        }else{
            throw new NotFoundException();
        }
        return assinatura;
    }

    public List<Assinatura> listar(){
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

    public Assinatura consultarPorId(Integer id){
        return repository
                .findById(id)
                .orElseThrow(NotFoundException::new);
    }

}
