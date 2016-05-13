package ru.kpfu.itis.group11401;/**
 * Created by 1 on 17.04.2016.
 */

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DoTests {
    public static void main(String[] args) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\Inform\\terslozh\\output.txt"));
        /// куда будем сохранять результат
        ArrayList<Integer> out;
        for (int i = 1; i < 120; i++) {
            BufferedReader reader = new BufferedReader(new FileReader("D:\\Inform\\terslozh\\tests\\input" + i + ".txt"));


            String line;
            List<String> peeks;
            String[] mas;

            line = reader.readLine();
            mas = line.split(" ");
            int[][] adjacencyMatrix = new int[Integer.parseInt(mas[0])][Integer.parseInt(mas[0])];
            adjacencyMatrix[Integer.parseInt(mas[0]) - 1][Integer.parseInt(mas[1]) - 1] = 1;
            adjacencyMatrix[Integer.parseInt(mas[1]) - 1][Integer.parseInt(mas[0]) - 1] = 1;
            while ((line = reader.readLine()) != null) {
                mas = line.split(" ");
                adjacencyMatrix[Integer.parseInt(mas[0]) - 1][Integer.parseInt(mas[1]) - 1] = 1;
                adjacencyMatrix[Integer.parseInt(mas[1]) - 1][Integer.parseInt(mas[0]) - 1] = 1;
            }
           // out = i + "; "+ LevelVertexCover.LevelAlgoritm(adjacencyMatrix);
            out =  LevelVertexCover.LevelAlgoritm(adjacencyMatrix);
            writer.write(out + "\n");
        }
        writer.close();

    }

    public static int[][] makeMatrix(int kol, int i) throws IOException {

        return null;
    }

    public static int getKol(int i) throws IOException {
        String[] mas;
        List<String> peeks;
        int kol = 2;
        boolean boolmas0 = true;
        boolean boolmas1 = true;

        BufferedReader reader = new BufferedReader(new FileReader("D:\\Inform\\terslozh\\tests\\input" + i + ".txt"));
        String line;
        peeks = new ArrayList<String>();
        while ((line = reader.readLine()) != null) {
            mas = line.split(" ");
            if (peeks.isEmpty()) {
                peeks.add(mas[0]);
                peeks.add(mas[1]);
            }
            for (String j : peeks) {
                if (mas[0].equals(j)) {
                    boolmas0 = false;
                }
                if (mas[1].equals(j)) {
                    boolmas1 = false;
                }
            }
            if (boolmas0) {
                peeks.add(mas[0]);
                kol++;
            }
            if (boolmas1) {
                peeks.add(mas[1]);
                kol++;
            }
            boolmas0 = true;
            boolmas1 = true;
        }
        // System.out.println(kol);
        // System.out.println(peeks);

        int[][] adjacencyMatrix = {
                //1  2  3  4  5  6  7
            /* 1 */    {0, 1, 0, 1, 0, 0, 0},
            /* 2 */    {1, 0, 1, 1, 0, 0, 0},
            /* 3 */    {0, 1, 0, 1, 1, 1, 0},
            /* 4 */    {1, 1, 1, 0, 1, 0, 0},
            /* 5 */    {0, 0, 1, 1, 0, 0, 1},
            /* 6 */    {0, 0, 1, 0, 0, 0, 0},
            /* 7 */    {0, 0, 0, 0, 1, 0, 0},
        };
        return kol;
    }
}


//если нужен массив то список можно запросто преобрпзовать
// String[] linesAsArray = lines.toArray(new String[lines.size()]);
