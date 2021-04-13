package com.saurabh.filereader;

import com.saurabh.filereader.service.FileReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class LargeFileReaderApplication {
	@Autowired
	private FileReaderService fileReaderService;
	public static void main(String[] args) {

		SpringApplication.run(LargeFileReaderApplication.class, args);

	}

}
