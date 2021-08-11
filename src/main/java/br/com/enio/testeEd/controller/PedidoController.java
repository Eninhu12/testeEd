package br.com.enio.testeEd.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.enio.testeEd.model.AddProdutoModel;
import br.com.enio.testeEd.model.PedidoModel;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    @PostMapping("/cadastrar")
    public PedidoModel cadastrar() {
        return null;
    }

    @PutMapping("/adicionar")
    public PedidoModel adicionar(@RequestBody AddProdutoModel model) {
        return null;
    }

    @PutMapping("/retirar/{id}")
    public PedidoModel retirar(@PathVariable Long id) {
    	return null;
    }

    @GetMapping("/listar")
    public List<PedidoModel> listar() {
    	return null;
    }

    @PutMapping("/pagar/{id}")
    public PedidoModel pagar(@PathVariable Long id) {
    	return null;
    }

    @DeleteMapping("/excluir/{id}")
    public PedidoModel excluir(@PathVariable Long id) {
    	return null;
    }
}
