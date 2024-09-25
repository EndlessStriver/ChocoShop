package Util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class MethodUtil {
	
	public static LocalDate ConvertStringToLocalDate(String date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDate Local = null;
		try {
            LocalDate localDate = LocalDate.parse(date, formatter);
            Local = localDate;
        } catch (DateTimeParseException e) {
            System.out.println("Định dạng ngày không hợp lệ: " + e.getMessage());
        }
		return Local;
	}
}
