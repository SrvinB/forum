package br.cascuda.forum.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.cascuda.forum.dao.LoginDao;
import br.cascuda.forum.model.Email;
import br.cascuda.forum.model.UserServer;
import br.cascuda.forum.redirect.Redirect;
import br.cascuda.forum.util.Session;
import br.cascuda.forum.util.Util;

@Named
@RequestScoped
public class LogInController extends Redirect{
	private Email access = new Email();
	
	private Boolean validation() {
		getAccess().setPassword(Util.encrypt(getAccess().getPassword()));//CRIPYTOGRAFA SENHA INFOMADA PARA VERIFICAÇÃO
		LoginDao buscar = new LoginDao();
		for (UserServer element: buscar.registry()) {
			if(element.getEmail().getLogIn().equals(getAccess().getLogIn())) {
				System.out.println("LOGIN VÁLIDO! ;)");
				if (element.getEmail().getPassword().equals(getAccess().getPassword())) {
					System.out.println("SENHA VÁLIDA");
					return true;
				}
			}
		}
		return false;
	}
	
	public void start() {
		if (validation()) {
			System.out.println("ACESSO LIBERADO");
			Session.getInstance().setAttribute("connect", getAccess());
			
			redirectHomeLog();
		} else {
			System.out.println("ACESSO NEGADO");
		}
	}
	
	public Email getAccess() {
		return access;
	}

	public void setAccess(Email access) {
		this.access = access;
	}
}
