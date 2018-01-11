package onelife.obstacles;

import java.util.ArrayList;

import edu.virginia.engine.display.Sprite;

public class testObstacles {
	
    public ArrayList<Sprite> blocks = new ArrayList<Sprite>();
	public ArrayList<Sprite> spikes = new ArrayList<Sprite>();
	public ArrayList<Sprite> platforms = new ArrayList<Sprite>();
	public ArrayList<Sprite> lavaPits = new ArrayList<Sprite>();
    
	Sprite block0 = new Sprite("block0", "block.png");
	Sprite block1 = new Sprite("block1", "block.png");
	Sprite block2 = new Sprite("block2", "block.png");
	Sprite block3 = new Sprite("block3", "block.png");
	Sprite block4 = new Sprite("block4", "block.png");
	Sprite block5 = new Sprite("block5", "block.png");
//	Sprite block6 = new Sprite("block6", "block.png");
//	Sprite block7 = new Sprite("block7", "block.png");
//	Sprite block8 = new Sprite("block8", "block.png");
//	Sprite block9 = new Sprite("block9", "block.png");
//	Sprite block10 = new Sprite("block10", "block.png");
//	Sprite block11 = new Sprite("block11", "block.png");
    
	Sprite spike0 = new Sprite("spike0", "spike.png");
	Sprite spike1 = new Sprite("spike1", "spike.png");
	Sprite spike2 = new Sprite("spike2", "spike.png");
	Sprite spike3 = new Sprite("spike3", "spike.png");
//	Sprite spike4 = new Sprite("spike4", "spike.png");
//	Sprite spike5 = new Sprite("spike5", "spike.png");
//	Sprite spike6 = new Sprite("spike6", "spike.png");
//	Sprite spike7 = new Sprite("spike7", "spike.png");
    
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
	Sprite platform18 = new Sprite("platform18", "ledge.png");
	Sprite platform19 = new Sprite("platform0", "ledge.png");
	Sprite platform20 = new Sprite("platform1", "ledge.png");
	Sprite platform21 = new Sprite("platform2", "ledge.png");
	Sprite platform22 = new Sprite("platform3", "ledge.png");
	Sprite platform23 = new Sprite("platform4", "ledge.png");
	Sprite platform24 = new Sprite("platform5", "ledge.png");
	Sprite platform25 = new Sprite("platform6", "ledge.png");
	Sprite platform26 = new Sprite("platform7", "ledge.png");
	Sprite platform27 = new Sprite("platform8", "ledge.png");
	Sprite platform28 = new Sprite("platform9", "ledge.png");
	Sprite platform29 = new Sprite("platform9", "ledge.png");
	Sprite platform30 = new Sprite("platform9", "ledge.png");
	Sprite platform31 = new Sprite("platform9", "ledge.png");
	Sprite platform32 = new Sprite("platform9", "ledge.png");
	Sprite platform33 = new Sprite("platform9", "ledge.png");
	Sprite platform34 = new Sprite("platform9", "ledge.png");
	Sprite platform35 = new Sprite("platform9", "ledge.png");
	Sprite platform36 = new Sprite("platform9", "ledge.png");
	Sprite platform37 = new Sprite("platform9", "ledge.png");
	Sprite platform38 = new Sprite("platform9", "ledge.png");
	Sprite platform39 = new Sprite("platform9", "ledge.png");
	Sprite platform40 = new Sprite("platform9", "ledge.png");
    
//	Sprite lava0 = new Sprite("lava0", "lava.png");
//	Sprite lava1 = new Sprite("lava1", "lava.png");
//	Sprite lava2 = new Sprite("lava2", "lava.png");
//	Sprite lava3 = new Sprite("lava3", "lava.png");
//	Sprite lava4 = new Sprite("lava4", "lava.png");
	Sprite lava5 = new Sprite("lava5", "lava.png");
	Sprite lava6 = new Sprite("lava6", "lava.png");
	Sprite lava7 = new Sprite("lava7", "lava.png");
	Sprite lava8 = new Sprite("lava8", "lava.png");

    
	public testObstacles() {
		
		/** Making Blocks!!! **/
		//xpos
		block0.xpos = 200;
		block1.xpos = 250;
		block2.xpos = 450;
		block3.xpos = 700;
		block4.xpos = 750;
		block5.xpos = 800;
//		block6.xpos = 850;
//		block7.xpos = 1100;
//		block8.xpos = 1150;
//		block9.xpos = 1200;
//		block10.xpos = 1250;
//		block11.xpos = 1400;
		//ypos
		block0.ypos = 90;
		block1.ypos = 0;
		block2.ypos = 60;
		block3.ypos = 90;
		block4.ypos = 60;
		block5.ypos = 90;
//		block6.ypos = 0;
//		block7.ypos = 60;
//		block8.ypos = 60;
//		block9.ypos = 60;
//		block10.ypos = 60;
//		block11.ypos = 90;
		
		/** Making Spikes!!! **/
		//xpos
		spike0.xpos = 250;
		spike1.xpos = 400;
		spike2.xpos = 460;
		spike3.xpos = 600;
//		spike4.xpos = 800;
//		spike5.xpos = 1100;
//		spike6.xpos = 1160;
//		spike7.xpos = 1220;
		//ypos
		spike0.ypos = 108;
		spike1.ypos = 108;
		spike2.ypos = 108;
		spike3.ypos = 108;
//		spike4.ypos = 108;
//		spike5.ypos = 108;
//		spike6.ypos = 108;
//		spike7.ypos = 108;
		
		/** Making Platforms!!! **/
		//xpos
		platform0.xpos = 0;
		platform1.xpos = 100;
		platform2.xpos = 200;
		platform3.xpos = 2500;
		platform4.xpos = 400;
		platform5.xpos = 450;
		platform6.xpos = 500;
		platform7.xpos = 650;
		platform8.xpos = 750;
		platform9.xpos = 850;
		platform10.xpos = 850;
		platform11.xpos = 950;
		platform12.xpos = 1050;
		platform13.xpos = 1100;
		platform14.xpos = 1200;
		platform15.xpos = 1300;
		platform16.xpos = 1400;
		platform17.xpos = 1500;
		platform18.xpos = 1550;
		platform19.xpos = 50;
		platform20.xpos = 100;
		platform21.xpos = 150;
		platform22.xpos = 200;
		platform23.xpos = 250;
		platform24.xpos = 300;
		platform25.xpos = 350;
		platform26.xpos = 400;
		platform27.xpos = 450;
		platform28.xpos = 500;
		platform29.xpos = 550;
		platform30.xpos = 600;
		platform31.xpos = 650;
		platform32.xpos = 700;
		platform33.xpos = 750;
		platform34.xpos = 800;
		platform35.xpos = 850;
		platform36.xpos = 900;
		platform37.xpos = 950;
		platform38.xpos = 1000;
		platform39.xpos = 1050;
		platform40.xpos = 1100;
		//ypos
		platform0.ypos = 136;
		platform1.ypos = 100;
		platform2.ypos = 136;
		platform3.ypos = 90;
		platform4.ypos = 136;
		platform5.ypos = 122;
		platform6.ypos = 108;
		platform7.ypos = 80;
		platform8.ypos = 100;
		platform9.ypos = 70;
		platform10.ypos = 136;
		platform11.ypos = 108;
		platform12.ypos = 90;
		platform13.ypos = 90;
		platform14.ypos = 136;
		platform15.ypos = 100;
		platform16.ypos = 120;
		platform17.ypos = 136;
		platform18.ypos = 136;
		platform19.ypos = 136;
		platform20.ypos = 136;
		platform21.ypos = 136;
		platform22.ypos = 136;
		platform23.ypos = 136;
		platform24.ypos = 136;
		platform25.ypos = 136;
		platform26.ypos = 136;
		platform27.ypos = 136;
		platform28.ypos = 136;
		platform29.ypos = 136;
		platform30.ypos = 136;
		platform31.ypos = 136;
		platform32.ypos = 136;
		platform33.ypos = 136;
		platform34.ypos = 136;
		platform35.ypos = 136;
		platform36.ypos = 136;
		platform37.ypos = 136;
		platform38.ypos = 136;
		platform39.ypos = 136;
		platform40.ypos = 136;
		
		/** Making Lava Pits!!! **/
		//xpos
//		lava0.xpos = 250;
//		lava1.xpos = 450;
//		lava2.xpos = 525;
//		lava3.xpos = 575;
//		lava4.xpos = 575;
		lava5.xpos = 800;
		lava6.xpos = 1000;
		lava7.xpos = 1150;
		lava8.xpos = 1350;
		//ypos
//		lava0.ypos = 132;
//		lava1.ypos = 132;
//		lava2.ypos = 132;
//		lava3.ypos = 132;
//		lava4.ypos = 132;
		lava5.ypos = 120;
		lava6.ypos = 120;
		lava7.ypos = 120;
		lava8.ypos = 120;
		
	}
    
	public void addTestObstacles() {
   	 
	   	 blocks.add(block0);
	   	 blocks.add(block1);
	   	 blocks.add(block2);
	   	 blocks.add(block3);
	   	 blocks.add(block4);
	   	 blocks.add(block5);
//   	 blocks.add(block6);
//   	 blocks.add(block7);
//   	 blocks.add(block8);
//   	 blocks.add(block9);
//   	 blocks.add(block10);
//   	 blocks.add(block11);
   	 
//	   	 spikes.add(spike0);
	   	 spikes.add(spike1);
	   	 spikes.add(spike2);
	   	 spikes.add(spike3);
//   	 spikes.add(spike4);
//   	 spikes.add(spike5);
//   	 spikes.add(spike6);
//   	 spikes.add(spike7);
   	 
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
	   	 platforms.add(platform18);
	   	 platforms.add(platform19);
	   	 platforms.add(platform20);
	   	platforms.add(platform21);
	   	platforms.add(platform22);
	   	platforms.add(platform23);
	   	platforms.add(platform24);
	   	platforms.add(platform25);
	   	platforms.add(platform26);
	   	platforms.add(platform27);
	   	platforms.add(platform28);
	   	platforms.add(platform29);
	   	platforms.add(platform30);
	   	platforms.add(platform31);
	   	platforms.add(platform32);
	   	platforms.add(platform33);
	   	platforms.add(platform34);
	   	platforms.add(platform35);
	   	platforms.add(platform36);
	   	platforms.add(platform37);
	   	platforms.add(platform38);
	   	platforms.add(platform39);
	   	platforms.add(platform40);

//   	 lavaPits.add(lava0);
//   	 lavaPits.add(lava1);
//   	 lavaPits.add(lava2);
//   	 lavaPits.add(lava3);
//   	 lavaPits.add(lava4);
	   	 lavaPits.add(lava5);
	   	 lavaPits.add(lava6);
	   	 lavaPits.add(lava7);
		}
    
	    public ArrayList<Sprite> getBlocks() {
	    	return blocks;
	    }
	    public ArrayList<Sprite> getSpikes() {
	    	return spikes;
	    }
	    public ArrayList<Sprite> getPlatforms() {
	    	return platforms;
	    }
	    public ArrayList<Sprite> getLava() {
	    	return lavaPits;
	    }
    
}
