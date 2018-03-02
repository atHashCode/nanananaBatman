package com.atsistemas.hashcode.batmaaaaan;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App 
{
	
	final static String FILENAME = "a_example.in";
	final static String PARTIAL_SOLUTION = "";
	final static Integer RETRIES = 1000;
	
	public static void main(String[] args) throws FileNotFoundException, IOException {

	    final Logger LOGGER = LoggerFactory.getLogger(App.class);
	    Integer puntuacion = 0;
	    Integer nuevaPuntuacion = 0;

		Solution finalSolutionS = new Solution("d_metropolis.in", "d_metropolis.txt", PARTIAL_SOLUTION);
		finalSolutionS.evaluate();
		Solution finalSolution = new Solution("a_example.in", PARTIAL_SOLUTION);
		try {			for (int i = 0; i<RETRIES; i++) {
			Solution solution = new Solution("e_high_bonus.in", PARTIAL_SOLUTION);
			solution.generateSolution();
			solution.optimize();
			nuevaPuntuacion = solution.evaluate();
			solution.mutate();

			if (nuevaPuntuacion>=puntuacion)  { 
				LOGGER.info("DING!!! on " + i + " - " + (nuevaPuntuacion-puntuacion) + " - " + solution.getFilename());
				puntuacion = nuevaPuntuacion;
				finalSolution = solution;
			}
		}
		    puntuacion = 0;
			for (int i = 0; i<RETRIES; i++) {
				Solution solution = new Solution("d_metropolis.in", PARTIAL_SOLUTION);
				solution.generateSolution();
				solution.optimize();
				nuevaPuntuacion = solution.evaluate();
				solution.mutate();
				
				if (nuevaPuntuacion>=puntuacion)  { 
					LOGGER.info("DING!!! on " + i + " - " + (nuevaPuntuacion-puntuacion) + " - " + solution.getFilename());
					puntuacion = nuevaPuntuacion;
					finalSolution = solution;
				}
			}
			finalSolution.saveOutput();
			for (int i = 0; i<RETRIES; i++) {
				Solution solution = new Solution("c_no_hurry.in", PARTIAL_SOLUTION);
				solution.generateSolution();
				solution.optimize();
				nuevaPuntuacion = solution.evaluate();
				solution.mutate();
				solution.saveOutput();
				if (nuevaPuntuacion>=puntuacion)  { 
					LOGGER.info("DING!!! on " + i + " - " + (nuevaPuntuacion-puntuacion) + " - " + solution.getFilename());
					puntuacion = nuevaPuntuacion;
					finalSolution = solution;
				}
			}
			finalSolution.saveOutput();


			finalSolution = new Solution("a_example.in", PARTIAL_SOLUTION);
		    puntuacion = 0;
			for (int i = 0; i<RETRIES; i++) {
				Solution solution = new Solution("b_should_be_easy.in", PARTIAL_SOLUTION);
				solution.generateSolution();
				solution.optimize();
				nuevaPuntuacion = solution.evaluate();
				solution.mutate();
				if (nuevaPuntuacion>=puntuacion)  { 
					LOGGER.info("DING!!! on " + i + " - " + (nuevaPuntuacion-puntuacion) + " - " + solution.getFilename());
					puntuacion = nuevaPuntuacion;
					finalSolution = solution;
				}
			}
			finalSolution.saveOutput();


			finalSolution = new Solution("a_example.in", PARTIAL_SOLUTION);
		    puntuacion = 0;
			for (int i = 0; i<RETRIES; i++) {
				Solution solution = new Solution("c_no_hurry.in", PARTIAL_SOLUTION);
				solution.generateSolution();
				solution.optimize();
				nuevaPuntuacion = solution.evaluate();
				solution.mutate();
				
				if (nuevaPuntuacion>=puntuacion)  { 
					LOGGER.info("DING!!! on " + i + " - " + (nuevaPuntuacion-puntuacion) + " - " + solution.getFilename());
					puntuacion = nuevaPuntuacion;
					finalSolution = solution;
				}
			}
			finalSolution.saveOutput();

		    puntuacion = 0;
			for (int i = 0; i<RETRIES; i++) {
				Solution solution = new Solution("d_metropolis.in", PARTIAL_SOLUTION);
				solution.generateSolution();
				solution.optimize();
				nuevaPuntuacion = solution.evaluate();
				solution.mutate();
				
				if (nuevaPuntuacion>=puntuacion)  { 
					LOGGER.info("DING!!! on " + i + " - " + (nuevaPuntuacion-puntuacion) + " - " + solution.getFilename());
					puntuacion = nuevaPuntuacion;
					finalSolution = solution;
				}
			}
			finalSolution.saveOutput();


			finalSolution = new Solution("a_example.in", PARTIAL_SOLUTION);
		    puntuacion = 0;
			for (int i = 0; i<RETRIES; i++) {
				Solution solution = new Solution("e_high_bonus.in", PARTIAL_SOLUTION);
				solution.generateSolution();
				solution.optimize();
				nuevaPuntuacion = solution.evaluate();
				solution.mutate();

				if (nuevaPuntuacion>=puntuacion)  { 
					LOGGER.info("DING!!! on " + i + " - " + (nuevaPuntuacion-puntuacion) + " - " + solution.getFilename());
					puntuacion = nuevaPuntuacion;
					finalSolution = solution;
				}
			}

			finalSolution.saveOutput();

			LOGGER.info("DONE!");

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
