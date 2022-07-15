package com.stevedutch.assignment9.service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import com.stevedutch.assignment9.domain.Recipe;

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
	
		//show saved encoding for txt.file
//		System.out.println(java.nio.charset.Charset.defaultCharset());
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
						
//			System.out.println(preparationMinutes + "\n" +n);
//			System.out.println(dairyFree);
			
			Recipe tempObj = new Recipe(cookingMinutes, dairyFree, glutenFree, instructions, 
					preparationMinutes, pricePerServing, readyInMinutes, servings, 
					spoonacularScore, title, vegan, vegetarian);
//			System.out.println(tempObj);

			recipes.add(tempObj);
			
		}

		System.out.println(records.getClass());
	
		return recipes;
	}
	
	public List<String> readFile (String filename) throws IOException {

		return Files.readAllLines(Paths.get(filename));
	}
}
