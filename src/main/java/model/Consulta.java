package model;

import model.Animal;
import java.time.LocalDate;

public class Consulta {
    private Animal animal;
    private Veterinario veterinario;
    private LocalDate data;
    private String descricao;

    public Consulta(Animal animal, Veterinario veterinario, LocalDate data, String descricao) {
        this.animal = animal;
        this.veterinario = veterinario;
        this.data = data;
        this.descricao = descricao;
    }

    public Animal getAnimal() { return animal; }
    public Veterinario getVeterinario() { return veterinario; }
    public LocalDate getData() { return data; }
    public String getDescricao() { return descricao; }
}

