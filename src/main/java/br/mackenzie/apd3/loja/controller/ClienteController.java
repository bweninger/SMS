package br.mackenzie.apd3.loja.controller;

import br.mackenzie.apd3.loja.dto.ClienteDTO;
import br.mackenzie.apd3.loja.dto.EnderecoDTO;
import br.mackenzie.apd3.loja.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

/**
 * Created by BWeninger on 20/04/2015.
 */
@Controller
@RequestMapping(value = "/clientes")
public class ClienteController implements Serializable {

    @Autowired
    private ClienteService clienteService;

    @RequestMapping(value = "/buscarDadosCliente", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ClienteDTO buscarDados(@RequestBody ClienteDTO cliente) {
        if (cliente.getEmail() != null) {
            return this.clienteService.buscarClientePorEmail(cliente.getEmail());
        } else if (cliente.getCpf() != null) {
            return this.clienteService.buscarClientePorCPF(cliente.getCpf());
        } else {
            return cliente;
        }
    }

    @RequestMapping(value = "/buscarEnderecos", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<EnderecoDTO> buscarEnderecosCliente(@RequestBody ClienteDTO cliente) {
        return this.clienteService.buscarEnderecos(cliente);
    }

    @RequestMapping(value = "/incluirDados", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ClienteDTO incluirDadosCliente(@RequestBody ClienteDTO cliente) {
        return this.clienteService.cadastrarCliente(cliente);
    }

    @RequestMapping(value = "/incluirNovoEndereco/{idCliente}", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ClienteDTO incluirNovoEndereco(@PathVariable(value = "idCliente") Long idCliente, @RequestBody EnderecoDTO endereco) {
        ClienteDTO cliente = new ClienteDTO();
        cliente.setId(idCliente);
        cliente = this.clienteService.cadastrarEnderecoCliente(cliente, endereco);
        return cliente;

    }
}
