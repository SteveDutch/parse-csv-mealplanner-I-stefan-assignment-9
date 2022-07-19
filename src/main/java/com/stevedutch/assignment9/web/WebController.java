package com.stevedutch.assignment9.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stevedutch.assignment9.domain.Recipe;
import com.stevedutch.assignment9.service.FileParser;

@RestController
public class WebController {

	private String recipeFile = "recipes.txt";
	private FileParser fileParser = new FileParser();
	private List<Recipe> selectedRecipes = new ArrayList<Recipe>();

	private ArrayList<Recipe> readRecipes() throws IOException {
		return fileParser.fileReader(recipeFile);
	}

	@GetMapping("")
	public String begin() {
		return "<p>WELCOME</p>  <p>Enter </p><p>/gluten-free </p> <p>OR "
				+ "</p><p>/vegan </p><p>OR</p>/vegan-and-gluten-free</p>"
				+ " <p>OR </p><p>/vegetarian </p><p>OR</p> <p>/all-recipes </p>" 
				+ "<p>FOR A SELECTION OF RECIPES</p>";
	}

	@GetMapping("/gluten-free")
	public String glutenFree() throws IOException {
		selectedRecipes = readRecipes().stream()
										.filter(x -> x.getGlutenFree().equals(true))
										.collect(Collectors.toList());

		return "<p>GLUTENFREE RECIPES ARE HERE</p>" + selectedRecipes;
	}

	@GetMapping("/vegan")
	public String vegan() throws IOException {
		selectedRecipes = readRecipes().stream()
										.filter(x -> x.getVegan().equals(true))
										.collect(Collectors.toList());

		return "<p>VEGAN  RECIPES ARE HERE</p>" + selectedRecipes;
	}

	@GetMapping("/vegan-and-gluten-free")
	public String veganAndGlutenFree() throws IOException {
		selectedRecipes = readRecipes().stream()
										.filter(x -> x.getGlutenFree().equals(true))
										.filter(x -> x.getVegan().equals(true))
										.collect(Collectors.toList());

		return "<p>VEGAN ANG GLUTENFREE RECIPES ARE HERE</p>" + selectedRecipes;
	}

	@GetMapping("/vegetarian")
	public String vegetarian() throws IOException {
		selectedRecipes = readRecipes().stream()
										.filter(x -> x.getVegetarian().equals(true))
										.collect(Collectors.toList());

		return "<p>VEGETARIAN RECIPES ARE HERE</p>" + selectedRecipes;
	}

	@GetMapping("/all-recipes")
	public String allRecipes() throws IOException {
		selectedRecipes = readRecipes();
		return "<p>Here comes the whole recipes collection</p>" + selectedRecipes;
	}

}
