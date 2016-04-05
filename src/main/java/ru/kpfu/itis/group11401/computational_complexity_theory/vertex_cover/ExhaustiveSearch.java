package ru.kpfu.itis.group11401.computational_complexity_theory.vertex_cover;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ExhaustiveSearch {
    public static List<Set<Integer>> getCovers(int[][] adjacencyMatrix) {
        List<Set<Integer>> res = new ArrayList<>();
        int lastSetCode = (int) Math.pow(2, adjacencyMatrix.length);
        for (int setCode = 1; setCode < lastSetCode; setCode++) {
            BitSet set = convert(setCode);
            if (covers(set, adjacencyMatrix)) {
                res.add(set.stream().boxed().collect(Collectors.toSet()));
            }
        }
        return res;
    }

    private static boolean covers(BitSet set, int[][] adjacencyMatrix) {
        boolean res = true;
        for (int i = 0; res && i < adjacencyMatrix.length; i++) {
            if (!set.get(i)) {
                for (int j = 0; j <= i; j++) {
                    if (!set.get(j) && adjacencyMatrix[i][j] > 0) {
                        res = false;
                        break;
                    }
                }
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
