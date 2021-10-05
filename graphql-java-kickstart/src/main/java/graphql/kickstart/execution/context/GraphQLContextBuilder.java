package graphql.kickstart.execution.context;

import java.util.HashMap;
import java.util.Map;

public interface GraphQLContextBuilder {

  /** @return the graphql context */
  GraphQLContext build();

  default Map<Object, Object> build(GraphQLContext context) {
    Map<Object, Object> graphqlContext = new HashMap<>();
    graphqlContext.put(GraphQLContext.class, context);
    return graphqlContext;
  }
}
