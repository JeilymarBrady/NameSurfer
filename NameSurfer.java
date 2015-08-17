import javax.swing.JFrame ;
import javax.swing.JPanel ;
import javax.swing.JTextArea ;
import javax.swing.JScrollPane ;
import javax.swing.JTextField ;
import javax.swing.JButton ;

import java.awt.BorderLayout ;
import java.awt.Dimension ;

import java.awt.event.ActionListener ;
import java.awt.event.ActionEvent ;

import java.io.File ;
import java.io.IOException ;

import java.util.Scanner ;


public class NameSurfer{

	JTextArea displayArea ;
	JTextField nameTF ;
	
	NameRecord[] namesArray ;
	
	
	public static void main( String[] arg ) throws IOException {
		NameSurfer app = new NameSurfer() ;
	}
	
	public NameSurfer() throws IOException {
		JFrame frame = new JFrame("Name Surfer") ; 
		JPanel mainPanel = new JPanel() ;
		mainPanel.setLayout( new BorderLayout() ) ;
		
		
		
		displayArea = new JTextArea(); 
		displayArea.setEditable(false); 
		JScrollPane scroller = new JScrollPane(displayArea); 
		scroller.setPreferredSize(new Dimension(250,600)); 
		mainPanel.add( scroller, BorderLayout.CENTER);
		
		JPanel controlPanel = new JPanel() ;
		nameTF = new JTextField(10) ;
		controlPanel.add(nameTF) ;
		
		JButton findB = new JButton("Find") ;
		controlPanel.add(findB) ;
		findB.addActionListener( new FindListener() ) ;
		
		JButton matchB = new JButton("Match") ;
		controlPanel.add(matchB) ;
		matchB.addActionListener( new MatchListener() ) ;
		
		mainPanel.add(controlPanel, BorderLayout.SOUTH ) ;
		
		frame.add(mainPanel) ;
		frame.pack() ;
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;
		frame.setVisible(true) ;
		
		read("baby-names.txt") ;
		fillDisplay() ;
		System.out.println(startsWithChar('A', namesArray ) ) ;
		
	}
	
	
	public int startsWithChar( char ch, NameRecord[] data ) {
		int count = 0 ;
		for(int i = 0; i < data.length; i++ ) {
			String name = data[i].getName() ;
			char letter = name.charAt(0) ;
			if( data[i].getName().charAt(0) == ch )
				count++ ;
		}
		return count ; 
	}
	
	void fillDisplay() {
		displayArea.setText("") ;
		for(int i = 0; i<namesArray.length; i++  ) 
			displayArea.append(" "+namesArray[i].toString() + "\n" ) ;
	}
	
	void read(String filename) throws IOException {
		File f = new File( filename ) ;
		Scanner sc = new Scanner( f ) ;
		
		int num = sc.nextInt() ;
		sc.nextLine() ;
		namesArray = new NameRecord[num] ;
		
		for( int i = 0; i<num; i++ ) {
			String line = sc.nextLine() ;
			namesArray[i] = new NameRecord( line ) ;
		}
		
	}
	
/*

	catch(IOException ex ) {
		System.out.println(ex) ;
		System.out.exit(0) ;
	{


*/
	
	class FindListener implements ActionListener {
		public void actionPerformed( ActionEvent e ) {
			displayArea.append("Find\n") ;
			NameRecord nr = findName( nameTF.getText() ) ;
			if( nr != null ) {
				displayArea.setText("FIND RESULTS for " + nameTF.getText() + ":\n" +
					"Decade \t Rank \n" + "------- \t ------ \n") ;
					for( int i = 0; i < NameRecord.DECADES; i++ ) {
						displayArea.append(NameRecord.START + i*10 + "\t" + nr.getRank(i) + "\n" ) ;
					}
			}
		}
	}

	class MatchListener implements ActionListener {
		public void actionPerformed( ActionEvent e ) {
			displayArea.append("Match\n") ;
			displayArea.setText("MATCH RESULTS for " + nameTF.getText() + ":\n" +
					"Name \t Best Decade \n" + "------ \t ----------- \n") ;
		String name = nameTF.getText().toLowerCase() ;
		for(int i = 0; i < namesArray.length; i++ ) {
			String nrName = namesArray[i].getName().toLowerCase() ;
			if( nrName.contains(name) ) //namesArray[i].getName().contains(nameTF.getText() ) )
				displayArea.append(namesArray[i].getName() + "\t" + namesArray[i].bestDecade() + "\n" ) ;
		}
		}
	}
	
	public NameRecord findName( String name ) {
		for(int i = 0; i < namesArray.length; i++ ) {
			if(name.equalsIgnoreCase( namesArray[i].getName() ) ) {
				return namesArray[i] ;
			}
		}
		return null ;
	}
	
	
}
