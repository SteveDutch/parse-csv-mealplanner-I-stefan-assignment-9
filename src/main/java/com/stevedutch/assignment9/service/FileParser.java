package com.stevedutch.assignment9.service;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import com.stevedutch.assignment9.domain.Recipe;
import com.stevedutch.assignment9.domain.RecipeString;

public class FileParser {

	public ArrayList<Recipe> fileReader(String filename) throws IOException {
		Reader in = new FileReader(filename);
		Iterable<CSVRecord> records = CSVFormat.DEFAULT.builder()
														.setDelimiter(',')
														.setTrim(true)
														.setTrailingDelimiter(true)
														.setIgnoreSurroundingSpaces(true)
														.setSkipHeaderRecord(false)
														.setHeader()
														.setQuote('\"')
														.setEscape('\\')
														.build()
														.parse(in);

		ArrayList<Recipe> recipes = new ArrayList<Recipe>();
		for (CSVRecord record : records) {
			// less verbose way, but also less human eyes friendly
//			int cookingMinutesTemp = Integer.parseInt(record.get(0));
//			boolean dairyFreeTemp = Boolean.parseBoolean(record.get(1));
//			boolean glutenFreeTemp = Boolean.parseBoolean(record.get(2));
//			String instructionsTemp = record.get(3);

			Integer cookingMinutes = Integer.parseInt(record.get("Cooking Minutes"));
			boolean dairyFree = Boolean.parseBoolean(record.get("Dairy Free"));
			boolean glutenFree = Boolean.parseBoolean(record.get("Gluten Free"));
			String instructions = record.get("Instructions");
			Double preparationMinutes = Double.parseDouble(record.get("Preparation Minutes"));
			Double pricePerServing = Double.parseDouble(record.get("Price Per Serving"));
			Integer readyInMinutes = Integer.parseInt(record.get("Ready In Minutes"));
			Integer servings = Integer.parseInt(record.get("Servings"));
			Double spoonacularScore = Double.parseDouble(record.get("Spoonacular Score"));
			String title = record.get("Title");
			boolean vegan = Boolean.parseBoolean(record.get("Vegan"));
			boolean vegetarian = Boolean.parseBoolean(record.get("Vegetarian"));

			Recipe tempObj = new Recipe(cookingMinutes, dairyFree, glutenFree, instructions, preparationMinutes,
					pricePerServing, readyInMinutes, servings, spoonacularScore, title, vegan, vegetarian);

			recipes.add(tempObj);
		}

		return recipes;
	}
	
	public ArrayList<RecipeString> fileReadertoStrings(String filename) throws IOException {
		Reader in = new FileReader(filename);
		Iterable<CSVRecord> records = CSVFormat.DEFAULT.builder()
														.setDelimiter(',')
														.setTrim(true)
														.setTrailingDelimiter(true)
														.setIgnoreSurroundingSpaces(true)
														.setSkipHeaderRecord(false)
														.setHeader()
														.setQuote('\"')
														.setEscape('\\')
														.build()
														.parse(in);

		ArrayList<RecipeString> recipes = new ArrayList<RecipeString>();
		for (CSVRecord record : records) {
			// less verbose way, but also less human eyes friendly
//			int cookingMinutesTemp = Integer.parseInt(record.get(0));
//			boolean dairyFreeTemp = Boolean.parseBoolean(record.get(1));
//			boolean glutenFreeTemp = Boolean.parseBoolean(record.get(2));
//			String instructionsTemp = record.get(3);

			String cookingMinutes = record.get("Cooking Minutes");
			String dairyFree = record.get("Dairy Free");
			String glutenFree = record.get("Gluten Free");
			String instructions = record.get("Instructions");
			String preparationMinutes = record.get("Preparation Minutes");
			String pricePerServing = record.get("Price Per Serving");
			String readyInMinutes = record.get("Ready In Minutes");
			String servings = record.get("Servings");
			String spoonacularScore = record.get("Spoonacular Score");
			String title = record.get("Title");
			String vegan = record.get("Vegan");
			String vegetarian = record.get("Vegetarian");

			RecipeString tempObj = new RecipeString(cookingMinutes, dairyFree, glutenFree, instructions, preparationMinutes,
					pricePerServing, readyInMinutes, servings, spoonacularScore, title, vegan, vegetarian);

			recipes.add(tempObj);
		}

		return recipes;
	}
}
