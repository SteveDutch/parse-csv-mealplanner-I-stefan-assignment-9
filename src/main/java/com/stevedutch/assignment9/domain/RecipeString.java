package com.stevedutch.assignment9.domain;

public class RecipeString {
	private String cookingMinutes;

    private String dairyFree;

    private String glutenFree;

    private String instructions;

    private String preparationMinutes;

    private String pricePerServing;

    private String readyInMinutes;

    private String servings;

    private String spoonacularScore;

    private String title;

    private String vegan;

    private String vegetarian;

	public RecipeString(String cookingMinutes, String dairyFree, String glutenFree, String instructions,
			String preparationMinutes, String pricePerServing, String readyInMinutes, String servings,
			String spoonacularScore, String title, String vegan, String vegetarian) {
		super();
		this.cookingMinutes = cookingMinutes;
		this.dairyFree = dairyFree;
		this.glutenFree = glutenFree;
		this.instructions = instructions;
		this.preparationMinutes = preparationMinutes;
		this.pricePerServing = pricePerServing;
		this.readyInMinutes = readyInMinutes;
		this.servings = servings;
		this.spoonacularScore = spoonacularScore;
		this.title = title;
		this.vegan = vegan;
		this.vegetarian = vegetarian;
	}

	public String getCookingMinutes() {
		return cookingMinutes;
	}

	public void setCookingMinutes(String cookingMinutes) {
		this.cookingMinutes = cookingMinutes;
	}

	public String getDairyFree() {
		return dairyFree;
	}

	public void setDairyFree(String dairyFree) {
		this.dairyFree = dairyFree;
	}

	public String getGlutenFree() {
		return glutenFree;
	}

	public void setGlutenFree(String glutenFree) {
		this.glutenFree = glutenFree;
	}

	public String getInstructions() {
		return instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}

	public String getPreparationMinutes() {
		return preparationMinutes;
	}

	public void setPreparationMinutes(String preparationMinutes) {
		this.preparationMinutes = preparationMinutes;
	}

	public String getPricePerServing() {
		return pricePerServing;
	}

	public void setPricePerServing(String pricePerServing) {
		this.pricePerServing = pricePerServing;
	}

	public String getReadyInMinutes() {
		return readyInMinutes;
	}

	public void setReadyInMinutes(String readyInMinutes) {
		this.readyInMinutes = readyInMinutes;
	}

	public String getServings() {
		return servings;
	}

	public void setServings(String servings) {
		this.servings = servings;
	}

	public String getSpoonacularScore() {
		return spoonacularScore;
	}

	public void setSpoonacularScore(String spoonacularScore) {
		this.spoonacularScore = spoonacularScore;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getVegan() {
		return vegan;
	}

	public void setVegan(String vegan) {
		this.vegan = vegan;
	}

	public String getVegetarian() {
		return vegetarian;
	}

	public void setVegetarian(String vegetarian) {
		this.vegetarian = vegetarian;
	}


}
