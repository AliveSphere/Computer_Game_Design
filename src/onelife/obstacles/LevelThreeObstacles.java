package onelife.obstacles;

import java.util.ArrayList;

import edu.virginia.engine.display.Sprite;

public class LevelThreeObstacles {
	
	public ArrayList<Sprite> spikes1 = new ArrayList<Sprite>();
	public ArrayList<Sprite> spikes2 = new ArrayList<Sprite>();
	public ArrayList<Sprite> platforms = new ArrayList<Sprite>();
	public ArrayList<Sprite> lavaPits = new ArrayList<Sprite>();
    
	Sprite spike0 = new Sprite("spike0", "spike.png");
	Sprite spike1 = new Sprite("spike1", "spike.png");
	Sprite spike2 = new Sprite("spike2", "spike.png");
	Sprite spike3 = new Sprite("spike3", "spike.png");
	Sprite spike4 = new Sprite("spike4", "spike.png");
	Sprite spike5 = new Sprite("spike5", "spike.png");
	Sprite spike6 = new Sprite("spike6", "spike.png");
	Sprite spike7 = new Sprite("spike7", "spike.png");
	Sprite spike8 = new Sprite("spike7", "spike.png");
	Sprite spike9 = new Sprite("spike7", "spike.png");
	Sprite spike10 = new Sprite("spike7", "spike.png");
	Sprite spike11 = new Sprite("spike7", "spike.png");
	Sprite spike12 = new Sprite("spike7", "spike.png");
	Sprite spike13 = new Sprite("spike7", "spike.png");
	Sprite spike14 = new Sprite("spike7", "spike.png");
	Sprite spike15 = new Sprite("spike7", "spike.png");
	Sprite spike16 = new Sprite("spike7", "spike.png");
	Sprite spike17 = new Sprite("spike7", "spike.png");
	Sprite spike18 = new Sprite("spike7", "spike.png");
	Sprite spike19 = new Sprite("spike7", "spike.png");
	Sprite spike20 = new Sprite("spike7", "spike.png");
	Sprite spike21 = new Sprite("spike7", "spike.png");
	Sprite spike22 = new Sprite("spike7", "spike.png");
	Sprite spike23 = new Sprite("spike7", "spike.png");
	Sprite spike24 = new Sprite("spike7", "spike.png");
	Sprite spike25 = new Sprite("spike7", "spike.png");
	Sprite spike26 = new Sprite("spike7", "spike.png");
	Sprite spike27 = new Sprite("spike7", "spike.png");
	Sprite spike28 = new Sprite("spike7", "spike.png");
	Sprite spike29 = new Sprite("spike7", "spike.png");
	Sprite spike30 = new Sprite("spike7", "spike.png");
	Sprite spike31 = new Sprite("spike7", "spike.png");
    
	Sprite platform0 = new Sprite("platform0", "ledge.png");
	Sprite platform1 = new Sprite("platform1", "ledge.png");
	Sprite platform2 = new Sprite("platform2", "ledge.png");
	Sprite platform3 = new Sprite("platform3", "ledge.png");
	Sprite platform4 = new Sprite("platform4", "ledge.png");
	Sprite platform5 = new Sprite("platform5", "ledge.png");
	Sprite platform6 = new Sprite("platform6", "ledge.png");
	Sprite platform7 = new Sprite("platform7", "ledge.png");
	Sprite platform8 = new Sprite("platform8", "ledge.png");
	Sprite platform9 = new Sprite("platform9", "ledge.png");
	Sprite platform10 = new Sprite("platform10", "ledge.png");
	Sprite platform11 = new Sprite("platform11", "ledge.png");
	Sprite platform12 = new Sprite("platform12", "ledge.png");
	Sprite platform13 = new Sprite("platform13", "ledge.png");
	Sprite platform14 = new Sprite("platform14", "ledge.png");
	Sprite platform15 = new Sprite("platform15", "ledge.png");
	Sprite platform16 = new Sprite("platform16", "ledge.png");
	Sprite platform17 = new Sprite("platform17", "ledge.png");
    
	Sprite lava0 = new Sprite("lava0", "lava.png");
	Sprite lava1 = new Sprite("lava1", "lava.png");
	Sprite lava2 = new Sprite("lava2", "lava.png");
	Sprite lava3 = new Sprite("lava3", "lava.png");
	Sprite lava4 = new Sprite("lava4", "lava.png");

    
	public LevelThreeObstacles() {
		
		
		/** Making Spikes1!!! **/
		//xpos
		spike0.xpos = 150;
    	spike1.xpos = 200;
    	spike2.xpos = 300;
    	spike3.xpos = 350;
    	spike4.xpos = 400;
    	spike5.xpos = 450;
    	spike6.xpos = 650;
    	spike7.xpos = 700;
    	spike8.xpos = 750;
    	spike9.xpos = 850;
    	spike10.xpos = 950;
    	spike11.xpos = 1050;
    	spike12.xpos = 1150;
    	spike13.xpos = 1200;
    	spike14.xpos = 1250;
    	spike15.xpos = 1300;
    	spike16.xpos = 1350;
    	spike17.xpos = 1400;
		spike18.xpos = 150;
		spike19.xpos = 200;
		spike20.xpos = 300;
		spike21.xpos = 450;
		spike22.xpos = 550;
		spike23.xpos = 750;
		spike24.xpos = 1050;
		spike25.xpos = 1200;
		spike26.xpos = 1250;
		spike27.xpos = 1300;
		spike28.xpos = 1350;
		spike29.xpos = 1400;
		spike30.xpos = 1450;
		spike31.xpos = 1500;
		//ypos
		spike0.ypos = 108;
		spike1.ypos = 30;
		spike2.ypos = 108;
		spike3.ypos = 108;
		spike4.ypos = 108;
		spike5.ypos = 108;
		spike6.ypos = 30;
		spike7.ypos = 30;
		spike8.ypos = 108;
    	spike9.ypos = 108;
    	spike10.ypos = 108;
    	spike11.ypos = 108;
    	spike12.ypos = 108;
    	spike13.ypos = 108;
    	spike14.ypos = 30;
    	spike15.ypos = 30;
    	spike16.ypos = 108;
    	spike17.ypos = 108;
		spike18.ypos = 108;
		spike19.ypos = 108;
		spike20.ypos = 30;
		spike21.ypos = 30;
		spike22.ypos = 108;
		spike23.ypos = 108;
		spike24.ypos = 108;
		spike25.ypos = 108;
		spike26.ypos = 108;
		spike27.ypos = 108;
		spike28.ypos = 108;
		spike29.ypos = 108;
		spike30.ypos = 108;
		spike31.ypos = 108;
		//scale
		spike1.scaleY = -1;
		spike6.scaleY = -1;
		spike7.scaleY = -1;
		spike14.scaleY = -1;
		spike15.scaleY = -1;
		spike20.scaleY = -1;
		spike21.scaleY = -1;
		
		/** Making Spikes2!!! **/
		//xpos
		
		//ypos
		
		/** Making Platforms!!! **/
		//xpos
		platform0.xpos = 0;
		platform1.xpos = 50;
		platform2.xpos = 150;
		platform3.xpos = 250;
		platform4.xpos = 350;
		platform5.xpos = 550;
		platform6.xpos = 600;
		platform7.xpos = 650;
		platform8.xpos = 750;
		platform9.xpos = 850;
		platform10.xpos = 950;
		platform11.xpos = 1100;
		platform12.xpos = 1300;
		platform13.xpos = 1350;
		platform14.xpos = 1400;
		platform15.xpos = 1450;
		platform16.xpos = 1500;
		platform17.xpos = 1550;
		//ypos
		platform0.ypos = 136;
		platform1.ypos = 136;
		platform2.ypos = 108;
		platform3.ypos = 80;
		platform4.ypos = 108;
		platform5.ypos = 108;
		platform6.ypos = 108;
		platform7.ypos = 108;
		platform8.ypos = 80;
		platform9.ypos = 80;
		platform10.ypos = 80;
		platform11.ypos = 80;
		platform12.ypos = 80;
		platform13.ypos = 136;
		platform14.ypos = 136;
		platform15.ypos = 136;
		platform16.ypos = 136;
		platform17.ypos = 136;
		
		/** Making Lava Pits!!! **/
		//xpos
		lava0.xpos = 100;
		lava1.xpos = 350;
		lava2.xpos = 650;
		lava3.xpos = 1050;
		lava4.xpos = 1125;
		//ypos
		lava0.ypos = 120;
		lava1.ypos = 120;
		lava2.ypos = 120;
		lava3.ypos = 120;
		lava4.ypos = 120;
		
	}
    
	public void addLevelThreeObstacles() {
	   	 spikes1.add(spike0);
	   	 spikes1.add(spike1);
	   	 spikes1.add(spike2);
	   	 spikes1.add(spike3);
	   	 spikes1.add(spike4);
	   	 spikes1.add(spike5);
	   	 spikes1.add(spike6);
	   	 spikes1.add(spike7);
	   	 spikes1.add(spike8);
		 spikes1.add(spike9);
		 spikes1.add(spike10);
		 spikes1.add(spike11);
		 spikes1.add(spike12);
		 spikes1.add(spike13);
		 spikes1.add(spike14);
		 spikes1.add(spike15);
		 spikes1.add(spike16);
		 spikes1.add(spike17);
		 spikes2.add(spike18);
		 spikes2.add(spike19);
		 spikes2.add(spike20);
		 spikes2.add(spike21);
		 spikes2.add(spike22);
		 spikes2.add(spike23);
		 spikes2.add(spike24);
		 spikes2.add(spike25);
		 spikes2.add(spike26);
		 spikes2.add(spike27);
		 spikes2.add(spike28);
		 spikes2.add(spike29);
		 spikes2.add(spike30);
		 spikes2.add(spike31);
   	 
	   	 platforms.add(platform0);
	   	 platforms.add(platform1);
	   	 platforms.add(platform2);
	   	 platforms.add(platform3);
	   	 platforms.add(platform4);
	   	 platforms.add(platform5);
	   	 platforms.add(platform6);
	   	 platforms.add(platform7);
	   	 platforms.add(platform8);
	   	 platforms.add(platform9);
	   	 platforms.add(platform10);
	   	 platforms.add(platform11);
	   	 platforms.add(platform12);
	   	 platforms.add(platform13);
	   	 platforms.add(platform14);
	   	 platforms.add(platform15);
	   	 platforms.add(platform16);
	   	 platforms.add(platform17);

	   	 lavaPits.add(lava0);
	   	 lavaPits.add(lava1);
	   	 lavaPits.add(lava2);
	   	 lavaPits.add(lava3);
	   	 lavaPits.add(lava4);
		}
	
	    public ArrayList<Sprite> getSpikes1() {
	    	return spikes1;
	    }
	    public ArrayList<Sprite> getSpikes2() {
	    	return spikes2;
	    }
	    public ArrayList<Sprite> getPlatforms() {
	    	return platforms;
	    }
	    public ArrayList<Sprite> getLava() {
	    	return lavaPits;
	    }
    
}