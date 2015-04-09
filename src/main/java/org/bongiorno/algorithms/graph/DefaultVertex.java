package org.bongiorno.algorithms.graph;

import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
* @author chribong
*/
class DefaultVertex implements Vertex {

    private static long counter = 0;

    private long id = counter++;

    private Map<String,Object> properties;
    private Map<String, Edge> edges;

    @Override
    public Vertex addVertex(String edgeName, Vertex v) {
        Edge e = edges.get(edgeName);
        if(e == null) {
            e = new DefaultEdge(this,v);
            edges.put(edgeName,e);
        }
        return this;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public Vertex walkTo(Vertex v) {
        return addVertex("anonymous",v);
    }

    @Override
    public Vertex addProperty(String name, Object value) {
        properties.put(name,value);
        return this;
    }

    @Override
    public Vertex addVertex(Vertex v) {
        return addVertex("anonymous",v);
    }

    @Override
    public Object getProperty(String name) {
        return null;
    }


    @Override
    public Vertex andThenRemove(Vertex v) {
        return null;
    }

    @Override
    public Vertex andThenRemove(Edge e) {
        return null;
    }

    @Override
    public Graph findPath(Vertex v) {
        return null;
    }

    private LinkedHashSet dfs(LinkedHashSet<Vertex> visited, Vertex v) {

        if (!visited.contains(v)) {
            visited.add(v);
            for (Edge edge : edges.values()) {
                dfs(visited,v);
            }
        }
        return visited;
    }
}
