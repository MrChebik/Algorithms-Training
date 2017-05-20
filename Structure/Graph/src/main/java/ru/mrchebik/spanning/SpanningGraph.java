package ru.mrchebik.spanning;

import ru.mrchebik.Graph;

/**
 * Created by mrchebik on 14.05.17.
 */
public class SpanningGraph extends Graph {
    public void mst() {
        vertexList[0].wasVisited = true;
        theStack.push(0);
        while (!theStack.isEmpty()) {
            int currentVertex = (int) theStack.peek();

            int v = getAdjUnvisitedVertex(currentVertex);
            if (v == -1) {
                theStack.pop();
            } else {
                vertexList[v].wasVisited = true;
                theStack.push(v);

                displayVertex(currentVertex);
                displayVertex(v);
                System.out.println(" ");
            }
        }

        for (int j = 0; j < nVerts; j++) {
            vertexList[j].wasVisited = false;
        }
    }
}
