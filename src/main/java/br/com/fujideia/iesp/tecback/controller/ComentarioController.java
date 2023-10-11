package br.com.fujideia.iesp.tecback.controller;

import br.com.fujideia.iesp.tecback.model.Comentario;
import br.com.fujideia.iesp.tecback.service.ComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comentario")
public class ComentarioController {

    @Autowired
    private ComentarioService service;

    @PostMapping
    public ResponseEntity<Comentario> salvar(@RequestBody Comentario comentario){
        comentario = service.salvar(comentario);
        return ResponseEntity.ok(comentario);
    }

    @PutMapping
    public ResponseEntity<Comentario> alterar(@RequestBody Comentario comentario){
        comentario = service.alterar(comentario);
        return ResponseEntity.ok(comentario);
    }

    @GetMapping
    public ResponseEntity<List<Comentario>> listar(){
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comentario> consultar(@PathVariable("id") Integer id){
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
