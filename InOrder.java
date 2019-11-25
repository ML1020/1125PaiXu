import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrder {
    //中序遍历，非递归
    public static void inOrderNoR(Node root){
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        while (!stack.empty() || cur != null){
            while (cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            //pop出栈并删除
            Node top = stack.pop();
            System.out.println(top.value);
            cur = top.right;
        }
    }

    //中序递归遍历1
    public static List<Integer> list;
    private static void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        list.add(root.value);
        inOrder(root.right);
    }
    public static List<Integer> inOrderTraversal(Node root) {
        list = new ArrayList<>();
        inOrder(root);
        return list;
    }

    //中序递归遍历2
    public static void inOrderTraversal2(Node root) {
        if (root == null) {
            return;
        }
        inOrderTraversal2(root.left);
        System.out.println(root.value);
        inOrderTraversal2(root.right);
    }


    public static void main(String[] args) {
        Node n1 = new Node(1);
        n1.left = new Node(2);
        n1.right = new Node(3);
        n1.left.left = new Node(4);
        n1.left.right = new Node(5);
        n1.right.right = new Node(6);

        inOrderNoR(n1);
        System.out.println("====");
        List<Integer> list = inOrderTraversal(n1);
        System.out.println(list);
        System.out.println("====");
        inOrderTraversal2(n1);
    }
}
