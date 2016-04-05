package ru.kpfu.itis.group11401.computational_complexity_theory.vertex_cover;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ApproxVertexCover {
    public static List<Integer> search(List<Edge> edges) {
        List<Integer> res = new LinkedList<>();

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
