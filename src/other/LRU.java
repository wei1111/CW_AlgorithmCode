package other;

import org.junit.Test;

import java.util.HashMap;

/**
 * @Author: wei1
 * @Date: Create in 2019/2/20 16:17
 * @Description:
 */
public class LRU {
    private class Node<V> {
        private V value;
        Node<V> last;
        Node<V> next;

        public Node(V value) {
            this.value = value;
        }
    }

    //都是添加在tail然后删除的时候删除head
    private class NodeDoubleLinkedList<V> {
        Node<V> head;
        Node<V> tail;
        int size;

        public NodeDoubleLinkedList() {
            head = null;
            tail = null;
            size = 0;
        }

        //添加一个node到双向链表尾部
        public void addNode(Node<V> node) {
            if (node == null) {
                return;
            }
            if (head == null) {
                this.head = node;
                this.tail = node;
                size++;
                return;
            }
            node.last = tail;
            tail.next = node;
            tail = node;
            size++;
        }

        public void moveNodeToTail(Node<V> node) {
            if (node == null) {
                return;
            }
            if (head == null || tail == node) {
                return;
            }
            if (head == node) {
                head = head.next;
            } else {
                node.last.next = node.next;
                node.next.last = node.last;
            }
            tail.next = node;
            node.last = tail;
            tail = node;
            node.next = null;
        }

        public Node<V> removeHead() {
            if (head == null) {
                return null;
            }
            Node<V> result = head;
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                head.next.last = null;
                head = head.next;
                head.next = null;
            }
            size--;
            return result;
        }
    }

    public class MyCache<K, V> {
        HashMap<K, Node<V>> keyToNode;
        HashMap<Node<V>, K> nodeToKey;
        NodeDoubleLinkedList<V> list;
        int capacity;

        public MyCache(int capacity) {
            if (capacity < 1) {
                throw new RuntimeException("缓存容量设置的太小");
            }
            this.capacity = capacity;
            keyToNode = new HashMap<>();
            nodeToKey = new HashMap<>();
            list = new NodeDoubleLinkedList<>();
        }

        public V get(K key) {
            Node<V> node = keyToNode.get(key);
            list.moveNodeToTail(node);
            return node.value;
        }

        public V removeMostUnUsedNode() {
            Node<V> node = list.removeHead();
            K key = nodeToKey.remove(node);
            //从这里可以看出我们要删除hashmmap中的node需要知道key，只有有了双向的对应的关系才可以都删除
            keyToNode.remove(key);
            return node.value;
        }

        public void set(K key, V value) {
            if (keyToNode.containsKey(key)) {
                Node<V> node = keyToNode.get(key);
                node.value = value;
                list.moveNodeToTail(node);
            } else {
                Node<V> node = new Node<>(value);
                keyToNode.put(key, node);
                nodeToKey.put(node, key);
                list.addNode(node);
            }
        }
    }

    @Test
    public void test() {
        MyCache lru = new MyCache(4);
    }
}
