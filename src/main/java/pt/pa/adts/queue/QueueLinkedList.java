package pt.pa.adts.queue;

import java.util.ArrayList;
import java.util.List;

/**
 * This class must implement the Queue interface
 * @param <T>
 */
public class QueueLinkedList<T> implements Queue<T>  {

    private ListNode header, trailer;
    private int size;

    public QueueLinkedList() {
        header= new ListNode(null,null,null);
        trailer=new ListNode(null,header,null);
        header.next=trailer;
        size=0;
    }

    //TODO: implementar métodos da interface à custa da estrutura de dados fornecida
    @Override
    public void enqueue(T elem) throws QueueFullException, NullPointerException{
        if (elem==null){
            throw new NullPointerException("Um valor nulo não pode ser adicionado á fila");
        }
        ListNode newNode= new ListNode(elem,trailer.prev,trailer);
        trailer.prev.next=newNode;


    }



    @Override
    public T dequeue() throws QueueEmptyException {
        if (size==0){
            throw new QueueEmptyException("A fila já está vazia");
        }
        T element = front();
        header.next=header.next.next;
        header.next.prev=header;
        size--;
        return element;
    }

    @Override
    public T front() throws QueueEmptyException {
        if(size==0){
            throw new QueueEmptyException("A fila está vazia");
        }
        return header.next.element;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public void clear() {
    while(!isEmpty()){
        dequeue();
    }
    }

    private class ListNode {
        private T element;
        private ListNode next;
        private ListNode prev;

        public ListNode(T element, ListNode prev, ListNode next) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
    }


}
