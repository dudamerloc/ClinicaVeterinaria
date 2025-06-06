package controller;

import model.Animal;
import model.Cliente;
import model.Consulta;
import model.Veterinario;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

public class ClinicaController {
    private Map<Cliente, List<Animal>> clientesAnimais = new HashMap<>();
    private Set<Veterinario> veterinarios = new HashSet<>();
    private List<Consulta> consultas = new ArrayList<>();

    public void adicionarCliente(Cliente cliente) {
        clientesAnimais.putIfAbsent(cliente, new ArrayList<>());
    }

    public void adicionarAnimalAoCliente(Cliente cliente, Animal animal) {
        clientesAnimais.computeIfAbsent(cliente, c -> new ArrayList<>()).add(animal);
    }

    public void adicionarVeterinario(Veterinario vet) {
        veterinarios.add(vet);
    }

    public void adicionarConsulta(Consulta consulta) throws ConsultaInvalidaException {
        if (consulta.getDescricao() == null || consulta.getDescricao().trim().isEmpty()) {
            throw new ConsultaInvalidaException("Descrição da consulta não pode ser vazia.");
        }
        consultas.add(consulta);

        String info = "Consulta em "
                + consulta.getData()
                + " com " + consulta.getVeterinario().getNome()
                + ": " + consulta.getDescricao();
        consulta.getAnimal().adicionarHistorico(info);

        salvarConsultaEmArquivo(consulta);
    }

    private void salvarConsultaEmArquivo(Consulta consulta) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("consultas.txt", true))) {
            writer.write("Animal: " + consulta.getAnimal().getNome()
                    + " | Tipo: " + consulta.getAnimal().getTipo()
                    + " | Veterinário: " + consulta.getVeterinario().getNome()
                    + " | Data: " + consulta.getData()
                    + " | Descrição: " + consulta.getDescricao());
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Erro ao salvar consulta no arquivo: " + e.getMessage());
        }
    }

    public List<Animal> getAnimaisDoCliente(Cliente cliente) {
        return clientesAnimais.get(cliente);
    }

    public Set<Veterinario> getVeterinarios() {
        return veterinarios;
    }

    public List<Consulta> getConsultas() {
        return consultas;
    }

    public Cliente buscarClientePorCpf(String cpf) {
        for (Cliente cliente : clientesAnimais.keySet()) {
            if (cliente.getCpf().equals(cpf)) {
                return cliente;
            }
        }
        return null;
    }

    public Veterinario buscarVeterinarioPorCrmv(String crmv) {
        for (Veterinario vet : veterinarios) {
            if (vet.getCrmv().equals(crmv)) {
                return vet;
            }
        }
        return null;
    }
}
