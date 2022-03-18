package br.com.andsantos.messaging.builder;

import br.com.andsantos.messaging.dto.ClienteDTO;

public class ClienteBuilder {
    private String nomeEmpresa;
    private String nomeContato;
    private String email;

    private ClienteBuilder() { }

    public static ClienteBuilder builder() {
        return new ClienteBuilder();
    }

    public ClienteBuilder nomeEmpresa(String empresa) {
        this.nomeEmpresa = empresa;
        return this;
    }

    public ClienteBuilder nomeContato(String contato) {
        this.nomeContato = contato;
        return this;
    }

    public ClienteBuilder email(String mail) {
        this.email = mail;
        return this;
    }

    public ClienteDTO build() {
        ClienteDTO cliente = new ClienteDTO();

        if (this.nomeEmpresa == null) {
            throw new BuilderException("Nome da Empresa não informado.");
        }

        if (this.nomeContato == null) {
            throw new BuilderException("Nome do Contato não informado.");
        }

        if (this.email == null) {
            throw new BuilderException("E-mail do Cliente não informado.");
        }

        cliente.setNomeContato(nomeContato);
        cliente.setNomeEmpresa(nomeEmpresa);
        cliente.setEmail(email);

        return cliente;
    }
}
