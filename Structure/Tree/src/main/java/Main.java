/**
 * Created by mrchebik on 12.04.17.
 */
public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree();

        tree.insert(60);
        tree.insert(40);
        tree.insert(30);
        tree.insert(50);
        tree.insert(45);
        
        tree.inOrder(tree.root);
    }
}
