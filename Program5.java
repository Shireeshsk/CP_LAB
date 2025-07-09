import java.util.Random;
public class Program5{
    static class TreapNode {
        int key, priority;
        TreapNode left, right;

        // Constructor
        public TreapNode(int key) {
            this.key = key;
            this.priority = new Random().nextInt(100);  // Random priority
            this.left = this.right = null;
        }
    }

    static class Treap {
        // Right Rotation
        private TreapNode rotateRight(TreapNode y) {
            TreapNode x = y.left;
            y.left = x.right;
            x.right = y;
            return x;
        }

        // Left Rotation
        private TreapNode rotateLeft(TreapNode x) {
            TreapNode y = x.right;
            x.right = y.left;
            y.left = x;
            return y;
        }

        // Insertion
        public TreapNode insert(TreapNode root, int key) {
            if (root == null) {
                return new TreapNode(key);
            }

            if (key < root.key) {
                root.left = insert(root.left, key);

                // Rotate if heap property is violated
                if (root.left != null && root.left.priority > root.priority) {
                    root = rotateRight(root);
                }
            } else {
                root.right = insert(root.right, key);

                // Rotate if heap property is violated
                if (root.right != null && root.right.priority > root.priority) {
                    root = rotateLeft(root);
                }
            }

            return root;
        }

        // Deletion
        public TreapNode delete(TreapNode root, int key) {
            if (root == null) {
                return null;
            }

            if (key < root.key) {
                root.left = delete(root.left, key);
            } else if (key > root.key) {
                root.right = delete(root.right, key);
            } else {  
                // Key found, perform deletion
                if (root.left == null) {
                    return root.right;
                } else if (root.right == null) {
                    return root.left;
                }

                // Rotate to bring a child up
                if (root.left.priority > root.right.priority) {
                    root = rotateRight(root);
                    root.right = delete(root.right, key);
                } else {
                    root = rotateLeft(root);
                    root.left = delete(root.left, key);
                }
            }

            return root;
        }

        // Inorder Traversal
        public void inorder(TreapNode root) {
            if (root != null) {
                inorder(root.left);
                System.out.println("Key: " + root.key + ", Priority: " + root.priority);
                inorder(root.right);
            }
        }
    }
    
    public static void main(String[] args) {
        Treap treap = new Treap();
        TreapNode root = null;

        // Inserting elements
        int[] keys = {10, 20, 5, 15, 30};
        for (int key : keys) {
            root = treap.insert(root, key);
        }

        System.out.println("Treap Inorder Traversal:");
        treap.inorder(root);

        // Deleting a node
        System.out.println("\nDeleting node 15...");
        root = treap.delete(root, 15);

        System.out.println("Treap after deletion:");
        treap.inorder(root);
    }
}