package views;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;

public class FrmPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	public static JTextPane textPane;
	public static String sTextoAntiguo = "", sTextoNuevo;

	public FrmPrincipal() {
		int iX, iY;
		
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		
		iX = (screensize.width - 600) / 2;
		iY = (screensize.height - 400) / 2;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(iX, iY, 600, 400);
		setTitle("Editor de texto");
		setIconImage(Toolkit.getDefaultToolkit().createImage("Notas.png"));
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		JMenuItem miNuevo = new JMenuItem("Nuevo");
		mnArchivo.add(miNuevo);
		
		JMenuItem miAbrir = new JMenuItem("Abrir");
		mnArchivo.add(miAbrir);
		
		JMenuItem miGuardar = new JMenuItem("Guardar");
		mnArchivo.add(miGuardar);
		
		JMenuItem miGuardarComo = new JMenuItem("Guardar Como");
		mnArchivo.add(miGuardarComo);
		
		mnArchivo.addSeparator();
		
		JMenuItem miSalir = new JMenuItem("Salir");
		mnArchivo.add(miSalir);
		
		JMenu mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);
		
		JMenuItem miManual = new JMenuItem("Manual");
		mnAyuda.add(miManual);
		
		JMenuItem miAcercaDe = new JMenuItem("Acerca de");
		mnAyuda.add(miAcercaDe);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		textPane = new JTextPane();
		contentPane.add(textPane, BorderLayout.CENTER);
		
		setVisible(true);
		
		// Eventos
		
		miNuevo.addActionListener(v -> {
			if(!textPane.getText().isEmpty()) {
				if(!sTextoAntiguo.equals(sTextoNuevo) ) {
					preguntaGuardar();
				}
			}
			
			textPane.setText("");
		});
		
		miAbrir.addActionListener(v -> {
			sTextoAntiguo = textPane.getText();
			sTextoNuevo = controllers.Controller.abrirArchivo();
			
			// Comprobar si esta guardado
			if(sTextoAntiguo.isEmpty() || sTextoAntiguo.equals(sTextoNuevo) ) {
				textPane.setText(sTextoNuevo);
			}else {
				preguntaGuardar();
				
				textPane.setText(sTextoNuevo);
			}
		});
		
		miGuardar.addActionListener(v -> {
			controllers.Controller.guardar();
		});
		
		miGuardarComo.addActionListener(v -> {
			controllers.Controller.guardarComo();
		});
		
		miSalir.addActionListener(v -> {
			cerrarVentana();
		});
		
		miAcercaDe.addActionListener(v -> {
			new DiaAcercaDe();
		});
		
		miManual.addActionListener(v -> {
			new DiaManual();
		});
		
		addWindowListener(new java.awt.event.WindowAdapter() {
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		    	cerrarVentana();
		    }
		});
	}
	
	private static void cerrarVentana() {
		if(!textPane.getText().isEmpty()) {
			if(!sTextoAntiguo.equals(sTextoNuevo) ) {
				preguntaGuardar();
			}
		}
		
		controllers.Controller.cerrarVentana();
	}
	
	private static void preguntaGuardar() {
		byte bOpcion = (byte) JOptionPane.showConfirmDialog(null, "¿Quieres guardar?", "¿Quieres guardar?", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
		
		if(bOpcion < 1) {
			if(controllers.Controller.oFile != null) {
				controllers.Controller.guardar();
			}else {
				controllers.Controller.guardarComo();
			}
			
		}
	}

}
