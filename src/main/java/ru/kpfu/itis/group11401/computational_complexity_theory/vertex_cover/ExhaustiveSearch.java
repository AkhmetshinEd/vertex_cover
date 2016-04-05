package ru.kpfu.itis.group11401.computational_complexity_theory.vertex_cover;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ExhaustiveSearch {
    public static List<Set<Integer>> process(int[][] adjacencyMatrix) {
        List<Set<Integer>> res = new ArrayList<>();
        int lastSetCode = (int) Math.pow(2, adjacencyMatrix.length);
        for (int setCode = 1; setCode < lastSetCode; setCode++) {
            BitSet set = convert(setCode);
            boolean covers = true;
            for (int i = 0; covers && i < adjacencyMatrix.length; i++) {
                if (!set.get(i)) {
                    for (int j = 0; j <= i; j++) {
                        if (!set.get(j) && (adjacencyMatrix[i][j] > 0)) {
                            covers = false;
                            break;
                        }
                    }
                }
            }
            if (covers) {
                res.add(set.stream().boxed().collect(Collectors.toSet()));
            }
        }
        return res;
    }

    private static BitSet convert(int value) {
        BitSet res = new BitSet();
        int ind = 0;
        while (value > 0) {
            if (value % 2 != 0) {
                res.set(ind);
            }
            ind++;
            value >>>= 1;
        }
        return res;
    }
}
