package com.parrisu.finals.entities;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Contestant {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private int rank;
	
	private int changes;
	
	private String name;
	
	@Column(name="league_number")
	private int leagueNumber;
	
	private String league;
	
	@Column(name="steam_name")
	private String steamName;
	
	@Column(name="xbox_name")
	private String xboxName;
	
	@Column(name="psn_name")
	private String psnName;
	
	private int cashouts;
	
	@OneToMany(mappedBy="contestant")
	private List<Change> manyChanges;

	
	public List<Change> getManyChanges() {
		return manyChanges;
	}


	public void setManyChanges(List<Change> manyChanges) {
		this.manyChanges = manyChanges;
	}


	public Contestant() {}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public int getChanges() {
		return changes;
	}

	public void setChanges(int changes) {
		this.changes = changes;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLeagueNumber() {
		return leagueNumber;
	}

	public void setLeagueNumber(int leagueNumber) {
		this.leagueNumber = leagueNumber;
	}

	public String getLeague() {
		return league;
	}

	public void setLeague(String league) {
		this.league = league;
	}

	public String getSteamName() {
		return steamName;
	}

	public void setSteamName(String steamName) {
		this.steamName = steamName;
	}

	public String getXboxName() {
		return xboxName;
	}

	public void setXboxName(String xboxName) {
		this.xboxName = xboxName;
	}

	public String getPsnName() {
		return psnName;
	}

	public void setPsnName(String psnName) {
		this.psnName = psnName;
	}

	public int getCashouts() {
		return cashouts;
	}

	public void setCashouts(int cashouts) {
		this.cashouts = cashouts;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contestant other = (Contestant) obj;
		return id == other.id;
	}


	@Override
	public String toString() {
		return "Contestant [id=" + id + ", rank=" + rank + ", changes=" + changes + ", name=" + name + ", leagueNumber="
				+ leagueNumber + ", league=" + league + ", steamName=" + steamName + ", xboxName=" + xboxName
				+ ", psnName=" + psnName + ", cashouts=" + cashouts + "]";
	}
	
	
	
	

}
