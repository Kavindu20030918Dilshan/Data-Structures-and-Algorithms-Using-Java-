package Stack;


import java.util.*;

class Stack {

    private int[] dataArray;
    private int nextIndex;
    private double loadFactor;
    private int initsize;

    Stack(int initsize, double loadFactor) {
        dataArray = new int[initsize];
        nextIndex = 0;
        this.loadFactor = loadFactor;
        this.initsize = initsize;
    }

    public void push(int data) {
        if (nextIndex >= dataArray.length) {
            extendArray();
        }
        dataArray[nextIndex] = data;
        nextIndex++;

    }

    private void extendArray() {
        int size = dataArray.length + (int) (dataArray.length * loadFactor);
        int[] tempArray = new int[size];
        for (int i = 0; i < dataArray.length; i++) {
            tempArray[i] = dataArray[i];
        }

        dataArray = tempArray;
    }

    public void printStack() {
        System.out.print("[");
        for (int i = nextIndex - 1; i >= 0; i--) {
            System.out.print(dataArray[i] + ", ");
        }
        System.out.println(nextIndex <= 0 ? "empty]" : "\b\b]");
    }

    private boolean isEmpty() {
        return nextIndex <= 0;
    }

    public void pop() {
        if (!isEmpty()) {
            nextIndex--;
        }

    }

    public int capacity() {
        return dataArray.length;
    }

    public int size() {
        return nextIndex;

    }

    public void clear() {
        nextIndex = 0;
        dataArray = new int[initsize];

    }

    public int peek() {
        if (isEmpty()) {
            return -1;
        }
        return dataArray[nextIndex - 1];
    }

    public int poll() {
        if (isEmpty()) {
            return -1;
        }
        int topData = dataArray[nextIndex - 1];
        pop();
        return topData;
    }

    public int search(int data) {
        for (int i = 0; i < nextIndex; i++) {
            if (dataArray[i] == data) {
                return (nextIndex - 1) - i;
            }
        }

        return -1;

    }

    public int[] toArray() {
        int[] temArray = new int[nextIndex];
        for (int i = 0; i < temArray.length; i++) {
            temArray[i] = dataArray[(nextIndex - 1) - i];
        }

        return temArray;
    }

}

class Example1 {

    public static void main(String[] args) {
        Stack s1 = new Stack(10, 0.5); // %
        s1.printStack();
        System.out.println("Capacity :" + s1.capacity()); // 10
        System.out.println("Size :" + s1.size()); // 0
        System.out.println();

        s1.push(10);
        s1.push(20);
        s1.push(30);
        s1.push(40);
        s1.push(50);
        s1.push(60);
        s1.push(70);
        s1.push(80);
        s1.push(90);
        s1.push(100);

        s1.printStack(); // [100,90,80,70,60,50,40,30,20,10]
        System.out.println("Capacity :" + s1.capacity());
        System.out.println("Size of Stack :" + s1.size());
        System.out.println();
        s1.push(200);

        System.out.println("Index of 40 :" + s1.search(40)); // 6
        System.out.println("Index of 99 :" + s1.search(99)); // -1

        System.out.println();

        System.out.println("Top Data :" + s1.peek());
        System.out.println("After Calling peek......."); //  100
        s1.printStack(); // [200,100,90,80,70,60,50,40,30,20,10]

        System.out.println("Top Data :" + s1.poll());
        System.out.println("After Calling poll......."); //  100
        s1.printStack(); // [100,90,80,70,60,50,40,30,20,10]

        int[] ar = s1.toArray();
        System.out.println("calling toArray :" + Arrays.toString(ar)); // [100,90,80,70,60,50,40,30,20,10]

        s1.printStack(); // [200,100,90,80,70,60,50,40,30,20,10]
        System.out.println("Capacity :" + s1.capacity());
        System.out.println("Size of Stack :" + s1.size());
        System.out.println();

        s1.clear();
        s1.printStack(); // [empty]
        System.out.println("Capacity :" + s1.capacity()); // 10
        System.out.println("Size of Stack :" + s1.size()); // 0

    }
}
