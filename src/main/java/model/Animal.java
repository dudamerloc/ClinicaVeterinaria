package model;

import java.util.ArrayList;
import java.util.List;

public class Animal {
    private String nome;
    private String tipo;
    private String sexo;
    private String castrado;

    //Lista que armazena eventos ou registros no histórico do animal
    private List<String> historico;

    //Construtor que inicializa o animal com nome, tipo, sexo e status de castração
    //Também inicializa a lista de histórico vazia
    public Animal(String nome, String tipo, String sexo, String castrado){
        this.nome = nome;
        this.tipo = tipo;
        this.sexo = sexo;
        this.castrado = castrado;
        this.historico = new ArrayList<>();
    }

    //Métodos getters e setters para acessar e modificar os atributos do animal
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

    //Retorna a lista de eventos do histórico do animal
    public List<String> getHistorico(){
        return historico;
    }

    //Adiciona um evento ao histórico do animal
    public void adicionarHistorico(String evento){
        historico.add(evento);
    }
}

