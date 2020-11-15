package search.specifications;

import java.math.BigDecimal;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import search.entity.Search;

//検索条件を作成
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
                return cb.like(root.get("studio"), "%" + studio + "%");
            }
        };
    }
	
	//複数選択を可能にしたかったのだが、うまく書くことができなかった
	public static Specification<Search> weekContains(String week) {
        return StringUtils.isEmpty(week) ? null : new Specification<Search>() {
            @Override
            public Predicate toPredicate(Root<Search> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                return cb.like(root.get("week"), "%" + week + "%");
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
