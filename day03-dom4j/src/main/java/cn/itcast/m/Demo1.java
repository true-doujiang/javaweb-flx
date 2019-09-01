package cn.itcast.m;


/**
 * 作者: 尤欢欢
 * 日期： 2017年10月29日 下午6:12:07
 * 描述：打印M型  用excel画出来，再把二维数组写出来找规律
 */
public class Demo1 {

	public static void main(String[] args) {
		int num = 9;
		int arr[][] = new int[3][9];
		
		int x = 2;
		int y = 0;
		boolean order = false;
		for(int i=1; i<=9; i++){
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
			if(x>2){
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
		
		System.out.println(arr[0]);	//第一行
		System.out.println(arr[1]); //第二行
		System.out.println(arr[2]); //第三行
		
	}
}
