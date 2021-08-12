package br.com.enio.testeEd.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.enio.testeEd.domain.Cliente;
import br.com.enio.testeEd.repository.ClienteRepository;

@Repository
public class ClienteRepositoryImpl implements ClienteRepository {

	private final static List<Cliente> CLIENTES = new ArrayList<>();
	
	@Override
	public Cliente cadastrar(final Cliente domain) {
		CLIENTES.add(domain);
		return domain;
	}

	@Override
	public Cliente apagar(final Cliente domain) {
		CLIENTES.remove(domain);
		return domain;
	}

	@Override
	public List<Cliente> listar() {
		return CLIENTES;
	}

	@Override
	public Cliente consultar(final Long id) {
		for (Cliente cliente : CLIENTES) {
			if (cliente.getId().equals(id)) {
				return cliente;
			}
		}
		return null;
	}
}
