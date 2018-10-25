/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bth2;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lebao
 */
public class GameLoop implements Runnable{
    private boolean isRunning;
	private Demo demo;
	private List<Charater> characters;
	private List<KinematicWandering> kinematicWanderings;

	public GameLoop(boolean isRunning, Demo demo) {
		super();
		this.isRunning = isRunning;
		this.demo = demo;
		Charater c1 = new Charater(new Vector2D(demo.getHeight()/2, demo.getWidth()/2), 0, new Vector2D(0, 0), 0, Color.RED);
		Charater c2 = new Charater(new Vector2D(demo.getHeight()/2, demo.getWidth()/2), 0, new Vector2D(0, 0), 0, Color.GREEN);
		
		this.characters = new ArrayList<Charater>();
		this.kinematicWanderings = new ArrayList<KinematicWandering>();
		
		this.characters.add(c1);
		this.characters.add(c2);
		for (Charater c: this.characters) {
			this.kinematicWanderings.add(new KinematicWandering(c, 6, 2));
		}
	}

	public boolean isRunning() {
		return isRunning;
	}

	public void setRunning(boolean isRunning) {
		this.isRunning = isRunning;
	}

	public Demo getDemo() {
		return demo;
	}

	public void setDemo(Demo demo) {
		this.demo = demo;
	}

	@Override
	public void run() {
		while (isRunning) {
			demo.getGraphics().clearRect(0,  0,  demo.getWidth(), demo.getHeight());
			for (Charater c: this.characters) {
				c.update(this.kinematicWanderings.get(this.characters.indexOf(c)).generateKinematicOutput(), 2);
				c.render(this.demo.getGraphics());
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
