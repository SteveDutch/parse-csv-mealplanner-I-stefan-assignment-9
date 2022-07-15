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
	List<Recipe> endpointSelector = new ArrayList<Recipe>();
	
	
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
	public String glutenFree() throws IOException {
		
		endpointSelector = recipes.fileReader(recipeFile);
		endpointSelector = endpointSelector.stream().filter(x -> x.getGlutenFree().equals(true)).collect(Collectors.toList());

		return "Ja Mann! " + "GLUTENFREE RECIPES ARE HERE11111->" + endpointSelector.toString();
	}
	
	@GetMapping("/vegan")
	public String vegan() throws IOException {
		
		endpointSelector= recipes.fileReader(recipeFile);
		endpointSelector = endpointSelector.stream().filter(x -> x.getVegan().equals(true))
													.collect(Collectors.toList());

		return "Ja Mann! " + "VEGAN  RECIPES ARE FHERE" + endpointSelector;
		}

	@GetMapping("/vegan-and-gluten-free")
	public String veganAndGlutenFree () throws IOException {
		endpointSelector= recipes.fileReader(recipeFile);
//		endpointSelector = endpointSelector.stream().filter(x -> x.getVegan().equals(true) && x.getGlutenFree().equals(true))
//				.collect(Collectors.toList());
		
		endpointSelector = endpointSelector.stream()
					
						.filter(x -> x.getGlutenFree().equals(true))
						.filter(x -> x.getVegan().equals(true))
						.collect(Collectors.toList());

		return "Ja Mann! " + "VEGAN ANG GLUTENFREE RECIPES ARE here" + endpointSelector;
	}

	@GetMapping("/vegetarian")
	public String vegetarian () throws IOException {
		endpointSelector = recipes.fileReader(recipeFile);
		endpointSelector = endpointSelector.stream()
								.filter(x -> x.getVegetarian().equals(true))
								.collect(Collectors.toList());

		
		return "--Ja Mann! " + "vegetarian RECIPES ARE here" + endpointSelector;
	} 

	@GetMapping("/all-recipes")
	public String allRecipes () throws IOException {
		;
		return "Here comes the whole recipes collection" + recipes.readFile(recipeFile);
	}

}

