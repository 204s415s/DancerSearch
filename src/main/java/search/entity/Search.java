package search.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import search.entity.Dancer;


@Entity
@Table(name="search")
public class Search {
	
	//I was considering using Lombok due to the lengthy code, but it didn't work.
	@Id
	@Column(name="id")
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name="dancer_code")
	private String dancerCode;
	//Associate with dancer table in dancer_code column
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="dancer_code", insertable = false, updatable = false )
	private Dancer dance;
	public String getDancerCode() {
		return dancerCode;
	}
	public void setDancerCode(String dancerCode) {
		this.dancerCode = dancerCode;
	}
	public Dancer getDance() {
		return dance;
	}
	public void setDance(Dancer dance) {
		this.dance = dance;		
	}
	
	@Column(name="dancer")
	private String dancer;
	public String getDancer() {
		return dancer ;
	}
	public void setDancer(String dancer) {
		this.dancer = dancer;
	}
	
	@Column(name="team")
	private String team;
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	
	@Column(name="studio")
	private String studio;
	public String getStudio() {
		return studio;
	}
	public void setStudio(String studio) {
		this.studio = studio;
	}
	
	@Column(name="week")
	private String week;
	public String getWeek() {
		return week;
	}
	public void setWeek(String week) {
		this.week = week;
	}
	
	@Column(name="start")
	private BigDecimal start;
	public BigDecimal getStart() {
		return start;
	}
	public void setStart(BigDecimal start) {
		this.start = start;
	}
	
	@Column(name="close")
	private BigDecimal close;
	public BigDecimal getClose() {
		return close;
	}
	
	public void setClose(BigDecimal close) {
		this.close = close;
	}
			
	@Column(name="level")
	private String level;
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	
	@Column(name="link")
	private String link;
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}

}
