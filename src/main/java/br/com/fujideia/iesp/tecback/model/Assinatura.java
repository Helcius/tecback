package br.com.fujideia.iesp.tecback.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Assinatura {

    @Id
    @GeneratedValue
    private Integer id;
    private String tipo;
    private Integer valor;
    private Integer QuantidadeDispositivos;

}
