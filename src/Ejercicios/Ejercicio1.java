package Ejercicios;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.JTable;

public class Ejercicio1 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JButton btn_pagar;
	private JButton btn_agregarCompra;
	private JLabel lblNewLabel_3;
	private JTextField tf_totalPagar;
	private JComboBox<String> cb_marca;
	private JTextField tf_cantidad;
	private JPanel panel;
	private JTable table;
	private JScrollPane scrollPane_1;
    DefaultTableModel model = new DefaultTableModel();
	private JTextArea ta_resultados;
	private JButton btn_limpiar;
	
	String[] modelos = {
		"Motorola Buds 3 Pro Glacier Gray",
		"Nokia 8 Neptune Blue",
		"Alcatel 10 Pebble White",
		"Xiaomi 11 Lite 5G Black 128 GB",
		"Samsung 10T 5G Lunar Silver"
	};
	
	double precioModelo1 = 329.90;
	double precioModelo2 = 699.9;
	double precioModelo3 = 899.9;
	double precioModelo4 = 1699.9;
	double precioModelo5 = 1999.9;
	
	int cantidadTotalCelulares1 = 0;
	int cantidadTotalCelulares2 = 0;
	int cantidadTotalCelulares3 = 0;
	int cantidadTotalCelulares4 = 0;
	int cantidadTotalCelulares5 = 0;
	
	int cantidadObsequiosDeCelular1 = 0;
	int cantidadObsequiosDeCelular2 = 0;
	int cantidadObsequiosDeCelular3 = 0;
	int cantidadObsequiosDeCelular4 = 0;
	int cantidadObsequiosDeCelular5 = 0;
	
	double totalAPagar = 0;
	
	int cantidadObsequiosTotales = 0;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio1 frame = new Ejercicio1();
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
	public Ejercicio1() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 971, 542);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		
		panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBackground(new Color(216, 216, 216));
		panel.setBounds(0, 446, 957, 66);
		contentPane.add(panel);
		panel.setLayout(null);


		lblNewLabel = new JLabel("Total a pagar:");
		lblNewLabel.setBounds(632, 10, 109, 38);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 16));
		
		tf_totalPagar = new JTextField();
		tf_totalPagar.setEditable(false);
		tf_totalPagar.setBounds(739, 12, 208, 38);
		panel.add(tf_totalPagar);
		tf_totalPagar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tf_totalPagar.setColumns(10);
		
		btn_limpiar = new JButton("Limpiar");
		btn_limpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reiniciarApp();
			}
		});
		btn_limpiar.setFont(new Font("Dialog", Font.PLAIN, 16));
		btn_limpiar.setBounds(10, 19, 251, 29);
		panel.add(btn_limpiar);

		lblNewLabel_1 = new JLabel("Jaen Figueroa");
		lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 35));
		lblNewLabel_1.setBounds(10, 24, 258, 52);
		contentPane.add(lblNewLabel_1);

		lblNewLabel_2 = new JLabel("Marca:");
		lblNewLabel_2.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(10, 109, 59, 38);
		contentPane.add(lblNewLabel_2);

		btn_pagar = new JButton("Pagar");
		btn_pagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pagar();
				mostrarCantidadObsequios();
			}
		});
		btn_pagar.setFont(new Font("Dialog", Font.PLAIN, 16));
		btn_pagar.setBounds(10, 390, 251, 32);
		contentPane.add(btn_pagar);

		btn_agregarCompra = new JButton("Agregar compra");
		btn_agregarCompra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agregarCompra();
				imprimir();
			}
		});
		btn_agregarCompra.setFont(new Font("Dialog", Font.PLAIN, 16));
		btn_agregarCompra.setBounds(10, 348, 251, 32);
		contentPane.add(btn_agregarCompra);

		lblNewLabel_3 = new JLabel("Cantidad:");
		lblNewLabel_3.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(10, 205, 109, 38);
		contentPane.add(lblNewLabel_3);

		cb_marca = new JComboBox<>();
		cb_marca.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cb_marca.setModel(new DefaultComboBoxModel<>(modelos));
		cb_marca.setBounds(10, 157, 251, 38);
		contentPane.add(cb_marca);

		tf_cantidad = new JTextField();
		tf_cantidad.setFont(new Font("Dialog", Font.PLAIN, 16));
		tf_cantidad.setColumns(10);
		tf_cantidad.setBounds(10, 242, 251, 32);
		contentPane.add(tf_cantidad);

        model.addColumn("Marca");
        model.addColumn("Cantidad");
        model.addColumn("Importe (S/.)");
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(278, 22, 669, 323);
		contentPane.add(scrollPane_1);
		
		table = new JTable(model);
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		scrollPane_1.setViewportView(table);
		
		ta_resultados = new JTextArea();
		ta_resultados.setEditable(false);
		ta_resultados.setFont(new Font("Arial", Font.PLAIN, 18));
		ta_resultados.setBounds(278, 365, 669, 57);
		contentPane.add(ta_resultados);
		
        TableColumn columnaMarca = table.getColumnModel().getColumn(1);
        TableColumn columnaCantidad = table.getColumnModel().getColumn(1);
        TableColumn columnaImporte = table.getColumnModel().getColumn(0);

        columnaMarca.setPreferredWidth(200);
        columnaCantidad.setPreferredWidth(50);   
        columnaImporte.setPreferredWidth(150);
	}

	// METODOS PRINCIPALES

	String leerMarca(){
		return cb_marca.getSelectedItem().toString();
	}
	
	int leerCantidad() {
		return Integer.parseInt(tf_cantidad.getText());
	}
	
	double calcularImporteParcial(double precio, int cantidad) {
		return precio * cantidad;
	}
	
	void acumularCantidades(String modelo, int cantidad) {
		
		if(modelo == modelos[0]) {
			cantidadTotalCelulares1 += cantidad;
		}
		else if(modelo == modelos[1]) {
			cantidadTotalCelulares2 += cantidad;
		}
		else if(modelo == modelos[2]) {
			cantidadTotalCelulares3 += cantidad;
		}
		else if(modelo == modelos[3]) {
			cantidadTotalCelulares4 += cantidad;
		}
		else if(modelo == modelos[4]) {
			cantidadTotalCelulares5 += cantidad;
		}
	}
	
	int calcularObsequio(String modelo, int cantidad) {
		int cantidadMicas = 0;
		
		if(modelo == modelos[0]) {
			cantidadMicas = cantidad;
		}
		else if(modelo == modelos[1]) {
			cantidadMicas = cantidad;
		}
		else if(modelo == modelos[2]) {
			cantidadMicas = 2 * cantidad;
		}
		else if(modelo == modelos[3]) {
			cantidadMicas = 3 * cantidad;
		}
		else if(modelo == modelos[4]) {
			cantidadMicas = 5 * cantidad;
		}
		
		return cantidadMicas;
	}
	
	void imprimir() {
		
		double importe_1 = precioModelo1 * cantidadTotalCelulares1;
		double importe_2 = precioModelo2 * cantidadTotalCelulares2;
		double importe_3 = precioModelo3 * cantidadTotalCelulares3;
		double importe_4 = precioModelo4 * cantidadTotalCelulares4;
		double importe_5 = precioModelo5 * cantidadTotalCelulares5;
		
		model.setRowCount(0);
		
		if(cantidadTotalCelulares1 > 0) {
			model.addRow(new Object[]{modelos[0], cantidadTotalCelulares1, importe_1});
		}
		
		if(cantidadTotalCelulares2 > 0) {
			model.addRow(new Object[]{modelos[1], cantidadTotalCelulares2, importe_2});
		}
		
		if(cantidadTotalCelulares3 > 0) {
			model.addRow(new Object[]{modelos[2], cantidadTotalCelulares3, importe_3});
		}
		
		if(cantidadTotalCelulares4 > 0) {
			model.addRow(new Object[]{modelos[3], cantidadTotalCelulares4, importe_4});
		}
		
		if(cantidadTotalCelulares5 > 0) {
			model.addRow(new Object[]{modelos[4], cantidadTotalCelulares5, importe_5});
		}
		
		tf_totalPagar.setText("S/. " + totalAPagar);
	}
	
	void mostrarCantidadObsequios() {
		ta_resultados.setText("Cantidad de micas de obsequio: " + cantidadObsequiosTotales);
	}
	
	// OTROS METODOS
	
	double obtenerPrecio(String modelo) {
		double precio = 0;
	
		if(modelo == modelos[0]) {
			precio = precioModelo1;
		}
		else if(modelo == modelos[1]) {
			precio = precioModelo2;
		}
		else if(modelo == modelos[2]) {
			precio = precioModelo3;
		}
		else if(modelo == modelos[3]) {
			precio = precioModelo4;
		}
		else if(modelo == modelos[4]) {
			precio = precioModelo5;
		}

		return precio;
	}
	
	void agregarCompra() {
		//leer los campos de entrada
		String marca = leerMarca();
		int cantidad = leerCantidad();
		double precio = obtenerPrecio(marca);
		
		// acumular cantidadees
		double importeParcial = calcularImporteParcial(precio, cantidad);
		totalAPagar += importeParcial;
		
		acumularCantidades(marca, cantidad);
	}
	
	void pagar() {
		cantidadObsequiosDeCelular1 = calcularObsequio(modelos[0], cantidadTotalCelulares1);
		cantidadObsequiosDeCelular2 = calcularObsequio(modelos[1], cantidadTotalCelulares2);
		cantidadObsequiosDeCelular3 = calcularObsequio(modelos[2], cantidadTotalCelulares3);
		cantidadObsequiosDeCelular4 = calcularObsequio(modelos[3], cantidadTotalCelulares4);
		cantidadObsequiosDeCelular5 = calcularObsequio(modelos[4], cantidadTotalCelulares5);
		
		cantidadObsequiosTotales = 
				cantidadObsequiosDeCelular1 +
				cantidadObsequiosDeCelular2 +
				cantidadObsequiosDeCelular3 +
				cantidadObsequiosDeCelular4 +
				cantidadObsequiosDeCelular5;
	}
	
	void reiniciarApp() {
		// reiniciar valores de las variables
		cantidadTotalCelulares1 = 0;
		cantidadTotalCelulares2 = 0;
		cantidadTotalCelulares3 = 0;
		cantidadTotalCelulares4 = 0;
		cantidadTotalCelulares5 = 0;
		
		totalAPagar = 0;
		
		cantidadObsequiosTotales = 0;
		
		// limpiar visualmente
		model.setRowCount(0);
		tf_cantidad.setText("");
		tf_totalPagar.setText("");
		ta_resultados.setText("");
		cb_marca.setSelectedIndex(0);
	}
}
