package views;

import java.awt.*;

import javax.swing.*;

public class DiaAcercaDe extends JDialog {

	private static final long serialVersionUID = 1L;
	private Font fntLbl = new Font("Arial", Font.PLAIN, 18);

	public DiaAcercaDe() {
		int iX, iY;
		
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		
		iX = (screensize.width - 450) / 2;
		iY = (screensize.height - 300) / 2;
		
		setBounds(iX, iY, 450, 300);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		setIconImage(Toolkit.getDefaultToolkit().createImage("Notas.png"));
		setModal(true);
		setResizable(false);
		
		// Adaptar imagen al label
		
		JLabel lblImagen = new JLabel();
		lblImagen.setBounds(32, 58, 130, 130);
		
		ImageIcon imgIcon = new ImageIcon("Notas.png");
		Image imgEscalada = imgIcon.getImage().getScaledInstance(lblImagen.getWidth(),
				lblImagen.getHeight(), Image.SCALE_SMOOTH);
		Icon iconoEscalado = new ImageIcon(imgEscalada);
		lblImagen.setIcon(iconoEscalado);
		
		getContentPane().add(lblImagen);
		
		JLabel lblEditor = new JLabel("Editor de texto");
		lblEditor.setBounds(197, 76, 123, 14);
		lblEditor.setFont(fntLbl);
		getContentPane().add(lblEditor);
		
		JLabel lblVersion = new JLabel("Version: 1.0");
		lblVersion.setBounds(197, 118, 102, 14);
		lblVersion.setFont(fntLbl);
		getContentPane().add(lblVersion);
		
		JLabel lblAutor = new JLabel("Autor: Antonio Torres 2021");
		lblAutor.setBounds(197, 160, 227, 14);
		lblAutor.setFont(fntLbl);
		getContentPane().add(lblAutor);
		
		setVisible(true);
	}
}
