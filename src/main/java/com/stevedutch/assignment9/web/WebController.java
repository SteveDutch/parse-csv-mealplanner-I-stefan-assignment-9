package com.stevedutch.assignment9.web;

import java.io.IOException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stevedutch.assignment9.service.FileParser;

@RestController
public class WebController {
	
	@GetMapping("/first")
	public String first () {
		System.out.println("hamstibamsti from /first");
		return "Welcome on my first\n JAVA SPRING BOOT BUILD WEBPAGE" + '\n' + "Ja Mann! " + '\n' + "FileParser is following soon";
	}
	
	@GetMapping("/start")
	public String begin () throws IOException {
		FileParser test = new FileParser();
		test.fileReader();
		return "placeholder for start";
	}
	
	@GetMapping("/gluten-free")
	public String glutenFree () {
		return "Under Construction ------------------------Ja Mann! " + "GLUTENFREE RECIPES ARE FOLLOWING SOON";
	}
	
	@GetMapping("/vegan")
	public String vegan() {
		return "Under Construction ------------------------Ja Mann! " + "VEGAN  RECIPES ARE FOLLOWING SOON";
	}

	@GetMapping("/vegan-and-gluten-free")
	public String veganAndGlutenFree () {
		return "Under Construction ------------------------Ja Mann! " + "VEGAN ANG GLUTENFREE RECIPES ARE FOLLOWING SOON";
	}

	@GetMapping("/vegetarian")
	public String vegettarian () {
		return "Under Construction ------------------------Ja Mann! " + "vegetarian RECIPES ARE FOLLOWING SOON";
	}

	@GetMapping("/all-recipes")
	public String allRecipes () {
		return "Under Construction ------------------------Ja Mann! " + "ALL<<<< RECIPES ARE FOLLOWING SOON";
	}

}
