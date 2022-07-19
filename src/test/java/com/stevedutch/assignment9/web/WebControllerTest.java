package com.stevedutch.assignment9.web;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.stevedutch.assignment9.domain.Recipe;
import com.stevedutch.assignment9.service.FileParser;

class WebControllerTest {

	@Test
	//since it's a RestController only objects are returned, so a huge String objct would be the solution
	void should_put_filtered_recipes_in_a_readable_String() throws IOException {
		FileParser sut = new FileParser();
		String recipes = "recipes.txt";
		ArrayList<Recipe> testCase = sut.fileReader(recipes);
		
		System.out.println(testCase);
	}

}
