package br.cascuda.forum.controller;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.cascuda.forum.model.Publicacao;
import br.cascuda.forum.util.Session;

@Named
@ViewScoped
public class ComentarioControler {
	public Publicacao publicacao = new Publicacao();
	
	public void salvarComentario() {
		Session.getInstance().setAttribute("comentario", publicacao.getDescricao());
	}

	public Publicacao getPublicacao() {
		return publicacao;
	}

	public void setPublicacao(Publicacao publicacao) {
		this.publicacao = publicacao;
	}

}
