public class postArrayToBST1 {

    public static TreeNode posArrayToBST1(int[] posArr) {
        return process1(posArr, 0, posArr.length-1);
    }

    public static TreeNode process1(int[] posArr, int L, int R) {
        if (L > R) {
            return null;
        }

        TreeNode head = new TreeNode(posArr[R]);

        // We need to think three edge scenarios:
        // 1. only one node;
        // 2. only one node with its left child nodes, no right child nodes; [1,3,2,4,5]
        // 3. only one node with its right child nodes, no left child nodes;
        if (L == R) {
            return head;
        }

        int index = L;
        while (index < R-1 && posArr[index] < head.val) {
            index++;
        }

        head.left = process1(posArr, L, index-1);
        head.right = process1(posArr, index, R);

        return head;
    }

    public static TreeNode generateRandomBST(int min, int max, int maxLevel) {
        if (min > max) {
            return null;
        }

        return createTree(min, max, 1, maxLevel);
    }

    private static TreeNode createTree(int min, int max, int level, int maxLevel) {
        if (min > max || level > maxLevel) {
            return null;
        }

        TreeNode node = new TreeNode(random(min, max));
        node.left = createTree(min, node.val-1, level + 1, maxLevel);
        node.right = createTree(node.val+1, max, level + 1, maxLevel);
        return node;
    }

    public static int random(int min, int max) {
        return min + (int) (Math.random() * (max-min+1));
    }
}
