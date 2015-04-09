package org.bongiorno.algorithms.graph;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
* @author chribong
*/
class DefaultEdge implements Edge {
    private Map<String,Object> properties = new HashMap<String, Object>();
    private Vertex in;
    private Vertex out;

    DefaultEdge(Vertex in, Vertex out) {
        this.in = in;
        this.out = out;
    }

    @Override
    public Vertex getInVertex() {
        return in;
    }

    @Override
    public Map<String, Object> getProperties() {
        return Collections.unmodifiableMap(properties);
    }

    @Override
    public Object getProperty(String name) {
        return properties.get(name);
    }

    @Override
    public Vertex getOutVertex() {
        return out;
    }

    @Override
    public Edge addProperty(String name, Object value) {
        properties.put(name,value);
        return this;
    }
}
