package br.com.enio.testeEd.repository;

import java.util.List;

import br.com.enio.testeEd.domain.Cliente;

public interface ClienteRepository {
	Cliente cadastrar(Cliente domain);
	Cliente apagar(Cliente domain);
	List<Cliente> listar();
	Cliente consultar(Long id);
}
