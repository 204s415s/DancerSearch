package search.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import search.entity.Dancer;
import search.entity.Studio;
import search.entity.Week;

@Entity
@Table(name="search")
public class Search implements Serializable {
	
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
	
	@Column(name="studio_id")
	private String studioId;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="studio_id", insertable = false, updatable = false )
	private Studio studio;
	public String getStudioId() {
		return studioId;
	}
	public void setStudioId(String studioId) {
		this.studioId = studioId;
	}
	
	public Studio getStudio() {
		return studio;
	}
	public void serStudio(Studio studio) {
		this.studio = studio;
	}
	
	@Column(name="week_id")
	private String weekId;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="week_id", insertable = false, updatable = false )
	private Week week;
	public String getWeekId() {
		return weekId;
	}
	public void setWeekId(String weekId) {
		this.weekId = weekId;
	}
	
	public Week getWeek() {
		return week;
	}
	public void serWeek(Week week) {
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
