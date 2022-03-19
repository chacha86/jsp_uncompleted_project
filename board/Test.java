package board;

public class Test {

	public static void main(String[] args) {
		String str = "A,B,C,D";
		
		System.out.println(str);
		String[] array = str.split(",");
				    
		//출력				
		for(int i=0;i<array.length;i++) {
		System.out.println(array[i]);
		}
				
	}

}
