package com.backend.westernunion;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Welcome {

	@RequestMapping("/welcome")
	public static String welcomeMessage() {
		return "Bievenido a WesterUnion :)";
	}
}
