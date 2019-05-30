// visualisation: https://www.cs.usfca.edu/~galles/visualization/Heap.html
import java.util.Arrays;
public class MinHeap{
    private int capacity = 10;
    private int size = 0;
    
    private int items[] = new int[capacity];
    
    private int getLeftChildIndex(int parentIndex){
        return parentIndex*2 + 1;
    }
    private int getRightChildIndex(int parentIndex){
        return parentIndex*2 + 2;
    }
    private int getParentIndex(int childIndex){
        return (childIndex-1)/2;
    }
    private boolean hasLeftChild(int parentIndex){
        return getLeftChildIndex(parentIndex) < size;
    }
    private boolean hasRightChild(int parentIndex){
        return getRightChildIndex(parentIndex) < size;
    }
    private boolean hasParent(int childIndex){
        return getParentIndex(childIndex) >= 0;
    }
    private int leftChild(int index){
        return items[getLeftChildIndex(index)];
    }
    private int rightChild(int index){
        return items[getRightChildIndex(index)];
    }
    private int parent(int index){
        return items[getParentIndex(index)];
    }
    private void swap(int indexOne, int indexTwo){
        int temp = items[indexOne];
        items[indexOne] = items[indexTwo];
        items[indexTwo] = temp;
    }
    
    //while adding if the capacity of 10 gets filled, the array size should be doubled
    private void ensureExtraCapacity(){
        if(size==capacity){
            items = Arrays.copyOf(items,capacity*2);
            capacity *= 2;
        }
    }
    //to return the smallest element
    public int peek(){
        if(size==0){
            throw new IllegalStateException();
        }
        return items[0];
    }
    
     //to remove the smallest element
    public int poll(){
        if(size==0){
            throw new IllegalStateException();
        }
        int item = items[0];
        items[0] = items[size-1];
        size--;
        heapifyDown();
        return item;
    }
    
    
    public void add(int item){
        ensureExtraCapacity();
        items[size] = item;
        size++;
        heapifyUp();
    }
    
    
    // compares the element with it's parent. if it's value is smaller, swap the element
    // and it's parent. and again compare their values until the element has a parent and it's value is 
    //smaller
    public void heapifyUp(){
        int index = size-1;
        while(hasParent(index) && parent(index) > items[index]){
            swap(getParentIndex(index),index);
            index = getParentIndex(index);
        }
    }
    
    
    //compares the element with value of it's smallest child value. if element's value is greater,
    // swap both of them and go on doing this until the element has children and elements value is 
    // greater than it's children value
    public void heapifyDown(){
        int index = 0; 
        while(hasLeftChild(index)){
            int smallerChildIndex = getLeftChildIndex(index);
            if(hasRightChild(index) && rightChild(index) < leftChild(index)){
                smallerChildIndex = getRightChildIndex(index);
            }
            if(items[index] < items[smallerChildIndex])
                break;
            else{
            swap(index,smallerChildIndex);
            }
            index = smallerChildIndex;
        }
    }




    public static void main(String[]args){
        Main heap = new Main();
        heap.add(10);
        heap.add(15);
        heap.add(17);
        heap.add(15);
        heap.add(2);
        heap.add(3);
        heap.add(1);
        System.out.println(heap.peek());
        System.out.println(heap.poll());
        System.out.println(heap.peek());
        
    }
    
}
