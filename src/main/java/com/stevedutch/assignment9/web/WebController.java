package com.stevedutch.assignment9.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stevedutch.assignment9.domain.Recipe;
import com.stevedutch.assignment9.service.FileParser;



@RestController
public class WebController {
	
	String recipeFile = "recipes.txt";
//	@Autowired
	FileParser recipes = new FileParser();
	
	@GetMapping("/first")
	public String first () {
		System.out.println("hamstibamsti from /first");
		String hamstibamsti = "Test \nmonsterstring \n";
		return hamstibamsti + "Welcome on my first\n JAVA SPRING BOOT BUILD WEBPAGE" + '\n' + "Ja Mann! " + '\n' + "FileParser is following soon";
	}
	
	@GetMapping("/start")
	public String begin (ArrayList<Recipe> printTest) throws IOException {
		FileParser test = new FileParser();
		ArrayList<Recipe> printVersuch = test.fileReader("recipes.txt");
		printVersuch.stream()
				
				.map(x -> x.getInstructions())
				 .map(x -> x.toString())
				.forEach(System.out::println);
		
		List<String> testo =new ArrayList<String>();
		testo.add("jj");
		testo.add("jfejfeo");
		return "placeholder for start" +"\n "  + test.readFile("test.txt");
	}
	
	@GetMapping("/gluten-free")
	public String glutenFree () throws IOException {
		List<Recipe> glutenFree = new ArrayList<Recipe>();
		glutenFree = recipes.fileReader(recipeFile);
		glutenFree = glutenFree.stream()
				 .filter(x -> x.getGlutenFree().equals(true)) 
					.collect(Collectors.toList());
						
		
		
		return "Under Construction ---Ja Mann! " + "GLUTENFREE RECIPES ARE HERE11111->" + glutenFree.toString();
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
	public String allRecipes () throws IOException {
		;
		return "Here comes the whole recipes collection" + recipes.readFile(recipeFile);
	}

}

