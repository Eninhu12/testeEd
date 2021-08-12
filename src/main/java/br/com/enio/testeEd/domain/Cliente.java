package br.com.enio.testeEd.domain;

import lombok.Getter;

@Getter
public class Cliente {

	private static long gerador = 0;
	
	private Long id;
	private String nome;
    private String documento;

    public Cliente(String nome, String documento) {
    	this.id = ++gerador;
    	this.nome = nome;
        this.documento = documento;
    }
    
    public void alterar(String nome, String documento) {
    	this.nome = nome;
        this.documento = documento;
	}

    public String getDocumentoFormatado() {
        return this.getDocumento().replaceAll("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");
    }
}