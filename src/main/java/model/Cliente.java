package model;

public class Cliente {
    private String nome;
    private String cpf;
    private String telefone;
    private String endereco;

    // Construtor que inicializa todos os atributos do cliente
    public Cliente(String nome, String cpf, String telefone, String endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    // Getters e setters para acessar e modificar os atributos
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco(){
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;  // Se for o mesmo objeto, retorna true
        if(obj == null || getClass() != obj.getClass()) return false;  // Se o objeto for null ou de classe diferente, retorna false
        Cliente other = (Cliente) obj;
        return cpf.equals(other.cpf);
    }

    @Override
    public int hashCode() {
        return cpf.hashCode();
    }
}

