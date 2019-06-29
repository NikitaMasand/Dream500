/*

Similar to finding median of running integers. Using lowers(max heap) and highers (min heap)
Also can use count sort..have to check it
*/


package HackerRankInterviewPreparation.Sorting;

import java.util.Comparator;
import java.util.PriorityQueue;

public class FraudulentActivityNotifications {
    static int activityNotifications(int[] expenditure, int d) {
        int notifications = 0;
        //max heap for elements to left side of median
        PriorityQueue<Integer>lowers = new PriorityQueue<>(
                new Comparator<Integer>(){
                    public int compare(Integer a, Integer b){
                        return -1*a.compareTo(b);
                    }
                }
        );

        //min heap for elements to right side of median
        PriorityQueue<Integer>highers = new PriorityQueue<>();
        int index = 0;
        for(int i=0;i<d; i++){
            add(expenditure[i],lowers,highers);
            rebalance(lowers,highers);
        }
        for(int i=d;i<expenditure.length;i++){
            double median = findMedian(lowers,highers);
            if(expenditure[i]>=2*median){
                notifications++;
            }
            remove(expenditure[index],lowers,highers);
            rebalance(lowers,highers);
            index++;
            add(expenditure[i],lowers,highers);
            rebalance(lowers,highers);
        }
        return notifications;

    }

    static void add(int data, PriorityQueue<Integer>lowers, PriorityQueue<Integer>highers){
        if(lowers.size()==0 || data<=lowers.peek()){
            lowers.add(data);
        }
        else{
            highers.add(data);
        }
    }

    static void rebalance(PriorityQueue lowers, PriorityQueue highers){
        PriorityQueue<Integer> biggerHeap = lowers.size()>highers.size() ? lowers:highers;
        PriorityQueue<Integer>smallerHeap = lowers.size()>highers.size() ? highers:lowers;
        if(biggerHeap.size()-smallerHeap.size()>=2){
            smallerHeap.add(biggerHeap.poll());
        }
    }
    static void remove(int data, PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers){
            if(data<=lowers.peek()){
                lowers.remove(data);
            }
            else {
                highers.remove(data);
            }
    }
    static double findMedian(PriorityQueue lowers, PriorityQueue highers){
        PriorityQueue<Integer> biggerHeap = lowers.size()>highers.size() ? lowers:highers;
        PriorityQueue<Integer>smallerHeap = lowers.size()>highers.size() ? highers:lowers;
        if(biggerHeap.size()==smallerHeap.size())
            return ((double)biggerHeap.peek()+smallerHeap.peek())/2;
        else return biggerHeap.peek();

    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,4};
        System.out.println(activityNotifications(arr,4));
    }
}
