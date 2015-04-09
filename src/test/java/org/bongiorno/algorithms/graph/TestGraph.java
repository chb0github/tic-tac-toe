package org.bongiorno.algorithms.graph;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedHashSet;

import static org.junit.Assert.assertEquals;

/**
 * @author chribong
 */
public class TestGraph {

    @Test
    public void testGraph() throws Exception {
        Graph g = new DefaultGraph();
        g.addVertex(new DefaultVertex())
                .walkTo(new DefaultVertex())
                .addVertex(new DefaultVertex())
                .addVertex(new DefaultVertex())
                .addVertex(new DefaultVertex())
                .walkTo(new DefaultVertex())
                    .addVertex(new DefaultVertex())
                    .addVertex(new DefaultVertex());
        LinkedHashSet<Graph> path = g.findPath(v -> v.getId() == 8);

    }

    @Test
    public void testGraphBasicProperties() throws Exception {
        Graph g = new DefaultGraph();
        g.addProperty("name","Christian")
                .addProperty("age", 38)
                .addProperty("groceries", Arrays.asList("Milk", "Eggs"));

        assertEquals("Christian",g.getProperty("name"));
        assertEquals(38,g.getProperty("age"));
        assertEquals(Arrays.asList("Milk", "Eggs"),g.getProperty("groceries"));
    }

    @Test
    public void testVertexProperties() throws Exception {
        Vertex v = new DefaultVertex();
        v.addProperty("name", "Christian")
                .addProperty("age", 38)
                .addProperty("groceries", Arrays.asList("Milk", "Eggs"));

        assertEquals("Christian", v.getProperty("name"));
        assertEquals(38, v.getProperty("age"));
        assertEquals(Arrays.asList("Milk", "Eggs"), v.getProperty("groceries"));
    }

    @Test
    public void testEdgeProperties() throws Exception {
        Vertex i = new DefaultVertex();
        Vertex o = new DefaultVertex();
        Edge v = new DefaultEdge(i,o);
        v.addProperty("name", "Christian")
                .addProperty("age", 38)
                .addProperty("groceries", Arrays.asList("Milk", "Eggs"));

        assertEquals("Christian", v.getProperty("name"));
        assertEquals(38, v.getProperty("age"));
        assertEquals(Arrays.asList("Milk", "Eggs"), v.getProperty("groceries"));

    }
}
