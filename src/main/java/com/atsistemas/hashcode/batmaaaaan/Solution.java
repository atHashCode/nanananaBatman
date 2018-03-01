package com.atsistemas.hashcode.batmaaaaan;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Solution {
    private static final Logger LOGGER = LoggerFactory.getLogger(Solution.class);

    ArrayList<ArrayList<String>> cars;

    private List<Ride> carreras = new ArrayList<>();
    private Integer puntuacion = 0;
    
    private Integer carsNumber = 800;
    private Integer raceNumber = 1000;
    private Integer bonus = 1000;
    private String inputFile = "";
    private Score score;

    public Solution(String inputFile, String candidate) throws FileNotFoundException, IOException {

    	this.inputFile = inputFile;
    	inputFile = "files/input/"+ inputFile;
        try (FileReader fileReader = new FileReader(inputFile)) {
            BufferedReader br = new BufferedReader(fileReader);
            String fileLine = br.readLine();
            String [] datos = fileLine.split(" ");
            carsNumber = Integer.parseInt(datos[2]);
            raceNumber = Integer.parseInt(datos[3]);
            bonus = Integer.parseInt(datos[4]);
            while ((fileLine = br.readLine()) != null) {
            		List<Ride> fila = new ArrayList<>();
            		datos = fileLine.split(" ");
            		carreras.add(new Ride(Integer.parseInt(datos[0]),Integer.parseInt(datos[1]),
            				Integer.parseInt(datos[2]),Integer.parseInt(datos[3]),
            				Integer.parseInt(datos[4]),Integer.parseInt(datos[5])));
            		
            }
        }
        
        score = new Score(carreras,bonus);
 
    }
    
	public void generateSolution() {
		cars = new ArrayList<ArrayList<String>>();
		for (int i=0; i< carsNumber ;i++) {
			cars.add(new ArrayList<String>());
		}
		for (int i=0; i< raceNumber ;i++) {
			
			List <String> car = cars.get(new Random().nextInt(carsNumber));
			if (car == null) car = new ArrayList();
			
			cars.get(new Random().nextInt(carsNumber)).add(i+"");
		}
	}

    
	public void optimize() {

	}

	
	public void evaluate() {
		puntuacion = 0;
		for (List car : cars) {
			puntuacion += score.calculaScore(car);
		}

	}
	
	public void mutate() {
		
		for (List car : cars) {
			long seed = System.nanoTime();
			Collections.shuffle(car, new Random(seed));
		}

	}
	
	public void saveSolution() {
		save("solutions");
	}
	
	public void saveOutput() {
		save("output");
	}
	
	private void save(String folder) {
		
		StringBuilder result = new StringBuilder(10);
		for (List<String> car : cars) {
			result.append(car.size() + " ");
			result.append(String.join(" ", car));
			result.append("\n");
		}
		
        try (FileWriter fileWriter = new FileWriter(new File("files/" + folder + "/"+ inputFile + "-" + puntuacion + "-" + new Date() + ".txt"))) {
        	fileWriter.write(result.toString());
        } catch (IOException e) {
			LOGGER.error(e.getMessage());
		}
	}
	
}
