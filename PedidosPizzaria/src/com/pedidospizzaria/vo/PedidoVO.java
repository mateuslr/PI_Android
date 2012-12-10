package com.pedidospizzaria.vo;

public class PedidoVO {
	private Integer id;
	private Integer mesa;
	private PizzaVO pizza;
	private BebidaVO bebida;
	
	public PedidoVO() {
		
	}
	
	public PedidoVO(Integer id, Integer mesa, PizzaVO pizza, BebidaVO bebida) {
		super();
		this.id = id;
		this.mesa = mesa;
		this.pizza = pizza;
		this.bebida = bebida;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getMesa() {
		return mesa;
	}
	public void setMesa(Integer mesa) {
		this.mesa = mesa;
	}
	public PizzaVO getPizza() {
		return pizza;
	}
	public void setPizza(PizzaVO pizza) {
		this.pizza = pizza;
	}
	public BebidaVO getBebida() {
		return bebida;
	}
	public void setBebida(BebidaVO bebida) {
		this.bebida = bebida;
	}
	
}
