package br.com.enio.testeEd.service;

import java.util.List;

import br.com.enio.testeEd.domain.Cliente;
import br.com.enio.testeEd.model.ClienteModel;

public interface ClienteService {
	
	Cliente cadastrar(ClienteModel model);
	Cliente alterar(Long id, ClienteModel model);
	Cliente apagar(Long id);
	List<Cliente> listar();
	Cliente consultar(Long id);
	Boolean validarCpf(String cpf);
	String getNovoCpf();
}
