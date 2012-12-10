package com.pedidospizzaria.vo;

public class BebidaVO {
	private Integer id;
	private String nome;
	private String desc;
	
	public BebidaVO() {
		
	}
	
	public BebidaVO(Integer id, String nome, String desc) {
		super();
		this.id = id;
		this.nome = nome;
		this.desc = desc;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
}
