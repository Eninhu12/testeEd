package br.com.enio.testeEd.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.enio.testeEd.domain.Cliente;
import br.com.enio.testeEd.domain.ItemPedido;
import br.com.enio.testeEd.domain.Pedido;
import br.com.enio.testeEd.domain.Perfume;
import br.com.enio.testeEd.exeptions.NaoExisteException;
import br.com.enio.testeEd.model.AddProdutoModel;
import br.com.enio.testeEd.repository.PedidoRepository;
import br.com.enio.testeEd.service.ClienteService;
import br.com.enio.testeEd.service.PedidoService;
import br.com.enio.testeEd.service.PerfumeService;

@Service
public class PedidoServiceImpl implements PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private PerfumeService perfumeService;
	
	@Override
	public Pedido cadastrar(final Long idCliente) {
		Cliente cliente = clienteService.consultar(idCliente);
		Pedido pedido = new Pedido(cliente);
		return pedidoRepository.salvar(pedido);
	}

	@Override
	public List<Pedido> listar() {
		return pedidoRepository.listar();
	}

	@Override
	public Pedido adicionar(AddProdutoModel model) {
		Perfume perfume = perfumeService.consultar(model.getIdProduto());
		Pedido pedido = pedidoRepository.consultar(model.getIdPedido());
		pedido.addPerfume(perfume, model.getQtd());
		return pedido;
	}

	@Override
	public Pedido retirar(Long idItemPedido) {
		List<Pedido> pedidos = this.listar();
		for (Pedido pedido : pedidos) {
			for (ItemPedido itemPedido : pedido.getItens()) {
				if (itemPedido.getId().equals(idItemPedido)) {
					pedido.removeItemPedido(itemPedido);
					return pedido;
				}
			}
		}
		throw new NaoExisteException(idItemPedido);
	}

	@Override
	public Pedido pagar(Long id) {
		Pedido pedido = pedidoRepository.consultar(id);
		pedido.realizarPagamento();
		return pedido;
	}

	@Override
	public Pedido excluir(Long id) {
		Pedido pedido = pedidoRepository.consultar(id);
		pedidoRepository.apagar(pedido);
		return pedido;
	}
}
