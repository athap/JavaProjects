package atul.mint.wordchain;

import java.awt.Frame;
import java.util.ArrayList;

public class Runner 
{
	public static void main(String[] args) 
	{
		Frame frame = new Frame("Word Chain");
		
		RunnerGUI gui = new RunnerGUI();
		
		frame.add("Center", gui);
		
		gui.init();
		gui.start();
		
		frame.pack();
		frame.setVisible(true);
		
		/*ChainFinder finder = new ChainFinder();
		ArrayList<String> result = finder.shortestWordChainBetween("bar", "fat");
		System.out.println(result.toString());*/
		
	}

}
