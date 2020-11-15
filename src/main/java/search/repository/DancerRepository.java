package search.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import search.entity.Dancer;

public interface DancerRepository extends JpaRepository<Dancer, String>{

}
