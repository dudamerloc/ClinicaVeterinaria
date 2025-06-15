package model;

public class Veterinario {
    private String nome;
    private String cpf;
    private String crmv;

    // Construtor que inicializa o veterinário com nome, CPF e CRMV
    public Veterinario(String nome, String cpf, String crmv) {
        this.nome = nome;
        this.cpf = cpf;
        this.crmv = crmv;
    }

    // Getters e setters para acessar e modificar os atributos
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public String getCrmv() { return crmv; }
    public void setCrmv(String crmv) { this.crmv = crmv; }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;  // Mesma referência, retorna true
        if(obj == null || getClass() != obj.getClass()) return false;  // Null ou classe diferente, retorna false
        Veterinario other = (Veterinario) obj;
        return crmv.equals(other.crmv);  // Compara o CRMV para definir igualdade
    }

    @Override
    public int hashCode() {
        return crmv.hashCode();
    }
}

