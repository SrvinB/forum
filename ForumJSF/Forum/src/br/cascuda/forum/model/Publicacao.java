package br.cascuda.forum.model;

import java.time.LocalDate;

public class Publicacao {
	private String descricao;
	private LocalDate quandoPublicado;
	private TipoPublicacao tipo;
	
	public TipoPublicacao getTipo() {
		return tipo;
	}
	public void setTipo(TipoPublicacao tipo) {
		this.tipo = tipo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public LocalDate getQuandoPublicado() {
		return quandoPublicado;
	}
	public void setQuandoPublicado(LocalDate quandoPublicado) {
		this.quandoPublicado = quandoPublicado;
	}
	
	
}
