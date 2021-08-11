package br.com.enio.testeEd.domain;

import lombok.Getter;

@Getter
public class Cliente {

	private static long gerador = 0;
	
	private Long id;
	private String nome;
	private String documento;
	private String sintoma;
}
