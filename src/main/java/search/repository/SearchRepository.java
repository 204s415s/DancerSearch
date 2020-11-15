package search.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import search.entity.Search;

public interface SearchRepository extends
    JpaRepository<Search, Long>, JpaSpecificationExecutor<Search> {
	
}