package onelife.maingame;

import java.awt.Graphics;
import java.io.IOException;
import java.util.ArrayList;

import edu.virginia.engine.display.DisplayObject;
import edu.virginia.engine.display.Game;
import edu.virginia.engine.display.SoundManager;
import edu.virginia.engine.util.GameClock;


//class that holds all the splash screens and levels
//this is the "main game loop" if you will
public class GameManager extends Game {

	//all splash screens and levels
	private ArrayList<DisplayObject> screens = new ArrayList<DisplayObject>();
	
	//final variables to reference order in which screens are added to arraylist
	private final int START_SCREEN = 0;
	private final int CONTROLS_SCREEN = 1;
	private final int TIPS_SCREEN = 2;
	private final int TUTORIAL = 3;
	private final int PROTOTYPE = 4;
	private final int LEVEL_2 = 5;
	private final int LEVEL_3 = 6;
	private final int VICTORY_SCREEN = 7;
	private final int GAME_OVER_SCREEN = 8;
	private final int LEADERBOARD_SCREEN = 9;
	
	private GameClock timer;
	
	private SplashStart start;
	private SplashControls controls;
	private SplashTips tips;
	private testLevel tutorial;
	private Prototype prototype;
	private LevelTwo levelTwo;
	private LevelThree levelThree;
	private SplashVictory victory;
	private SplashGameOver gameOver;
	private SplashLeaderboard leaderboard;
	
	//current screen should start at start screen to begin game
	private int currScreen = START_SCREEN;
	
	public GameManager() {
		super("One Life!", 820, 670);	//call Game's constructor, create a window/jpanel etc
		
		//initialize all of the splash screens and levels
		//set to invisible to start so they aren't drawn/waste processing power
		start = new SplashStart();
		controls = new SplashControls();
		tips = new SplashTips();
		tutorial = new testLevel();
		tutorial.setVisible(false);
		prototype = new Prototype();
		prototype.setVisible(false);
		levelTwo = new LevelTwo();
		levelTwo.setVisible(false);
		levelThree = new LevelThree();
		levelThree.setVisible(false);
		victory = new SplashVictory();
		gameOver = new SplashGameOver();
		tutorial.pr = prototype;
		prototype.lt = levelTwo;
		levelTwo.l3 = levelThree;
		
		//add them to list of screens
		screens.add(start);
		screens.add(controls);
		screens.add(tips);
		screens.add(tutorial);
		screens.add(prototype);
		screens.add(levelTwo);
		screens.add(levelThree);
		screens.add(victory);
		screens.add(gameOver);
		
		//begin game!
		timer = new GameClock();
		this.start(currScreen);
	}
	
	//getter
	public ArrayList<DisplayObject> getScreens() {
		return screens;
	}
	
	//method that ends the current screen at start the next one
	//only one child at a time, so only drawing one screen at a time
	public void start(int screen) {
		if (screen >= screens.size()) //if at end screen (victory/game over), can't go forward
			return;
		
		this.removeAllChildren();
		screens.get(screen).setVisible(true);
		this.addChild(screens.get(screen), this);
	}
	
	//"main game loop"
	//GameManager determines if a screen is done and ready to go to next screen
	//if that screen's visibility has been set to false
	@Override
	public void update(ArrayList<Integer> pressedKeys) {
		super.update(pressedKeys);
		
		//on start screen, and screen is invisible indicating time to move forward
		if (currScreen == START_SCREEN && !screens.get(currScreen).isVisible()) {
			//if the user didn't click to go to control screen, then set screen equal to tutorial (first level)
			if (!((SplashStart) screens.get(currScreen)).toControls()) {
				currScreen = TIPS_SCREEN;
				start(currScreen);
				return;
			}
			//otherwise, send them to the controls screen
			else {
				super.pressedKeys.clear();
				((SplashControls) screens.get(CONTROLS_SCREEN)).setPressed(false);
				screens.get(CONTROLS_SCREEN).setVisible(true);
				currScreen = CONTROLS_SCREEN;
				start(currScreen);
				return;
			}
		}
		//on controls screen, going back to start screen
		else if (currScreen == CONTROLS_SCREEN && !screens.get(currScreen).isVisible()) {
			super.pressedKeys.clear();
			screens.get(START_SCREEN).setVisible(true);
			((SplashStart) screens.get(START_SCREEN)).setToControls(false);
			currScreen = START_SCREEN;
			start(currScreen);
			return;
		}
		else if (currScreen == TIPS_SCREEN && !screens.get(currScreen).isVisible()) {
			currScreen = TUTORIAL;
			start(currScreen);
			return;
		}
		else if (currScreen == VICTORY_SCREEN && !screens.get(currScreen).isVisible()) {
			leaderboard = new SplashLeaderboard(((SplashVictory) screens.get(currScreen)).getPlayerName(), 
					timer.getElapsedTime() / 1000, ((LevelThree) screens.get(LEVEL_3)).getFinalScore());
			if (screens.size() > 9)
				screens.remove(LEADERBOARD_SCREEN);
			screens.add(LEADERBOARD_SCREEN, leaderboard);
			screens.add(leaderboard);
			currScreen = LEADERBOARD_SCREEN;
			start(currScreen);
			return;
		}
		//if on leaderboard screen and want to play again, set start screen as next
		//and reset game timer. otherwise quit the game
		else if (currScreen == LEADERBOARD_SCREEN && !screens.get(currScreen).isVisible()) {
			if (((SplashLeaderboard) screens.get(currScreen)).getCurrentSelect())
				this.exitGame();
			else {
				currScreen = START_SCREEN;
				tutorial = new testLevel();
				prototype = new Prototype();
				levelTwo = new LevelTwo();
				levelThree = new LevelThree();
				tutorial.pr = prototype;
				prototype.lt = levelTwo;
				levelTwo.l3 = levelThree;
				screens.remove(TUTORIAL);
				screens.add(TUTORIAL, tutorial);
				screens.remove(PROTOTYPE);
				screens.add(PROTOTYPE, prototype);
				screens.remove(LEVEL_2);
				screens.add(LEVEL_2, levelTwo);
				screens.remove(LEVEL_3);
				screens.add(LEVEL_3, levelThree);
				start(currScreen);
				timer = new GameClock();
				return;
			}
		}
		//do the same if on game over screen
		else if (currScreen == GAME_OVER_SCREEN && !screens.get(currScreen).isVisible()) {
			if (((SplashGameOver) screens.get(currScreen)).getCurrentSelect())
				this.exitGame();
			else {
				currScreen = START_SCREEN;
				tutorial = new testLevel();
				prototype = new Prototype();
				levelTwo = new LevelTwo();
				levelThree = new LevelThree();
				tutorial.pr = prototype;
				prototype.lt = levelTwo;
				levelTwo.l3 = levelThree;
				screens.remove(TUTORIAL);
				screens.add(TUTORIAL, tutorial);
				screens.remove(PROTOTYPE);
				screens.add(PROTOTYPE, prototype);
				screens.remove(LEVEL_2);
				screens.add(LEVEL_2, levelTwo);
				screens.remove(LEVEL_3);
				screens.add(LEVEL_3, levelThree);
				start(currScreen);
				timer = new GameClock();
				return;
			}
		}
		//otherwise, non-special case. if they're on a level and beaten it, advance to
		//next level. otherwise send to game over screen
		//if currScreen = last level and beaten, send to victory
		else if (currScreen < screens.size()) {
			//if currently in a level
			if (currScreen == TUTORIAL || currScreen == LEVEL_2 || currScreen == LEVEL_3 || currScreen == PROTOTYPE) {
				//if all Tails are dead (or predetermined number of Tails dead necessary for a loss on that level)
				//send to game over
				if (((Level) screens.get(currScreen)).getAllDead()) {
					screens.get(currScreen).setVisible(false);
					currScreen = GAME_OVER_SCREEN;
					start(currScreen);
				}
				//otherwise, if not visible aka ready to move on and not dead, go to next level (or victory if on last level)
				else if (currScreen == LEVEL_3 && !screens.get(currScreen).isVisible()) {
					((SplashVictory) screens.get(VICTORY_SCREEN)).startTimer();
					currScreen++;
					start(currScreen);
				}
				else if (!screens.get(currScreen).isVisible()) {
					currScreen++;
					start(currScreen);
				}
			}
			//otherwise, progress to next screen
			else if (!screens.get(currScreen).isVisible()) {
				currScreen++;
				start(currScreen);
			}
		}
		else
			System.out.println("ERROR!");
	}
	
	@Override
	public void draw(Graphics g) {
		super.draw(g);
	}
	
	//main method that runs the game
	public static void main(String[] args) throws IOException {
		GameManager onelife = new GameManager();
		onelife.start();
		SoundManager song = new SoundManager();
		song.playSound("TailsTheme.wav");
	}
}
