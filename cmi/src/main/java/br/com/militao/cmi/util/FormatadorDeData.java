package br.com.militao.cmi.util;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class FormatadorDeData {	
	
	
	public static String formata(LocalDate data) {	
	
		return data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}

	public static String formata(LocalDateTime dataHora) {	
		
		return dataHora.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
	}
	
	public static String formata(Timestamp timestamp) {
		LocalDateTime datahora = timestamp.toLocalDateTime();
		return datahora.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
	}
	
	public static Date toDate(LocalDate localDate) {			

		return java.sql.Date.valueOf(localDate);
		
	}
	
	public static LocalDate toLocalDate(Date date) {
		
		if(date == null) {		
			return null;	
		}else {
			return new java.sql.Date(date.getTime()).toLocalDate();
		}
		
	}	
	
	public static LocalDateTime toLocalDateTime(Timestamp timestamp) {		
		return timestamp.toLocalDateTime();
	}

	public static Timestamp toTimeStamp(LocalDateTime dataHora) {		
		return java.sql.Timestamp.valueOf(dataHora);
	}

}
