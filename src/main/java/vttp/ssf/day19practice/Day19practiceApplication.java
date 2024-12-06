package vttp.ssf.day19practice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import vttp.ssf.day19practice.service.TodoService;

@SpringBootApplication
public class Day19practiceApplication implements CommandLineRunner{

	   @Autowired
    TodoService todoSvc;

	@Override
    public void run(String... args) throws Exception {
      
        todoSvc.readJsonFile();
        

    }

	public static void main(String[] args) {
		SpringApplication.run(Day19practiceApplication.class, args);
	}

}
