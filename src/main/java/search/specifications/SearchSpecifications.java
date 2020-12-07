package search.specifications;

import java.math.BigDecimal;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import search.entity.Search;

//Create search criteria
public class SearchSpecifications {
	
	public static Specification<Search> dancerContains(String dancer) {
        return StringUtils.isEmpty(dancer) ? null : new Specification<Search>() {
            @Override
            public Predicate toPredicate(Root<Search> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                return cb.like(root.get("dancer"), "%" + dancer + "%");
            }
        };
    }
	
	public static Specification<Search> teamContains(String team) {
        return StringUtils.isEmpty(team) ? null : new Specification<Search>() {
            @Override
            public Predicate toPredicate(Root<Search> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                return cb.like(root.get("team"), "%" + team + "%");
            }
        };
    }
	
	public static Specification<Search> studioContains(String studio) {
        return StringUtils.isEmpty(studio) ? null : new Specification<Search>() {
            @Override
            public Predicate toPredicate(Root<Search> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                return cb.equal(root.join("studio", JoinType.LEFT).get("studio"), studio);
            }
        };
    }
	
	//I wanted to allow multiple selections, but I couldn't write well
	public static Specification<Search> weekContains(String week) {
        return StringUtils.isEmpty(week) ? null : new Specification<Search>() {
            @Override
            public Predicate toPredicate(Root<Search> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                return cb.equal(root.join("week", JoinType.LEFT).get("week"), week);
            }
        };
    }
	
	public static Specification<Search> startGreaterThanEqual(BigDecimal startFrom) {
        return StringUtils.isEmpty(startFrom) ? null : new Specification<Search>() {
            @Override
            public Predicate toPredicate(Root<Search> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                return cb.greaterThanOrEqualTo(root.get("start"), startFrom);
            }
        };
    }
	
	public static Specification<Search> startLessThanEqual(BigDecimal startTo) {
        return StringUtils.isEmpty(startTo) ? null : new Specification<Search>() {
            @Override
            public Predicate toPredicate(Root<Search> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                return cb.lessThanOrEqualTo(root.get("start"), startTo);
            }
        };
    }
	
	public static Specification<Search> closeGreaterThanEqual(BigDecimal closeFrom) {
        return StringUtils.isEmpty(closeFrom) ? null : new Specification<Search>() {
            @Override
            public Predicate toPredicate(Root<Search> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                return cb.greaterThanOrEqualTo(root.get("close"), closeFrom);
            }
        };
    }
	
	public static Specification<Search> closeLessThanEqual(BigDecimal closeTo) {
        return StringUtils.isEmpty(closeTo) ? null : new Specification<Search>() {
            @Override
            public Predicate toPredicate(Root<Search> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                return cb.lessThanOrEqualTo(root.get("close"), closeTo);
            }
        };
    }
	
	public static Specification<Search> levelContains(String level) {
        return StringUtils.isEmpty(level) ? null : new Specification<Search>() {
            @Override
            public Predicate toPredicate(Root<Search> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                return cb.like(root.get("level"), "%" + level + "%");
            }
        };
    }
}
