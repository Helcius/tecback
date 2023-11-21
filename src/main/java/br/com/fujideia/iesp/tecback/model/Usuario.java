package br.com.fujideia.iesp.tecback.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Usuario {

    @Id
    @GeneratedValue
    private Integer id;
    private String nome;
    private String email;
}

//- Assinatura
//  *id
//  *tipo
//  *valor
//  *quantidadeDispositivos
//
// - Catálogo
// *id
// *titulo
// *ano
// *genero
// *classificacao
//
//- Comentários
//* id
//* idUsuario
//* texto
//
//- Genero
//  *id
//  *nome
//  *descrição
//
//- Avaliação
//  *id
//  *nota
//  *descrição