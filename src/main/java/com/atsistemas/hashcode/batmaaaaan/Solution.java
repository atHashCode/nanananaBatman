package com.atsistemas.hashcode.batmaaaaan;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
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
    private List<Ride> carreras = new ArrayList<>();
    private Integer puntuacion = 0;
    
    private Integer carsNumber = 0;
    private Integer raceNumber = 0;

    public Solution(String inputFile, String candidate) throws FileNotFoundException, IOException {

        try (FileReader fileReader = new FileReader(inputFile)) {
            BufferedReader br = new BufferedReader(fileReader);
            String fileLine = br.readLine();
            String datos[] = fileLine.split(" ");
            carsNumber = Integer.parseInt(datos[2]);
            raceNumber = Integer.parseInt(datos[3]);
            while ((fileLine = br.readLine()) != null) {
            	datos  = fileLine.split(" ");
            	carreras.add(new Ride(Integer.parseInt(datos[0]),Integer.parseInt(datos[1]),
            	Integer.parseInt(datos[2]),Integer.parseInt(datos[3]),
            	Integer.parseInt(datos[4]),Integer.parseInt(datos[5])));
            }
        }
 
    }
    
	public void generateSolution() {
		
		for (int i=0; i< raceNumber ;i++)
			cars.get(new Random().nextInt(carsNumber)).add(i+"");
	}

    public Solution() {
    }
    
    public void cargaInicial(String inputFile) throws FileNotFoundException, IOException {

        try (FileReader fileReader = new FileReader(inputFile)) {
            BufferedReader br = new BufferedReader(fileReader);
            String fileLine = br.readLine();
            String [] datos = fileLine.split(" ");
            carsNumber = Integer.parseInt(datos[2]);
            raceNumber = Integer.parseInt(datos[3]);
            while ((fileLine = br.readLine()) != null) {
            		List<Ride> fila = new ArrayList<>();
            		datos = fileLine.split(" ");
            		fila.add(new Ride(Integer.parseInt(datos[0]),Integer.parseInt(datos[1]),
            				Integer.parseInt(datos[2]),Integer.parseInt(datos[3]),
            				Integer.parseInt(datos[4]),Integer.parseInt(datos[5])));
            		
            }
        }
 
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
		for (List<String> car : cars) {
			result.append(car.size() + " ");
			result.append(String.join(" ", car));
			result.append("\n");
		}
		
        try (FileWriter fileWriter = new FileWriter(new File("files/" + folder + "/"+puntuacion + "-" + new Date() + ".txt"))) {
        	fileWriter.write(result.toString());
        } catch (IOException e) {
			LOGGER.error(e.getMessage());
		}
	}
	
}
