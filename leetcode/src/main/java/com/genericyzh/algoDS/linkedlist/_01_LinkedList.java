package com.genericyzh.algoDS.linkedlist;

import java.util.NoSuchElementException;

/**
 * 实现单向链表
 *
 * @author genericyzh
 * @date 2017/7/18 21:43
 */
public class _01_LinkedList<E> {
    int size;
    private Node head;
    private Node tail;

    public void add(E element) {
        // 如果链表是空的时候，头跟尾是一样的
        if (head == null) {
            head = tail = new Node(element);
        } else {
            tail.next = new Node(element);
            tail = tail.next;
        }
        size++;
    }

    public E get(int index) {
        if (index >= size || index < 0) {
            throw new NoSuchElementException();
        }

        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node.element;
    }

    public boolean delete(E element) {
        Node temp = new Node(null, head);
        Node dummy = temp;
        // 因为是delete方法，所以需要使用next来判断，不能使用temp.element作判断，如果用temp的话，就不能删除了(因为删除是操作被删除的上一个节点的next)
        while (temp.next != null) {
            if (temp.next.element.equals(element)) {
                if (temp.next == tail) {
                    tail = temp;
                }
                temp.next = temp.next.next;
                // 优雅的处理head的element等于element的情况，包括只有一个元素的情况
                head = dummy.next;
                size--;
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    private class Node {
        E element;
        Node next;

        public Node(E e) {
            this.element = e;
        }

        public Node(E e, Node next) {
            this.element = e;
            this.next = next;
        }
    }
}
