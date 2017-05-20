package ru.mrchebik.spanning.weighted;

/**
 * Created by mrchebik on 18.05.17.
 */
public class Edge {
    public int srcVert;
    public int destVert;
    public int distance;

    public Edge(int sv, int dv, int d) {
        srcVert = sv;
        destVert = dv;
        distance = d;
    }
}
