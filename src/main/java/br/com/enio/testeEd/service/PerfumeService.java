package br.com.enio.testeEd.service;

import java.util.List;

import br.com.enio.testeEd.domain.Perfume;
import br.com.enio.testeEd.model.PerfumeModel;

public interface PerfumeService {

	Perfume cadastrar(PerfumeModel model);
	Perfume alterar(Long id, PerfumeModel model);
	Perfume apagar(Long id);
	List<Perfume> listar();
	Perfume consultar(Long id);
}
