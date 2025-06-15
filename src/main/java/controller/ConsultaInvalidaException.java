package controller;

// Define uma nova exceção personalizada que herda de Exception
public class ConsultaInvalidaException extends Exception {

    // Construtor que recebe uma mensagem de erro como parâmetro
    public ConsultaInvalidaException(String mensagem) {

        // Chama o construtor da superclasse (Exception) para registrar a mensagem
        super(mensagem);
    }
}

