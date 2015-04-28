package br.mackenzie.apd3.loja.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bweninger on 15/04/2015.
 */
public class ClienteDTO implements Serializable {

    private Long id;
    private String nome;
    private String email;
    private String cpf;
    private List<EnderecoDTO> enderecos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf.replaceAll("\\.","").replaceAll("-","");
    }

    public List<EnderecoDTO> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<EnderecoDTO> enderecos) {
        this.enderecos = enderecos;
    }

    public void adicionarEndereco(EnderecoDTO enderecoDTO) {
        if(this.enderecos == null){
            this.enderecos = new ArrayList<>();
        }
        this.enderecos.add(enderecoDTO);
    }
}
