package com.github.sl1907.queues;

public class CircularQueue<T> {

    private final int size;
    private int head;
    private int tail;
    private final T[] queue;

    public CircularQueue(int size) {
        this.size = size;
        this.head = 0;
        this.tail = 0;
        //noinspection unchecked
        this.queue = (T[]) new Object[size];
    }

    public CircularQueue() {
        this(10);
    }

    public boolean isEmpty() {
        return this.head == this.tail;
    }

    public boolean isFull() {
        return (this.tail + 1) % this.size == this.head;
    }

    public void enqueue(T element) {
        if (this.isFull()) {
            throw new RuntimeException("Queue is full");
        }
        this.queue[this.tail] = element;
        this.tail = (this.tail + 1) % this.size;
    }

    public T dequeue() {
        if (this.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        T element = this.queue[this.head];
        this.head = (this.head + 1) % this.size;
        return element;
    }

    public T peek() {
        if (this.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return this.queue[this.head];
    }

    public void print() {
        for (int i = this.head; i < this.tail; i++) {
            System.out.print(this.queue[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CircularQueue<Integer> queue = new CircularQueue<>(100);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);
        queue.enqueue(7);
        queue.enqueue(8);
        queue.enqueue(9);
        queue.enqueue(10);
        queue.print();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.print();
    }
}
