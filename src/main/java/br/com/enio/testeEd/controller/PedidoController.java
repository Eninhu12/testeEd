package br.com.enio.testeEd.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.enio.testeEd.domain.Pedido;
import br.com.enio.testeEd.model.AddProdutoModel;
import br.com.enio.testeEd.model.PedidoModel;
import br.com.enio.testeEd.service.PedidoService;

@RestController
@RequestMapping("/pedido")
public class PedidoController {
	@Autowired
	private PedidoService pedidoService;
	
    @PostMapping("/cadastrar/{idCliente}")
    public PedidoModel cadastrar(@PathVariable Long idCliente) {
    	Pedido pedido = pedidoService.cadastrar(idCliente);
        return new PedidoModel(pedido);
    }

    @PutMapping("/adicionar")
    public PedidoModel adicionar(@RequestBody AddProdutoModel model) {
    	Pedido pedido = pedidoService.adicionar(model);
    	return new PedidoModel(pedido);
    }

    @PutMapping("/retirar/{idItemPedido}")
    public PedidoModel retirar(@PathVariable Long idItemPedido) {
    	Pedido pedido = pedidoService.retirar(idItemPedido);
    	return new PedidoModel(pedido);
    }

    @GetMapping("/listar")
    public List<PedidoModel> listar() {
    	
    	List<Pedido> listaPedido = pedidoService.listar();
    	List<PedidoModel> models = new ArrayList<>();
    	for (Pedido pedido : listaPedido) {
    		models.add(new PedidoModel(pedido));
		}
    	return models;
    }

    @PutMapping("/pagar/{id}")
    public PedidoModel pagar(@PathVariable Long id) {
    	Pedido pedido = pedidoService.pagar(id);
        return new PedidoModel(pedido);
    }

    @DeleteMapping("/excluir/{id}")
    public PedidoModel excluir(@PathVariable Long id) {
    	Pedido pedido = pedidoService.excluir(id);
        return new PedidoModel(pedido);
    }
}
