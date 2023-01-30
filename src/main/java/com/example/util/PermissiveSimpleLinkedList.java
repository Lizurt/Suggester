package com.example.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PermissiveSimpleLinkedList<T> {
    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Setter
    public static class Node<T> {
        private T value;
        private Node<T> prev;
        private Node<T> next;
    }

    private Node<T> first;

    private Node<T> last;

    public void remove(Node<T> node) {
        if (node == null) {
            // alright sure we removed the null node you're welcome
            return;
        }
        if (node == first) {
            removeFirst();
            return;
        }
        if (node == last) {
            removeLast();
            return;
        }
        if (node.prev == null || node.next == null) {
            // mission failed successfully - this node doesn't exist in this list so it's already removed
            return;
        }
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = null;
        node.prev = null;
    }

    public void add(Node<T> node) {
        if (node.prev == null) {
            addFirst(node.value);
            return;
        }
        if (node.next == null) {
            addLast(node.value);
            return;
        }
        node.prev.next = node;
        node.next.prev = node;
    }

    public Node<T> addFirst(T value) {
        Node<T> node = new Node<>();
        node.setValue(value);
        if (first == null) {
            first = node;
            last = node;
            return node;
        }
        first.prev = node;
        node.next = first;
        first = node;
        return node;
    }

    public Node<T> addLast(T value) {
        Node<T> node = new Node<>();
        node.setValue(value);
        if (last == null) {
            first = node;
            last = node;
            return node;
        }
        last.next = node;
        node.prev = last;
        last = node;
        return node;
    }

    public Node<T> removeFirst() {
        if (first == null) {
            return null;
        }
        if (first.next == null) {
            Node<T> temp = first;
            first = null;
            last = null;
            return temp;
        }
        Node<T> temp = first;
        first.next.prev = null;
        first = first.next;
        temp.next = null;
        return temp;
    }

    public Node<T> removeLast() {
        if (last == null) {
            return null;
        }
        if (last.prev == null) {
            Node<T> temp = last;
            first = null;
            last = null;
            return temp;
        }
        Node<T> temp = last;
        last.prev.next = null;
        last = last.prev;
        temp.prev = null;
        return temp;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("[");
        Node<T> node = first;
        while (node != null) {
            result.append(node.value.toString());
            if (node.next != null) {
                result.append(", ");
            }
            node = node.next;
        }
        result.append("]");
        return result.toString();
    }
}
