package com.atsistemas.hashcode.batmaaaaan;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.atsistemas.hashcode.pizza.Celda;

public class Solution {
    private static final Logger LOGGER = LoggerFactory.getLogger(Solution.class);

    private Integer puntuacion = 0;

    public Solution(String inputFile, String candidate) {

        try (FileReader fileReader = new FileReader(inputFile)) {
            BufferedReader br = new BufferedReader(fileReader);
            br.readLine();
//            List<List<Celda>> celdas = new ArrayList<>();
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
        try (FileWriter fileWriter = new FileWriter(new File("files/" + folder + "/"+puntuacion + "-" + new Date() + ".txt"))) {
        	fileWriter.write(solucion.toString());
        } catch (IOException e) {
			LOGGER.error(e.getMessage());
		}
	}
	
}
