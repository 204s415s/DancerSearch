package search.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import search.entity.Studio;

public interface StudioRepository extends JpaRepository<Studio, String>{

}
