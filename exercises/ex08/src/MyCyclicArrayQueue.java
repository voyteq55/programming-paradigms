import java.util.ArrayList;

public class MyCyclicArrayQueue<E> implements MyQueue<E> {
    private ArrayList<E> cyclicArray;
    private int startIndex;
    private int endIndex;
    private int realSize;
    private static final int MAX_CYCLIC_ARRAY_SIZE = 3;

    public MyCyclicArrayQueue() {
        cyclicArray = new ArrayList<>(MAX_CYCLIC_ARRAY_SIZE);
        for (int i = 0; i < MAX_CYCLIC_ARRAY_SIZE; i++) {
            cyclicArray.add(null);
        }
        startIndex = 0;
        endIndex = 0;
        realSize = 0;
    }

    @Override
    public void enqueue(E x) throws FullException {
        if (isFull()) {
            throw new FullException("queue is full");
        }
        cyclicArray.set(endIndex, x);
        endIndex = (endIndex + 1) % MAX_CYCLIC_ARRAY_SIZE;
        realSize++;
    }

    @Override
    public void dequeue() {
        if (!isEmpty()) {
            startIndex = (startIndex + 1) % MAX_CYCLIC_ARRAY_SIZE;
            realSize--;
        }
    }

    @Override
    public E first() throws EmptyException {
        if (isEmpty()) {
            throw new EmptyException("queue is empty");
        }
        return cyclicArray.get(startIndex);
    }

    @Override
    public boolean isEmpty() {
        return realSize == 0;
    }

    @Override
    public boolean isFull() {
        return realSize >= MAX_CYCLIC_ARRAY_SIZE;
    }
}
