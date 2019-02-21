package com.ordinaryyzh.algoDS.linkedlist;

import java.util.NoSuchElementException;

/**
 * 双向链表
 *
 * @author genericyzh
 * @date 2017/7/20 21:41
 */
public class _02_DoublyLinkedList<E> {
    private int size;
    private Node head;
    private Node tail;

    public void add(E e) {
        if (e == null) throw new AssertionError();

        if (head == null) {
            head = tail = new Node(e);
        } else {
            tail.next = new Node(e, tail, null);
            tail = tail.next;
        }
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    public E get(int index) {
        if (index >= size) {
            throw new NoSuchElementException();
        }
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.elem;
    }

    public boolean delete(E elem) {
        Node temp = head;
        while (temp != null && !temp.elem.equals(elem)) {
            temp = temp.next;
        }
        // no node with given element is found
        if (temp == null) return false;

        size--;

        // 处理只有一个节点
        if (size == 0) {
            head = tail = null;
        }

        // 处理删除的是头结点
        if (temp == head) {
            temp.next.pre = null;
            head = head.next;
            return true;
        }

        // 处理删除的是尾节点
        if (temp == tail) {
            temp.pre.next = null;
            tail = temp.pre;
            return true;
        }

        // change links
        temp.pre.next = temp.next;
        temp.next.pre = temp.pre;

        return true;
    }

    private class Node {
        E elem;
        Node pre;
        Node next;

        public Node(E elem) {
            this.elem = elem;
        }

        public Node(E elem, Node pre, Node next) {
            this.elem = elem;
            this.pre = pre;
            this.next = next;
        }
    }
}
