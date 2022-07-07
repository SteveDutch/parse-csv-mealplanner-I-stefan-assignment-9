package com.stevedutch.assignment9.service;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;

import org.apache.commons.csv.CSVRecord;
import org.junit.jupiter.api.Test;

class FileParserTest {

	@Test
	void parseInFile() throws IOException {
		FileParser sut = new FileParser();

		Iterable<CSVRecord> check = sut.fileReader();
		 
		 boolean exspectedResult = check.get();
			
		;
}
}