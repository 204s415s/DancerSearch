package search.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="week")
public class Week implements Serializable{
	
	@Id
	@Column(name="week_id")
	private int weekId;
	@OneToMany(mappedBy="week")
	private List<Search> search;
	public int getWeekId() {
		return weekId;
	}
	public void setweekId(int weekId) {
		this.weekId = weekId;
	}
	
	@Column(name="week")
	private String week;
	public String getWeek() {
		return week;
	}
	public void setWeek(String week) {
		this.week = week;
	}
	
	public List<Search> getSearch() {
		return search;
	}
	public void setSearch(List<Search> search) {
		this.search = search;
	}

}
