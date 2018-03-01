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
//			solution = new Solution();
//			solution.cargaInicial("files/input/a_example.in");
			solution = new Solution(FILENAME, PARTIAL_SOLUTION);
			solution.generateSolution();
			solution.optimize();
			solution.evaluate();
			solution.mutate();
			solution.saveSolution();

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
