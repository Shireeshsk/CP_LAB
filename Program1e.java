import java.util.Random;

class TreapNode {
    int key, priority, count;
    TreapNode left, right;

    public TreapNode(int key) {
        this.key = key;
        this.priority = new Random().nextInt(100000);
        this.count = 1;
        this.left = this.right = null;
    }
}

class Treap {
    TreapNode root;
 
    private int getCount(TreapNode node) {
        return (node == null) ? 0 : node.count;
    }

    private void updateCount(TreapNode node) {
        if (node != null) {
            node.count = 1 + getCount(node.left) + getCount(node.right);
        }
    }

    private TreapNode rotateRight(TreapNode y) {
        TreapNode x = y.left;
        TreapNode temp = x.right;
        x.right = y;
        y.left = temp;
        updateCount(y);
        updateCount(x);
        return x;
    }

    private TreapNode rotateLeft(TreapNode x) {
        TreapNode y = x.right;
        TreapNode temp = y.left;
        y.left = x;
        x.right = temp;
        updateCount(x);
        updateCount(y);
        return y;
    }

    public TreapNode insert(TreapNode node, int key) {
        if (node == null) return new TreapNode(key);

        if (key <= node.key) {
            node.left = insert(node.left, key);
            if (node.left.priority > node.priority) {
                node = rotateRight(node);
            }
        } else {
            node.right = insert(node.right, key);
            if (node.right.priority > node.priority) {
                node = rotateLeft(node);
            }
        }

        updateCount(node);
        return node;
    }

    public int countGreater(TreapNode node, int val) {
        if (node == null) return 0;
        if (node.key > val) {
            return 1 + getCount(node.right) + countGreater(node.left, val);
        } else {
            return countGreater(node.right, val);
        }
    }

    public void insert(int key) {
        root = insert(root, key);
    }

    public int countGreater(int val) {
        return countGreater(root, val);
    }
}

public class ReversePairsTreap {
    public static int reversePairs(int[] nums) {
        Treap treap = new Treap();
        int count = 0;

        for (int num : nums) {
            count += treap.countGreater(2 * num);
            treap.insert(num);
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,2,3,1};
        System.out.println("Reverse Pairs: " + reversePairs(nums));
    }
}