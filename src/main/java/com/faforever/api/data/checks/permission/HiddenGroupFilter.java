package com.faforever.api.data.checks.permission;

import com.faforever.api.data.domain.UserGroup;
import com.yahoo.elide.core.Path.PathElement;
import com.yahoo.elide.core.filter.FilterPredicate;
import com.yahoo.elide.core.filter.Operator;
import com.yahoo.elide.core.filter.expression.FilterExpression;
import com.yahoo.elide.security.FilterExpressionCheck;
import com.yahoo.elide.security.RequestScope;

import java.util.Collections;

public class HiddenGroupFilter extends FilterExpressionCheck<UserGroup> {
  public static final String EXPRESSION = "restrict to public groups only";

  @Override
  public FilterExpression getFilterExpression(Class<?> entityClass, RequestScope requestScope) {
    return new FilterPredicate(
      new PathElement(UserGroup.class, Boolean.class, "publicGroup"),
      Operator.IN, Collections.singletonList(Boolean.TRUE));
  }
}
