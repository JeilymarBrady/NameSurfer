/** GraphPanel.java 
  * 
  * This class is used to draw the NameSurfer graph.  A GraphPanel
  * should be declared as an instance variable in the NameSurfer class and
  * instantiated in the NameSurfer constructor.  Add it to the CENTER of the
  * GUI (move the displayArea to the EAST).  The methods clearAll(), clearOne()
  * and addName() can be called from the ButtonListener in NameSurfer to update
  * the graph.
  */
import java.awt.*;
import javax.swing.*;
import java.util.*;

public class GraphPanel extends JPanel
{

	/** holds records for the names to be graphed **/
	ArrayList<NameRecord> graphArray;  
	
	/** array used to graph data for each name in a different color **/
	Color[] COLORS = {Color.red, Color.blue, Color.black, Color.magenta};
	
	/** constant used to leave a margin (in pixels) around the edge of the graph **/
	final static int MARGIN = 20;
	
	
	/**
	 * constructor that initializes the graph panel 
	 */
	public GraphPanel()
	{
		// instantiates graphArray to hold list of names to graph 
		graphArray = new ArrayList<NameRecord>();
		
		// sets the size of the panel
		setPreferredSize(new Dimension(600,600));
	}

	/** Method used to draw the panel.  It is called automatically when
	 *  the panel is created and updated each time repaint() is called 
	 */ 
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		
		int width = getWidth();
		int height = getHeight();
		
		
		// use the Graphics parameter g to draw  grid lines and
		// to write the decades across the bottom of the graph  (Part 3)

	
		
		// loop to graph each name in the graphArray (Part 4)
		// HINT: write the code to graph one name, then add a loop to graph
		// all the names in graphArray
		
		
	}
	
	/** clears the oldest name from the front of the graphArray and updates the graph **/
	public void clearOne()
	{

		// add code to remove one name from the graphArray (if not empty)
		// and call repaint() to update the graph
	}
	
	/** clears the graphArray and updates the graph **/
	public void clearAll()
	{
		// add code to clear all names from the graphArray 
		// and call repaint() to update the graph
	}
	/** adds one name to the back of the graphArray and updates the graph 
	 *  @param record NameRecord to add to the graph
	 **/	
	public void addName(NameRecord record)
	{
		// add code to add record to the graphArray 
		// and call repaint() to update the graph
	}
}
