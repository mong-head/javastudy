package prob5;

public class Prob5 {

	public static void main(String[] args) {
		for(int i=1;i<100;i++) {
			char[] str = String.valueOf(i).toCharArray();
			int count = 0;
			for(char s : str) {
				if(s=='3'|| s=='6' ||s=='9') {
					count++;
				}
			}
			if(count>0) {
				System.out.print(i+" ");
				for(int j=0;j<count;j++)
					System.out.print("짝");
				System.out.println();
			}
			
		}
	}
}
