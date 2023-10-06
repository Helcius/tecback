package br.com.fujideia.iesp.tecback.model;

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
    private Integer nota;
    private String descricao;

}
