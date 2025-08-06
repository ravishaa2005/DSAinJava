class LRUCache {

    class Node{
        int key,value;
        Node next,prev;
        Node(int key,int value){
            this.key=key;
            this.value=value;
        }    
    }
    private int capacity;
    HashMap<Integer,Node> map;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.capacity=capacity;
        map=new HashMap<>();
        head=new Node(-1,-1);
        tail=new Node(-1,-1);
        head.next=tail;
        tail.prev=head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        Node node=map.get(key);
        deleteNode(node);
        insertAfterHead(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node=map.get(key);
            node.value=value;
            deleteNode(node);
            insertAfterHead(node);
        }else{
            if(map.size()==capacity){
                Node node=tail.prev;
                map.remove(node.key);
                deleteNode(node);
            }
            Node newNode=new Node(key,value);
            map.put(key,newNode);
            insertAfterHead(newNode);
        }
    }

    private void deleteNode(Node node){
        map.remove(node.key);
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }

    private void insertAfterHead(Node node){
        map.put(node.key,node);
        node.next=head.next;
        head.next.prev=node;
        head.next=node;
        node.prev=head;
    }
}