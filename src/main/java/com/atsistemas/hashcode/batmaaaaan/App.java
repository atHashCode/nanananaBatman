package com.atsistemas.hashcode.batmaaaaan;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App 
{
	
	final static String FILENAME = "a_example.in";
	final static String PARTIAL_SOLUTION = "";
	
	public static void main(String[] args) throws FileNotFoundException, IOException {

	    final Logger LOGGER = LoggerFactory.getLogger(App.class);
	   
		Solution solution;
		try {
			solution = new Solution("a_example.in", "a_example.in.txt", PARTIAL_SOLUTION);
//			solution = new Solution();
//			solution.cargaInicial("files/input/a_example.in");
			solution = new Solution("a_example.in", PARTIAL_SOLUTION);
			solution.generateSolution();
			solution.optimize();
			solution.evaluate();
			solution.mutate();
			solution.saveOutput();
			
			solution = new Solution("b_should_be_easy.in", PARTIAL_SOLUTION);
			solution.generateSolution();
			solution.optimize();
			solution.evaluate();
			solution.mutate();
			solution.saveOutput();
			
			solution = new Solution("c_no_hurry.in", PARTIAL_SOLUTION);
			solution.generateSolution();
			solution.optimize();
			solution.evaluate();
			solution.mutate();
			solution.saveOutput();
			
			solution = new Solution("d_metropolis.in", PARTIAL_SOLUTION);
			solution.generateSolution();
			solution.optimize();
			solution.evaluate();
			solution.mutate();
			solution.saveOutput();
			
			solution = new Solution("e_high_bonus.in", PARTIAL_SOLUTION);
			solution.generateSolution();
			solution.optimize();
			solution.evaluate();
			solution.mutate();
			solution.saveOutput();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
