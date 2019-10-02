
/* STUDENT NAME:Ege Aral Karabulut
 * File: SuperKarelBro.java
 */

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import stanford.karel.SuperKarel;

public class SuperKarelBros extends SuperKarel {

	public void run() {

		playThemeSong(THEME_SONG);

		// Your code starts here.
		move();
		trimmingTheTree();
		reverseDownstairs();
		coinBricks();
		longPipe();
		pinkTower();
		
		// Your code ends here.

		playVictorySong(VICTORY_SONG);
	}

	/** Helper Methods */
	// Your code starts here.
       private void trimmingTheTree() {
    	   while (frontIsClear())  {
    		   move();
    	   }
    	   if (frontIsBlocked()) {
			   turnLeft();
		   }
    	  while (rightIsBlocked()) {
    		  move();
    		  if (cornerColorIs(RED)) {
    			  paintCorner(CYAN);
    		  }
    	  }
    	  turnRight();
    	  move();
    	  while (rightIsBlocked()) {
    		  if(cornerColorIs(RED)) {
    			  paintCorner(CYAN);
    		  }
    		  move();
    	  }
    	  if (cornerColorIs(RED)) {
    		  paintCorner(CYAN);
    	  }
    	  turnRight();
    	  move();
    	  while (rightIsBlocked()) {
    		  move();
    		  if (cornerColorIs(RED)) {
    			  paintCorner(CYAN);
    		  }
    		  if (frontIsBlocked()) {
    			  turnLeft();
    		  }
    	  }
    		  
       }
       
       
       
       private void reverseDownstairs() {
    	   turnRight();
    	   move();
    	   move();
    	   while(rightIsClear()) {
    		   turnRight();
    		   move();
    		   turnLeft();
    		   move();
    	   }
    		   

       }
       
       
       private void coinBricks() {
    	   while (rightIsBlocked()) {
    		   move();
    	   }
    	   move();
    	   while (true) {
    		   turnLeft();
    		   while (!cornerColorIs(YELLOW)) {
    			   move();
    		   }
    		   paintCorner(CYAN);
    		   turnAround();
    		   if (beepersPresent()) {
    			   pickBeeper();
    			   break;
    		   }
    		   findWall();
    		   turnLeft();
    		   move();
    	   }
    	  findWall();
    	  turnLeft();
    	  findWall();
       }
       
       
       private void longPipe() {
    	   turnLeft();
    	   while (rightIsBlocked()) {
    		   move();
    	   }
    	   turnRight(); 
    	   move();
    	   turnRight();
    	   move();
    	   while (cornerColorIs(GREEN)) {
    		  safeBeeper();
    		  if (frontIsClear()) {
    			  move();
    		  }
    		  if (rightIsClear()) {
    			  turnRight();
    		  } 
    		  if (leftIsClear()) {
    			  turnLeft();    		  }
    		  
    	   }
    	   
    	   }
       
       
       private void pinkTower() {
    	   
       }
       
       
       
       private void findWall() {
    	   while (frontIsClear()) {
    		   move();
    	   }
    	   
       }
       
       private void safeBeeper() {
    	   while (beepersPresent()) {
    		   pickBeeper();
    	   }
       }
	// Your code ends here.

	/** ----- Do not change anything below here. ----- */

	private void playThemeSong(String fileLocation) {
		try {
			inputStream = AudioSystem.getAudioInputStream(new File(fileLocation));
			clip = AudioSystem.getClip();
			clip.open(inputStream);
			clip.loop(Clip.LOOP_CONTINUOUSLY);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void playVictorySong(String fileLocation) {
		try {
			clip.close();
			inputStream.close();
			inputStream = AudioSystem.getAudioInputStream(new File(fileLocation));
			clip.open(inputStream);
			clip.start();

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}


	private static final String THEME_SONG = "theme.wav";
	private static final String VICTORY_SONG = "victory.wav";
	private Clip clip;
	private AudioInputStream inputStream;

}
