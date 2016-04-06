package ru.kpfu.itis.group11401.computational_complexity_theory.vertex_cover;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ExhaustiveSearch {
    public static Set<Set<Integer>> getCovers(int[][] adjacencyMatrix) {
        return IntStream.range(1, (int) Math.pow(2, adjacencyMatrix.length))
                .mapToObj(ExhaustiveSearch::convert)
                .filter(set -> covers(set, adjacencyMatrix))
                .collect(Collectors.toSet());
    }

    public static void main(String[] args) {
        int[][] adjacencyMatrix = {
                {2, 1, 0, 0, 1, 0},
                {1, 0, 1, 0, 1, 0},
                {0, 1, 0, 1, 0, 0},
                {0, 0, 1, 0, 1, 1},
                {1, 1, 0, 1, 0, 0},
                {0, 0, 0, 1, 0, 0}
        };
        System.out.println(getCovers(adjacencyMatrix));
    }

    private static boolean covers(Set<Integer> set, int[][] adjacencyMatrix) {
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            if (!set.contains(i)) {
                for (int j = 0; j <= i; j++) {
                    if (!set.contains(j) && adjacencyMatrix[i][j] > 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private static Set<Integer> convert(int value) {
        Set<Integer> res = new HashSet<>();
        int ind = 0;
        while (value > 0) {
            if ((value & 1) != 0) {
                res.add(ind);
            }
            ind++;
            value >>>= 1;
        }
        return res;
    }
}
