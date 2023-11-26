package br.com.fujideia.iesp.tecback.model.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AssinaturaDTO {

    @Id
    @GeneratedValue
    private Integer id;
    private String tipo;
    private Integer valor;
    private Integer QuantidadeDispositivos;
}
