package br.com.fujideia.iesp.tecback.controller;

import br.com.fujideia.iesp.tecback.model.Filme;
import br.com.fujideia.iesp.tecback.model.dto.FilmeListaDTO;
import br.com.fujideia.iesp.tecback.service.FilmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/filme")
public class FilmeController {

    @Autowired
    private FilmeService service;

    @PostMapping
    public ResponseEntity<Filme> salvar(@RequestBody Filme filme){
        filme = service.salvar(filme);
        return ResponseEntity.ok(filme);
    }

    @PutMapping
    public ResponseEntity<Filme> alterar(@RequestBody Filme filme){
        filme = service.alterar(filme);
        return ResponseEntity.ok(filme);
    }

    @GetMapping
    public ResponseEntity<List<Filme>> listar(){
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Filme> consultar(@PathVariable("id") Integer id){
        return ResponseEntity.ok(service.consultarPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> excluir(@PathVariable("id") Integer id){
        if(service.excluir(id)){
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/genero/{genero}")
    public ResponseEntity<List<Filme>> listarFilmePorGenero(@PathVariable String generoDado){
        return ResponseEntity.ok(service.listarFilmesPorGenero(generoDado));
    }

    @GetMapping("/ano/{ano}")
    public ResponseEntity<List<Filme>> listarFilmesPorAno(@PathVariable String anoDado, String tituloDado){
        return ResponseEntity.ok(service.listarFilmesPorAno(anoDado, tituloDado));
    }

    @GetMapping("/filme/nome/genero")
    public ResponseEntity<List<FilmeListaDTO>> listarFilmeNomeGenero(){
        return ResponseEntity.ok(service.listaFilmeNomeGenero());
    }
}
