package onelife.maingame;

import java.awt.Font;
import java.awt.Graphics;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import com.sun.glass.events.KeyEvent;

import edu.virginia.engine.display.DisplayObjectContainer;
import edu.virginia.engine.display.Sprite;
import edu.virginia.engine.util.LeaderBoardManager;
import javafx.util.Pair;

public class SplashLeaderboard extends DisplayObjectContainer {
	private LeaderBoardManager lbm;
	private final String FILENAME = "resources" + File.separator + "highscores.txt";
	private ArrayList<Pair<String, Double> > timeHighScores = new ArrayList<Pair<String, Double> >();
	private ArrayList<Pair<String, Integer> > pointsHighScores = new ArrayList<Pair<String, Integer> >();
	private Scanner sc = null;
	
	private boolean currentSelect = false; //false = try again, true = quit
	
	public SplashLeaderboard() {
		
	}
	
	public SplashLeaderboard(String name, double time, int points) {
		super("Splash Leaderboard");
		Sprite background = new Sprite("Leaderboard", "splashleaderboard.png");
		
		this.addChild(background, this);
		
		lbm = new LeaderBoardManager();
		try {
			lbm.addNewScore(time, points, name);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		readFile();
	}
	
	@Override
	public void update(ArrayList<Integer> pressedKeys) {
		super.update(pressedKeys);
		
		for (int i = 0; i < pressedKeys.size(); i++) {
			if (pressedKeys.get(i).equals(KeyEvent.VK_LEFT) || pressedKeys.get(i).equals(KeyEvent.VK_RIGHT)) {
				currentSelect = !currentSelect;
				pressedKeys.clear();
			}
			else if (pressedKeys.get(i).equals(KeyEvent.VK_ENTER)) {
				this.setVisible(false);
				pressedKeys.clear();
			}
		}
	}
	
	@Override
	public void draw(Graphics g) {
		super.draw(g);
		
		int min = Math.min(10, timeHighScores.size());
		g.setFont(new Font(g.getFont().getFontName(), g.getFont().getStyle(), 24));
		for (int i = 0; i < min; i++) {
			g.drawString(timeHighScores.get(i).getKey() + ":   " + timeHighScores.get(i).getValue(), 110, (i * 29) + 328);
		}
		
		min = Math.min(10, pointsHighScores.size());
		for (int i = 0; i < min; i++) {
			g.drawString(pointsHighScores.get(i).getKey() + ":   " + pointsHighScores.get(i).getValue(), 515, (i * 29) + 330);
		}
		
		if (!currentSelect) 
			g.drawRect(100, 615, 270, 50);
		else
			g.drawRect(530, 615, 125, 50);
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
	
	public boolean getCurrentSelect() {
		return currentSelect;
	}
}
