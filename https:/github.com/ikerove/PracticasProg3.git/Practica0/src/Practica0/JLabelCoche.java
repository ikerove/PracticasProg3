package Practica0;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.ImageIcon;
import javax.swing.JLabel;



public class JLabelCoche extends JLabel{
	
	//private JLabel coche = new JLabel();
	//private Image imagen;
	//private ImageIcon im = new ImageIcon("imagenes/strangerthings.jpg");
	//private ImageIcon imagenConDimensiones = new ImageIcon(im.getImage().getScaledInstance(getWidth(),getHeight(),Image.SCALE_DEFAULT));
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double Giro = Math.PI/2;

	public JLabelCoche() {
		super();
		try {
			setIcon( new ImageIcon( JLabelCoche.class.getResource( "coche.png" ).toURI().toURL() ) );
		} catch (Exception e) {
			System.err.println( "Error en carga de recurso: coche.png no encontrado" );
			e.printStackTrace();
		}
		setBounds( 0, 0, 100, 100 );
	}
	
	
	protected void paintComponent(Graphics g) {
		Image img = ((ImageIcon) getIcon()).getImage();
		Graphics2D g2 = (Graphics2D) g;

		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
				RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2.setRenderingHint(RenderingHints.KEY_RENDERING,
				RenderingHints.VALUE_RENDER_QUALITY);
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g2.rotate( Giro, 50, 50 );
		g2.drawImage(img, 0, 0, 100, 100, null);
	}

	public void setGiro( double gradosGiro ) {
		Giro = gradosGiro/180*Math.PI;
		Giro = -Giro;
		Giro = Giro + Math.PI/2;
	}
	
	
}


