package cn.itcast.generic;

import org.junit.Test;

public class Demo4 {

	//编写一个泛型方法，实现指定位置上的数组元素的交换
	public <T> void swap(T arr[],int pos1,int pos2){
		T temp = arr[pos1];
		arr[pos1] = arr[pos2];
		arr[pos2] = temp;
	}
	
	//编写一个泛型方法，接收一个任意数组，并颠倒所有元素
	public <T> T[] reverse(T arr[]){  //String arr[] 
		for(T str : arr){
			System.out.print(str + " "); 
		}
		System.out.println();
		
		int start = 0;
		int end = arr.length-1;
		
		while(true){
			if(start>=end){
				break;
			}
			
			T temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			
			start++;
			end--;
		}
		
		for(T str : arr){
			System.out.print(str + " "); 
		}
		return arr;
	}
	
	/*
	 public <T> T[] aa(T arr[]){
		int i = 0;
		int j = arr.length - 1;
		while(i<j){
			T temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			i++;
			j--;
		}
		for(T t : arr){
			System.out.print(t + ",");
		}
		return arr;
	}*/
	
	@Test
	public void test1(){
		String [] reverseArr = reverse(new String[]{"a","v","y","c","j"});
		//System.out.println(reverseArr);
		
		String s[] = new String[2];
		s[1]="sdafas";
		s[0]="sdafas";
		//s[2]="sdafas"; //java.lang.ArrayIndexOutOfBoundsException: 2
		//s[3]="sdafas";
		//System.out.println(s); 
	}
	

	
}
