package com.stevedutch.assignment9.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stevedutch.assignment9.domain.Recipe;
import com.stevedutch.assignment9.service.FileParser;

@RestController
public class WebController {

	private String recipeFile = "recipes.txt";
	@Autowired
	private FileParser fileParser = new FileParser();
	private ArrayList<Recipe> selectedRecipes = new ArrayList<Recipe>();
	


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
	public ArrayList<Recipe> glutenFree() throws IOException {
		selectedRecipes = readRecipes().stream()
										.filter(x -> x.getGlutenFree().equals(true))
										.collect(Collectors.toCollection(ArrayList<Recipe>::new));
		return selectedRecipes;
	}

	@GetMapping("/vegan")
	public ArrayList<Recipe> vegan() throws IOException {
		selectedRecipes = readRecipes().stream()
										.filter(x -> x.getVegan().equals(true))
										.collect(Collectors.toCollection(ArrayList<Recipe>::new));
		return selectedRecipes;
	}

	@GetMapping("/vegan-and-gluten-free")
	public ArrayList<Recipe> veganAndGlutenFree() throws IOException {
		selectedRecipes = readRecipes().stream()
										.filter(x -> x.getGlutenFree().equals(true))
										.filter(x -> x.getVegan().equals(true))
										.collect(Collectors.toCollection(ArrayList<Recipe>::new));
		return selectedRecipes;
	}

	@GetMapping("/vegetarian")
	public ArrayList<Recipe> vegetarian() throws IOException {
		selectedRecipes = readRecipes().stream()
										.filter(x -> x.getVegetarian().equals(true))
										.collect(Collectors.toCollection(ArrayList<Recipe>::new));
		return selectedRecipes;
	}

	@GetMapping("/all-recipes")
	public ArrayList<Recipe> allRecipes() throws IOException {
		selectedRecipes = readRecipes();
		return  selectedRecipes;
	}

}
