package controllers;

import java.io.*;

import javax.swing.JFileChooser;

public class Controller {
	
	public static RandomAccessFile oFile;
	private static String sRuta;
	
	public static String abrirArchivo() {
		
		String sResultado = "";
		JFileChooser fileChooser = new JFileChooser();
		
		byte bOpcion = (byte) fileChooser.showOpenDialog(fileChooser);
		
		if(bOpcion != JFileChooser.CANCEL_OPTION) {
			try {
				sRuta = fileChooser.getSelectedFile().getAbsolutePath();
				oFile = new RandomAccessFile(sRuta, "r");
				byte[] bytesLeidos = new byte[(int) oFile.length()];
				oFile.readFully(bytesLeidos);
				String sTexto = new String(bytesLeidos);
				
				//views.FrmPrincipal.textPane.setText(sTexto);
				sResultado = sTexto;
				
				oFile.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return sResultado;
	}
	
	public static String abrirArchivo(String sRutaFichero) {
		
		String sResultado = "";
		try {
				
				RandomAccessFile oFichero = new RandomAccessFile(sRutaFichero, "r");
				byte[] bytesLeidos = new byte[(int) oFichero.length()];
				oFichero.readFully(bytesLeidos);
				String sTexto = new String(bytesLeidos);
				
				//views.FrmPrincipal.textPane.setText(sTexto);
				sResultado = sTexto;
				
				oFichero.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		return sResultado;
	}

	public static void guardarComo() {
		
		JFileChooser fileChooser = new JFileChooser();
		
		byte bOpcion = (byte) fileChooser.showSaveDialog(fileChooser);
		
		if(bOpcion != JFileChooser.CANCEL_OPTION) {
			
			guardar(fileChooser.getSelectedFile().getAbsolutePath());
			
		}
		
	}
	
	public static void guardar() {
		if(oFile != null) {
			try {
				RandomAccessFile oFileDestino = new RandomAccessFile(sRuta, "rw");
				String sTexto = views.FrmPrincipal.textPane.getText();
				
				oFileDestino.setLength(0);
				for(byte bContador = 0;bContador < sTexto.length();bContador++) {
					oFileDestino.write(sTexto.charAt(bContador));
				}
				
				oFileDestino.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void guardar(String sRutaAbsoluta) {
		try {
			RandomAccessFile oFileDestino = new RandomAccessFile(sRutaAbsoluta, "rw");
			String sTexto = views.FrmPrincipal.textPane.getText();
				
			oFileDestino.setLength(0);
			for(byte bContador = 0;bContador < sTexto.length();bContador++) {
				oFileDestino.write(sTexto.charAt(bContador));
			}
			
			oFileDestino.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void cerrarVentana() {

		System.exit(0);
		
	}
	
}
