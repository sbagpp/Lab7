package it.polito.tdp.poweroutages.model;

import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.poweroutages.DAO.PowerOutageDAO;

public class Model {
	
	private List<PowerOutages> soluzioneOttima;
	private PowerOutageDAO podao;
	private Integer maxP;
	private Integer hours;
	private List<PowerOutages> list;
	
	public Model() {
		podao = new PowerOutageDAO();
		this.soluzioneOttima = new ArrayList <>();
		this.hours = null;
		this.maxP = null;
		this.list =  new ArrayList <>();
	}
	
	public List<Nerc> getNercList() {
		return podao.getNercList();
	}

	public List<PowerOutages> getPowerOutages(Integer years, Integer hours, Nerc n) {
		this.hours = hours;
		this.list = this.podao.getPowerOutages(years, hours, n);
		
		return list;
	}

}
