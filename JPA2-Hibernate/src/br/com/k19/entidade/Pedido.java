package br.com.k19.entidade;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Pedido {
	@Id
	@GeneratedValue
	private Long id;
	@Temporal(TemporalType.DATE)
	private Calendar dataDoPedido;
	
	@ManyToOne // Relacionamento entre entidades (MUITOS pedidos PARA UM cliente)

	@JoinColumn(name="cliente_id")
	private Cliente cliente;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Calendar getDataDoPedido() {
		return dataDoPedido;
	}
	public void setDataDoPedido(Calendar dataDoPedido) {
		this.dataDoPedido = dataDoPedido;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Cliente getCliente() {
		return cliente;
	}
}
