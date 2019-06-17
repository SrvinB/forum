package br.cascuda.forum.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.cascuda.forum.dao.UserServerDao;
import br.cascuda.forum.model.UserServer;
import br.cascuda.forum.redirect.Redirect;
import br.cascuda.forum.util.Session;

@Named
@ViewScoped
public class ConsultaController extends Redirect implements Serializable {

	private static final long serialVersionUID = -1905862185158065738L;
	UserServerDao comando = new UserServerDao();
	private List<UserServer> listaUsuario = null;
	private UserServer connectUser = new UserServer();
	private String quemBuscar; 

	public ConsultaController() {
		setConnectUser((UserServer)Session.getInstance().getAttribute("connected"));
	}
	public void edit(UserServer user) {
		Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
		flash.put("register", user);
		redirectPerfil();
	}

	public void delete(UserServer user) {
		comando.delete(user);
		setListaUsuario(getComando().registry());//ATUALIZA A LISTA EXIBIDA NO DATATABLE APÓS DELETAR USUARIO
	}

	public void pesquisar() {
		if (getQuemBuscar() != "") {
			setListaUsuario(getComando().takeUserByName(getQuemBuscar()));
		} else {
			setListaUsuario(getComando().registry());//BUSCA A LISTA DE USUARIOS ATUAL
		}
	}
	
	public void sair() {
		Session.getInstance().invalidateSession();
		redirectLogin();
	}
	
	public UserServerDao getComando() {
		return comando;
	}

	public void setComando(UserServerDao comando) {
		this.comando = comando;
	}

	public UserServer getConnectUser() {
		return connectUser;
	}

	public void setConnectUser(UserServer connectUser) {
		this.connectUser = connectUser;
	}

	public List<UserServer> getListaUsuario() {
		return listaUsuario;
	}

	public void setListaUsuario(List<UserServer> listaUsuario) {
		this.listaUsuario = listaUsuario;
	}

	public String getQuemBuscar() {
		return quemBuscar;
	}

	public void setQuemBuscar(String quemBuscar) {
		this.quemBuscar = quemBuscar;
	}
}
