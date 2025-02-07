package br.com.fujideia.iesp.tecback.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Catalogo {

    @Id
    @GeneratedValue
    private Integer id;
    private String titulo;
    private Integer ano;
    private String genero;
    private String classificacao;
}
