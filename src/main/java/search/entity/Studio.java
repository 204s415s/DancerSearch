package search.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="studio")
public class Studio implements Serializable{
	
	@Id
	@Column(name="studio_id")
	private int studioId;
	@OneToMany(mappedBy="studio")
	private List<Search> search;
	public int getStudioId() {
		return studioId;
	}
	public void setStudioId(int studioId) {
		this.studioId = studioId;
	}
	
	@Column(name="studio")
	private String studio;
	public String getStudio() {
		return studio;
	}
	public void setStudio(String studio) {
		this.studio = studio;
	}
	
	public List<Search> getSearch() {
		return search;
	}
	public void setSearch(List<Search> search) {
		this.search = search;
	}

}
