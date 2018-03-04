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
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Solution {
	private static final Logger LOGGER = LoggerFactory.getLogger(Solution.class);

	ArrayList<Car> cars;

	private List<Ride> carreras = new ArrayList<>();
	private Integer puntuacion = 0;

	private Integer carsNumber = 800;
	private Integer raceNumber = 1000;
	private Integer bonus = 1000;
	private Integer limit = 1000;
	private String inputFile = "";
	private Score score;

	public Solution(String inputFile) throws FileNotFoundException, IOException {

		this.inputFile = inputFile;
		inputFile = "files/input/"+ inputFile;
		int indice = 0;
		try (FileReader fileReader = new FileReader(inputFile)) {
			BufferedReader br = new BufferedReader(fileReader);
			String fileLine = br.readLine();
			String [] datos = fileLine.split(" ");
			carsNumber = Integer.parseInt(datos[2]);
			raceNumber = Integer.parseInt(datos[3]);
			bonus = Integer.parseInt(datos[4]);
			limit = Integer.parseInt(datos[5]);
			while ((fileLine = br.readLine()) != null) {
				datos = fileLine.split(" ");
				carreras.add(new Ride(indice++, Integer.parseInt(datos[0]),Integer.parseInt(datos[1]),
						Integer.parseInt(datos[2]),Integer.parseInt(datos[3]),
						Integer.parseInt(datos[4]),Integer.parseInt(datos[5])));

			}
		}

		score = new Score(carreras,bonus,limit);

	}
	public Solution(String inputFile, String solucionParcial) throws FileNotFoundException, IOException {

		this.inputFile = inputFile;
		inputFile = "files/input/"+ inputFile;
		int indice = 0;
		try (FileReader fileReader = new FileReader(inputFile)) {
			BufferedReader br = new BufferedReader(fileReader);
			String fileLine = br.readLine();
			String [] datos = fileLine.split(" ");
			carsNumber = Integer.parseInt(datos[2]);
			raceNumber = Integer.parseInt(datos[3]);
			bonus = Integer.parseInt(datos[4]);
			limit = Integer.parseInt(datos[5]);
			while ((fileLine = br.readLine()) != null) {
				datos = fileLine.split(" ");
				carreras.add(new Ride(indice++, Integer.parseInt(datos[0]),Integer.parseInt(datos[1]),
						Integer.parseInt(datos[2]),Integer.parseInt(datos[3]),
						Integer.parseInt(datos[4]),Integer.parseInt(datos[5])));

			}
		}
		cars = new ArrayList<>();
		String parcialinputFile = "files/input/"+ solucionParcial;
		try (FileReader fileReader = new FileReader(parcialinputFile)) {
			BufferedReader br = new BufferedReader(fileReader);
			String fileLine;
			while ((fileLine = br.readLine()) != null) {
				ArrayList<Ride> carrerasCoche = new ArrayList<>();
				String datos[] = fileLine.split(" ");
				for (int i=1; i<datos.length;i++){
					carrerasCoche.add(carreras.get(Integer.parseInt(datos[i])));
				}
				Car car = new Car(carrerasCoche);
				cars.add(car);
			}
		}
		score = new Score(carreras, bonus, limit);
		evaluate();

	}
	public void generateSolution() {
		cars = new ArrayList<Car>();
		List<Ride> carrerasSolucion = new ArrayList<>();
		Collections.shuffle(carrerasSolucion, new Random(System.nanoTime()));
		carrerasSolucion.addAll(carreras);
		Posicion inicio = new Posicion(0,0);
		for (int i=0; i< carsNumber ;i++) {
			Car car = new Car();
			Ride primeraCarrera = carrerasSolucion.get((int) ((Math.random() * carrerasSolucion.size())) );//mejorCarrera(carrerasSolucion, inicio, 0);
			if (primeraCarrera == null) {
				primeraCarrera = carrerasSolucion.get((int) ((Math.random() * carrerasSolucion.size())) );
			}
			if (primeraCarrera != null) {
				car.addCarrera(primeraCarrera);
				carrerasSolucion.remove(primeraCarrera);
			}
			cars.add(car);
		}
		while (! carrerasSolucion.isEmpty()) {
			for (Car car: cars) {
				Ride mejorCarrera = mejorCarrera(carrerasSolucion, car.getUltimaPosicion(), car.getUltimoStep());
				if (mejorCarrera != null) {
					car.addCarrera(mejorCarrera);
					carrerasSolucion.remove(mejorCarrera);
				}
			}
		}		
	}

	private Ride mejorCarrera(List<Ride> carrerasSolucion, Posicion posicion, Integer step) {
		Integer mejorScore = 0;
		Ride mejorCarrera = null;
		if (!carrerasSolucion.isEmpty()) {
			mejorCarrera = carrerasSolucion.get(0);
			mejorScore = score.calculaScore(mejorCarrera, posicion, step);
		}
		for(Ride carrera: carrerasSolucion) {
			Integer scoreActual = score.calculaScore(carrera, posicion, step); 
			if (scoreActual > mejorScore) {
				mejorCarrera = carrera;
				mejorScore = scoreActual;
			} else if (scoreActual.equals(mejorScore) && new Random().nextBoolean()) {
				mejorCarrera = carrera;
				mejorScore = scoreActual;
			}
		}
		return mejorCarrera;
	}

	public void optimize() {

	}


	public Integer evaluate() {
		puntuacion = 0;
		for (Car car : cars) {
			Integer carValue =  score.calculaScore(car);
			//			LOGGER.info("Car " + i + " gets -> " +carValue);
			puntuacion += carValue;
		}
		return puntuacion;
	}

	public void mutate() {

		//		for (List car : cars) {
		//			long seed = System.nanoTime();
		//			Collections.shuffle(car, new Random(seed));
		//		}

	}

	public void saveSolution() {
		save("solutions");
	}

	public void saveOutput() {
		save("output");
	}

	public void save(String folder) {
		StringBuilder result = new StringBuilder(10);
		for (Car car : cars) {
			List<Ride> carreras = car.getCarreras();
			result.append(carreras.size() + " ");
			for (Ride carrera: carreras) {
				result.append(carrera.getIndice() + " ");
			}
			result.append("\n");
		}

		try (FileWriter fileWriter = new FileWriter(new File("files/" + folder + "/"+ inputFile + "-" + evaluate() + "-" + Math.random() + ".txt"))) {
			fileWriter.write(result.toString());
		} catch (IOException e) {
			LOGGER.error(e.getMessage());
		}
	}


	public String getFilename() {
		return inputFile;
	}

}
