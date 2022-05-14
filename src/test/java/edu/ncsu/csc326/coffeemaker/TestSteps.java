/*
 * Copyright (c) 2009,  Sarah Heckman, Laurie Williams, Dright Ho
 * All Rights Reserved.
 * 
 * Permission has been explicitly granted to the University of Minnesota 
 * Software Engineering Center to use and distribute this source for 
 * educational purposes, including delivering online education through
 * Coursera or other entities.  
 * 
 * No warranty is given regarding this software, including warranties as
 * to the correctness or completeness of this software, including 
 * fitness for purpose.
 * 
 * 
 * Modified 20171114 by Ian De Silva -- Updated to adhere to coding standards.
 * 
 */
package edu.ncsu.csc326.coffeemaker;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.But;
import cucumber.api.java.en.*;

import edu.ncsu.csc326.coffeemaker.CoffeeMaker;
import edu.ncsu.csc326.coffeemaker.UICmd.ChooseService;
import edu.ncsu.csc326.coffeemaker.UICmd.Command;
import gherkin.lexer.Th;
import org.junit.Before;

import edu.ncsu.csc326.coffeemaker.CoffeeMakerUI;
import edu.ncsu.csc326.coffeemaker.CoffeeMakerUI.Mode;

import java.util.List;

/**
 * Contains the step definitions for the cucumber tests.  This parses the 
 * Gherkin steps and translates them into meaningful test steps.
 */
public class TestSteps {
	
	private Recipe recipe1;
	private Recipe recipe2;
	private Recipe recipe3;
	private Recipe recipe4;
	private Recipe recipe5;
	private CoffeeMakerUI coffeeMakerMain; 
	private CoffeeMaker coffeeMaker;
	private RecipeBook recipeBook;

	
	private void initialize() {
		recipeBook = new RecipeBook();
		coffeeMaker = new CoffeeMaker(recipeBook, new Inventory());
		coffeeMakerMain = new CoffeeMakerUI(coffeeMaker);
	}
	@Given ("^the coffee maker is in waiting state$")
	public void the_coffeemaker_is_in_waiting_state() throws Throwable{
		assertEquals(coffeeMakerMain.getMode(),Mode.WAITING);
//		System.out.println(coffeeMakerMain.getMode());
	}
	@Given("^user picks an (.*)$")
	public void user_picks_an_option(int options) throws Throwable{
		initialize();
		//System.out.println("The User picked " + options);
		coffeeMakerMain.UI_Input(options);
	}

	@Then("^the coffee maker enters the (.*)$")
	public void theCoffeeMakerEntersTheMode(Mode modoFunc) throws Throwable {
		assertEquals(coffeeMakerMain.getMode(),modoFunc);
	}

	@And ("^the user inputs (//d)$")
	public void the_user_inputs(List<Mode> args) throws Throwable{
		initialize();
		System.out.println("the data is:" + args);
//		ChooseService button = new ChooseService(option);
//		coffeeMakerMain.UI_Input(button);
//		assertEquals(coffeeMakerMain.getMode(),Mode.DELETE_RECIPE);


	}

    @Given("^an empty recipe book$")
    public void an_empty_recipe_book() throws Throwable {
        initialize();
    }

    @Given("a default recipe book")
	public void a_default_recipe_book() throws Throwable {
    	initialize();
    	
		//Set up for r1
		recipe1 = new Recipe();
		recipe1.setName("Coffee");
		recipe1.setAmtChocolate("0");
		recipe1.setAmtCoffee("3");
		recipe1.setAmtMilk("1");
		recipe1.setAmtSugar("1");
		recipe1.setPrice("50");
		
		//Set up for r2
		recipe2 = new Recipe();
		recipe2.setName("Mocha");
		recipe2.setAmtChocolate("20");
		recipe2.setAmtCoffee("3");
		recipe2.setAmtMilk("1");
		recipe2.setAmtSugar("1");
		recipe2.setPrice("75");
		
		//Set up for r3
		recipe3 = new Recipe();
		recipe3.setName("Latte");
		recipe3.setAmtChocolate("0");
		recipe3.setAmtCoffee("3");
		recipe3.setAmtMilk("3");
		recipe3.setAmtSugar("1");
		recipe3.setPrice("100");
		
		//Set up for r4
		recipe4 = new Recipe();
		recipe4.setName("Hot Chocolate");
		recipe4.setAmtChocolate("4");
		recipe4.setAmtCoffee("0");
		recipe4.setAmtMilk("1");
		recipe4.setAmtSugar("1");
		recipe4.setPrice("65");
		
		//Set up for r5 (added by MWW)
		recipe5 = new Recipe();
		recipe5.setName("Super Hot Chocolate");
		recipe5.setAmtChocolate("6");
		recipe5.setAmtCoffee("0");
		recipe5.setAmtMilk("1");
		recipe5.setAmtSugar("1");
		recipe5.setPrice("100");

		recipeBook.addRecipe(recipe1);
		recipeBook.addRecipe(recipe2);
		recipeBook.addRecipe(recipe3);
		recipeBook.addRecipe(recipe4);
		
	}


}
