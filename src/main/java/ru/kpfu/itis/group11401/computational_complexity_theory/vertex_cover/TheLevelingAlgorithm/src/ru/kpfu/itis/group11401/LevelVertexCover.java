package ru.kpfu.itis.group11401;

import java.util.ArrayList;

/**
 * Created by Astashev.
 */

public class LevelVertexCover {


    public static ArrayList<Integer> LevelAlgoritm(int[][] adjacencyMatrix) {
        long start = System.nanoTime();
        int kol = 0;
        ArrayList<Peek> forRemovePeak = new ArrayList<Peek>();
        ArrayList<Integer> sol = new ArrayList<Integer>();
        // создаем список верщин по матрице
        ArrayList<Peek> peeks = getPeek(adjacencyMatrix);
        // удаляем вершины у со степенью = 0
        int num = 0;
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
            }
        }
        for (Peek p :
                forRemovePeak) {
            peeks.remove(p);
        }
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
            //t(v) ← c · deg(v) находим наибольшую пропорционально-степенную функцию относительно w.  t(v) ← c · deg(v)
            // и вычисляем w'(v) = w(v) - t(v)
            for (Peek p : peeks) {
                p.setWeight(p.getWeight() - cMin * p.getDegree());
            }
            for (Peek p : peeks) {
                if (p == peekWithCmin) {
                    forRemovePeak.add(p);
                    sol.add(p.getI());
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
            for (Peek p :
                    forRemovePeak) {
                peeks.remove(p);
            }
            cMin = Integer.MAX_VALUE;
        }
        for (int  p : sol) {
      //      System.out.print(p + " ");
            kol++;
        }
      //  System.out.println();

        long end = System.nanoTime();

       // return end - start + "; " + kol;
        return sol;
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