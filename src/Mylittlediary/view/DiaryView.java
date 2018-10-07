package Mylittlediary.view;

import javax.swing.JFrame;

import Mylittlediary.diary.Diary;
import Mylittlediary.diary.Notes;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import Mylittlediary.diary.Diary;
import java.awt.Window.Type;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Component;


public class DiaryView extends JFrame {
	
	private Diary diary; //valami apro pici vï¿½ltoztatï¿½s kell ebbe ide bele
	private JPanel mainPanel = new JPanel();
	private JButton btnJegyzetek = new JButton("Jegyzetek ");
	private JLabel lblMen = new JLabel("Men\u00FC");
	private JLabel lblDtum = new JLabel("D\u00E1tum:");
	public JLabel varninglbl = new JLabel("");
	private JLabel lblBejegyzs = new JLabel("Bejegyz\u00E9s:");
	private JButton btnHozzad = new JButton("Hozz\u00E1ad");
	private JPanel findPanel = new JPanel();
	private JButton btnBack_1 = new JButton("Back");
	private JLabel lblDtum_1 = new JLabel("D\u00E1tum:");
	private JLabel lblJegzyeteid = new JLabel("Jegyzeteid:");
	
	//subtest miatt teszek ide kommenteket 
	//subsubsubsubsubususbsub
	
	public JTextField txtDatum;
	private JTextArea txtNote;
	private JTextField txtDatumkeres;
	private JTable listatable;
	private JTextArea txtrJegyzet = new JTextArea();
	
	//git changes 
	public int abcsefg;
	public double testmodi;
	//commit name: second in code 
	
	//megegy tesztes change deploy miatt 
	
	int develope ; 
	
	public void hozzaad(){
		Notes uj = new Notes(txtNote.getText(), txtDatum.getText());
		int talalat=0;
		for(int i = 0; i< diary.notes.size(); i++){
			if(diary.notes.get(i).getDate().equals(txtDatum.getText())){
				varninglbl.setText("Ilyened már van, csak módosítani lehet");		
				talalat=1;
			}
			
		}
		if (talalat==0) {
			txtNote.setText("");
			txtDatum.setText("éééé.hh.nn.");
			varninglbl.setText("Hozzáadva");
		diary.addNote(uj);	
		try {
			diary.saveToFile("note.txt");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		}
	}
	
	
	
	public void keress(){
		int talalat=0;
		for(int i = 0; i< diary.notes.size(); i++){
			if(diary.notes.get(i).getDate().equals(txtDatumkeres.getText())){
				txtrJegyzet.setText(diary.notes.get(i).getEventName());			
				talalat=1;
			}
			
		}
		if (talalat==0) {
			txtrJegyzet.setText("Nincs az adott napra programod!");			
		}
		
	}
	
	
	public void torles(){
		for(int i = 0; i< diary.notes.size(); i++){
			if(diary.notes.get(i).getDate().equals(txtDatumkeres.getText())){
				diary.notes.remove(i);
			}
	
		}
		txtDatumkeres.setText("eeee.hh.nn.");
		txtrJegyzet.setText("");
		try {
			diary.saveToFile("note.txt");
		} catch (FileNotFoundException e1) {
			
			e1.printStackTrace();
		} catch (IOException e1) {
			
			e1.printStackTrace();
		}
		
	}
	
	
	public void modosit(){
		for(int i = 0; i< diary.notes.size(); i++){
			if(diary.notes.get(i).getDate().equals(txtDatumkeres.getText())){
				diary.notes.get(i).setEventName(txtrJegyzet.getText());
			}
	
		}
	try {
		diary.saveToFile("note.txt");
	} catch (FileNotFoundException e1) {
		
		e1.printStackTrace();
	} catch (IOException e1) {
		
		e1.printStackTrace();
	}
		
	}
	
	
	
	
	public DiaryView() {
		
		setTitle("My little diary");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(new CardLayout(0, 0));
		
		diary = new Diary();
		try {
			diary.readFromFile("note.txt");
		} catch (ClassNotFoundException | IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		//for (int i = 0; i < diary.notes.size(); i++) {
		//	System.out.println(i);
		//}
		
		
		getContentPane().add(mainPanel, "mainpanel");
		
		
		JButton btnNewButton = new JButton("Jegyzet hozzáadása");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl
				= (CardLayout)(getContentPane().getLayout());
			    cl.show(getContentPane(), "notepanel");
			    txtNote.setText("Írd be a jegyzeted");
			    txtDatum.setText("éééé.hh.nn."); //efefed
			    varninglbl.setText("");
			    
			}
			
		});
		
		JButton btnJegyzetekKeresse = new JButton("Jegyzetek keresése");
		btnJegyzetekKeresse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl
				= (CardLayout)(getContentPane().getLayout());
			    cl.show(getContentPane(), "findpanel");
			    txtDatumkeres.setText("eeee.hh.nn.");
			    txtrJegyzet.setText("Itt lesz a jegyzeted");
			   
			}
		});
		
		
		
		
		JButton btnKilps = new JButton("Kilépés");
		btnKilps.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					diary.saveToFile("note.txt");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.exit(0);
			}
		});
		
		
		
		
		GroupLayout gl_mainPanel = new GroupLayout(mainPanel);
		gl_mainPanel.setHorizontalGroup(
			gl_mainPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_mainPanel.createSequentialGroup()
					.addGap(140)
					.addGroup(gl_mainPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_mainPanel.createSequentialGroup()
							.addComponent(btnKilps, GroupLayout.PREFERRED_SIZE, 32, Short.MAX_VALUE)
							.addGap(136))
						.addGroup(gl_mainPanel.createSequentialGroup()
							.addGroup(gl_mainPanel.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnJegyzetek, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
								.addComponent(btnJegyzetekKeresse, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
								.addComponent(btnNewButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE))
							.addGap(136))))
				.addGroup(Alignment.LEADING, gl_mainPanel.createSequentialGroup()
					.addGap(198)
					.addComponent(lblMen, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(203))
		);
		gl_mainPanel.setVerticalGroup(
			gl_mainPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_mainPanel.createSequentialGroup()
					.addGap(27)
					.addComponent(lblMen)
					.addGap(18)
					.addComponent(btnNewButton)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnJegyzetekKeresse)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnJegyzetek)
					.addGap(18)
					.addComponent(btnKilps)
					.addContainerGap(48, Short.MAX_VALUE))
		);
		mainPanel.setLayout(gl_mainPanel);
		JPanel notePanel = new JPanel();
		
		getContentPane().add(notePanel, "notepanel");
		
		JButton btnBack = new JButton("back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl
				= (CardLayout)(getContentPane().getLayout());
			    cl.show(getContentPane(), "mainpanel");
			}
		});
		
		
		
		txtDatum = new JTextField();
		txtDatum.setText("ï¿½ï¿½ï¿½ï¿½.hh.nn.");
		txtDatum.setColumns(10);
		txtDatum.addFocusListener(new FocusListener() {
			
			@Override
			public void focusGained(FocusEvent arg0) {
				txtDatum.setText("");}

			@Override
			public void focusLost(FocusEvent arg0) {
				
				
			}
		});
		
		
		txtNote = new JTextArea();
		txtNote.setLineWrap(true);
		txtNote.setWrapStyleWord(true);
		txtNote.setText("note");
		txtNote.setColumns(10);
		txtNote.addFocusListener(new FocusListener() {
			
			@Override
			public void focusGained(FocusEvent arg0) {
				txtNote.setText("");}

			@Override
			public void focusLost(FocusEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		btnHozzad.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				hozzaad();
		}
		});
		
		
		
		
		
		GroupLayout gl_notePanel = new GroupLayout(notePanel);
		gl_notePanel.setHorizontalGroup(
			gl_notePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_notePanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_notePanel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_notePanel.createSequentialGroup()
							.addGroup(gl_notePanel.createParallelGroup(Alignment.LEADING)
								.addComponent(txtNote, GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE)
								.addGroup(gl_notePanel.createSequentialGroup()
									.addComponent(btnBack)
									.addPreferredGap(ComponentPlacement.RELATED, 268, Short.MAX_VALUE)
									.addComponent(btnHozzad))
								.addGroup(gl_notePanel.createSequentialGroup()
									.addComponent(lblDtum)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(txtDatum, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblBejegyzs))
							.addContainerGap())
						.addGroup(gl_notePanel.createSequentialGroup()
							.addGap(46)
							.addComponent(varninglbl)
							.addGap(187))))
		);
		gl_notePanel.setVerticalGroup(
			gl_notePanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_notePanel.createSequentialGroup()
					.addGap(26)
					.addGroup(gl_notePanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDtum)
						.addComponent(txtDatum, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(lblBejegyzs)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtNote, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
					.addComponent(varninglbl)
					.addGap(18)
					.addGroup(gl_notePanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnBack)
						.addComponent(btnHozzad))
					.addContainerGap())
		);
		notePanel.setLayout(gl_notePanel);
		
		
		
		
		
		getContentPane().add(findPanel, "findpanel");
		
		
		btnBack_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl
				= (CardLayout)(getContentPane().getLayout());
			    cl.show(getContentPane(), "mainpanel");
			}
		});
		
		
		
		txtDatumkeres = new JTextField();
		txtDatumkeres.setText("eeee.hh.nn.");
		txtDatumkeres.setColumns(10);
		
		JButton btnTrls = new JButton("T\u00F6rl\u00E9s");
		
		
		JButton btnMdosts = new JButton("M\u00F3dos\u00EDt\u00E1s");
		
		
		
		
		JButton btnKeress = new JButton("Keres\u00E9s");
		
		
		JList list = new JList();
		
		JScrollPane scrollPane = new JScrollPane();
		
		
		GroupLayout gl_findPanel = new GroupLayout(findPanel);
		gl_findPanel.setHorizontalGroup(
			gl_findPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_findPanel.createSequentialGroup()
					.addGroup(gl_findPanel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_findPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblDtum_1)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtDatumkeres, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnKeress))
						.addGroup(gl_findPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnBack_1)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnMdosts)
							.addGap(18)
							.addComponent(btnTrls))
						.addGroup(gl_findPanel.createSequentialGroup()
							.addGap(20)
							.addGroup(gl_findPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 376, GroupLayout.PREFERRED_SIZE)
								.addComponent(list, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(36, Short.MAX_VALUE))
		);
		gl_findPanel.setVerticalGroup(
			gl_findPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_findPanel.createSequentialGroup()
					.addGap(31)
					.addGroup(gl_findPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDtum_1)
						.addComponent(txtDatumkeres, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnKeress))
					.addGap(9)
					.addComponent(list, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
					.addGap(31)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 265, GroupLayout.PREFERRED_SIZE)
					.addGap(53)
					.addGroup(gl_findPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnBack_1)
						.addComponent(btnTrls)
						.addComponent(btnMdosts))
					.addContainerGap())
		);
		
		
	    txtrJegyzet.setLineWrap(true);
	    txtrJegyzet.setWrapStyleWord(true);
		txtrJegyzet.setText("jegyzet");
		scrollPane.setViewportView(txtrJegyzet);
		findPanel.setLayout(gl_findPanel);
		
		
		btnKeress.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				keress();
			}
		});
		
		
		btnMdosts.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				modosit();
			}
		});
		
		
			txtDatumkeres.addFocusListener(new FocusListener() {
			
			@Override
			public void focusGained(FocusEvent arg0) {
				txtDatumkeres.setText("");}

			@Override
			public void focusLost(FocusEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		btnTrls.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
					torles();
					
			}
		});
		
		
		
		JPanel listPanel = new JPanel();
		getContentPane().add(listPanel, "listpanel");
		
		JButton btnBack_2 = new JButton("Back");
		btnBack_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl
				= (CardLayout)(getContentPane().getLayout());
			    cl.show(getContentPane(), "mainpanel");
			    
			}
		});
		
		
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		
		GroupLayout gl_listPanel = new GroupLayout(listPanel);
		gl_listPanel.setHorizontalGroup(
			gl_listPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_listPanel.createSequentialGroup()
					.addGap(25)
					.addGroup(gl_listPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 365, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblJegzyeteid)
						.addComponent(btnBack_2))
					.addContainerGap(42, Short.MAX_VALUE))
		);
		gl_listPanel.setVerticalGroup(
			gl_listPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_listPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblJegzyeteid)
					.addGap(18)
					.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 342, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
					.addComponent(btnBack_2)
					.addGap(21))
		);
		
	
		
		btnJegyzetek.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl
				= (CardLayout)(getContentPane().getLayout());
			    cl.show(getContentPane(), "listpanel");
				DefaultTableModel model = new DefaultTableModel(){
					@Override
					public boolean isCellEditable(int row, int column){
						return false;
					}
				};
				model.addColumn("Dï¿½tum");
				model.addColumn("Bejegyzï¿½s");
					
				
				listatable = new JTable(model);
				scrollPane_1.setViewportView(listatable);
				listPanel.setLayout(gl_listPanel);
				
			    for (int i = 0; i < diary.notes.size(); i++) {
					model.addRow(new Object[]{diary.notes.get(i).getDate(), diary.notes.get(i).getEventName()});
				}
			    
			    
			}
		});
		
		
		
		CardLayout cl = (CardLayout)(getContentPane().getLayout());
	    cl.show(getContentPane(), "mainPanel");

		
	}
	
	
	

	public static void main(String[] args) {
		DiaryView asd = new DiaryView();
		asd.setTitle("MyLittleDiary");
		asd.setBounds(100, 100, 500, 500);
		asd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		asd.setVisible(true);
	}
}

