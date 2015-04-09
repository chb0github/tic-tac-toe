package org.bongiorno.algorithms.graph;

import java.util.Map;

/**
 * @author chribong
 */
public interface Edge {

    public Map<String,Object> getProperties();

    public Object getProperty(String name);

    public Edge addProperty(String name, Object value);

    public Vertex getInVertex();

    public Vertex getOutVertex();
}
