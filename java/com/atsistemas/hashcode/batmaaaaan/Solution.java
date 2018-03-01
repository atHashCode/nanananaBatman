package com.atsistemas.hashcode.batmaaaaan;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Solution {
    private static final Logger LOGGER = LoggerFactory.getLogger(Solution.class);
    
    private List<List<String>> cars;
//
    private Integer puntuacion = 0;
    
    private Integer carsNumber = 0;
    private Integer raceNumber = 0;

    public Solution(String inputFile, String candidate) {

        try (FileReader fileReader = new FileReader(inputFile)) {
            BufferedReader br = new BufferedReader(fileReader);
            br.readLine();
            List<List<Celda>> cars = new ArrayList<>();
            int row = 0;
            String fileLine;
            while ((fileLine = br.readLine()) != null) {
//                List<Celda> fila = new ArrayList<>();
//                for (int column = 0; column < fileLine.length(); column++) {
//                    Character literal = fileLine.charAt(column);
//
//                    fila.add(new Celda(row, column, literal.toString()));
//                }
//                celdas.add(fila);
                row++;
            }
        }
 
    }
    
	public void generateSolution() {
		
		for (int i=0; i< raceNumber ;i++)
			cars.get(new Random().nextInt(carsNumber)).add(i)
	}


	public void optimize() {

	}

	
	public void evaluate() {
		puntuacion = 0;

	}
	
	public void mutate() {

	}
	
	public void saveSolution() {
		save("solutions");
	}
	
	public void saveOutput() {
		save("output");
	}
	
	private void save(String folder) {
		
		StringBuilder result = new StringBuilder(10);
		result.append(porciones.size()).append("\n");
		for (List<String> car : cars) {
			result.append(car.size() + " ");
			result.append(String.join(" ", car));
			result.append("\n");
		}
		
        try (FileWriter fileWriter = new FileWriter(new File("files/" + folder + "/"+puntuacion + "-" + new Date() + ".txt"))) {
        	fileWriter.write(result);
        } catch (IOException e) {
			LOGGER.error(e.getMessage());
		}
	}
	
}
