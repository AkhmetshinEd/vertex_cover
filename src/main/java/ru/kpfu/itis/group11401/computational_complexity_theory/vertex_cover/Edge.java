package ru.kpfu.itis.group11401.computational_complexity_theory.vertex_cover;

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
