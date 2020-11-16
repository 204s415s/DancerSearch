package search.form;
import java.io.Serializable;
import java.math.BigDecimal;

//Keep search results
public class SearchForm implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String dancer ="";
	public String getDancer() {
		return dancer ;
	}
	public void setDancer(String dancer) {
		this.dancer = dancer;
	}
	
	private String team;
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	
	private String studio;
	public String getStudio() {
		return studio;
	}
	public void setStudio(String studio) {
		this.studio = studio;
	}
	
	private String week;
	public String getWeek() {
		return week;
	}
	public void setWeek(String week) {
		this.week = week;
	}
	
	private BigDecimal start;
	public BigDecimal getStart() {
		return start;
	}
	public void setStart(BigDecimal start) {
		this.start = start;
	}
	
	private BigDecimal close;
	public BigDecimal getClose() {
		return close;
	}
	public void setClose(BigDecimal close) {
		this.close = close;
	}
	
	private String level;
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}

}
