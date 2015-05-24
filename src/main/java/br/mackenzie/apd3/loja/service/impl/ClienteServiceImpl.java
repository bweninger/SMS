package br.mackenzie.apd3.loja.service.impl;

import br.mackenzie.apd3.loja.dao.ClienteDAO;
import br.mackenzie.apd3.loja.dao.EnderecoDAO;
import br.mackenzie.apd3.loja.dto.ClienteDTO;
import br.mackenzie.apd3.loja.dto.EnderecoDTO;
import br.mackenzie.apd3.loja.model.Cliente;
import br.mackenzie.apd3.loja.model.Endereco;
import br.mackenzie.apd3.loja.service.ClienteService;
import br.mackenzie.apd3.loja.util.DTOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by BWeninger on 20/04/2015.
 */
@Service
@Transactional
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteDAO clienteDAO;

    @Autowired
    private EnderecoDAO enderecoDAO;

    @Override
    public ClienteDTO buscarClientePorEmail(String email) {
        Cliente cliente = this.clienteDAO.buscarPorEmail(email);
        ClienteDTO clienteDTO = new ClienteDTO();
        if (cliente == null) {
            clienteDTO.setEmail(email);
            return clienteDTO;
        }

        DTOUtil.copiarPropriedades(cliente, clienteDTO,
                DTOUtil.obterNomesAtributos(ClienteDTO.class));
        return clienteDTO;
    }

    @Override
    public ClienteDTO buscarClientePorCPF(String cpf) {
        Cliente cliente = this.clienteDAO.buscarPorCPF(cpf);
        ClienteDTO clienteDTO = new ClienteDTO();
        DTOUtil.copiarPropriedades(cliente, clienteDTO,
                DTOUtil.obterNomesAtributos(ClienteDTO.class));
        return clienteDTO;
    }

    @Override
    public ClienteDTO cadastrarCliente(ClienteDTO dto) {
        Cliente cliente = new Cliente();

        if (dto.getCpf() != null) {
            dto.setCpf(dto.getCpf().replaceAll("\\.", "").replaceAll("-", ""));
        }

        DTOUtil.copiarPropriedades(dto, cliente, DTOUtil.obterNomesAtributos(Cliente.class));
        this.clienteDAO.incluir(cliente);
        dto.setId(cliente.getId());
        return dto;
    }

    @Override
    public ClienteDTO cadastrarEnderecoCliente(ClienteDTO clienteDTO, EnderecoDTO enderecoDTO) {
        Endereco endereco = new Endereco();
        Cliente cliente = new Cliente();
        DTOUtil.copiarPropriedades(enderecoDTO, endereco, DTOUtil.obterNomesAtributos(Endereco.class));
        DTOUtil.copiarPropriedades(clienteDTO, cliente, DTOUtil.obterNomesAtributos(Cliente.class));
        endereco.setCliente(cliente);
        this.enderecoDAO.incluir(endereco);
        cliente = this.clienteDAO.buscarPorChave(endereco.getCliente().getId());
        DTOUtil.copiarPropriedades(cliente, clienteDTO,
                DTOUtil.obterNomesAtributos(ClienteDTO.class));

        List<Endereco> enderecos = this.enderecoDAO.listarPorCliente(cliente.getId());
        clienteDTO.setEnderecos(DTOUtil.converterLista(enderecos, EnderecoDTO.class));

        return clienteDTO;
    }

    @Override
    public List<EnderecoDTO> buscarEnderecos(ClienteDTO clienteDTO) {
        List<Endereco> enderecos = this.enderecoDAO.listarPorCliente(clienteDTO.getId());
        return DTOUtil.converterLista(enderecos, EnderecoDTO.class);
    }


}
