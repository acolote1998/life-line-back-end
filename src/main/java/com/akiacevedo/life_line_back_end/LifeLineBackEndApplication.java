package com.akiacevedo.life_line_back_end;

import com.akiacevedo.life_line_back_end.service.DayService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LifeLineBackEndApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context =  SpringApplication.run(LifeLineBackEndApplication.class, args);
		DayService service = context.getBean(DayService.class);
		System.out.println(service.getDays());
	}

}
