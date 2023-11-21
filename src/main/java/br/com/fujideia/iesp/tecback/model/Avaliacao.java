package br.com.fujideia.iesp.tecback.model;

import br.com.fujideia.iesp.tecback.validator.NotaValida;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "tb_avaliacao")
public class Avaliacao implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;


    //validação: tem que ser de 0 a 10.
    private Integer nota;



    private String descricao;

}
