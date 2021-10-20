package views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class DiaManual extends JDialog {

	private static final long serialVersionUID = 1L;
	
	private final JPanel contentPanel = new JPanel();

	public DiaManual() {
		int iX, iY;
		
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		
		iX = (screensize.width - 450) / 2;
		iY = (screensize.height - 300) / 2;
		
		setBounds(iX, iY, 450, 300);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);		
		getContentPane().setLayout(new BorderLayout());
		setModal(true);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().createImage("Notas.png"));
		
		
		JLabel lblManual = new JLabel("");
		getContentPane().add(lblManual, BorderLayout.CENTER);
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		lblManual.setText(controllers.Controller.abrirArchivo("manual.txt"));
		
		setVisible(true);
	}

}
