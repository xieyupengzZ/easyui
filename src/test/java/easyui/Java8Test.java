package easyui;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;

import easyui.iyunmai.service.oneParameterFun;

public class Java8Test {

	public static void main(String[] args){
			
			oneParameterFun opf = (param) -> (param+"zZ");
			System.out.println(opf.oneTest("xieyupeng"));
			
			LocalDate.now();
			LocalTime.now();
			LocalDateTime.now();
			
			LocalDate date = LocalDate.of(2017, 6, 22);
			LocalTime time = LocalTime.of(17, 47);
			LocalDateTime.of(2016, 5, 22, 17, 47, 20);
			LocalDateTime dateTime = LocalDateTime.of(date, time);
			
			Instant instant = dateTime.atZone(ZoneId.systemDefault()).toInstant();
			Date utilDate = Date.from(instant);
			
			
	}
}
