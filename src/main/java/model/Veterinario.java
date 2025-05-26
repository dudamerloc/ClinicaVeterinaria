package model;

public class Veterinario {
    private String nome;
    private String cpf;
    private String crmv;

    public Veterinario(String nome, String cpf, String crmv) {
        this.nome = nome;
        this.cpf = cpf;
        this.crmv = crmv;
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public String getCrmv() { return crmv; }
    public void setCrmv(String crmv) { this.crmv = crmv; }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        Veterinario other = (Veterinario) obj;
        return crmv.equals(other.crmv);
    }

    @Override
    public int hashCode() {
        return crmv.hashCode();
    }
}

