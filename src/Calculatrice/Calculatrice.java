package calculatrice;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.awt.event.ActionEvent;

public class Calculatrice {

	private JFrame frame;
	private String affiche = "";
	private Double number = null;
	private Double nbNext = null;
	private Double sign = null;
	private Double valueM = .0;
	private char operator;
	private boolean isOn = false;
	private char operatorForEqual;
	private Double numberForEqual;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculatrice window = new Calculatrice();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Calculatrice() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setBounds(100, 100, 400, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel ScreenZone = new JPanel();
		ScreenZone.setBackground(new Color(135, 206, 250));
		ScreenZone.setBounds(26, 75, 336, 50);
		frame.getContentPane().add(ScreenZone);
		ScreenZone.setLayout(null);

		JLabel Screen = new JLabel("");
		Screen.setHorizontalAlignment(SwingConstants.RIGHT);
		Screen.setBounds(36, 0, 300, 50);
		ScreenZone.add(Screen);
		Screen.setBackground(Color.WHITE);

		JPanel BouttonContainer = new JPanel();
		BouttonContainer.setBackground(Color.DARK_GRAY);
		BouttonContainer.setBounds(10, 163, 364, 267);
		frame.getContentPane().add(BouttonContainer);
		BouttonContainer.setLayout(null);

		JPanel SolarZone = new JPanel();
		SolarZone.setBackground(Color.GRAY);
		SolarZone.setBounds(100, 11, 182, 44);
		frame.getContentPane().add(SolarZone);

		JButton MRC = new JButton("MRC");
		MRC.setBounds(10, 11, 60, 40);
		BouttonContainer.add(MRC);
		MRC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (isOn == true) {
					affiche = Double.toString(valueM);
					afficheText(Screen);
					number = valueM;
				}
			}
		});

		JButton MMore = new JButton("M+");
		MMore.setBounds(80, 11, 60, 40);
		BouttonContainer.add(MMore);
		MMore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (isOn == true) {
					valueM += Double.parseDouble(Screen.getText());
				}
			}
		});

		JButton MLess = new JButton("M-");
		MLess.setBounds(150, 11, 60, 40);
		BouttonContainer.add(MLess);
		MLess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (isOn == true) {
					valueM -= Double.parseDouble(Screen.getText());
				}
			}
		});

		JButton CE = new JButton("CE");
		CE.setBounds(220, 11, 60, 40);
		BouttonContainer.add(CE);
		CE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (isOn == true) {
					Screen.setText("0");
					affiche = "";
					number = 0.0;
				}
			}
		});

		JButton ON = new JButton("ON");
		ON.setBackground(Color.RED);
		ON.setBounds(290, 11, 60, 40);
		BouttonContainer.add(ON);
		ON.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (isOn == false) {
					isOn = true;
				}
				if (isOn == true) {
					affiche = "0";
					Screen.setText(affiche);
					number = 0.0;
					nbNext = null;
					operator = '\u0000';
					operatorForEqual = '\u0000';
					numberForEqual = null;
				}
			}
		});

		JButton ZERO = new JButton("0");
		ZERO.setBounds(10, 216, 60, 40);
		BouttonContainer.add(ZERO);
		ZERO.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (isOn == true) {
					if (Screen.getText() != "0") {
						Screen.setText(affiche + "0");
						affiche = Screen.getText();
						number = Double.valueOf(affiche);
					}
				}
			}
		});

		JButton ONE = new JButton("1");
		ONE.setBounds(10, 164, 60, 40);
		BouttonContainer.add(ONE);
		ONE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (isOn == true) {
					if (Screen.getText() == "0") {
						Screen.setText("1");
					} else {
						Screen.setText(affiche + "1");
					}
					affiche = Screen.getText();
					number = Double.valueOf(affiche);

				}
			}
		});

		JButton TWO = new JButton("2");
		TWO.setBounds(80, 164, 60, 40);
		BouttonContainer.add(TWO);
		TWO.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (isOn == true) {
					if (Screen.getText() == "0") {
						Screen.setText("2");
					} else {
						Screen.setText(affiche + "2");
					}
					affiche = Screen.getText();
					number = Double.valueOf(affiche);
				}
			}
		});

		JButton THREE = new JButton("3");
		THREE.setBounds(150, 164, 60, 40);
		BouttonContainer.add(THREE);
		THREE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (isOn == true) {
					if (Screen.getText() == "0") {
						Screen.setText("3");
					} else {
						Screen.setText(affiche + "3");
					}
					affiche = Screen.getText();
					number = Double.valueOf(affiche);
				}
			}
		});

		JButton FOR = new JButton("4");
		FOR.setBounds(10, 113, 60, 40);
		BouttonContainer.add(FOR);
		FOR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (isOn == true) {
					if (Screen.getText() == "0") {
						Screen.setText("4");
					} else {
						Screen.setText(affiche + "4");
					}
					affiche = Screen.getText();
					number = Double.valueOf(affiche);
				}
			}
		});

		JButton FIVE = new JButton("5");
		FIVE.setBounds(80, 113, 60, 40);
		BouttonContainer.add(FIVE);
		FIVE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (isOn == true) {
					if (Screen.getText() == "0") {
						Screen.setText("5");
					} else {
						Screen.setText(affiche + "5");
					}
					affiche = Screen.getText();
					number = Double.valueOf(affiche);
				}
			}
		});

		JButton SIX = new JButton("6");
		SIX.setBounds(150, 113, 60, 40);
		BouttonContainer.add(SIX);
		SIX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (isOn == true) {
					if (Screen.getText() == "0") {
						Screen.setText("6");
					} else {
						Screen.setText(affiche + "6");
					}
					affiche = Screen.getText();
					number = Double.valueOf(affiche);
				}
			}
		});

		JButton SEVEN = new JButton("7");
		SEVEN.setBounds(10, 62, 60, 40);
		BouttonContainer.add(SEVEN);
		SEVEN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (isOn == true) {
					if (Screen.getText() == "0") {
						Screen.setText("7");
					} else {
						Screen.setText(affiche + "7");
					}
					affiche = Screen.getText();
					number = Double.valueOf(affiche);
				}
			}
		});

		JButton EIGHT = new JButton("8");
		EIGHT.setBounds(80, 62, 60, 40);
		BouttonContainer.add(EIGHT);
		EIGHT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (isOn == true) {
					if (Screen.getText() == "0") {
						Screen.setText("8");
					} else {
						Screen.setText(affiche + "8");
					}
					affiche = Screen.getText();
					number = Double.valueOf(affiche);
				}
			}
		});

		JButton NINE = new JButton("9");
		NINE.setBounds(150, 62, 60, 40);
		BouttonContainer.add(NINE);
		NINE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (isOn == true) {
					if (Screen.getText() == "0") {
						Screen.setText("9");
					} else {
						Screen.setText(affiche + "9");
					}
					affiche = Screen.getText();
					number = Double.valueOf(affiche);
				}
			}
		});

		JButton Point = new JButton(".");
		Point.setBounds(80, 216, 60, 40);
		BouttonContainer.add(Point);
		Point.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (isOn == true) {
					if (affiche.equals("")) {
						Screen.setText(affiche + "0.");
						affiche = Screen.getText();
						number = Double.valueOf(affiche);
					} else if (affiche.indexOf(".") == -1) {
						Screen.setText(affiche + ".");
						affiche = Screen.getText();
						number = Double.valueOf(affiche);
					}
				}
			}
		});

		JButton Root = new JButton("\u221A ");
		Root.setBounds(290, 62, 60, 40);
		BouttonContainer.add(Root);
		Root.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (isOn == true) {
					testNumber();
					if (number < 0) {
						affiche = "Une racine est forcément positive";
						afficheText(Screen);
					} else {
						number = Math.sqrt(number);
						afficheNumber(Screen);
						testNbNext();
					}
				}
			}
		});

		JButton Percent = new JButton("%");
		Percent.setBounds(220, 62, 60, 40);
		BouttonContainer.add(Percent);
		Percent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (isOn == true) {
					System.out.println("Entrée % nbMémoire = " + nbNext + " signe " + operator + " nbEntrée = " + number + " %");
					if (nbNext == null) {
						number = 0.0;
					}
					if (number == null) {
						number = nbNext;
					}
					if (operator == '+' || operator == '-') {
						number = (number * nbNext) / 100;
					} else if (operator == '*' || operator == '/') {
						number = number / 100;
					}
					System.out.println(
							"Sortie % nbMémoire = " + nbNext + " signe " + operator + " nbEntrée = " + number + "\n");
					afficheNumber(Screen);
				}
			}
		});

		JButton Signe = new JButton("+/-");
		Signe.setBounds(150, 216, 60, 40);
		BouttonContainer.add(Signe);
		Signe.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				if (isOn == true) {
					if (!Screen.getText().equals("0")) {
						sign = Double.valueOf(Screen.getText());
						sign = -sign;
						Screen.setText(Double.toString(sign));
					}
					affiche = Screen.getText();
					number = Double.valueOf(affiche);
				}
			}
		});

		JButton Add = new JButton("+");
		Add.setBounds(220, 164, 60, 92);
		BouttonContainer.add(Add);
		Add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (isOn == true) {
					calculer(Screen);
					operator = '+';
					System.out.println("Sortie > nbMémoire = " + nbNext + " signe " + operator + " nbEntrée = " + number + "\n");
				}
			}
		});

		JButton Substract = new JButton("-");
		Substract.setBounds(290, 164, 60, 40);
		BouttonContainer.add(Substract);
		Substract.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (isOn == true) {
					calculer(Screen);
					operator = '-';
					System.out.println("Sortie > nbMémoire = " + nbNext + " signe " + operator + " nbEntrée = " + number + "\n");
				}
			}
		});

		JButton Multiply = new JButton("X");
		Multiply.setBounds(220, 113, 60, 40);
		BouttonContainer.add(Multiply);
		Multiply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (isOn == true) {
					calculer(Screen);
					operator = '*';
					System.out.println("Sortie > nbMémoire = " + nbNext + " signe " + operator + " nbEntrée = " + number + "\n");
				}
			}
		});

		JButton Divide = new JButton("\u00F7");
		Divide.setBounds(290, 113, 60, 40);
		BouttonContainer.add(Divide);
		Divide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (isOn == true) {
					calculer(Screen);
					operator = '/';
					System.out.println("Sortie > nbMémoire = " + nbNext + " signe " + operator + " nbEntrée = " + number + "\n");
				}
			}
		});

		JButton Equal = new JButton("=");
		Equal.setBounds(290, 216, 60, 40);
		BouttonContainer.add(Equal);
		Equal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (isOn == true) {
					if (nbNext == null) {
						nbNext = number;
					} else if (operator == '\u0000') {
						if (number != null) {
							nbNext = number;
						}
						operator = operatorForEqual;
						number = numberForEqual;
						calculer(Screen);
					} else {
						if (number == null) {
							number = nbNext;
						}
						numberForEqual = number;
						calculer(Screen);
						operatorForEqual = operator;
					}
					operator = '\u0000';
					System.out.println("Sortie > nbMémoire = " + nbNext + " signe " + operator + " nbEntrée = " + number + "\n");
				}
			}
		});
	}

	private void calculer(JLabel Screen) {
		System.out.println("Entrée > nbMémoire = " + nbNext + " signe " + operator + " nbEntrée = " + number);
		if (number != null) {
			switch (operator) {
			case '+':
				nbNext += number;
				afficheNbNext(Screen);
				break;
			case '-':
				nbNext -= number;
				afficheNbNext(Screen);
				break;
			case '*':
				nbNext *= number;
				afficheNbNext(Screen);
				break;
			case '/':
				if (number == 0) {
					affiche = "La division par 0 est impossible";
					afficheText(Screen);
				} else {
					nbNext /= number;
					afficheNbNext(Screen);
				}
				break;
			default:
				nbNext = number;
				afficheNbNext(Screen);
			}
		}
		number = null;
	}

	private void afficheNbNext(JLabel Screen) {
		affiche = "";
		Screen.setText(format(nbNext));
	}

	private void afficheNumber(JLabel Screen) {
		affiche = "";
		Screen.setText(format(number));
	}

	private void afficheText(JLabel Screen) {
		Screen.setText(affiche);
		affiche = "";
	}

	private void testNumber() {
		if (number == null) {
			number = nbNext;
		}
	}

	private void testNbNext() {
		if (nbNext == null) {
			nbNext = number;
			number = null;
		}
	}

	public String format(Double result) {
		DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols(Locale.US);
		DecimalFormat df = new DecimalFormat("#.###############", otherSymbols);
		String resultFormat = df.format(result);
		return resultFormat;
	}

}
