public class Main {
    public static void main(String[] args) {
        MyCyclicArrayQueue<String> stringQueue = new MyCyclicArrayQueue<>();
        System.out.printf("isEmpty: %b\n", stringQueue.isEmpty());
        System.out.printf("isFull: %b\n", stringQueue.isFull());
        stringQueue.enqueue("AAA");
        stringQueue.enqueue("BBB");

        System.out.printf("first: %s\n", stringQueue.first());
        System.out.printf("first: %s\n", stringQueue.first());
        stringQueue.dequeue();
        System.out.printf("first after deque: %s\n", stringQueue.first());
        stringQueue.dequeue();
//        System.out.printf("first after deque: %s\n", stringQueue.first());
        stringQueue.enqueue("CCC");
        stringQueue.enqueue("DDD");
        stringQueue.enqueue("EEE");
//        stringQueue.enqueue("FFF");
        System.out.printf("first: %s\n", stringQueue.first());
        System.out.printf("isEmpty: %b\n", stringQueue.isEmpty());
        System.out.printf("isFull: %b\n", stringQueue.isFull());
        stringQueue.dequeue();
        System.out.println("dequeue");
        System.out.printf("first: %s\n", stringQueue.first());
        System.out.printf("isEmpty: %b\n", stringQueue.isEmpty());
        System.out.printf("isFull: %b\n", stringQueue.isFull());
        stringQueue.dequeue();
        System.out.println("dequeue");
        System.out.printf("first: %s\n", stringQueue.first());
        System.out.printf("isEmpty: %b\n", stringQueue.isEmpty());
        System.out.printf("isFull: %b\n", stringQueue.isFull());
        System.out.println("dequeue");
        stringQueue.dequeue();
//        System.out.printf("first: %s\n", stringQueue.first());
        System.out.printf("isEmpty: %b\n", stringQueue.isEmpty());
        System.out.printf("isFull: %b\n", stringQueue.isFull());
    }
}