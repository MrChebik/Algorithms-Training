package ru.mrchebik;

/**
 * Created by mrchebik on 14.05.17.
 */
public class Vertex {
    public char label;
    public boolean wasVisited;

    public Vertex(char lab) {
        label = lab;
        wasVisited = false;
    }
}
