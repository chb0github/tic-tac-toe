package org.bongiorno.algorithms.graph;

import java.util.*;
import java.util.function.Predicate;

/**
 * @author chribong
 */
public class DefaultGraph implements Graph {
    private Map<String,Object> properties = new HashMap<String, Object>();

    @Override
    public Vertex addIsolatedVertex(Vertex v) {
        return null;
    }

    @Override
    public Vertex addVertex(String edgeName, Vertex v) {
        return null;
    }

    @Override
    public Vertex addVertex(Vertex v) {
        return null;
    }

    @Override
    public LinkedHashSet<Graph> findPath(Vertex destination) {
        return null;
    }

    @Override
    public Map<String, Object> getProperties() {
        return Collections.unmodifiableMap(properties);
    }

    @Override
    public Graph addProperty(String name, Object value) {
        properties.put(name,value);
        return this;
    }

    @Override
    public Object getProperty(String name) {
        return properties.get(name);
    }

    @Override
    public LinkedHashSet<Graph> findPath(Predicate<Vertex> p) {
        return null;
    }
}
