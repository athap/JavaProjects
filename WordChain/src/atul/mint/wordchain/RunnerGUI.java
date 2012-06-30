package atul.mint.wordchain;

import java.applet.Applet;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
 
public class RunnerGUI extends Applet implements ActionListener
{
	public RunnerGUI()
	{
		mChainFinder = new ChainFinder();
	}
	
	public void init()
	{		
		mEnterWordsLabel = new Label("Enter start and end word");
		add(mEnterWordsLabel);
		
		mFirstWordField = new TextField(10);
		add(mFirstWordField);
		
		mSecondWordField = new TextField(10);
		add(mSecondWordField);
		
		mFindChainButton = new Button("Find Chain");
		add(mFindChainButton);
		
		mFindChainButton.addActionListener(this);
		
		Panel panelResult = new Panel();
		panelResult.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		mResultLabel = new Label("Results");
		panelResult.add(mResultLabel);		
		
		add(panelResult);
	}
	
	public void actionPerformed(ActionEvent e)
	{		
		mResultLabel.setText("processing...");
		
		ArrayList<String> results = 
			mChainFinder.shortestWordChainBetween(mFirstWordField.getText(),
					mSecondWordField.getText());
		
		if(results != null)
			mResultLabel.setText(results.toString());
		else
			mResultLabel.setText("No results");
		
		repaint();
	}
	
	public void paint(Graphics g)
	{
		//g.drawString("Chain: " + mResult, 50, 100);
	}
	
	private Label mEnterWordsLabel;
	private TextField mFirstWordField, mSecondWordField;
	private Button mFindChainButton;
	private Label mResultLabel;
	
	private ChainFinder mChainFinder;
}