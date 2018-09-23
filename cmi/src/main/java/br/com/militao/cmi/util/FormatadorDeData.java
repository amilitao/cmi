package br.com.militao.cmi.util;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class FormatadorDeData {	
	
	
	public static String formata(LocalDate data) {	
		if(data != null) {
		return data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		}else {
			return "";
		}
	}

	public static String formata(LocalDateTime dataHora) {
		if(dataHora != null) {		
		return dataHora.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
		}else {
			return "";
		}
		
	}
	
	public static String formata(Timestamp timestamp) {
		if(timestamp != null) {
		LocalDateTime datahora = timestamp.toLocalDateTime();
		return datahora.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
		}else {
			return "";
		}
		
	}
	
	public static Date toDate(LocalDate localDate) {			
		if(localDate != null) {
		return java.sql.Date.valueOf(localDate);
		}else {
			return null;
		}
		
	}
	
	public static LocalDate toLocalDate(Date date) {
		
		if(date != null) {		
			return new java.sql.Date(date.getTime()).toLocalDate();	
		}else {			
			return null;
		}
		
	}	
	
	public static LocalDateTime toLocalDateTime(Timestamp timestamp) {	
		if(timestamp != null) {
		return timestamp.toLocalDateTime();
		}else {
			return null;
		}
	}

	public static Timestamp toTimeStamp(LocalDateTime dataHora) {
		if(dataHora != null) {
		return java.sql.Timestamp.valueOf(dataHora);
		}else {
			return null;
		}
	}

}
