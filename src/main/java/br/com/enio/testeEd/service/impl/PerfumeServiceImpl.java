package br.com.enio.testeEd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.enio.testeEd.domain.Perfume;
import br.com.enio.testeEd.exeptions.NaoExisteException;
import br.com.enio.testeEd.model.PerfumeModel;
import br.com.enio.testeEd.repository.PerfumeRepository;
import br.com.enio.testeEd.service.PerfumeService;


@Service
public class PerfumeServiceImpl implements PerfumeService {

	@Autowired
	private PerfumeRepository perfumeRepository;
	
	@Override
	public Perfume cadastrar(final PerfumeModel model) {
		return perfumeRepository.cadastrar(new Perfume(model.getNome(), model.getValor(), model.getTipo()));
	}

	@Override
	public Perfume alterar(final Long id, final PerfumeModel model) {
		Perfume p = this.consultar(id);
		p.alterar(model.getNome(), model.getValor(), model.getTipo());
		return p;
	}

	@Override
	public Perfume apagar(final Long id) {
		return this.perfumeRepository.apagar(this.consultar(id));
	}

	@Override
	public List<Perfume> listar() {
		return this.perfumeRepository.listar();
	}

	@Override
	public Perfume consultar(final Long id) {
		return this.perfumeRepository.consultar(id)
				.orElseThrow(() -> new NaoExisteException(id));
	}

}
