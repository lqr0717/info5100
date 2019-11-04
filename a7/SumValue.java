package info5100a7;

import java.util.Random;

public class SumValue {
	
    public static long Sum_arr(int[] arr) {
    	long s = 0;
    	for(int i = 0; i< arr.length; i++) {
    		s += arr[i];
    	}
    	return s;
    }
    /*generate array of random numbers*/
    static void generateRandomArray(int[] arr){
    	Random r = new Random();
    	for(int i = 0; i<arr.length; i++) {
    		arr[i] = r.nextInt(100);
    	}
    }
    public static class SumThread extends Thread{
    	int[] arr;
    	int start,end;
    	private long sum =0;
    	SumThread(int[] arr, int start, int end){
    		this.arr = arr;
    		this.start = start;
    		this.end = end;
    	}
    	public void run() {
    		for(int i = start; i<end; i++) {
    			sum += arr[i];
    		}
    	}
    	public long getSum() {
    		return this.sum;
    	}
    }
    /*get sum of an array using 4 threads*/
    static long sum(int[] arr){
        SumThread Sum1Thread = new SumThread(arr,0,1000000);
        SumThread Sum2Thread = new SumThread(arr,1000000,2000000);
        SumThread Sum3Thread = new SumThread(arr,2000000,3000000);
        SumThread Sum4Thread = new SumThread(arr,3000000,4000000);
        Sum1Thread.run();
        Sum2Thread.run();
        Sum3Thread.run();
        Sum4Thread.run();
        long sum = Sum1Thread.getSum() + Sum2Thread.getSum() + Sum3Thread.getSum() + Sum4Thread.getSum();
        return sum;
        
    }

    public static void main(String[] args){
        int[] arr = new int[4000000];
        generateRandomArray(arr);
        long sum1 = sum(arr);
        long sum2 = Sum_arr(arr);
        System.out.println("Sum by thread: " + sum1);
        System.out.println("Sum by normal method: " + sum2);
        
    }
}