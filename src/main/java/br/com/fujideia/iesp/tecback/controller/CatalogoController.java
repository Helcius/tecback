package br.com.fujideia.iesp.tecback.controller;

import br.com.fujideia.iesp.tecback.model.Catalogo;
import br.com.fujideia.iesp.tecback.service.CatalogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/catalogo")

public class CatalogoController {
    @Autowired
    private CatalogoService service;

    @PostMapping
    public ResponseEntity<Catalogo> salvar(@RequestBody Catalogo catalogo){
        catalogo = service.salvar(catalogo);
        return ResponseEntity.ok(catalogo);
    }

    @PutMapping
    public ResponseEntity<Catalogo> alterar(@RequestBody Catalogo catalogo){
        catalogo = service.alterar(catalogo);
        return ResponseEntity.ok(catalogo);
    }
    @GetMapping
    public ResponseEntity<List<Catalogo>> listar(){
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Catalogo> consultar(@PathVariable("id") Integer id){
        return ResponseEntity.ok(service.consultarPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> excluir(@PathVariable("id") Integer id) {
        if (service.excluir(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
}