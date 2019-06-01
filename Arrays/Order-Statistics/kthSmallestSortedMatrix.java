//in order to specifically find kth smallest, this logic works. I have to check why it is failing if you make a for loop for printing kth 
//smallest from k = 1 to 16 or if I try to print three or more smallest numbers sometimes.






import java.util.Arrays;
class HeapNode{
    int value;
    int row;
    int col;
    public HeapNode(int value,int row, int col){
        this.value = value;
        this.row = row;
        this.col = col;
    }
}
public class kthSmallestInMatrix {
    private int capacity = 10;
    private int size = 0;
    private HeapNode items[] = new HeapNode[capacity];
    private int getLeftChildIndex(int parentIndex){
        return 2*parentIndex + 1;
    }
    private int getRightChildIndex(int parentIndex){
        return 2*parentIndex + 2;
    }
    private int getParentIndex(int childIndex){
        return (childIndex-1)/2;
    }
    private boolean hasLeftChild(int index){
        return getLeftChildIndex(index) < size;
    }
    private boolean hasRightChild(int index){
        return getRightChildIndex(index) < size;
    }
    private boolean hasParent(int index){
        return getParentIndex(index) >= 0 ;
    }
    private int leftChildValue(int index){
        return items[getLeftChildIndex(index)].value;
    }
    private int rightChildValue(int index){
        return items[getRightChildIndex(index)].value;
    }
    private int parentValue(int index){
        return items[getParentIndex(index)].value;
    }
    private int rowNumber(int index){
        return items[index].row;
    }
    private int colNumber(int index){
        return items[index].col;
    }

    private void swap(int indexOne, int indexTwo){
        HeapNode temp = items[indexOne];
        items[indexOne] = items[indexTwo];
        items[indexTwo] = temp;
    }

    private void ensureExtraCapacity(){
        if(size==capacity){
            items = Arrays.copyOf(items,capacity*2);
            capacity *= 2;
        }
    }

    public HeapNode peek(){
        if(size==0)
            throw new IllegalStateException();
        return items[0];
    }

    public HeapNode poll(){
        if(size==0){
            throw new IllegalStateException();
        }
        HeapNode item = items[0];
        items[0] = items[size-1];
        size--;
        heapifyDown();
        return item;
    }
    public void add(HeapNode item){
        ensureExtraCapacity();
        items[size]= item;
        size++;
        heapifyUp();
    }

    public void heapifyUp(){
        int index = size-1;
        while(hasParent(index)&&items[getParentIndex(index)].value>items[index].value){
            swap(index,getParentIndex(index));
            index = getParentIndex(index);
        }
    }

    public void heapifyDown(){
        int index = 0;
        while(hasLeftChild(index)){
            int smallerChildIndex = getLeftChildIndex(index);
            if(hasRightChild(index) && items[getRightChildIndex(index)].value < items[smallerChildIndex].value){
                    smallerChildIndex = getRightChildIndex(index);
            }
            if(items[index].value<items[smallerChildIndex].value)
                break;
            else{
                swap(index,smallerChildIndex);
            }
            index = smallerChildIndex;
        }
    }

    public void buildHeapFirstRow(int [][]matrix){
        //adding elements of first row of matrix to heap
        for(int i = 0;i<matrix[0].length;i++){
            HeapNode item = new HeapNode(matrix[0][i],0,i);
            add(item);
        }
    }

    public int kthSmallest(int [][]matrix,int k){
        buildHeapFirstRow(matrix);
        int smallk = 0;
        for(int i=0;i<k;i++){
            HeapNode item = peek();
            int row = item.row;
            int col = item.col;
            smallk = item.value;
            int nextVal;
            if(row<matrix[0].length-1)
                nextVal = matrix[row+1][col];
            else
                nextVal = Integer.MAX_VALUE;
            HeapNode newItem = new HeapNode(nextVal,row+1,col);
            items[0]=newItem;
            heapifyDown();
        }
        return smallk;
    }



    public static void main(String[] args) {
        kthSmallestInMatrix obj = new kthSmallestInMatrix();
        int matrix[][] = new int[][]{
                {10,20,30,40},
                {15,25,35,45},
                {24,29,37,48},
                {32,33,39,50}
        };
        System.out.println(obj.kthSmallest(matrix,9));

    }
}
