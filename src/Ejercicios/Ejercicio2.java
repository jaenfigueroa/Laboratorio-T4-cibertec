package Ejercicios;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.util.Random;

import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.border.EtchedBorder;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Ejercicio2 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btn_lanzar_jugador1;
	private JPanel panel;
	private JLabel lbl_jugador1_lanzamiento1;
	private JLabel lbl_jugador1_lanzamiento2;
	private JLabel lbl_jugador1_lanzamiento3;
	private JLabel lblNewLabel_1;
	private JPanel panel_1;
	private JButton btn_lanzar_jugador2;
	private JLabel lblNewLabel_2;
	private JLabel lbl_jugador2_lanzamiento1;
	private JLabel lbl_jugador2_lanzamiento2;
	private JLabel lbl_jugador2_lanzamiento3;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel;
	private JLabel lbl_ganador;
	private JPanel panel_2;
	private JLabel lblNewLabel_5;
	private JLabel lbl_jugador1_total;
	private JLabel lbl_jugador2_total;
	private JLabel lbl_numeroAConseguir;
	private JButton btn_iniciarJuego;
	private JButton btn_reiniciarJuego;
	private JLabel Lbl;
	private JPanel panel_3;
	private JPanel panel_4;
	private JPanel panel_5;

	// VARIABLES GLOBALES
	
	int numeroAConseguir = 0;

	int jugador1_dado1 = 0;
	int jugador1_dado2 = 0;
	int jugador1_dado3 = 0;

	int jugador2_dado1 = 0;
	int jugador2_dado2 = 0;
	int jugador2_dado3 = 0;

	int jugador1_total = 0;
	int jugador2_total = 0;
	
	boolean jugador1_botonPrecionado = false;
	boolean jugador2_botonPrecionado = false;
	
	String ganador = "";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio2 frame = new Ejercicio2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Ejercicio2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 969, 771);
		setLocationRelativeTo(null);
		contentPane = new JPanel();

		setContentPane(contentPane);
		contentPane.setLayout(null);

		panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(10, 274, 409, 450);
		contentPane.add(panel);
		panel.setLayout(null);

		btn_lanzar_jugador1 = new JButton("Lanzar dados");
		btn_lanzar_jugador1.setEnabled(false);
		btn_lanzar_jugador1.setBounds(133, 265, 155, 38);
		panel.add(btn_lanzar_jugador1);
		btn_lanzar_jugador1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_lanzar_jugador1.setEnabled(false);
				jugador1_botonPrecionado = true;
				
				generarDadosParaJugador(1);
				procesarJuego();
			}
		});
		btn_lanzar_jugador1.setFont(new Font("Tahoma", Font.PLAIN, 18));

		lbl_jugador1_lanzamiento1 = new JLabel("");
		lbl_jugador1_lanzamiento1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_jugador1_lanzamiento1.setForeground(new Color(255, 0, 128));
		lbl_jugador1_lanzamiento1.setBounds(10, 313, 129, 127);
		panel.add(lbl_jugador1_lanzamiento1);

		lbl_jugador1_lanzamiento2 = new JLabel("");
		lbl_jugador1_lanzamiento2.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_jugador1_lanzamiento2.setForeground(new Color(255, 0, 128));
		lbl_jugador1_lanzamiento2.setBounds(141, 313, 129, 127);
		panel.add(lbl_jugador1_lanzamiento2);

		lbl_jugador1_lanzamiento3 = new JLabel("");
		lbl_jugador1_lanzamiento3.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_jugador1_lanzamiento3.setForeground(new Color(255, 0, 128));
		lbl_jugador1_lanzamiento3.setBounds(270, 313, 129, 127);
		panel.add(lbl_jugador1_lanzamiento3);
		
		panel_4 = new JPanel();
		panel_4.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_4.setBackground(new Color(223, 223, 223));
		panel_4.setBounds(0, 0, 409, 48);
		panel.add(panel_4);
		panel_4.setLayout(null);

		lblNewLabel_1 = new JLabel("  Jugador 1");
		lblNewLabel_1.setBounds(0, 0, 409, 48);
		panel_4.add(lblNewLabel_1);
		lblNewLabel_1.setBackground(new Color(223, 223, 223));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));

		lblNewLabel = new JLabel("Cantidad obtenida:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(10, 78, 389, 38);
		panel.add(lblNewLabel);

		lbl_jugador1_total = new JLabel("_");
		lbl_jugador1_total.setForeground(new Color(0, 128, 255));
		lbl_jugador1_total.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_jugador1_total.setFont(new Font("Tahoma", Font.PLAIN, 80));
		lbl_jugador1_total.setBounds(148, 138, 122, 105);
		panel.add(lbl_jugador1_total);

		panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBounds(536, 274, 409, 450);
		contentPane.add(panel_1);

		btn_lanzar_jugador2 = new JButton("Lanzar dados");
		btn_lanzar_jugador2.setEnabled(false);
		btn_lanzar_jugador2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_lanzar_jugador2.setEnabled(false);
				jugador2_botonPrecionado = true;
				
				generarDadosParaJugador(2);
				procesarJuego();
			}
		});
		btn_lanzar_jugador2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn_lanzar_jugador2.setBounds(126, 265, 163, 38);
		panel_1.add(btn_lanzar_jugador2);

		lblNewLabel_2 = new JLabel("Cantidad obtenida:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_2.setBounds(20, 86, 389, 38);
		panel_1.add(lblNewLabel_2);

		lbl_jugador2_lanzamiento1 = new JLabel("");
		lbl_jugador2_lanzamiento1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_jugador2_lanzamiento1.setForeground(new Color(255, 0, 128));
		lbl_jugador2_lanzamiento1.setBounds(10, 313, 129, 127);
		panel_1.add(lbl_jugador2_lanzamiento1);

		lbl_jugador2_lanzamiento2 = new JLabel("");
		lbl_jugador2_lanzamiento2.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_jugador2_lanzamiento2.setForeground(new Color(255, 0, 128));
		lbl_jugador2_lanzamiento2.setBounds(141, 313, 129, 127);
		panel_1.add(lbl_jugador2_lanzamiento2);

		lbl_jugador2_lanzamiento3 = new JLabel("");
		lbl_jugador2_lanzamiento3.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_jugador2_lanzamiento3.setForeground(new Color(255, 0, 128));
		lbl_jugador2_lanzamiento3.setBounds(274, 313, 129, 127);
		panel_1.add(lbl_jugador2_lanzamiento3);
		
		panel_5 = new JPanel();
		panel_5.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_5.setBackground(new Color(223, 223, 223));
		panel_5.setBounds(0, 0, 409, 48);
		panel_1.add(panel_5);
		panel_5.setLayout(null);

		lblNewLabel_3 = new JLabel("  Jugador 2");
		lblNewLabel_3.setBounds(0, 0, 409, 48);
		panel_5.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 20));

		lbl_jugador2_total = new JLabel("_");
		lbl_jugador2_total.setForeground(new Color(0, 128, 255));
		lbl_jugador2_total.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_jugador2_total.setFont(new Font("Tahoma", Font.PLAIN, 80));
		lbl_jugador2_total.setBounds(158, 134, 122, 105);
		panel_1.add(lbl_jugador2_total);
		
		panel_3 = new JPanel();
		panel_3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_3.setBackground(new Color(223, 223, 223));
		panel_3.setBounds(0, 0, 955, 101);
		contentPane.add(panel_3);
		panel_3.setLayout(null);

		lbl_ganador = new JLabel("________");
		lbl_ganador.setBounds(495, 10, 256, 76);
		panel_3.add(lbl_ganador);
		lbl_ganador.setForeground(new Color(0, 128, 64));
		lbl_ganador.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_ganador.setFont(new Font("Tahoma", Font.BOLD, 50));
		
		Lbl = new JLabel("Ganador:");
		Lbl.setBounds(247, 10, 240, 76);
		panel_3.add(Lbl);
		Lbl.setHorizontalAlignment(SwingConstants.CENTER);
		Lbl.setForeground(new Color(0, 128, 64));
		Lbl.setFont(new Font("Tahoma", Font.BOLD, 50));

		panel_2 = new JPanel();
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_2.setBounds(403, 139, 368, 101);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		lblNewLabel_5 = new JLabel("Número a llegar: ");
		lblNewLabel_5.setForeground(new Color(0, 0, 0));
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblNewLabel_5.setBounds(25, 21, 215, 58);
		panel_2.add(lblNewLabel_5);

		lbl_numeroAConseguir = new JLabel("_");
		lbl_numeroAConseguir.setForeground(new Color(0, 0, 0));
		lbl_numeroAConseguir.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_numeroAConseguir.setFont(new Font("Tahoma", Font.PLAIN, 80));
		lbl_numeroAConseguir.setBounds(247, 0, 108, 93);
		panel_2.add(lbl_numeroAConseguir);

		btn_iniciarJuego = new JButton("Iniciar");
		btn_iniciarJuego.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				IniciarJuego();
			}
		});
		btn_iniciarJuego.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn_iniciarJuego.setBounds(221, 139, 155, 43);
		contentPane.add(btn_iniciarJuego);
		
		btn_reiniciarJuego = new JButton("Reiniciar");
		btn_reiniciarJuego.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reiniciarJuego();
			}
		});
		btn_reiniciarJuego.setEnabled(false);
		btn_reiniciarJuego.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn_reiniciarJuego.setBounds(221, 197, 155, 43);
		contentPane.add(btn_reiniciarJuego);
	}

	// METODOS
	
	void IniciarJuego() {
		btn_iniciarJuego.setEnabled(false);
		
		determinarNumeroAConseguir();
		mostrarNumeroAConseguir();
		
		habilitarJugadores();
	}
	
	void procesarJuego() {
		if (
			jugador1_botonPrecionado &&
			jugador2_botonPrecionado
		) {
			mostrarResultados();
			mostrarDados();
			determinarGanador();
			mostrarGanador();
			
			btn_reiniciarJuego.setEnabled(true);
		}
	}

	void generarDadosParaJugador(int jugador) {
		
		int dadoAleatorio1 = obtenerNumeroAleatorio(1, 6);
		int dadoAleatorio2 = obtenerNumeroAleatorio(1, 6);
		int dadoAleatorio3 = obtenerNumeroAleatorio(1, 6);
		
		if(jugador == 1) {
			jugador1_dado1 = dadoAleatorio1;
			jugador1_dado2 = dadoAleatorio2;
			jugador1_dado3 = dadoAleatorio3;
			jugador1_total = dadoAleatorio1 + dadoAleatorio2 + dadoAleatorio3;
		}
		else {
			jugador2_dado1 = dadoAleatorio1;
			jugador2_dado2 = dadoAleatorio2;
			jugador2_dado3 = dadoAleatorio3;
			jugador2_total = dadoAleatorio1 + dadoAleatorio2 + dadoAleatorio3;
		}
	}
	
	void mostrarResultados() {
		lbl_jugador1_total.setText(jugador1_total + "");
		lbl_jugador2_total.setText(jugador2_total + "");	
	}
	
	void mostrarDados() {
		lbl_jugador1_lanzamiento1.setIcon(obtenerImagenDado(jugador1_dado1));
		lbl_jugador1_lanzamiento2.setIcon(obtenerImagenDado(jugador1_dado2));
		lbl_jugador1_lanzamiento3.setIcon(obtenerImagenDado(jugador1_dado3));
		
		lbl_jugador2_lanzamiento1.setIcon(obtenerImagenDado(jugador2_dado1));
		lbl_jugador2_lanzamiento2.setIcon(obtenerImagenDado(jugador2_dado2));
		lbl_jugador2_lanzamiento3.setIcon(obtenerImagenDado(jugador2_dado3));
	}
	
	ImageIcon obtenerImagenDado(int numero){
		String rutaImagen = "";
		
		switch (numero) {
			case 1: {
				rutaImagen = "/assets/dado-1.png";
				break;
			}
			case 2: {
				rutaImagen = "/assets/dado-2.png";
				break;
			}
			case 3: {
				rutaImagen = "/assets/dado-3.png";
				break;
			}
			case 4: {
				rutaImagen = "/assets/dado-4.png";
				break;
			}
			case 5: {
				rutaImagen = "/assets/dado-5.png";
				break;
			}
			case 6: {
				rutaImagen = "/assets/dado-6.png";
			}
		}
		
		return crearImagen(100, 100, rutaImagen);
	}
	
	void determinarNumeroAConseguir() {
		numeroAConseguir = obtenerNumeroAleatorio(3, 18);
		
	}
	
	void mostrarNumeroAConseguir() {
		lbl_numeroAConseguir.setText(numeroAConseguir + "");
	}
	
	void habilitarJugadores() {
		btn_lanzar_jugador1.setEnabled(true);
		btn_lanzar_jugador2.setEnabled(true);
	}
	
	void determinarGanador() {
		int jugador1_ditancia = Math.abs(numeroAConseguir - jugador1_total);
		int jugador2_ditancia = Math.abs(numeroAConseguir - jugador2_total);
		
		
		if(jugador1_ditancia < jugador2_ditancia) {
			ganador = "Jugador 1";
		}
		else if(jugador1_ditancia > jugador2_ditancia){
			ganador = "Jugador 2";
		}
		else {
			ganador = "Empate";
		}
	}
	
	void mostrarGanador() {
		lbl_ganador.setText(ganador);
	}
	
	void reiniciarJuego() {
		// reiniciar la interfaz
		lbl_ganador.setText("________");
		lbl_jugador1_total.setText("_");
		lbl_jugador2_total.setText("_");
		lbl_numeroAConseguir.setText("_");
		btn_reiniciarJuego.setEnabled(false);
		btn_iniciarJuego.setEnabled(true);
		
		// reiniciar variables
		numeroAConseguir = 0;

		jugador1_dado1 = 0;
		jugador1_dado2 = 0;
		jugador1_dado3 = 0;

		jugador2_dado1 = 0;
		jugador2_dado2 = 0;
		jugador2_dado3 = 0;

		jugador1_total = 0;
		jugador2_total = 0;
		
		jugador1_botonPrecionado = false;
		jugador2_botonPrecionado = false;
		
		ganador = "";
		
		// remover imagenes de dados lanzados
		lbl_jugador1_lanzamiento1.setIcon(null);
		lbl_jugador1_lanzamiento2.setIcon(null);
		lbl_jugador1_lanzamiento3.setIcon(null);
		
		lbl_jugador2_lanzamiento1.setIcon(null);
		lbl_jugador2_lanzamiento2.setIcon(null);
		lbl_jugador2_lanzamiento3.setIcon(null);
	}
	
	// UTILIDADES

	int obtenerNumeroAleatorio(int minimo, int maximo) {
		Random numero = new Random();
		return numero.nextInt(minimo, maximo + 1);
	}

	public ImageIcon crearImagen(int ancho, int alto, String rutaRelativa) {
		ImageIcon icon = new ImageIcon(Ejercicio2.class.getResource(rutaRelativa));
		Image image = icon.getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(image);
		return scaledIcon;
	}

}
