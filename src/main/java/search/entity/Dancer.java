package search.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="dancer")
public class Dancer {
	
	@Id
	@Column(name="dancer_code")
	private String dancerCode;
	//Associate with search table in dancer_code column
	@OneToMany(mappedBy="dance")
	private List<Search> search;
	public String getDancerCode() {
		return dancerCode;
	}
	public void setDancerId(String dancerCode) {
		this.dancerCode = dancerCode;
	}
	
	@Column(name="name")
	private String name;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name="team")
	private String team;
	public String getTeam() {
		return team;
	}
	public void getTeam(String team) {
		this.team = team;
	}	
	
	@Column(name="movie")
	private String movie;
	public String getMovie() {
		return movie;
	}
	public void getMovie(String movie) {
		this.movie = movie;
	}	
}