package com.stevedutch.assignment9.service;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.commons.csv.CSVRecord;
import org.junit.jupiter.api.Test;

import com.stevedutch.assignment9.domain.Recipe;

class FileParserTest {

	@Test
	void parseInFile() throws IOException {
		FileParser sut = new FileParser();
		String testFile = "recipes.txt";

		ArrayList<Recipe> check = sut.fileReader(testFile);
		 
//		 boolean exspectedResult = check.get();
			
		
}
}