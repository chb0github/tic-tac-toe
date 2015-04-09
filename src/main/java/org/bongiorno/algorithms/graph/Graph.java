package org.bongiorno.algorithms.graph;

import java.util.LinkedHashSet;
import java.util.Map;
import java.util.function.Predicate;

/**
 * @author chribong
 */
public interface Graph {


    public Vertex addVertex(String edgeName,Vertex v);

    public Vertex addVertex(Vertex v);

    public Vertex addIsolatedVertex(Vertex v);

    public LinkedHashSet<Graph> findPath(Predicate<Vertex> p);

    public LinkedHashSet<Graph> findPath(Vertex v);

    Map<String, Object> getProperties();

    public Graph addProperty(String name, Object value);

    public Object getProperty(String name);

}
