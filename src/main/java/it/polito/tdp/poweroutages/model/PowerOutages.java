package it.polito.tdp.poweroutages.model;
import java.time.*;

public class PowerOutages {
	private Integer id;
	private Nerc nerc;
	private LocalDate inizio;
	private LocalDate fine;
	private Integer personeCoinvolte;
	private Integer oreDurata;


	public PowerOutages(Integer id, LocalDate inizio, LocalDate fine, Integer personeCoinvolte, Integer oreDurata) {
		super();
		this.id = id;
		this.nerc = nerc;
		this.inizio = inizio;
		this.fine = fine;
		this.personeCoinvolte = personeCoinvolte;
		this.oreDurata = oreDurata;
	}
	

	public Integer getId() {
		return id;
	}

	public Nerc getNerc() {
		return nerc;
	}

	public LocalDate getInizio() {
		return inizio;
	}

	public LocalDate getFine() {
		return fine;
	}

	public Integer getPersoneCoinvolte() {
		return personeCoinvolte;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PowerOutages other = (PowerOutages) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "PowerOutages [id=" + id + ", nerc=" + nerc + ", inizio=" + inizio + ", fine=" + fine
				+ ", personeCoinvolte=" + personeCoinvolte + ", oreDurata=" + oreDurata + "]";
	}


	public Integer getOreDurata() {
		return oreDurata;
	}


	
	
	
	
	
}
