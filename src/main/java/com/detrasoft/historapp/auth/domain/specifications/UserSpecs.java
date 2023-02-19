package com.detrasoft.historapp.auth.domain.specifications;

import com.detrasoft.historapp.auth.domain.entities.User;
import com.detrasoft.historapp.auth.domain.filters.UserFilter;
import com.detrasoft.framework.crud.entities.Audit;
import org.springframework.data.jpa.domain.Specification;

import jakarta.persistence.criteria.Expression;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Predicate;
import java.util.ArrayList;

public class UserSpecs {

    public static Specification<User> withUserFilter(UserFilter filter) {
        return (root, query, builder) -> {

            Join<User, Audit> audit = root.join("audit");

            var predicates = new ArrayList<Predicate>();

            if (filter.getName() != null) {
                Expression<String> pricerExpression = builder.concat(
                        builder.concat(root.<String>get("firstName"), " "), root.<String>get("lastName"));
                predicates.add(builder.like(builder.upper(pricerExpression), "%" + filter.getName().toUpperCase() + "%"));
            }

            if (filter.getIdDetrasoft() != null && filter.getIdDetrasoft() > 0) {
                predicates.add(builder.equal(root.get("idDetrasoft"), filter.getIdDetrasoft()));
            }

            // Filter CreatedAt
            if (filter.getInitCreateAt() != null) {
                predicates.add(builder.greaterThanOrEqualTo(audit.get("createdAt"), filter.getInitCreateAt()));
            }
            if (filter.getFinalCreateAt() != null) {
                predicates.add(builder.lessThanOrEqualTo(audit.get("createdAt"),filter.getFinalCreateAt()));
            }

            // Filter UpdatedAt
            if (filter.getInitUpdatedAt() != null) {
                predicates.add(builder.greaterThanOrEqualTo(audit.get("updatedAt"), filter.getInitUpdatedAt()));
            }
            if (filter.getFinalUpdatedAt() != null) {
                predicates.add(builder.lessThanOrEqualTo(audit.get("updatedAt"),filter.getFinalUpdatedAt()));
            }

            if (filter.getEmail() != null) {
                predicates.add(builder.or(builder.like(root.get("email").as(String.class), "%" + filter.getEmail() + "%")));
            }

            return builder.and(predicates.toArray(new Predicate[0]));
        };
    }

}
