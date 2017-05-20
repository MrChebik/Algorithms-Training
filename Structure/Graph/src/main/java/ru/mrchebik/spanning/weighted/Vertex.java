package ru.mrchebik.spanning.weighted;

/**
 * Created by mrchebik on 18.05.17.
 */
public class Vertex {
    public char label;
    public boolean isInTree;

    public Vertex(char lab) {
        label = lab;
        isInTree = false;
    }
}
