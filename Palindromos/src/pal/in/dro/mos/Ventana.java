package pal.in.dro.mos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Ventana extends javax.swing.JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private static String version = "v1.0";
	private JLabel indicacion = new JLabel();
	private JTextField palabra = new JTextField();;
	private JButton ejecutar = new JButton("Ejecutar");
	private JTextField resultado;
	private JTextArea areaTexto;
	private JButton salir;
	private JLabel labelVersion = new JLabel();

	public Ventana() {
		super();
		saludar();
		configurarVentana();
		inicializarComponentes();
		setIconImage(new ImageIcon("fv").getImage());
	}

	private void configurarVentana() {
		this.setTitle("Palindromos | by Hernán Velásquez");
		this.setSize(600, 360);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void inicializarComponentes() {
		// creamos los componentes
		resultado = new JTextField();
		areaTexto = new JTextArea();
		salir = new JButton("Salir");

		// configuramos los componentes
		indicacion.setText("Ingrese una palabra para escribirla invertida y decir si es palindromo o no.");
		indicacion.setBounds(20, 20, 560, 40);
		indicacion.setFont(new java.awt.Font("Tahoma", 0, 17));
		palabra.setBounds(200, 80, 200, 30);
		palabra.setToolTipText("No usar signos de puntuación.");
		ejecutar.setBounds(250, 130, 100, 30);
		resultado.setBounds(200, 180, 200, 30);
		resultado.setFont(new java.awt.Font("Tahoma", 0, 20));
		resultado.setEditable(false);
		areaTexto.setBounds(200, 230, 200, 50);
		areaTexto.setEditable(false);
		salir.setBounds(480, 260, 100, 30);
		salir.addActionListener(this);
		ejecutar.addActionListener(this);
		salir.setToolTipText("Presione para salir");
		labelVersion.setBounds(270, 320, 30, 10);
		labelVersion.setText(version);

		// adicionamos los componentes a la ventana
		this.add(indicacion);
		this.add(palabra);
		this.add(ejecutar);
		this.add(resultado);
		this.add(areaTexto);
		this.add(salir);
		this.add(labelVersion);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Ejecutar")) {
			if (palabra.getText().length() == 0) {
				JOptionPane
						.showMessageDialog(this,
								"Debe ingresar almenos una palabra en la caja de texto.");
				resultado.setText(null);
				areaTexto.setText(null);
			} else {
				String cadenaInvertida = invertirCadena(palabra.getText());
				boolean isPalindromo = verificarPalindromo(palabra.getText()
						.toUpperCase());
				areaTexto.setText(cadenaInvertida);
				if (isPalindromo) {
					resultado.setText("SI es palindromo.");
				} else {
					resultado.setText("NO es palindromo.");
				}
			}
		}
		if (e.getActionCommand().equals("Salir")) {
			JOptionPane.showMessageDialog(this,
					"Gracias por usar este programa.");
			System.exit(DISPOSE_ON_CLOSE);
		}

	}

	private void saludar() {
		JOptionPane.showMessageDialog(this, "Bienvenido\n"
				+ "Hoy es un gran día" + ".");
	}

	private String invertirCadena(String text) {
		return new StringBuffer(text).reverse().toString();
	}

	private boolean verificarPalindromo(String text) {
		text = text.replaceAll(" ", "");
		for (int i = 0; i < text.length(); i++) {
			if (text.charAt(i) != text.charAt(text.length() - i - 1)) {
				return false;
			}
		}
		return true;
	}
}