package ar.com.eldars.javatest.alive;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AliveResource {
	
	@GetMapping("/alive")
	public String alive() {
		return "Is Alive!!!";
	}

}
