package board;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MyUtil {

	public static String getCurrentDate() {
		LocalDate now = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
		String formatedNow = now.format(formatter);
		
		return formatedNow;
	}
}
