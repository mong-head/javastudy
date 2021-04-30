package date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {

	public static void main(String[] args) {
		Date now = new Date();
		
		System.out.println(now);
		printDate01(now);
		printDate02(now);

	}
	public static void printDate01(Date now) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String date = sdf.format(now);
		System.out.println(date);
	}
	private static void printDate02(Date now) {
		//년도 (+1900)
		int year = now.getYear()+1900;
		//월(0~11) : (+1)
		int month = now.getMonth()+1;
		//일
		int date = now.getDate();
		//시
		int hour = now.getHours();
		//분
		int minutes = now.getMinutes();
		//초
		int seconds = now.getSeconds();
		
		System.out.printf("%d-%02d-%d %d:%d:%d\n",year,month,date,hour,minutes,seconds);
	}
}
