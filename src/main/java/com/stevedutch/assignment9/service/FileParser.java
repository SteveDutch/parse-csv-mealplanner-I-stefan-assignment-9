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
		Iterable<CSVRecord> records = CSVFormat.DEFAULT.builder()
				
				.setDelimiter(',').setTrim(true).setTrailingDelimiter(true)
				.setIgnoreSurroundingSpaces(true)
				.setSkipHeaderRecord(false).setHeader()
				 .setQuote('\"') 
				/* .setEscape('\"') */

				.build().parse(in);
		int n = 1;
		System.out.println(java.nio.charset.Charset.defaultCharset());
		for (CSVRecord record : records) {
			int cookingMinutesTemp = Integer.parseInt(record.get(0));
			boolean dairyFreeTemp = Boolean.parseBoolean(record.get(1));
			boolean glutenFreeTemp = Boolean.parseBoolean(record.get(2));
			String instructionsTemp = record.get(3);
			n++;
//			int cookingMinutes = Integer.parseInt(record.get("Cooking Minutes"));
//			boolean dairyFree = Boolean.parseBoolean(record.get("Dairy Free"));
//			boolean glutenFree = Boolean.parseBoolean(record.get("Gluten Free"));
			System.out.println(cookingMinutesTemp + "\n" +n);
//			System.out.println(dairyFree);
		}

		System.out.println(records.getClass());
		return records;
	}

}
