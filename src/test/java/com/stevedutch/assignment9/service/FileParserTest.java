package com.stevedutch.assignment9.service;

import java.io.IOException;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

import com.stevedutch.assignment9.domain.Recipe;

class FileParserTest {

	@Test
	void parseInFile() throws IOException {
		FileParser sut = new FileParser();
		String testFile = "recipes.txt";

		ArrayList<Recipe> check = sut.fileReader(testFile);
		check.getClass();	
		
}
}