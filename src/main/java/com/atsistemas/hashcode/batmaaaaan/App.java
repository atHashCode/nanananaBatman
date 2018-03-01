package com.atsistemas.hashcode.batmaaaaan;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App 
{
	
	final static String FILENAME = "a_example";
	final static String PARTIAL_SOLUTION = "";
	
	public static void main(String[] args) {

	    final Logger LOGGER = LoggerFactory.getLogger(App.class);

	   
		Solution solution;
		try {
			solution = new Solution();
			solution.cargaInicial("files/input/a_example.in");
			solution = new Solution("files/input/"+FILENAME, "files/input/"+PARTIAL_SOLUTION);

			solution.optimize();
			solution.evaluate();
			solution.mutate();
			solution.saveSolution();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
