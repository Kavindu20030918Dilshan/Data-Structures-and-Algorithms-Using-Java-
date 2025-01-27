package List;

class List {

    private int[] dataArray;
    private int nextIndex;
    private double loadFact;
    private int initSize;

    List(int initSize, double loadFact) {
        dataArray = new int[initSize];
        nextIndex = 0;
        this.loadFact = loadFact;
        this.initSize = initSize;
    }

    public boolean add(int index, int data) {
        if (isValidIndex(index)) {
            for (int i = nextIndex - 1; i >= index; i--) {
                dataArray[i + 1] = dataArray[i];
            }
            dataArray[index] = data;
            nextIndex++;
            return true;
        }
        return false;
    }

    private boolean isValidIndex(int index) {
        return index >= 0 && index < nextIndex;
    }

    public boolean add(int data) { //add to the last
        if (nextIndex >= dataArray.length) { //isFull()
            extendArray();
        }
        dataArray[nextIndex] = data;
        nextIndex++;
        return true;
    }

    public void set(int index, int data) {
        dataArray[index] = data;
    }

    private void extendArray() {
        int size = dataArray.length + (int) (dataArray.length * loadFact);
        int[] tempDataArray = new int[size];
        for (int i = 0; i < dataArray.length; i++) {
            tempDataArray[i] = dataArray[i];
        }
        dataArray = tempDataArray;
    }

    public void printList() {
        System.out.print("[");
        for (int i = 0; i < nextIndex; i++) {
            System.out.print(dataArray[i] + ", ");
        }
        System.out.println(nextIndex <= 0 ? "empty]" : "\b\b]");
    }

    public boolean isEmpty() {
        return nextIndex <= 0;
    }

    public boolean remove(int index) {
        if (isValidIndex(index)) {
            for (int i = index; i < nextIndex - 1; i++) {
                dataArray[i] = dataArray[i + 1];
            }
            nextIndex--;
            return true;
        }
        return false;
    }

    public int capacity() {
        return dataArray.length;
    }

    public int size() {
        return nextIndex;
    }

    public void clear() {
        dataArray = new int[initSize];
        nextIndex = 0;
    }

    public int get(int index) {
        if (isEmpty()) {
            return -1;
        }
        return dataArray[index];
    }

    public int search(int data) {
        for (int i = 0; i < nextIndex; i++) {
            if (dataArray[i] == data) {
                return i;
            }
        }
        return -1;
    }

    public int[] toArray() {
        int[] tempDataArray = new int[nextIndex];
        for (int i = 0; i < nextIndex; i++) {
            tempDataArray[i] = dataArray[i];
        }
        return tempDataArray;
    }

}

class Example1 {

    public static void main(String args[]) {
        List list = new List(100, 0.5);
        list.add(100);
        list.add(200);
        list.add(300);
        list.add(400);
        list.add(500);
        list.printList();
        //----------------
        list.add(2, 222);
        list.printList();//[100,200,222,300,400,500]

        System.out.println(list.get(2)); //222

        list.remove(2);
        list.printList();//[100,200,300,400,500]
    }
}
