import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostOrder {
    //后序遍历，非递归
    public static void postOrderNoR(Node root) {
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        Node last = null; //上一次被三次完整经过的结点
        while (!stack.empty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            Node top = stack.peek();//取栈顶元素，不删除
            if (top.right == null || top.right == last) {
                stack.pop();//取栈顶元素，删除
                System.out.println(top.value);
                last = top;
            } else {
                cur = top.right;
            }
        }
    }

    //后序递归遍历1
    public static List<Integer> list;
    private static void postOrder(Node root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        list.add(root.value);
    }
    public static List<Integer> postOrderTraversal(Node root) {
        list = new ArrayList<>();
        postOrder(root);
        return list;
    }

    //后序递归遍历2
    public static void postOrderTraversal2(Node root) {
        if (root == null) {
            return;
        }
        postOrderTraversal2(root.left);
        postOrderTraversal2(root.right);
        System.out.println(root.value);
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        n1.left = new Node(2);
        n1.right = new Node(3);
        n1.left.left = new Node(4);
        n1.left.right = new Node(5);
        n1.right.right = new Node(6);

        postOrderNoR(n1);
        System.out.println("====");
        List<Integer> list = postOrderTraversal(n1);
        System.out.println(list);
        System.out.println("====");
        postOrderTraversal2(n1);
    }
}
