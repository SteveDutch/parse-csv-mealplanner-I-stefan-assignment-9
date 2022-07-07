package com.stevedutch.assignment9.service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;


public class FileParser {
	
	public Iterable<CSVRecord> fileReader() throws IOException {
		Reader in = new FileReader("recipes.txt");
		Iterable<CSVRecord> records = CSVFormat.Builder
								.setIgnoreSurroundingSpaces(true)
								.setHeader()
								.setSkipHeaderRecord(false)
								.parse(in);
		for (CSVRecord record : records) {
			int cookingMinutes = Integer.parseInt(record.get("Cooking Minutes"));
			boolean dairyFree = Boolean.parseBoolean(record.get("Dairy Free"));
		}
		System.out.println(records);
		return records;
	}

}
