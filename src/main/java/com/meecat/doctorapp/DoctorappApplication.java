package com.meecat.doctorapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

import com.cloudinary.Cloudinary;

@SpringBootApplication
@EnableAutoConfiguration
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@EntityScan( basePackages = {"com.meecat.doctorapp.domain"} )
public class DoctorappApplication {

	public static void main(String[] args) {
		SpringApplication.run(DoctorappApplication.class, args);
	}
	

	@Bean
	public Cloudinary cloudinary() {
		return new Cloudinary("cloudinary://157185458731674:wcDXS8hdJmuf6DdPwot--wcx77A@yopo");
	}
}
