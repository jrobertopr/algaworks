package br.com.k19.jsf;

import java.util.HashMap;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@ManagedBean
public class AutenticadorBean {
	
	private static Map<String, String> mapa = new HashMap<String, String>();
	private String usuario;
	private String senha;
	
	// Acrescentando alguns usuários e suas respectivas senhas no atributo mapa
	static {
		AutenticadorBean.mapa.put("k19", "k19");
		AutenticadorBean.mapa.put("admin", "admin");
		AutenticadorBean.mapa.put("roberto.pereira", "admin123");
	}
	
	// método que verifica se os dados enviados pelo formulário de autenticação estão cadastrados no mapa
	public String autentica() {
		FacesContext fc = FacesContext.getCurrentInstance();
		
		if(AutenticadorBean.mapa.containsKey(this.usuario) && AutenticadorBean.mapa.get(this.usuario).equals(this.senha)) {
			
			ExternalContext ec = fc.getExternalContext();
			HttpSession session = (HttpSession)ec.getSession(false);
			session.setAttribute("usuario", this.usuario);
			
			return "/home";
		} else {
			FacesMessage fm = new FacesMessage("usuário e/ou senha inválidos");
			fm.setSeverity(FacesMessage.SEVERITY_ERROR);
			fc.addMessage(null, fm);
			return "/login";
		}
	}
	
	// método que registra saída do	usuário
	public String registraSaida() {
		FacesContext fc = FacesContext.getCurrentInstance();
		ExternalContext ec = fc.getExternalContext();
		HttpSession session = (HttpSession)ec.getSession(false);
		session.removeAttribute("usuario");
		
		return "/login";
	}
	
	// GETTERS E SETTERS

	public static Map<String, String> getMapa() {
		return mapa;
	}

	public static void setMapa(Map<String, String> mapa) {
		AutenticadorBean.mapa = mapa;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	
}
