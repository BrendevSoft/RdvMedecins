package rdvmedecins.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFilter;

@Entity
@Table(name = "rv")
@JsonFilter("rvFilter")
public class Rv extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	/*
	 * Fields
	 * =========================================================================
	 */

	@Temporal(TemporalType.DATE)
	private Date jour;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "id_client", insertable = false, nullable=false ,updatable=true)
	private Client client;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "id_creneau", insertable = false, nullable=false ,updatable=true)
	private Creneau creneau;

	/*
	 * constructors
	 * =========================================================================
	 */
	
	public Rv() {
	}

	public Rv(Date jour, Client client, Creneau creneau) {
		this.jour = jour;
		this.client = client;
		this.creneau = creneau;
	}


	/*
	 * getters et setters
	 * =========================================================================
	 */

	public Client getClient() {
		return client;
	}

	public Date getJour() {
		return jour;
	}

	public void setJour(Date jour) {
		this.jour = jour;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Creneau getCreneau() {
		return creneau;
	}

	public void setCreneau(Creneau creneau) {
		this.creneau = creneau;
	}

	/*
	 * Equals , hashCode, toString
	 * =========================================================================
	 */
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((client == null) ? 0 : client.hashCode());
		result = prime * result + ((creneau == null) ? 0 : creneau.hashCode());
		result = prime * result + ((jour == null) ? 0 : jour.hashCode());
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
		Rv other = (Rv) obj;
		if (client == null) {
			if (other.client != null)
				return false;
		} else if (!client.equals(other.client))
			return false;
		if (creneau == null) {
			if (other.creneau != null)
				return false;
		} else if (!creneau.equals(other.creneau))
			return false;
		if (jour == null) {
			if (other.jour != null)
				return false;
		} else if (!jour.equals(other.jour))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Rv [jour=" + jour + ", client=" + client + ", creneau=" + creneau + ", id=" + id + ", version="
				+ version + "]";
	}	

}