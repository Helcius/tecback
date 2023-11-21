package br.com.fujideia.iesp.tecback.model.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class FilmeListaDTO {
    @NotEmpty
    private String nome;
    private String nomeGenero;
}
