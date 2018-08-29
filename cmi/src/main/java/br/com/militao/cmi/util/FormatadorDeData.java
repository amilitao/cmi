package br.com.militao.cmi.util;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class FormatadorDeData {	
	
	
	public static String formata(LocalDate data) {	
	
		return data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}
	
	public static Date toDate(LocalDate localDate) {			

		return java.sql.Date.valueOf(localDate);
		
	}
	
	public static LocalDate toLocalDate(Date date) {
		
		return new java.sql.Date(date.getTime()).toLocalDate();		
		
	}

}
