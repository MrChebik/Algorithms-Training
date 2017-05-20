package ru.mrchebik;

/**
 * Created by mrchebik on 18.05.17.
 */
public class Topo extends Graph {
    private char[] sortedArray;

    public void topo() {
        sortedArray = new char[MAX_VERTS];
        int orig_nVerts = nVerts;

        while (nVerts > 0) {
            int currentVertex = noSuccessors();
            if (currentVertex == -1) {
                System.out.println("ERROR: Graph has cycles");
                return;
            }
            sortedArray[nVerts - 1] = vertexList[currentVertex].label;
            deleteVertex(currentVertex);
        }

        System.out.print("Topologically sorted order: ");
        for (int j = 0; j < orig_nVerts; j++) {
            System.out.print(sortedArray[j]);
        }
        System.out.println();
    }

    private int noSuccessors() {
        boolean isEdge;

        for (int row = 0; row < nVerts; row++) {
            isEdge = false;
            for (int col = 0; col < nVerts; col++) {
                if (adjMat[row][col] > 0) {
                    isEdge = true;
                    break;
                }
            }
            if (!isEdge) {
                return row;
            }
        }

        return -1;
    }

    private void deleteVertex(int delVert) {
        if (delVert != nVerts -1) {
            for (int j = delVert; j < nVerts - 1; j++) {
                vertexList[j] = vertexList[j + 1];
            }

            for (int row = delVert; row < nVerts - 1; row++) {
                moveRowUp(row, nVerts);
            }

            for (int col = delVert; col < nVerts - 1; col++) {
                moveColLeft(col, nVerts - 1);
            }

            nVerts--;
        }
    }

    private void moveRowUp(int row, int length) {
        for (int col = 0; col < length; col++) {
            adjMat[row][col] = adjMat[row + 1][col];
        }
    }

    private void moveColLeft(int col, int length) {
        for (int row = 0; row < length; row++) {
            adjMat[row][col] = adjMat[row][col + 1];
        }
    }
}
