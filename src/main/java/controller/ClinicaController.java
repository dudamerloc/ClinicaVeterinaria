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

    // Mapeia cada cliente para uma lista de seus animais
    private Map<Cliente, List<Animal>> clientesAnimais = new HashMap<>();
    private Set<Veterinario> veterinarios = new HashSet<>();
    private List<Consulta> consultas = new ArrayList<>();

    public void adicionarCliente(Cliente cliente) {
        clientesAnimais.putIfAbsent(cliente, new ArrayList<>());
    }

    // Adiciona um animal à lista de um cliente existente
    public void adicionarAnimalAoCliente(Cliente cliente, Animal animal) {
        clientesAnimais.computeIfAbsent(cliente, c -> new ArrayList<>()).add(animal);
    }

    // Adiciona um novo veterinário ao conjunto
    public void adicionarVeterinario(Veterinario vet) {
        veterinarios.add(vet);
    }

    // Adiciona uma nova consulta à lista, valida os dados e salva no histórico e no arquivo
    public void adicionarConsulta(Consulta consulta) throws ConsultaInvalidaException {
        if (consulta.getDescricao() == null || consulta.getDescricao().trim().isEmpty()) {
            throw new ConsultaInvalidaException("Descrição da consulta não pode ser vazia.");
        }
        // Adiciona à lista de consultas
        consultas.add(consulta);

        // Cria um texto com as informações da consulta para adicionar ao histórico do animal
        String info = "Consulta em "
                + consulta.getData()
                + " com " + consulta.getVeterinario().getNome()
                + ": " + consulta.getDescricao();

        // Adiciona o texto ao histórico do animal
        consulta.getAnimal().adicionarHistorico(info);

        // Salva os dados da consulta em um arquivo de texto
        salvarConsultaEmArquivo(consulta);
    }

    // Salva a consulta em um arquivo "consultas.txt"
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

    // Retorna a lista de animais de um determinado cliente
    public List<Animal> getAnimaisDoCliente(Cliente cliente) {
        return clientesAnimais.get(cliente);
    }

    // Retorna o conjunto de veterinários cadastrados
    public Set<Veterinario> getVeterinarios() {
        return veterinarios;
    }

    // Retorna a lista de consultas realizadas
    public List<Consulta> getConsultas() {
        return consultas;
    }

    // Busca e retorna um cliente pelo CPF
    public Cliente buscarClientePorCpf(String cpf) {
        for (Cliente cliente : clientesAnimais.keySet()) {
            if (cliente.getCpf().equals(cpf)) {
                return cliente;
            }
        }
        return null;
    }

    // Busca e retorna um veterinário pelo CRMV
    public Veterinario buscarVeterinarioPorCrmv(String crmv) {
        for (Veterinario vet : veterinarios) {
            if (vet.getCrmv().equals(crmv)) {
                return vet;
            }
        }
        return null;
    }
}
