package search.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import search.entity.Week;

public interface WeekRepository extends JpaRepository<Week, String>{

}
