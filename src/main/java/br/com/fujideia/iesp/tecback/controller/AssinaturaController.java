package br.com.fujideia.iesp.tecback.controller;

import br.com.fujideia.iesp.tecback.model.Assinatura;
import br.com.fujideia.iesp.tecback.service.AssinaturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assinatura")
public class AssinaturaController {
    @Autowired
    private AssinaturaService service;

    @PostMapping
    public ResponseEntity<Assinatura> salvar(@RequestBody Assinatura assinatura){
        assinatura = service.salvar(assinatura);
        return ResponseEntity.ok(assinatura);
    }

    @PutMapping
    public ResponseEntity<Assinatura> alterar(@RequestBody Assinatura assinatura){
        assinatura = service.alterar(assinatura);
        return ResponseEntity.ok(assinatura);
    }

    @GetMapping
    public ResponseEntity<List<Assinatura>> listar(){
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Assinatura> consultar(@PathVariable("id") Integer id){
        return ResponseEntity.ok(service.consultarPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> excluir(@PathVariable("id") Integer id) {
        if (service.excluir(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }


    }}
