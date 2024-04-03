package com.parrisu.finals.entities;

import java.time.LocalDateTime;
import java.util.Objects;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "rank_changes")
public class Change {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private int rank;
	
	private int change;
	
	@Column(name = "date_changed")
	@CreationTimestamp
	private LocalDateTime dateChanged;
	
	@ManyToOne
	@JoinColumn(name="contestant_id")
	private Contestant contestant;
	
	
	
	public LocalDateTime getDateChanged() {
		return dateChanged;
	}

	public void setDateChanged(LocalDateTime dateChanged) {
		this.dateChanged = dateChanged;
	}

	public Contestant getContestant() {
		return contestant;
	}

	public void setContestant(Contestant contestant) {
		this.contestant = contestant;
	}

	public Change () {}

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

	public int getChange() {
		return change;
	}

	public void setChange(int change) {
		this.change = change;
	}

	public LocalDateTime getUpdate_date() {
		return dateChanged;
	}

	public void setUpdate_date(LocalDateTime update_date) {
		this.dateChanged = update_date;
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
		Change other = (Change) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Change [id=" + id + ", rank=" + rank + ", change=" + change + ", dateChanged=" + dateChanged
				+ ", contestant=" + contestant + "]";
	}
	
	
	
	

}
