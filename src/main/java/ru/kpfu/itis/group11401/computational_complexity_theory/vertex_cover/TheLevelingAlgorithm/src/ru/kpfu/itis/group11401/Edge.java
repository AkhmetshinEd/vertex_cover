package ru.kpfu.itis.group11401;/**
 * Created by 1 on 07.04.2016.
 */

public class Edge {
    public int u, v;

    public Edge(int u, int v) {
        this.u = u;
        this.v = v;
    }

    public boolean isIncident(int vertex) {
        return (this.u == vertex || this.v == vertex);
    }

    @Override
    public String toString() {
        return "Edge{" +
                "u=" + u +
                ", v=" + v +
                '}';
    }
}