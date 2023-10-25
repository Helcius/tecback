package br.com.fujideia.iesp.tecback.service;


import br.com.fujideia.iesp.tecback.model.Filme;
import br.com.fujideia.iesp.tecback.model.dto.FilmeListaDTO;
import br.com.fujideia.iesp.tecback.repository.FilmeRepository;
import jakarta.ws.rs.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Slf4j
@Service
public class FilmeService {
    @Autowired
    private FilmeRepository repository;

    public Filme salvar(Filme filme){
        filme = repository.save(filme);
        return filme;
    }

    public Filme alterar(Filme filme){
        if(Objects.nonNull(filme.getId())){
            filme = repository.save(filme);
        }else{
            throw new NotFoundException();
        }
        return filme;
    }

    public List<Filme> listar(){
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

    public Filme consultarPorId(Integer id){
        return repository
                .findById(id)
                .orElseThrow(NotFoundException::new);
    }


    public List<Filme> listarFilmesPorGenero(String generoDado){
        return repository.listarFilmesPorGenero(generoDado);
    }

    public List<Filme> listarFilmesPorAno(String anoDado, String tituloDado){
        return repository.listarFilmesPorAno(anoDado, tituloDado);
    }

    public List<FilmeListaDTO> listaFilmeNomeGenero(){
        List<Filme> listaFilme = repository.findAll();
        List<FilmeListaDTO> listaDTO = new ArrayList<>();
        for (Filme filme : listaFilme){
            listaDTO.add(
                    FilmeListaDTO
                            .builder()
                            .nome(filme.getTitulo())
                            .nomeGenero(filme.getGenero().getTitulo())
                            .build()
            );
        }
        return listaDTO;
     }





}
