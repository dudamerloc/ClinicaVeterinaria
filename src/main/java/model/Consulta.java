package model;

import model.Animal;
import java.time.LocalDate;

public class Consulta {
    private Animal animal;  // Animal que será atendido na consulta
    private Veterinario veterinario;  // Veterinário responsável pela consulta
    private LocalDate data;  // Data da consulta
    private String descricao; // Descrição ou observações da consulta


    // Construtor que inicializa os atributos da consulta
    public Consulta(Animal animal, Veterinario veterinario, LocalDate data, String descricao) {
        this.animal = animal;
        this.veterinario = veterinario;
        this.data = data;
        this.descricao = descricao;
    }

    // Métodos getters para acessar os atributos da consulta
    public Animal getAnimal() { return animal; }
    public Veterinario getVeterinario() { return veterinario; }
    public LocalDate getData() { return data; }
    public String getDescricao() { return descricao; }
}

