
import javax.swing.border.Border;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.*;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.*;
import java.awt.event.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JList;



abstract class BessereMain$$Base extends JFrame {
	private static final long serialVersionUID = 1L;
	
	//GUI design stuff
	public JPanel masterPanel;
	public JPanel mainPage;
	public JPanel payPage;
	CardLayout cardLayout;
	public boolean isRoute = false;
	
	//Test
	public String priceToPay;
	
	//CardLayout page names
	public static final String PAGE_MAIN = "MAIN";
	public static final String PAGE_PAY = "PAY";
	public BessereMain$$Base() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//startpositions x, y && window width, height
		setBounds(100, 100, 800, 600);
		masterPanel = new JPanel();
		cardLayout = new CardLayout();
		masterPanel.setLayout(cardLayout);
		
		//debug stuff
		masterPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		masterPanel.setBorder(BorderFactory.createLineBorder(Color.blue));
		
		//finish masterPanel here
		setContentPane(masterPanel);
	}
	
	/**
	 * Idea: Each base feature creates their own card page and the refining features add to those cards
	 */
	public void design() {
		mainPage = new JPanel();
		mainPage.setLayout(new BorderLayout());
		
		paypageDesign();
		
		//Upperwindow contains SuchLeiste
		JPanel upperWindow = new JPanel();
		upperWindow.setLayout(new BoxLayout(upperWindow, BoxLayout.X_AXIS)); //so far this gives the least headache
		mainPage.add(upperWindow, BorderLayout.NORTH);
		
		//centerPanel contains buttons to book stuff
		JPanel centerPanel = new JPanel(new FlowLayout()); //dynamic layout 
		mainPage.add(centerPanel, BorderLayout.CENTER);
		
		masterPanel.add(mainPage, PAGE_MAIN);
		masterPanel.add(payPage, PAGE_PAY);
		
		cardLayout.show(masterPanel, PAGE_MAIN);
		
	}
	
	public void setTrue() {
		isRoute = true;
	}
	
	public void paypageDesign() {
		payPage = new JPanel();
		payPage.setLayout(new BoxLayout(payPage, BoxLayout.Y_AXIS));
		
		JPanel upperPage = new JPanel(new BorderLayout());
		JPanel lowerPage = new JPanel(new BorderLayout());
		payPage.add(upperPage);
		payPage.add(lowerPage);
		
		
		
		JPanel waehrungsrechner = new JPanel();
		waehrungsrechner.setLayout(new BoxLayout(waehrungsrechner, BoxLayout.Y_AXIS));
		
		payPage.add(waehrungsrechner);
		
		JLabel description = new JLabel("Das kostet ");
		
		description.setAlignmentX(CENTER_ALIGNMENT);
		description.setAlignmentY(CENTER_ALIGNMENT);
		upperPage.add(description, BorderLayout.SOUTH);
		
	}

	public void updateText(String newText) {
		priceToPay = newText;
		updatePrice();
	}
	
	public void updatePrice() {
		JPanel upperArea = (JPanel) payPage.getComponent(0);
		JLabel text = (JLabel) upperArea.getComponent(0);
		text.setText("Das kostet " + priceToPay);	
		text.setHorizontalTextPosition(JLabel.CENTER);
		
	}
	
	public static void main(String[] args) {

		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				BessereMain pTest = new BessereMain();
				pTest.design();
				pTest.setVisible(true);
				
			}
		});

	}
}



/**
 * Suchleiste is a simple TextField which is featured at the top of the page
 */
abstract class BessereMain$$Suchleiste extends  BessereMain$$Base  {
	private static final long serialVersionUID = 1L;
   
   private JTextField suchfeld;
   
   
   public void design() {
	   super.design();
	   
	   //textfield description and action button
	   JButton btnSearch = new JButton("Suche"); //TODO: display ((((Search Results, when button is clicked))))
	   
	   //crete a sort of box for textfield + button to be able to search stuff
	   suchfeld = new JTextField("");
	   
	   //Hokus Pokus, just hope that our panel here got added first ...
	   JPanel upper = (JPanel) mainPage.getComponent(0);
	   
	   //filler content
	   Dimension minSize = new Dimension(50, 30);
	   Dimension prefSize = new Dimension(400, 30);
	   Dimension maxSize = new Dimension(600, 30);
	   
	   //add everything to the grid layout
	   upper.add(new Box.Filler(minSize, prefSize, maxSize));
	   upper.add(btnSearch);
	   upper.add(suchfeld);
   }
      // inherited constructors


	public BessereMain$$Suchleiste (  ) { super(); }
}



/**
 * Sets the base for all the following book options
 */
abstract class BessereMain$$Unterkunft_buchen_base extends  BessereMain$$Suchleiste  {
	private static final long serialVersionUID = 1L;
	public JPanel unterkunftPage;
	public static final String PAGE_UNTERKUNFT = "UNTERKUNFT";
	
	public void design() {
		super.design();
		
		JPanel center = (JPanel) mainPage.getComponent(1);
		
		JButton btnBookResort = new JButton("Eine Unterkunft buchen");
		btnBookResort.setPreferredSize(new Dimension(200, 300));
		
		center.add(btnBookResort);
		
		//Start new Panel page here
		unterkunftPage = new JPanel(new BorderLayout());
		JPanel resorts = new JPanel(new FlowLayout());
		unterkunftPage.add(resorts, BorderLayout.CENTER);
		
		masterPanel.add(unterkunftPage, PAGE_UNTERKUNFT);
		
		//Button click switches Panel
		btnBookResort.addActionListener(new ActionListener() {
		    public void actionPerformed (ActionEvent event) {
		    	cardLayout.show(masterPanel, PAGE_UNTERKUNFT);
		    }
		} );
	}
      // inherited constructors


	public BessereMain$$Unterkunft_buchen_base (  ) { super(); }
}



/**
 * feature to book different hotels
 */
abstract class BessereMain$$Hotel extends  BessereMain$$Unterkunft_buchen_base  {
	private static final long serialVersionUID = 1L;

	public static final String PAGE_HOTELS = "HOTELS";
	public JPanel hotelPage;
	
	private JList list;
	
	public final String[] listEntries = { "Billiges Hotel", "Nicht so billiges Hotel", "teures Hotel", "Super-Mega-Hammer-Ultra-Deluxe Hotel"};
	
	public void design() {
		super.design();
		
		JButton btnBookHotel = new JButton("Hotel buchen");
		btnBookHotel.setPreferredSize(new Dimension(200, 300));
		
		JPanel resortPanel = (JPanel) unterkunftPage.getComponent(0);
		
		resortPanel.add(btnBookHotel);
		
		//Start new Panel page here
		hotelPage = new JPanel(new BorderLayout());
		
		listHotels();
		
		masterPanel.add(hotelPage, PAGE_HOTELS);
		
		//Button click switches Panel
		btnBookHotel.addActionListener(new ActionListener() {
		    public void actionPerformed (ActionEvent event) {
		    	cardLayout.show(masterPanel, PAGE_HOTELS);
		    }
		} );
	}
	
	public void listHotels() {
		
		list = new JList();

        list.setModel(new AbstractListModel() {

            @Override
            public int getSize() {
                return listEntries.length;
            }

            @Override
            public Object getElementAt(int i) {
                return listEntries[i];
            }
        });
        
    	list.addListSelectionListener(new ListSelectionListener() {
    		@Override
            public void valueChanged(ListSelectionEvent evt) {
                listValueChanged(evt);
            }
        });
        
    	hotelPage.add(list, BorderLayout.NORTH);
	}	
	
    private void listValueChanged(javax.swing.event.ListSelectionEvent evt) {
        //set text on right here
        final String s = (String) list.getSelectedValue();
        
        if(s.equals(listEntries[0]))
        	updateText("30 Euro");
        else if(s.equals(listEntries[1]))
        	updateText("50 Euro");
        else if(s.equals(listEntries[2]))
        	updateText("100 Euro");
        else if(s.equals(listEntries[3])) {
        	updateText("300 Euro");
        }
        
        cardLayout.show(masterPanel, PAGE_PAY);
        
        
    }
      // inherited constructors


	public BessereMain$$Hotel (  ) { super(); }

	
}



/**
 * feature to book different ferienhaeuser
 */
abstract class BessereMain$$Ferienhaus extends  BessereMain$$Hotel  {
	private static final long serialVersionUID = 1L;

	public static final String PAGE_FERIENHAUS = "FERIENHAUS";
	public JPanel ferienPage;
	
	private JList list;
	
	public final String[] listEntries = { "Billiges Ferienhaus", "Nicht so billiges Ferienhaus", "teures Ferienhaus", "Super-Mega-Hammer-Ultra-Deluxe Ferienhaus"};
	
	public void design() {
		super.design();
		
		JButton btnBookFerienhaus = new JButton("Ferienhaus buchen");
		btnBookFerienhaus.setPreferredSize(new Dimension(200, 300));
		
		JPanel resortPanel = (JPanel) unterkunftPage.getComponent(0);
		
		resortPanel.add(btnBookFerienhaus);
		
		//Start new Panel page here
		ferienPage = new JPanel(new BorderLayout());
		
		listFerienhaus();
		
		masterPanel.add(ferienPage, PAGE_FERIENHAUS);
		
		//Button click switches Panel
		btnBookFerienhaus.addActionListener(new ActionListener() {
		    public void actionPerformed (ActionEvent event) {
		    	cardLayout.show(masterPanel, PAGE_FERIENHAUS);
		    }
		} );
	}
	
	public void listFerienhaus() {
		
		list = new JList();

        list.setModel(new AbstractListModel() {

        	

            @Override
            public int getSize() {
                return listEntries.length;
            }

            @Override
            public Object getElementAt(int i) {
                return listEntries[i];
            }
        });
        
    	list.addListSelectionListener(new ListSelectionListener() {
            
    		@Override
            public void valueChanged(ListSelectionEvent evt) {
                listValueChanged(evt);
            }
        });
        
    	ferienPage.add(list, BorderLayout.NORTH);
	}	
	
    private void listValueChanged(javax.swing.event.ListSelectionEvent evt) {
    	 //set text on right here
        final String s = (String) list.getSelectedValue();
        
        if(s.equals(listEntries[0]))
        	updateText("30 Euro");
        else if(s.equals(listEntries[1]))
        	updateText("50 Euro");
        else if(s.equals(listEntries[2]))
        	updateText("100 Euro");
        else if(s.equals(listEntries[3])) {
        	updateText("300 Euro");
        }
        
        cardLayout.show(masterPanel, PAGE_PAY);
    }
      // inherited constructors


	public BessereMain$$Ferienhaus (  ) { super(); }

	
}



/**
 * feature to book different campingplaetze
 */
abstract class BessereMain$$Campingplatz extends  BessereMain$$Ferienhaus  {
	private static final long serialVersionUID = 1L;

	public static final String PAGE_CAMPING = "Camping";
	public static final String PAGE_CHOOSE = "Auswahl";
	
	public JPanel campingPage;
	public JPanel campingChoosePage;
	
	private JList list;
	
	public final String[] listEntries = { "Billiger Campingplatz", "Nicht so billiger Campingplatz", "teurer Campingplatz", "Super-Mega-Hammer-Ultra-Deluxe Campingplatz"};
	
	public void design() {
		super.design();
		
		JButton btnBookCamping = new JButton("Campingplatz buchen");
		btnBookCamping.setPreferredSize(new Dimension(200, 300));
		
		JPanel resortPanel = (JPanel) unterkunftPage.getComponent(0);
		
		resortPanel.add(btnBookCamping);
		
		//Start new Panel page here
		campingPage = new JPanel(new BorderLayout());
		
		//page for choosing after clicking on a camping place
		campingChoosePage = new JPanel(new FlowLayout());
		
		
		listCampingplaetze();
		
		masterPanel.add(campingPage, PAGE_CAMPING);
		masterPanel.add(campingChoosePage, PAGE_CHOOSE);
		
		//Button click switches Panel
		btnBookCamping.addActionListener(new ActionListener() {
		    public void actionPerformed (ActionEvent event) {
		    	cardLayout.show(masterPanel, PAGE_CAMPING);
		    }
		} );
		
		
		
	}
	
	public void listCampingplaetze() {
		
		list = new JList();

        list.setModel(new AbstractListModel() {

        	

            @Override
            public int getSize() {
                return listEntries.length;
            }

            @Override
            public Object getElementAt(int i) {
                return listEntries[i];
            }
        });
        
    	list.addListSelectionListener(new ListSelectionListener() {
            
    		@Override
            public void valueChanged(ListSelectionEvent evt) {
                listValueChanged(evt);
            }
        });
    	
    	
    	campingPage.add(list, BorderLayout.NORTH);
    	
	}	
	
    private void listValueChanged(javax.swing.event.ListSelectionEvent evt) {
        //set text on right here
        String s = (String) list.getSelectedValue();
        switch(s) {
        default: cardLayout.show(masterPanel, PAGE_CHOOSE);
        	break;
        }
    }
      // inherited constructors


	public BessereMain$$Campingplatz (  ) { super(); }

	
}



/**
 * feature to book different bungalows
 */
abstract class BessereMain$$Bungalow extends  BessereMain$$Campingplatz  {
	private static final long serialVersionUID = 1L;

	public static final String PAGE_BUNGALOW = "Bungalow";
	public JPanel bungalowPage;
	
	public final String[] listEntries= { "Billiger Bungalow", "Nicht so billiger Bungalow", "teurer Bungalow", "Super-Mega-Hammer-Ultra-Deluxe Bungalow"};
	
	private JList list;
	
	public void design() {
		super.design();
		
		JButton btnBookBungalow = new JButton("Bungalow buchen");
		btnBookBungalow.setPreferredSize(new Dimension(200, 300));
		
		campingChoosePage.add(btnBookBungalow);
		
		//Start new Panel page here
		bungalowPage = new JPanel(new BorderLayout());
		
		listBungalows();
		
		masterPanel.add(bungalowPage, PAGE_BUNGALOW);
		
		//Button click switches Panel
		btnBookBungalow.addActionListener(new ActionListener() {
		    public void actionPerformed (ActionEvent event) {
		    	cardLayout.show(masterPanel, PAGE_BUNGALOW);
		    }
		} );
	}
	
	public void listBungalows() {
		
		list = new JList();

        list.setModel(new AbstractListModel() {

        	

            @Override
            public int getSize() {
                return listEntries.length;
            }

            @Override
            public Object getElementAt(int i) {
                return listEntries[i];
            }
        });
        
    	list.addListSelectionListener(new ListSelectionListener() {
            
    		@Override
            public void valueChanged(ListSelectionEvent evt) {
                listValueChanged(evt);
            }
        });
        
    	bungalowPage.add(list, BorderLayout.NORTH);
	}	
	
    private void listValueChanged(javax.swing.event.ListSelectionEvent evt) {
        //set text on right here
        final String s = (String) list.getSelectedValue();
        
        if(s.equals(listEntries[0]))
        	updateText("30 Euro");
        else if(s.equals(listEntries[1]))
        	updateText("50 Euro");
        else if(s.equals(listEntries[2]))
        	updateText("100 Euro");
        else if(s.equals(listEntries[3])) {
        	updateText("300 Euro");
        }
        
        cardLayout.show(masterPanel, PAGE_PAY);
    }
      // inherited constructors


	public BessereMain$$Bungalow (  ) { super(); }

	
}



/**
 * feature to book different stellplaetze
 */
abstract class BessereMain$$Stellplatz extends  BessereMain$$Bungalow  {
	private static final long serialVersionUID = 1L;

	public static final String PAGE_STELLPLATZ = "Stellplatz";
	public JPanel stellplatzPage;
	
	private JList list;
	
	public final String[] listEntries = { "Billiger Stelplatz", "Nicht so billiger Stelplatz", "teurer Stellplatz", "Super-Mega-Hammer-Ultra-Deluxe Stellplatz"};

	
	public void design() {
		super.design();
		
		JButton btnBookStellplatz = new JButton("Stellplatz buchen");
		btnBookStellplatz.setPreferredSize(new Dimension(200, 300));
		
		campingChoosePage.add(btnBookStellplatz);
		
		//Start new Panel page here
		stellplatzPage = new JPanel(new BorderLayout());
		
		listStellplaetze();
		
		masterPanel.add(stellplatzPage, PAGE_STELLPLATZ);
		
		//Button click switches Panel
		btnBookStellplatz.addActionListener(new ActionListener() {
		    public void actionPerformed (ActionEvent event) {
		    	cardLayout.show(masterPanel, PAGE_STELLPLATZ);
		    }
		} );
	}
	
	public void listStellplaetze() {
		
		list = new JList();

        list.setModel(new AbstractListModel() {


            @Override
            public int getSize() {
                return listEntries.length;
            }

            @Override
            public Object getElementAt(int i) {
                return listEntries[i];
            }
        });
        
    	list.addListSelectionListener(new ListSelectionListener() {
            
    		@Override
            public void valueChanged(ListSelectionEvent evt) {
                listValueChanged(evt);
            }
        });
        
    	stellplatzPage.add(list, BorderLayout.NORTH);
	}	
	
    private void listValueChanged(javax.swing.event.ListSelectionEvent evt) {
        //set text on right here
        final String s = (String) list.getSelectedValue();
        
        if(s.equals(listEntries[0]))
        	updateText("30 Euro");
        else if(s.equals(listEntries[1]))
        	updateText("50 Euro");
        else if(s.equals(listEntries[2]))
        	updateText("100 Euro");
        else if(s.equals(listEntries[3])) {
        	updateText("300 Euro");
        }
        
        cardLayout.show(masterPanel, PAGE_PAY);
    }
      // inherited constructors


	public BessereMain$$Stellplatz (  ) { super(); }

	
}



/**
 * TODO base class for the trip thingies
 */
abstract class BessereMain$$Reise_buchen_base extends  BessereMain$$Stellplatz  {
	private static final long serialVersionUID = 1L;
	public static final String PAGE_REISE = "REISE";
	public JPanel reise_buchenPage;
	
	public void design() {
		super.design();
		
		JPanel center = (JPanel) mainPage.getComponent(1);
		
		JButton btnBookResort = new JButton("Eine Reise buchen");
		btnBookResort.setPreferredSize(new Dimension(200, 300));
		
		center.add(btnBookResort);
		
		//Start new Panel page here
		reise_buchenPage = new JPanel(new BorderLayout());
		JPanel travel = new JPanel(new FlowLayout());
		reise_buchenPage.add(travel, BorderLayout.CENTER);
		
		masterPanel.add(reise_buchenPage, PAGE_REISE);
		
		//Button click switches Panel
		btnBookResort.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
				  cardLayout.show(masterPanel,PAGE_REISE);
			  } 
			} );
	}
      // inherited constructors


	public BessereMain$$Reise_buchen_base (  ) { super(); }

}



/**
 * feature to book different busreisen
 */
abstract class BessereMain$$Busreise extends  BessereMain$$Reise_buchen_base  {
	private static final long serialVersionUID = 1L;

	public static final String PAGE_BUS = "BUS";
	public JPanel busPage;
	
	public final String[] listEntries = { "Billiger Bus", "Nicht so billiger Bus", "teurer Bus", "Super-Mega-Hammer-Ultra-Deluxe Bus"};
	
	private JList list;
	
	public void design() {
		super.design();
		
		JButton btnBookBus = new JButton("Bus buchen");
		btnBookBus.setPreferredSize(new Dimension(200, 300));
		
		JPanel jurneyPanel = (JPanel) reise_buchenPage.getComponent(0);
		
		jurneyPanel.add(btnBookBus);
		
		//Start new Panel page here
		busPage = new JPanel(new BorderLayout());
		
		listBus();
		
		masterPanel.add(busPage, PAGE_BUS);
		
		//Button click switches Panel
		btnBookBus.addActionListener(new ActionListener() {
		    public void actionPerformed (ActionEvent event) {
		    	cardLayout.show(masterPanel, PAGE_BUS);
		    }
		} );
	}
	
	public void listBus() {
		
		list = new JList();

        list.setModel(new AbstractListModel() {

            @Override
            public int getSize() {
                return listEntries.length;
            }

            @Override
            public Object getElementAt(int i) {
                return listEntries[i];
            }
        });
        
    	list.addListSelectionListener(new ListSelectionListener() {
    		@Override
            public void valueChanged(ListSelectionEvent evt) {
                listValueChanged(evt);
            }
        });
        
    	busPage.add(list, BorderLayout.NORTH);
	}	
	
    private void listValueChanged(javax.swing.event.ListSelectionEvent evt) {
        //set text on right here
        final String s = (String) list.getSelectedValue();
        
        if(s.equals(listEntries[0]))
        	updateText("30 Euro");
        else if(s.equals(listEntries[1]))
        	updateText("50 Euro");
        else if(s.equals(listEntries[2]))
        	updateText("100 Euro");
        else if(s.equals(listEntries[3])) {
        	updateText("300 Euro");
        }
        
        cardLayout.show(masterPanel, PAGE_PAY);
        
    }
      // inherited constructors


	public BessereMain$$Busreise (  ) { super(); }

	
}



/**
 * feature to book different car
 */
abstract class BessereMain$$Auto_mieten extends  BessereMain$$Busreise  {
	private static final long serialVersionUID = 1L;

	public static final String PAGE_CAR = "CAR";
	public static final String PAGE_ROUTE = "ROUTE";
	
	public JPanel carPage;
	public JPanel routePage;
	
	public final String[] listEntries = { "Billiges Auto", "Nicht so billiges Auto", "teures Auto", "Super-Mega-Hammer-Ultra-Deluxe Auto"};
	
	private JList list;
	
	public void design() {
		super.design();
		
		JButton btnBookCar = new JButton("Auto mieten");
		btnBookCar.setPreferredSize(new Dimension(200, 300));
		
		JPanel jurneyPanel = (JPanel) reise_buchenPage.getComponent(0);
		
		jurneyPanel.add(btnBookCar);
		
		//Start new Panel page here
		carPage = new JPanel(new FlowLayout());
		routePage = new JPanel(new FlowLayout());
		
		listCar();
		
		masterPanel.add(carPage, PAGE_CAR);
		masterPanel.add(routePage, PAGE_ROUTE);
		
		//Button click switches Panel
		btnBookCar.addActionListener(new ActionListener() {
		    public void actionPerformed (ActionEvent event) {
		    	cardLayout.show(masterPanel, PAGE_CAR);
		    }
		} );
	}
	
	public void listCar() {
		
		list = new JList();

        list.setModel(new AbstractListModel() {

            @Override
            public int getSize() {
                return listEntries.length;
            }

            @Override
            public Object getElementAt(int i) {
                return listEntries[i];
            }
        });
        
    	list.addListSelectionListener(new ListSelectionListener() {
    		@Override
            public void valueChanged(ListSelectionEvent evt) {
                listValueChanged(evt);
            }
        });
        
    	carPage.add(list, BorderLayout.NORTH);
	}	
	
    private void listValueChanged(javax.swing.event.ListSelectionEvent evt) {
    	
    	if(isRoute == false) {
    		//set text on right here
    		final String s = (String) list.getSelectedValue();
        
    		if(s.equals(listEntries[0]))
    			updateText("30 Euro");
    		else if(s.equals(listEntries[1]))
    			updateText("50 Euro");
    		else if(s.equals(listEntries[2]))
    			updateText("100 Euro");
    		else if(s.equals(listEntries[3])) 
    			updateText("300 Euro");
    		
    		cardLayout.show(masterPanel, PAGE_PAY);
    	}
    	else {
        
        cardLayout.show(masterPanel, PAGE_ROUTE);
    	}
    }
      // inherited constructors


	public BessereMain$$Auto_mieten (  ) { super(); }	
    		  
}



/**
 * feature to plan different routes
 */
abstract class BessereMain$$Route_planen extends  BessereMain$$Auto_mieten  {
	
	
	private static final long serialVersionUID = 1L;

	public static final String PAGE_ROUTE2 = "Route2";
	public JPanel route2Page;
	
	public final String[] listEntries= { "Schnellste Route", "Kuerzeste Route", "Schoenste Route", "Keine Autobahn"};
	
	private JList list;
	
	public void design() {
		super.design();
		
		setTrue();
		
		JButton btnBookRoute2 = new JButton("Route auswaehlen");
		JButton btnBookNoRoute = new JButton("Keine Route auswaehlen");
		btnBookRoute2.setPreferredSize(new Dimension(200, 300));
		btnBookNoRoute.setPreferredSize(new Dimension(200, 300));
		
		routePage.add(btnBookRoute2);
		routePage.add(btnBookNoRoute);
		
		//Start new Panel page here
		route2Page = new JPanel(new BorderLayout());
		
		listRoute2();
		
		masterPanel.add(route2Page, PAGE_ROUTE2);
		
		//Button click switches Panel
		btnBookRoute2.addActionListener(new ActionListener() {
		    public void actionPerformed (ActionEvent event) {
		    	cardLayout.show(masterPanel, PAGE_ROUTE2);
		    }
		} );
		btnBookNoRoute.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent event) {
				cardLayout.show(masterPanel, PAGE_PAY);
			}
		});
	}
	
	public void listRoute2() {
		
		list = new JList();

        list.setModel(new AbstractListModel() {

        	

            @Override
            public int getSize() {
                return listEntries.length;
            }

            @Override
            public Object getElementAt(int i) {
                return listEntries[i];
            }
        });
        
    	list.addListSelectionListener(new ListSelectionListener() {
            
    		@Override
            public void valueChanged(ListSelectionEvent evt) {
                listValueChanged(evt);
            }
        });
        
    	route2Page.add(list, BorderLayout.NORTH);
	}	
	
    private void listValueChanged(javax.swing.event.ListSelectionEvent evt) {
        //set text on right here
        final String s = (String) list.getSelectedValue();
        
        if(s.equals(listEntries[0]))
        	updateText("30 Euro");
        else if(s.equals(listEntries[1]))
        	updateText("50 Euro");
        else if(s.equals(listEntries[2]))
        	updateText("100 Euro");
        else if(s.equals(listEntries[3])) {
        	updateText("300 Euro");
        }
        
        cardLayout.show(masterPanel, PAGE_PAY);
    }
      // inherited constructors


	public BessereMain$$Route_planen (  ) { super(); }

	
}



/**
 * feature to book different flight
 */
abstract class BessereMain$$Flug extends  BessereMain$$Route_planen  {
	private static final long serialVersionUID = 1L;

	public static final String PAGE_FLIGHT = "FLIGHT";
	public JPanel flightPage;
	
	public final String[] listEntries = { "Billiger Flug", "Nicht so billiger Flug", "teurer Flug", "Super-Mega-Hammer-Ultra-Deluxe Flug"};
	
	private JList list;
	
	public void design() {
		super.design();
		
		JButton btnBookFlight = new JButton("Flug buchen");
		btnBookFlight.setPreferredSize(new Dimension(200, 300));
		
		JPanel jurneyPanel = (JPanel) reise_buchenPage.getComponent(0);
		
		jurneyPanel.add(btnBookFlight);
		
		//Start new Panel page here
		flightPage = new JPanel(new BorderLayout());
		
		listFlight();
		
		masterPanel.add(flightPage, PAGE_FLIGHT);
		
		//Button click switches Panel
		btnBookFlight.addActionListener(new ActionListener() {
		    public void actionPerformed (ActionEvent event) {
		    	cardLayout.show(masterPanel, PAGE_FLIGHT);
		    }
		} );
	}
	
	public void listFlight() {
		
		list = new JList();

        list.setModel(new AbstractListModel() {

            @Override
            public int getSize() {
                return listEntries.length;
            }

            @Override
            public Object getElementAt(int i) {
                return listEntries[i];
            }
        });
        
    	list.addListSelectionListener(new ListSelectionListener() {
    		@Override
            public void valueChanged(ListSelectionEvent evt) {
                listValueChanged(evt);
            }
        });
        
    	flightPage.add(list, BorderLayout.NORTH);
	}	
	
    private void listValueChanged(javax.swing.event.ListSelectionEvent evt) {
        //set text on right here
        final String s = (String) list.getSelectedValue();
        
        if(s.equals(listEntries[0]))
        	updateText("30 Euro");
        else if(s.equals(listEntries[1]))
        	updateText("50 Euro");
        else if(s.equals(listEntries[2]))
        	updateText("100 Euro");
        else if(s.equals(listEntries[3])) {
        	updateText("300 Euro");
        }
        
        cardLayout.show(masterPanel, PAGE_PAY);
        
    }
      // inherited constructors


	public BessereMain$$Flug (  ) { super(); }

	
}



/**
 * feature to book different cruise
 */
abstract class BessereMain$$Kreuzfahrt extends  BessereMain$$Flug  {
	private static final long serialVersionUID = 1L;

	public static final String PAGE_SHIP = "SHIP";
	public JPanel shipPage;
	
	public final String[] listEntries = { "Billige Kreuzfahrt", "Nicht so billige Kreuzfahrt", "teure Kreuzfahrt", "Super-Mega-Hammer-Ultra-Deluxe Kreufahrt"};
	
	private JList list;
	
	public void design() {
		super.design();
		
		JButton btnBookShip = new JButton("Kreuzfahrt buchen");
		btnBookShip.setPreferredSize(new Dimension(200, 300));
		
		JPanel jurneyPanel = (JPanel) reise_buchenPage.getComponent(0);
		
		jurneyPanel.add(btnBookShip);
		
		//Start new Panel page here
		shipPage = new JPanel(new BorderLayout());
		
		listShip();
		
		masterPanel.add(shipPage, PAGE_SHIP);
		
		//Button click switches Panel
		btnBookShip.addActionListener(new ActionListener() {
		    public void actionPerformed (ActionEvent event) {
		    	cardLayout.show(masterPanel, PAGE_SHIP);
		    }
		} );
	}
	
	public void listShip() {
		
		list = new JList();

        list.setModel(new AbstractListModel() {

            @Override
            public int getSize() {
                return listEntries.length;
            }

            @Override
            public Object getElementAt(int i) {
                return listEntries[i];
            }
        });
        
    	list.addListSelectionListener(new ListSelectionListener() {
    		@Override
            public void valueChanged(ListSelectionEvent evt) {
                listValueChanged(evt);
            }
        });
        
    	shipPage.add(list, BorderLayout.NORTH);
	}	
	
    protected void listValueChanged(javax.swing.event.ListSelectionEvent evt) {
        //set text on right here
        final String s = (String) list.getSelectedValue();
        
        if(s.equals(listEntries[0]))
        	updateText("30 Euro");
        else if(s.equals(listEntries[1]))
        	updateText("50 Euro");
        else if(s.equals(listEntries[2]))
        	updateText("100 Euro");
        else if(s.equals(listEntries[3])) {
        	updateText("300 Euro");
        }
        
        cardLayout.show(masterPanel, PAGE_PAY);
        
    }
      // inherited constructors


	public BessereMain$$Kreuzfahrt (  ) { super(); }
}



/**
 * TODO base class for the trip activities
 */
abstract class BessereMain$$Aktivitaet_buchen extends  BessereMain$$Kreuzfahrt  {
	private static final long serialVersionUID = 1L;
	public static final String PAGE_AKTIVITAET = "AKTIVITAET";
	public JPanel aktivitaet_buchen;
	
	public void design() {
		super.design();
		
		JPanel center = (JPanel) mainPage.getComponent(1);		
		
		JButton btnBookResort = new JButton("Eine Aktivitaet buchen");
		btnBookResort.setPreferredSize(new Dimension(200, 300));
		
		center.add(btnBookResort);
		
		//Start new Panel page here
		aktivitaet_buchen = new JPanel(new BorderLayout());
		masterPanel.add(aktivitaet_buchen, PAGE_AKTIVITAET);
		
		//Button click switches Panel
		btnBookResort.addActionListener(new ActionListener() { 
		  public void actionPerformed(ActionEvent e) { 
			  cardLayout.show(masterPanel,PAGE_AKTIVITAET);
		  } 
		} );
	}
      // inherited constructors


	public BessereMain$$Aktivitaet_buchen (  ) { super(); }
}



/**
 * Pay with credit card
 */
abstract class BessereMain$$Kreditkarte extends  BessereMain$$Aktivitaet_buchen  {
	private static final long serialVersionUID = 1L;
	
	public void design() {
		super.design();
		
		JButton btnKreditkarte = new JButton("Bezahlen mit Kreditkarte");
		updatePrice();
		//Button click switches Panel
		btnKreditkarte.addActionListener(new ActionListener() {
		    public void actionPerformed (ActionEvent event) {
		    	cardLayout.show(masterPanel, PAGE_MAIN);
		    }
		} );
		
		JPanel lowerArea = (JPanel) payPage.getComponent(1);
		lowerArea.add(btnKreditkarte, BorderLayout.NORTH);
	}
      // inherited constructors


	public BessereMain$$Kreditkarte (  ) { super(); }
}



/**
 * enables a Waehrungsrechner
 */
public class BessereMain extends  BessereMain$$Kreditkarte  {
	private static final long serialVersionUID = 1L;
	
	private JTextField entryEuro;
	private JLabel entryDollar;
	
	public void design() {
		super.design();
		
		JLabel euro = new JLabel("Euro: ");
		euro.setHorizontalAlignment(JLabel.RIGHT);
		JLabel dollar = new JLabel("Dollar: ");
		dollar.setHorizontalAlignment(JLabel.RIGHT);
		entryEuro = new JTextField("1.00");
		entryDollar = new JLabel("1.14");
		JButton btnCalc = new JButton("Umrechnen");
		btnCalc.setHorizontalAlignment(JButton.CENTER);
		
		btnCalc.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent event) {
				double euroInput;
				try {
					euroInput = Double.parseDouble(entryEuro.getText().replace(',', '.').trim());
					String bla = String.valueOf(euroInput * 1.14);
					entryDollar.setText(bla);
				}
				catch(Exception e) {
					entryDollar.setText("Ungueltige Angabe");
				}
				
		    }
		});
		
		JPanel waehrungsPanel = (JPanel) payPage.getComponent(2);
		JPanel calcStuff = new JPanel(new GridLayout(2,2));
		calcStuff.add(euro);
		calcStuff.add(entryEuro);
		calcStuff.add(dollar);
		calcStuff.add(entryDollar);
		waehrungsPanel.add(calcStuff);
		waehrungsPanel.add(btnCalc);
	}
      // inherited constructors


	public BessereMain (  ) { super(); }
}