package edu.virginia.engine.util;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import javafx.util.Pair;

public class LeaderBoardManager {
	
	private final String FILENAME = "resources" + File.separator + "highscores.txt";
	
	private ArrayList<Pair<String, Double> > timeHighScores;
	private ArrayList<Pair<String, Integer> > pointsHighScores;
	private Scanner sc = null;
	private FileWriter fw = null;
	
	public LeaderBoardManager() {
		timeHighScores = new ArrayList<Pair<String, Double> >();
		pointsHighScores = new ArrayList<Pair<String, Integer> >();
	}
	
	public void addNewScore(double time, int points, String name) throws IOException {
		readFile();
		writeFile(time, points, name, fw);
	}
	
	private void readFile() {
		File f = new File(FILENAME);
		try {
			sc = new Scanner(f);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (sc == null)
			return;
		
		timeHighScores.clear();
		pointsHighScores.clear();
		
		while (sc.hasNextLine()) {
			String curr = sc.nextLine();
			String[] vals = curr.split(" ");
			if (vals[0].equals("Time")) {
				for (int i = 1; i < vals.length; i += 2) {
					timeHighScores.add(new Pair<String, Double>(vals[i], Double.parseDouble(vals[i + 1])));
				}
			}
			else if (vals[0].equals("Points")) {
				for (int i = 1; i < vals.length; i += 2) {
					pointsHighScores.add(new Pair<String, Integer>(vals[i], Integer.parseInt(vals[i + 1])));
				}
			}
			else
				System.out.println(vals[0]);
		}
	}
	
	private void writeFile(double time, int score, String name, FileWriter fw) throws IOException {
		fw = new FileWriter(FILENAME);
		
		timeHighScores.add(new Pair<String, Double>(name, time));
		pointsHighScores.add(new Pair<String, Integer>(name, score));
		
		Collections.sort(timeHighScores, new PairComparatorDouble());
		Collections.sort(pointsHighScores, new PairComparatorInteger());
		
		fw.write("Time" + " ");
		String toWrite = "";
		for (int i = 0; i < timeHighScores.size(); i++) {
			toWrite += timeHighScores.get(i).getKey() + " " + Double.toString(timeHighScores.get(i).getValue()) + " ";
		}
		fw.write(toWrite);
		fw.write("\nPoints" + " ");
		toWrite = "";
		for (int i = 0; i < pointsHighScores.size(); i++) {
			toWrite += pointsHighScores.get(i).getKey() + " " + Integer.toString(pointsHighScores.get(i).getValue()) + " ";
		}
		fw.write(toWrite);
		fw.close();
	}
	
	private class PairComparatorDouble implements Comparator<Pair<String, Double> > {

		@Override
		public int compare(Pair<String, Double> o1, Pair<String, Double> o2) {
			return Double.compare(o1.getValue(), o2.getValue());
		}
		
	}
	
	private class PairComparatorInteger implements Comparator<Pair<String, Integer> > {

		@Override
		public int compare(Pair<String, Integer> o1, Pair<String, Integer> o2) {
			return (-1 * Integer.compare(o1.getValue(), o2.getValue()));
		}
		
	}
}
