package ru.kpfu.itis.group11401;

import java.util.ArrayList;

/**
 * Created by 1 on 07.04.2016.
 */

public class LevelVertexCover {

    static int[][] adjacencyMatrix = {
            //1  2  3  4  5  6  7
            /* 1 */    {0, 1, 0, 1, 0, 0, 0},
            /* 2 */    {1, 0, 1, 1, 0, 0, 0},
            /* 3 */    {0, 1, 0, 1, 1, 1, 0},
            /* 4 */    {1, 1, 1, 0, 1, 0, 0},
            /* 5 */    {0, 0, 1, 1, 0, 0, 1},
            /* 6 */    {0, 0, 1, 0, 0, 0, 0},
            /* 7 */    {0, 0, 0, 0, 1, 0, 0},
    };

    public static void main(String[] args) {
        ArrayList<Peek> forRemovePeak = new ArrayList<Peek>();
        String sol = "";
        // создаем список верщин по матрице
        ArrayList<Peek> peeks = getPeek(adjacencyMatrix);
        // Peek[] peeksMas = getPeekMas(adjacencyMatrix);
        // удаляем вершины у со степенью = 0
        int num = 0;
        System.out.println("**peeks**");
        for (Peek p : peeks) {
            if (p.getDegree() == 0) {
                forRemovePeak.add(p);
                continue;
            } else {
                for (int i = num; i < adjacencyMatrix.length; i++) {
                    if (adjacencyMatrix[i][i] == 1) {
                        adjacencyMatrix[i][i] = 0;
                    }
                }
                System.out.println(p);
            }
        }
        for (Peek p :
                forRemovePeak) {
            peeks.remove(p);
        }
        System.out.println("**peeks**");
        System.out.println();
        System.out.println();
        while (!peeks.isEmpty()) {
            double cMin = Integer.MAX_VALUE;
            double c = 0;
            Peek peekWithCmin = null;
            //вычсляем С = min{w(v)/deg(v)}
            for (Peek p : peeks) {
                c = p.getWeight() / p.getDegree();
                if (c < cMin) {
                    cMin = c;
                    peekWithCmin = p;
                }
            }
            System.out.println(cMin + " - c min  - " + peekWithCmin);
            //t(v) ← c · deg(v) находим наибольшую пропорционально-степенную функцию относительно w.  t(v) ← c · deg(v)
            // и вычисляем w'(v) = w(v) - t(v)
            for (Peek p : peeks) {
                p.setWeight(p.getWeight() - cMin * p.getDegree());
                System.out.println(p);
            }
            for (Peek p : peeks) {
                if (p == peekWithCmin) {
                    System.out.println(p + " to delete");
                    forRemovePeak.add(p);
                    sol += p.getI() + " ";
                    continue;
                }
            }
            //вычисляем вершины у которых должна уменьшится степень после удаления вершин с максимальной степенью
            for (Peek p : peeks) {
                if (adjacencyMatrix[p.getI() - 1][peekWithCmin.getI() - 1] == 1) {
                    p.setDegree(p.getDegree() - 1);
                    if (p.getDegree() == 0 || p.getWeight() == 0) {
                        forRemovePeak.add(p);

                    }
                }
            }
            System.out.println();
            for (Peek p :
                    forRemovePeak) {
                peeks.remove(p);
            }
            System.out.println(sol);
            System.out.println();
            cMin = Integer.MAX_VALUE;
        }
        System.out.println(sol);
    }

    public static ArrayList<Peek> getPeek(int[][] adjacencyMatrix) {
        ArrayList<Peek> peeks = new ArrayList<>();
        Peek[] masPeek = new Peek[adjacencyMatrix.length];
        int number = 0;
        for (int i = 0; i < adjacencyMatrix.length; i++) {

            number++;
            //System.out.println(number);
            int degree = 0;
            for (int j = 0; j < adjacencyMatrix.length; j++) {
                if (adjacencyMatrix[i][j] != 0 && adjacencyMatrix[i][j] != adjacencyMatrix[i][i]) {
                    degree++;
                }
            }
            Peek peek = new Peek(number, degree, 1);
            peeks.add(peek);
        }
        return peeks;
    }
}