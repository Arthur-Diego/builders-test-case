package com.builders.testcase.specification;

import com.builders.testcase.annotation.FieldEntity;
import com.builders.testcase.dto.ClientFieldRequestDTO;
import com.builders.testcase.model.Client;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static com.builders.testcase.utils.ReflectionSpecificationUtils.*;

public class ClientSpecification {

    public static Specification<Client> clientSpecification(ClientFieldRequestDTO dto) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new LinkedList<Predicate>();
            addPredicatesFields(dto, root, cb, predicates, null);
            return cb.and(predicates.toArray(new Predicate[predicates.size()]));
        };
    }

    private static <Y> void addPredicatesFields(Object dto, Root<Client> root, javax.persistence.criteria.CriteriaBuilder cb, List<Predicate> predicates, Path<Y> path) {
        Arrays.stream(dto.getClass().getDeclaredFields())
                .filter(f -> verifyIfFieldIsNull(dto, f))
                .forEach(f -> {
                    if (verifyIsEntityOrEmbbedable(f)) {
                        if (path == null) {
                            addPredicatesFields(getFieldValue(dto, f), root, cb, predicates, root.get(f.getName()));
                        } else {
                            addPredicatesFields(getFieldValue(dto, f), root, cb, predicates, path.get(f.getName()));
                        }
                    } else if (!f.isAnnotationPresent(FieldEntity.class) && path != null) {
                        if (verifyIsString(f)) {
                            predicates.add(cb.equal(path.get(f.getName()), getFieldValue(dto, f)));
                        } else {
                            predicates.add(cb.like(path.get(f.getName()), likeAll(getFieldValue(dto, f).toString())));
                        }
                    } else {
                        if (verifyIsString(f)) {
                            predicates.add(cb.equal(root.get(f.getName()), getFieldValue(dto, f)));
                        } else {
                            predicates.add(cb.like(root.get(f.getName()), likeAll(getFieldValue(dto, f).toString())));
                        }
                    }
                });
    }
}
