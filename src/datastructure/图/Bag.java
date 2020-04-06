package datastructure.图;

import java.util.Iterator;

class Bag<Item> implements Iterable<Item> {
    //链表实现Bag
    private Node first;//链表首结点
    private class Node{
        Item item;
        Node next;
    }
    //和stack的push方法完全相同，在头部添加
    public void add(Item item){
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
    }
    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private Node current = first;

        @Override
        public boolean hasNext() {
            return current!=null;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}

