import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TreeNode {
    int value;
    TreeNode left = null;
    TreeNode right = null;
    TreeNode(int value) {
        this.value = value;
    }
}

public class PreOrder {
    //层序遍历，非递归
    //前序遍历
    public static void preOrderNoR(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while (!stack.empty() || cur != null) {
            while (cur != null) {
                System.out.println(cur.value);//<第一次经过时打印，即第一次遍历时打印>
                stack.push(cur);
                cur = cur.left;
            }

            //pop出掉栈并取出
            TreeNode top = stack.pop();
            cur = top.right;
        }
    }

    //前序递归遍历1
    public static List<Integer> list;
    private static void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        list.add(root.value);
        preOrder(root.left);
        preOrder(root.right);
    }
    public static List<Integer> preOrderTraversal(TreeNode root) {
        list = new ArrayList<>();
        preOrder(root);
        return list;
    }


    //前序递归遍历2
    public static void preOrderTraversal2(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.value);
        preOrderTraversal2(root.left);
        preOrderTraversal2(root.right);
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        n1.left = new TreeNode(2);
        n1.right = new TreeNode(3);
        n1.left.left = new TreeNode(4);
        n1.left.right = new TreeNode(5);
        n1.right.right = new TreeNode(6);
        List<Integer> list = preOrderTraversal(n1);
        preOrderTraversal2(n1);
        System.out.println("======");
        System.out.println(list);
        System.out.println("======");
        preOrderNoR(n1);
    }
}
