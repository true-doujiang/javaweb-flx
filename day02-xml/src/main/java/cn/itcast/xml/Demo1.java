package cn.itcast.xml;

public class Demo1 {
	
	public static void main(String[] args) {
//		byte a[] = new byte[1024];  //1KB = 1024B(字节)
//		byte b[] = new byte[1024*1024];  //1M
		//byte c[] = new byte[1024*1024*64];  //64M  默认的极限值，再大内存溢出
		//byte d[] = new byte[1024*1024*1023]; //OutOfMemoryError: Java heap space
		//System.out.println(c); 
		
/*		
 		//最大可用内存，对应-Xmx
		Runtime.getRuntime().maxMemory(); 
		//当前JVM空闲内存
		Runtime.getRuntime().freeMemory(); 
		//当前JVM占用的内存总数，其值相当于当前JVM已使用的内存及freeMemory()的总和
		Runtime.getRuntime().totalMemory(); 
*/			
		System.out.println(Runtime.getRuntime().maxMemory()/1024/1024); //88M
		System.out.println(Runtime.getRuntime().freeMemory()/1024/1024); 
		System.out.println(Runtime.getRuntime().totalMemory()/1024/1024); 
	}
}