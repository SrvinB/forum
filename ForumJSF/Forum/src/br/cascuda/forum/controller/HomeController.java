package br.cascuda.forum.controller;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.cascuda.forum.dao.UserServerDao;
import br.cascuda.forum.model.Email;
import br.cascuda.forum.model.Publicacao;
import br.cascuda.forum.model.UserServer;
import br.cascuda.forum.redirect.Redirect;
import br.cascuda.forum.util.Session;

@Named
@RequestScoped
public class HomeController extends Redirect {
	private UserServer connectUser = new UserServer();
	private List<Publicacao> publicacoes = new ArrayList<Publicacao>();

	public HomeController() {
		super();
		UserServerDao comando = new UserServerDao();
		getConnectUser().setEmail((Email) Session.getInstance().getAttribute("connect"));

		for (UserServer userServer : comando.registry()) {
			if (userServer.getEmail().getLogIn().equals(getConnectUser().getEmail().getLogIn())) {
				Session.getInstance().invalidateSession();
				Session.getInstance().setAttribute("connected", userServer);
			}
		}
	}

	public UserServer getConnectUser() {
		return connectUser;
	}

	public void setConnectUser(UserServer connectUser) {
		this.connectUser = connectUser;
	}
	
	

}
