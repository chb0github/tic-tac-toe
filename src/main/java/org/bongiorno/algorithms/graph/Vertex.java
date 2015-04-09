package org.bongiorno.algorithms.graph;

/**
 * @author chribong
 */
public interface Vertex {

    long getId();

    Vertex addVertex(String edgeName, Vertex v);

    Vertex walkTo(Vertex v);


    Vertex andThenRemove(Vertex v);

    Vertex andThenRemove(Edge e);

    Vertex addProperty(String name,Object value);

    Object getProperty(String name);


    Graph findPath(Vertex v);

    Vertex addVertex(Vertex v);
}
