package br.com.enio.testeEd.domain;

import java.math.BigDecimal;

import br.com.enio.testeEd.model.PerfumeModel;
import lombok.Getter;

@Getter
public class ItemPedido {

	private static long gerador = 0;
	private Integer qtd;
	private PerfumeModel perfume;
	private BigDecimal total;
	private Long id;
	
}