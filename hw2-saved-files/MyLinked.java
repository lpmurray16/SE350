package hw2;

public class MyLinked {
    static class Node {
        public Node() { }
        public double item;
        public Node next;
    }

    int N;
    Node first;
    
    public MyLinked () {
        first = null;
        N = 0;
        assert checkInvariants ();
    }


    private boolean checkInvariants() {
        assert((N != 0) || (first == null));
        Node x = first;
        for (int i = 0; i < N; i++) {
            if (x==null) {
                return false;
            }
            x = x.next;
        }
        assert(x == null);
        return true;
    }

    public boolean isEmpty () { return first == null; }
    public int size () { return N; }
    public void add (double item) {
        Node newfirst = new Node ();
        newfirst.item = item;
        newfirst.next = first;
        first = newfirst;
        N++;
    }


    // delete the kth element
    public void delete (int k) {
        if (k < 0 || k >= N) throw new IllegalArgumentException ();
        Node temp = first;
        if (k == 0) {
            System.out.println("deleted: " + first.item);
            first = first.next;
            N = N - 1;
            temp = first;
            return;
        }
        for(int i = 1; i < k; i++){
            temp = temp.next;
        }
        System.out.println("deleted: " + temp.next.item); 
        temp.next = temp.next.next;
        N = N - 1;
        
        assert checkInvariants ();
    }

    // reverse the list "in place"... without creating any new nodes
    public void reverse () {
        Node curr = first, prev = null, next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        first = prev;
    
        assert checkInvariants ();
    }

    // remove 
    public void remove (double item) {
        Node temp = first, 
        prev = null;
        // if first has item or its consecutive
        while(temp != null && temp.item == item){
            first = temp.next;
            temp = first;
            N = N - 1;
        }
        // runs if the above loop hit a non-item node
        while(temp != null) {
            // searches for the next occurence of the item
            while(temp != null && temp.item != item){
                prev = temp;
                temp = temp.next;
            }
            //below runs when the above finds an occurence OR
            // reaches the end of list
            if (temp==null) return;//<-- returns if no more occurences found
            prev.next = temp.next;//<-- unlinks the Node containing item
            N = N - 1;
            temp = prev.next;//<-- update temp for next iteration
        }

    
        assert checkInvariants ();
    }
}
























