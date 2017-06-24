/**
 * Created by eminentstar on 2017. 3. 24..
 */
public class Queue<T> {
    private Node<T> head, tail;

    void enqueue(T value){
        Node n = new Node(value);

        if(head == null){
            head = n;
            tail = head;
        }

        tail.setNext(n);
        tail = tail.getNext();
    }

    T dequeue(){
        if(head != null){
            T item = head.getValue();
            head = head.getNext();
            return item;
        }
        return null;

        // My Implementation
        /*
        if(head == null){
            return null;
        }

        T retVal = head.getValue();

        if(head == tail){
            head = tail = null;
        }else{
            head = head.getNext();
        }

        return retVal;
        */
    }

}

