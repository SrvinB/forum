package br.cascuda.forum.redirect;

import br.cascuda.forum.util.Session;
import br.cascuda.forum.util.Util;

public class Redirect {

	public void redirectLogin() {
		Util.redirect("login.xhtml");
	}

	public void redirectSignUp() {
		Util.redirect("signUp.xhtml");
	}
	
	public void redirectMenuRoot() {
		Util.redirect("consulta.xhtml");
	}
	
	public void redirectHomeLog() {
		Util.redirect("home.xhtml");
	}
	
	public void redirectPerfil() {
		Util.redirect("perfil.xhtml");
	}
	
	public void redirectSair() {
		Session.getInstance().invalidateSession();
		Util.redirect("login.xhtml");
	}
	
	public void redirectPerfilConsulta() {
		Util.redirect("perfilConsulta.xhtml");
	}
	
	public void redirectQuemSomos() {
		Util.redirect("quemSomos.xhtml");
	}
	
	public void redirectFeedBack() {
		Util.redirect("feedBack.xhtml");
	}
	
	public void redirectComentarios() {
		Util.redirect("comentarios.xhrml");
	}
}
