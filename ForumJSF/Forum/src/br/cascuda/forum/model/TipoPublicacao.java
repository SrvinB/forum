package br.cascuda.forum.model;

public enum TipoPublicacao {
	QUESTAO(1, "questão"), COMENTARIO(2, "comentario");
	
	private int value;
	private String comentario;
	
	private TipoPublicacao(int value, String comentario) {
		this.value = value;
		this.comentario = comentario;
	}
	
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	
	
}
