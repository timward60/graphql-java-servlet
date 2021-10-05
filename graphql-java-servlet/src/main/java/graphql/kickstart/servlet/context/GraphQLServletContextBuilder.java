package graphql.kickstart.servlet.context;

import graphql.kickstart.execution.context.GraphQLContext;
import graphql.kickstart.execution.context.GraphQLContextBuilder;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;
import javax.websocket.server.HandshakeRequest;

public interface GraphQLServletContextBuilder extends GraphQLContextBuilder {

  GraphQLContext build(
      HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse);

  GraphQLContext build(Session session, HandshakeRequest handshakeRequest);

  default Map<Object, Object> buildGraphQLContext(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
    GraphQLContext context = build(httpServletRequest, httpServletResponse);
    Map<Object, Object> graphQLContext = new HashMap<>();
    graphQLContext.put(GraphQLContext.class, context);
    return graphQLContext;
  }

  default Map<Object, Object> buildGraphQLContext(Session session, HandshakeRequest handshakeRequest) {
    GraphQLContext context = build(session, handshakeRequest);
    Map<Object, Object> graphQLContext = new HashMap<>();
    graphQLContext.put(GraphQLContext.class, context);
    return graphQLContext;
  }
}
