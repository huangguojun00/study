package leecode.stack;

import java.util.HashMap;
import java.util.List;

/**
 * @Author Huang Guojun
 * @Date 2019/7/21
 * @Discription
 */
public class ClonePicture {
    /*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/ private HashMap<Node, Node> hashMap = new HashMap<>(16);

    public Node cloneGraph(Node node) {
        if (node==null){
            return null;
        }

        if (hashMap.containsKey(node)){
            return hashMap.get(node);
        }
        Node node1 = new Node(node.val);
        hashMap.put(node, node1);

        for (Node neighbor : node.neighbors) {
            node1.neighbors.add(cloneGraph(neighbor));
        }
        return node1;


    }
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node(int val) {}

        public Node(int _val,List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
