package model;

import java.util.ArrayList;
import java.util.List;

public class Animal {
    private String nome;
    private String tipo;
    private String sexo;
    private String castrado;
    private List<String> historico;

    public Animal(String nome, String tipo, String sexo, String castrado){
        this.nome = nome;
        this.tipo = tipo;
        this.sexo = sexo;
        this.castrado = castrado;
        this.historico = new ArrayList<>();
    }

    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }

    public String getTipo(){
        return tipo;
    }
    public void setTipo(String tipo){
        this.tipo = tipo;
    }
    public  String getSexo(){
        return sexo;
    }
    public void setSexo(String sexo){
        this.sexo = sexo;
    }
    public String getCastrado(){
        return castrado;
    }
    public void setCastrado(String castrado){
        this.castrado = castrado;
    }

    public List<String> getHistorico(){
        return historico;
    }

    public void adicionarHistorico(String evento){
        historico.add(evento);
    }
}

