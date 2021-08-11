package br.com.enio.testeEd.repository;
import java.util.List;
import java.util.Optional;

import br.com.enio.testeEd.domain.Perfume;

public interface PerfumeRepository {
	
	Perfume cadastrar(Perfume domain);
	Perfume apagar(Perfume domain);
	List<Perfume> listar();
	Optional<Perfume> consultar(Long id);
}
