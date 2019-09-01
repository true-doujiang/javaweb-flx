package cn.itcast.m;


/**
 * 作者: 尤欢欢
 * 日期： 2017年10月29日 下午6:12:07
 * 描述：打印M型  用excel画出来，再把二维数组写出来找规律
 */
public class Demo2 {

	public static void main(String[] args) {
		int num = 13;//随意输入一个数
		
		int height = num/4+1;
		int width = num;
		
		int arr[][] = new int[height][width];
		
		int x = height-1;
		int y = 0;
		
		boolean order = false;
		for(int i=1; i<=num; i++){
			arr[x][y] = i;
			y++;
			if(!order){
				x--;
			}
			if(order){
				x++;
			}
			if(x<0){
				order = true;
				x = x+2;
			}
			if(x>height-1){
				order = false;
				x = x-2;
			}
		}
		
		for(int i=0; i<arr.length; i++){
			for(int j=0; j<arr[i].length; j++){
				if(arr[i][j]==0){
					System.out.print(" ");
				}else{
					System.out.print(arr[i][j]);
				}
			}
			System.out.println();
		}
		
		
	}
}
