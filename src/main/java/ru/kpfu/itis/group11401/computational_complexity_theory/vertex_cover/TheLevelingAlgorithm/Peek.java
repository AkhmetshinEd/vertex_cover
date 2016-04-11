package ru.kpfu.itis.group11401;

/**
 * Created by 1 on 08.04.2016.
 */

public class Peek {
    private int degree;
    private int i;
    private double weight ;

    public double getWeight() {
        return weight;
    }

    public Peek(int i, int degree, int weight) {
        this.degree = degree;
        this.i = i;
        this.weight = 1;
    }

    public int getDegree() {
        return degree;
    }

    public int getI() {
        return i;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setDegree(int degree) {
        this.degree = degree;
    }

    public void setI(int i) {
        this.i = i;
    }

    @Override
    public String toString() {
        return "Peek{" +
                "degree=" + degree +
                ", i=" + i +
                ", weight=" + weight +
                '}';
    }
}