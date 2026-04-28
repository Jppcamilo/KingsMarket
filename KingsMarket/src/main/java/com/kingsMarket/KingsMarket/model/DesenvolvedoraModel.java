package com.kingsMarket.KingsMarket.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DesenvolvedoraModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome da desenvolvedora é obrigatório.")
    @Column(nullable = false)
    private String nome;

    @Lob
    private String descricao;

    private LocalDate dataFundacao;

    @OneToMany(mappedBy = "desenvolvedora", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<JogoModel> jogos;
}