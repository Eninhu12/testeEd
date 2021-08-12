package br.com.enio.testeEd.model;

import br.com.enio.testeEd.domain.Cliente;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ClienteModel {
	
	private Long id;
	private String nome;
    private String documento;
    
    public ClienteModel(final Cliente domain) {
    	this.id = domain.getId();
    	this.nome = domain.getNome();
    	this.documento = domain.getDocumento();
    }
}