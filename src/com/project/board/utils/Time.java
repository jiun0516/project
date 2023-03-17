package com.project.board.utils;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Time {
	
	// insert 할때 필요
	public static Timestamp localDateTimeToTimeStamp(LocalDateTime ldt) {
		return Timestamp.valueOf(ldt);
	}
	
	// select해서 가져올 때 필요
	public static LocalDateTime timeStampToLocalDateTime(Timestamp ts) {
		return ts.toLocalDateTime();
	}

	public static void main(String[] args) {
		Timestamp ts = localDateTimeToTimeStamp(LocalDateTime.now());
		System.out.println("ts : " + ts);
		
		LocalDateTime ldt = timeStampToLocalDateTime(ts);
		System.out.println("ldt : " + ldt);
	}
}
