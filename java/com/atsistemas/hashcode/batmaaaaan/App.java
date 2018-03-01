package com.atsistemas.hashcode.batmaaaaan;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App 
{
	
	final String FILENAME = "";
	final String PARTIAL_SOLUTION = "";
	
	public static void main(String[] args) {

	    final Logger LOGGER = LoggerFactory.getLogger(App.class);

		Solution solution = new Solution("files/input/"+FILENAME, "files/input/"+PARTIAL_SOLUTION);
		solution.optimize();
		solution.evaluate();
		solution.mutate();
		solution.save();
	}
}
