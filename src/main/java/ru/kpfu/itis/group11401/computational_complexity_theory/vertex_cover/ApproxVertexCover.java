package ru.kpfu.itis.group11401.computational_complexity_theory.vertex_cover;

import java.util.*;

public class ApproxVertexCover {
    public static Set<Integer> getCover(List<Edge> edges) {
        Set<Integer> res = new HashSet<>();

        // Перемешиваем список ребер
        Collections.shuffle(edges);

        while (!edges.isEmpty()) {
            Edge edge = edges.remove(0);
            res.add(edge.u);
            res.add(edge.v);

            // Удаляем все ребра, инцидентные вершине u или v
            Iterator<Edge> i = edges.iterator();

            while (i.hasNext()) {
                edge = i.next();
                if (edge.isIncident(edge.u) || edge.isIncident(edge.v)) {
                    i.remove();
                }
            }
        }

        return res;
    }
}
