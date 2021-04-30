package date;

import java.util.Calendar;

public class CalendarTest {

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance(); //new Calendar()안 됨
		printDate(cal);
		
		cal.set(Calendar.YEAR, 2020); //년도 세팅
		cal.set(Calendar.MONTH, 11); //4월
		cal.set(Calendar.DATE, 4);
		printDate(cal);
		
		cal.set(1996,7,31);
		cal.add(Calendar.DATE, 1000); //탄생일로부터 1000일 지난 시점
		printDate(cal);
	}
	private static void printDate(Calendar cal) {
		//년
		int year = cal.get(Calendar.YEAR);
		//월
		int month = cal.get(Calendar.MONTH);
		//일
		int date = cal.get(Calendar.DATE);
		//요일
		int day = cal.get(Calendar.DAY_OF_WEEK);
		final String[] DAYS = {"일","월","화","수","목","금","토"};
		//시
		int hour = cal.get(Calendar.HOUR);
		//분
		int minute = cal.get(Calendar.MINUTE);
		//초
		int second = cal.get(Calendar.SECOND);
		
		System.out.printf("%d년 %02d월 %02d일 %s요일 %02d:%02d:%02d\n",year,month+1,date,DAYS[day-1],hour,minute,second);
	}

}
