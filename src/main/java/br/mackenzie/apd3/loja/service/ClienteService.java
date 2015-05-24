package br.mackenzie.apd3.loja.service;

import br.mackenzie.apd3.loja.dto.ClienteDTO;
import br.mackenzie.apd3.loja.dto.EnderecoDTO;

import java.util.List;

/**
 * Created by BWeninger on 20/04/2015.
 */
public interface ClienteService {

    ClienteDTO buscarClientePorEmail(String email);

    ClienteDTO buscarClientePorCPF(String cpf);

    ClienteDTO cadastrarCliente(ClienteDTO dto);

    ClienteDTO cadastrarEnderecoCliente(ClienteDTO clienteDTO, EnderecoDTO enderecoDTO);

    List<EnderecoDTO> buscarEnderecos(ClienteDTO clienteDTO);
}
