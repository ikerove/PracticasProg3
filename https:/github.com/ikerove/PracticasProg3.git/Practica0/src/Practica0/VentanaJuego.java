package Practica0;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class VentanaJuego extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static JPanel principal;
	private JPanel sur;
	private JButton btnAcel, btnFren, btnGird, btnGiri;
	
	
	private CocheJuego c1;
	private Hilo hilo;
	
	
	public VentanaJuego() {
		setSize(720,480);
		principal = new JPanel();
		principal.setBackground(Color.WHITE);
		principal.setLayout(null);
		sur = new JPanel();
		
		btnAcel = new JButton("Acelera");
		btnFren = new JButton("Frena");
		btnGird = new JButton("Gira der.");
		btnGiri = new JButton("Gira izq.");
		
		
		sur.add(btnAcel);
		sur.add(btnFren);
		sur.add(btnGiri);
		sur.add(btnGird);

		
		
		
		
		getContentPane().add(principal, BorderLayout.CENTER);
		getContentPane().add(sur, BorderLayout.SOUTH);
		
		
		
			
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		
		
		btnAcel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				c1.acelera(+5);
				System.out.println( "Velocidad del coche: " + c1.getMiVelocidad() );
			}
		});
		
		
		btnFren.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				c1.acelera(-5);
				System.out.println( "Velocidad del coche: " + c1.getMiVelocidad() );
			}
		});
		
		
		btnGiri.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				c1.gira(+10);
				System.out.println( "Dirección del coche: " + c1.getMiDireccionActual() );
			}
		});
		
		btnGird.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				c1.gira(-10);
				System.out.println( "Dirección del coche: " + c1.getMiDireccionActual() );
			}
		});
		
		setVisible(true);
		
	}
	
	
	
	public static void main(String[]args) {
		VentanaJuego v =new VentanaJuego();
		v.CreaCoche(150, 100);
		v.c1.setPiloto("Juan");
		v.hilo = v.new Hilo();
		Thread nuevoHilo = new Thread(v.hilo);
		nuevoHilo.start();
		
		
	}
	
	
	public void CreaCoche(int posX, int posY) {
		c1 = new CocheJuego();
		c1.setPosX(posX);
		c1.setPosY(posY);
		principal.add(c1.getLblCoche());
	}
	
	public class Hilo implements Runnable {
		boolean sigo = true;
		@Override
		public void run() {
			while (sigo) {
				c1.mueve( 0.050 );
				try {
					Thread.sleep( 40);
				} catch (Exception e) {
				}
			}
		}
		public void acaba() {
			sigo = false;
		}
	};

	}


