package view;

import controller.ClinicaController;
import controller.ConsultaInvalidaException;
import model.Animal;
import model.Cliente;
import model.Consulta;
import model.Veterinario;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private ClinicaController controller = new ClinicaController();
    private Scanner scanner = new Scanner(System.in);

    public void iniciar() {
        controller.adicionarVeterinario(new Veterinario("Dra. Julia Cazeri", "99988877766", "CRMV:1234"));
        controller.adicionarVeterinario(new Veterinario("Dra. Maria Eduarda", "11122233344", "CRMV:5678"));

        boolean rodando = true;
        while (rodando) {
            System.out.println("\n=== Menu Clínica Veterinária ===");
            System.out.println("1. Cadastrar Mamãe ou Papai do Pet");
            System.out.println("2. Cadastrar Pet");
            System.out.println("3. Agendar Consulta");
            System.out.println("4. Listar Atendimentos");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            String opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                    cadastrarCliente();
                    break;
                case "2":
                    cadastrarAnimal();
                    break;
                case "3":
                    agendarConsulta();
                    break;
                case "4":
                    listarAtendimentos();
                    break;
                case "5":
                    rodando = false;
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente.");
            }
        }
    }

    private void cadastrarCliente() {
        System.out.print("Nome do Tutor: ");
        String nome = scanner.nextLine();
        System.out.print("CPF do cliente: ");
        String cpf = scanner.nextLine();
        System.out.println("Telefone para contato: ");
        String telefone = scanner.nextLine();
        System.out.println("Endereço do tutor: ");
        String endereco= scanner.nextLine();

        Cliente cliente = new Cliente(nome, cpf, telefone, endereco);
        controller.adicionarCliente(cliente);

        System.out.println("Cliente cadastrado com sucesso!");
    }

    private void cadastrarAnimal() {
        System.out.print("CPF do tutor do animal: ");
        String cpf = scanner.nextLine();

        Cliente cliente = controller.buscarClientePorCpf(cpf);
        if (cliente == null) {
            System.out.println("Tutor não encontrado.");
            return;
        }

        System.out.print("Nome do Pet: ");
        String nomeAnimal = scanner.nextLine();
        System.out.print("Tipo e raça do pet: ");
        String tipo = scanner.nextLine();
        System.out.println("Qual o Sexo do Pet(F/M)? ");
        String sexo = scanner.nextLine();
        System.out.println("O Pet e Castrado? ");
        String castrado = scanner.nextLine();

        Animal animal = new Animal(nomeAnimal, tipo, sexo, castrado);
        controller.adicionarAnimalAoCliente(cliente, animal);

        System.out.println("Pet cadastrado com sucesso para o Tutor " + cliente.getNome());
    }

    private void agendarConsulta() {
        System.out.print("CPF do Tutor: ");
        String cpf = scanner.nextLine();
        Cliente cliente = controller.buscarClientePorCpf(cpf);
        if (cliente == null) {
            System.out.println("Tutor não encontrado.");
            return;
        }

        List<Animal> animais = controller.getAnimaisDoCliente(cliente);
        if (animais == null || animais.isEmpty()) {
            System.out.println("Este Tutor não tem Pet(s) cadastrados.");
            return;
        }

        System.out.println("Pet(s) do Tutor:");
        for (int i = 0; i < animais.size(); i++) {
            System.out.println((i + 1) + ". " + animais.get(i).getNome() + " (" + animais.get(i).getTipo() + ")");
        }
        System.out.print("Escolha o Pet pelo número: ");
        int idxAnimal = Integer.parseInt(scanner.nextLine()) - 1;
        if (idxAnimal < 0 || idxAnimal >= animais.size()) {
            System.out.println("Número inválido.");
            return;
        }
        Animal animalSelecionado = animais.get(idxAnimal);

        if (controller.getVeterinarios().isEmpty()) {
            System.out.println("Não há veterinários cadastrados.");
            return;
        }

        System.out.println("Veterinários disponíveis:");
        List<Veterinario> listaVet = controller.getVeterinarios().stream().toList();
        for (int i = 0; i < listaVet.size(); i++) {
            System.out.println((i + 1) + ". " + listaVet.get(i).getNome() + " (CRMV: " + listaVet.get(i).getCrmv() + ")");
        }
        System.out.print("Escolha o veterinário pelo número: ");
        int idxVet = Integer.parseInt(scanner.nextLine()) - 1;
        if (idxVet < 0 || idxVet >= listaVet.size()) {
            System.out.println("Número inválido.");
            return;
        }
        Veterinario vetSelecionado = listaVet.get(idxVet);

        System.out.print("Descrição da consulta: ");
        String descricao = scanner.nextLine();

        Consulta consulta = new Consulta(animalSelecionado, vetSelecionado, LocalDate.now(), descricao);
        try {
            controller.adicionarConsulta(consulta);
            System.out.println("Consulta agendada com sucesso!");
        } catch (ConsultaInvalidaException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private void listarAtendimentos() {
        List<Consulta> consultas = controller.getConsultas();
        if (consultas.isEmpty()) {
            System.out.println("Nenhuma consulta registrada.");
            return;
        }

        System.out.println("\n=== Lista de Consultas ===");
        for (Consulta c : consultas) {
            System.out.println("Animal: " + c.getAnimal().getNome() +
                    ", Veterinário: " + c.getVeterinario().getNome() +
                    ", Data: " + c.getData() +
                    ", Descrição: " + c.getDescricao());
        }
    }
}

