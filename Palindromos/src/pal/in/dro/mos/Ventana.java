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

	// creamos los componentes y los inicializamos
	private static final long serialVersionUID = 1L;
	private static String version = "v1.1.1";
	private JLabel indicacion = new JLabel();
	private JTextField palabra = new JTextField();;
	private JButton ejecutar = new JButton("Ejecutar");
	private JTextField resultado = new JTextField();;
	private JTextArea areaTexto = new JTextArea();;
	private JButton salir = new JButton("Salir");;
	private JLabel labelVersion = new JLabel();
	private JButton limpiar = new JButton("Limpiar");
	private JLabel autor = new JLabel("by Hernán Velásquez | hernandvo@gmail.com");

	public Ventana() {
		super();
		saludar();
		configurarVentana();
		inicializarComponentes();
		setIconImage(new ImageIcon("fv").getImage());
	}

	private void configurarVentana() {
		this.setTitle("Palindromos");
		this.setSize(600, 360);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void inicializarComponentes() {

		// configuramos los componentes
		indicacion.setText("Ingrese una palabra para escribirla invertida y decir si es palíndromo o no.");
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
		salir.setToolTipText("Presione para salir");
		labelVersion.setBounds(565, 320, 40, 10);
		labelVersion.setText(version);
		labelVersion.setFont(new java.awt.Font("Tahoma", 0, 10));
		limpiar.setBounds(20, 260, 100, 30);
		autor.setBounds(2, 320, 300, 10);
		autor.setFont(new java.awt.Font("Tahoma", 0, 10));
		salir.addActionListener(this);
		ejecutar.addActionListener(this);
		limpiar.addActionListener(this);

		// adicionamos los componentes a la ventana
		this.add(indicacion);
		this.add(palabra);
		this.add(ejecutar);
		this.add(resultado);
		this.add(areaTexto);
		this.add(salir);
		this.add(labelVersion);
		this.add(limpiar);
		this.add(autor);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Limpiar")) { // Metodos del boton Limpiar
			limpiar();
		}
		if (e.getActionCommand().equals("Salir")) { // Metodos del boton Salir
			JOptionPane.showMessageDialog(this, "Gracias por usar este programa.");
			System.exit(DISPOSE_ON_CLOSE);
		}
		if (e.getActionCommand().equals("Ejecutar")) { // Metodos del boton Ejecutar
			if (palabra.getText().length() == 0) {
				JOptionPane.showMessageDialog(this, "Debe ingresar almenos una palabra en la caja de texto.");
				limpiar();
			} else {
				String cadenaInvertida = invertirCadena(palabra.getText());
				boolean isPalindromo = verificarPalindromo(palabra.getText().toUpperCase());
				areaTexto.setText(cadenaInvertida);
				if (isPalindromo) {
					resultado.setText("SI es palindromo.");
				} else {
					resultado.setText("NO es palindromo.");
				}
			}
		}

	}

	private void limpiar() {
		resultado.setText(null);
		areaTexto.setText(null);
		palabra.setText(null);
		palabra.requestFocus();
	}

	private void saludar() {
		JOptionPane.showMessageDialog(this, "Bienvenido.\n" + "Hoy es un gran día" + "!");
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