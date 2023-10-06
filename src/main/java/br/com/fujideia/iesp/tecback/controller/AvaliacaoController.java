package br.com.fujideia.iesp.tecback.controller;


import br.com.fujideia.iesp.tecback.model.Avaliacao;
import br.com.fujideia.iesp.tecback.model.Filme;
import br.com.fujideia.iesp.tecback.model.Usuario;
import br.com.fujideia.iesp.tecback.service.AvaliacaoService;
import br.com.fujideia.iesp.tecback.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/avaliacao")
public class AvaliacaoController {

    @Autowired
    private AvaliacaoService service;

    @PostMapping
    public ResponseEntity<Avaliacao> salvar(@RequestBody Avaliacao avaliacao){
        avaliacao = service.salvar(avaliacao);
        return ResponseEntity.ok(avaliacao);
    }

    @PutMapping
    public ResponseEntity<Avaliacao> alterar(@RequestBody Avaliacao avaliacao){
        avaliacao = service.alterar(avaliacao);
        return ResponseEntity.ok(avaliacao);
    }

    @GetMapping
    public ResponseEntity<List<Avaliacao>> listar(){
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Avaliacao> consultar(@PathVariable("id") Integer id){
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




}
