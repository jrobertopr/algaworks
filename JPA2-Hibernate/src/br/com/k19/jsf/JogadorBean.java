package br.com.k19.jsf;

import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;

import br.com.k19.entidade.Time;
import br.com.k19.entidade.Jogador;
import br.com.k19.servico.JogadorRepository;
import br.com.k19.servico.TimeRepository;

@ManagedBean
public class JogadorBean {
	
	private Jogador jogador = new Jogador();
	private Long timeID;
	private List<Jogador> jogadores;
	
	public void adiciona() {
		EntityManager manager = this.getManager();
		TimeRepository timeRepository = new TimeRepository(manager);
		JogadorRepository jogadorRepository = new JogadorRepository(manager);
		
		if(this.timeID != null) {
			Time time = timeRepository.procura(this.timeID);
			this.jogador.setTime(time);
		}
		
		if(this.jogador.getId() == null) {
			jogadorRepository.adiciona(this.jogador);
		} else {
			jogadorRepository.atualiza(this.jogador);
		}
		this.jogador = new Jogador();
		this.jogadores = null;
	}
	
	// sintax padrao
	public void preparaAlteracao() {
		Map<String, String> params = FacesContext.getCurrentInstance().
				getExternalContext().getRequestParameterMap();
		Long id = Long.parseLong(params.get("id"));
		EntityManager manager = this.getManager();
		JogadorRepository repository = new JogadorRepository(manager);
		this.jogador = repository.procura(id);
	}
	
	public void remove() {
		Map<String, String> params =
				FacesContext.getCurrentInstance().getExternalContext().
				getRequestParameterMap();
		Long id = Long.parseLong(params.get("id"));
		EntityManager manager = this.getManager();
		JogadorRepository repository = new JogadorRepository(manager);
		repository.remove(id);
		this.jogadores = null;
	}
	
	public List<Jogador> getJogadores() {
		if(this.jogadores == null) {
			EntityManager manager = this.getManager();
			JogadorRepository repository = new JogadorRepository(manager);
			this.jogadores = repository.getLista();
		}
		return this.jogadores;
	}
	
	// recuperando o EntityManager da requisicao
	private EntityManager getManager() {
		FacesContext fc = FacesContext.getCurrentInstance();
		ExternalContext ec = fc.getExternalContext();
		HttpServletRequest request = (HttpServletRequest) ec.getRequest();
		return (EntityManager) request.getAttribute("EntityManager");
	}

	// GETTERS E SETTERS
	
	public Jogador getJogador() {
		return jogador;
	}
	
	public void setJogador(Jogador jogador) {
		this.jogador = jogador;
	}
	
	public List<Jogador> getjogadores() {
		return jogadores;
	}
	
	public void setJogadores(List<Jogador> jogadores) {
		this.jogadores = jogadores;
	}

	public Long getTimeID() {
		return timeID;
	}

	public void setTimeID(Long timeID) {
		this.timeID = timeID;
	}
	

}
