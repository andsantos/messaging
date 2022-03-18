package br.com.andsantos.messaging.builder;

public class BuilderException extends RuntimeException {
    private static final long serialVersionUID = 6481067862610165319L;

    public BuilderException(String mensagem) {
        super(mensagem);
    }
}
