package br.com.enio.testeEd.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.SplittableRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.enio.testeEd.domain.Cliente;
import br.com.enio.testeEd.exeptions.NaoExisteException;
import br.com.enio.testeEd.model.ClienteModel;
import br.com.enio.testeEd.repository.ClienteRepository;
import br.com.enio.testeEd.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Override
	public Cliente cadastrar(final ClienteModel model) {
		if (!this.validarCpf(model.getDocumento())) {
			throw new RuntimeException("Documento inválido");
		}
		return clienteRepository.cadastrar(new Cliente(model.getNome(), model.getDocumento()));
	}

	@Override
	public Cliente alterar(final Long id, final ClienteModel model) {
		if (!this.validarCpf(model.getDocumento())) {
			throw new RuntimeException("Documento inválido");
		}
		Cliente c = this.consultar(id);
		c.alterar(model.getNome(), model.getDocumento());
		return c;
	}

	@Override
	public Cliente apagar(final Long id) {
		return this.clienteRepository.apagar(this.consultar(id));
	}

	@Override
	public List<Cliente> listar() {
		return this.clienteRepository.listar();
	}

	@Override
	public Cliente consultar(final Long id) {
		Cliente c = clienteRepository.consultar(id);
		if (Objects.isNull(c)) {
			throw new NaoExisteException(id);
		}
		return c;
	}
	
	@Override
	public Boolean validarCpf(final String cpf) {
		if (Objects.isNull(cpf) || cpf.length() != 11) {
            return false;
        }
        String preDoc = cpf.substring(0, 9);
        String cpfValido = this.gerarCpf(preDoc);
        return cpf.equals(cpfValido);
	}

	@Override
	public String getNovoCpf() {
		SplittableRandom sr = new SplittableRandom();
        String preDoc = "";
        for (int i = 0; i < 9; i++) {
            preDoc = preDoc + sr.nextInt(0, 10);
        }
        return this.gerarCpf(preDoc);
	}
	
	private String gerarCpf(final String preDocumento) {

        String preDoc = preDocumento;
        char[] numeros = preDoc.toCharArray();
        Integer soma = 0;

        for (int i = numeros.length; i > 0; i--) {
            Integer num = Integer.valueOf(String.valueOf(numeros[i - 1]));
            soma += (num * i);
        }
        Integer dv1 = soma % 11;

        preDoc = preDoc + (dv1.equals(10) ? 0 : dv1);
        numeros = preDoc.toCharArray();
        soma = 0;

        for (int i = numeros.length - 1; i >= 0; i--) {
            Integer num = Integer.valueOf(String.valueOf(numeros[i]));
            soma += (num * i);
        }
        Integer dv2 = soma % 11;

        return preDoc + (dv2.equals(10) ? 0 : dv2);
    }
}
