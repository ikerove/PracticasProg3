package Practica0;

public class CocheJuego extends Coche{
	
	private JLabelCoche lblCoche;

	public CocheJuego() {
		
		lblCoche = new JLabelCoche();
	}

	public JLabelCoche getLblCoche() {
		return lblCoche;
	}

	public void setLblCoche(JLabelCoche lblCoche) {
		this.lblCoche = lblCoche;
	}

	@Override
	public void setPosX(double posX) {

		super.setPosX(posX);
		lblCoche.setLocation((int)posX, (int)posY);
	}

	@Override
	public void setPosY(double posY) {

		super.setPosY(posY);
		lblCoche.setLocation((int)posX, (int)posY);
	}

	@Override
	public void setMiDireccionActual(double miDireccionActual) {
		// TODO Auto-generated method stub
		super.setMiDireccionActual(miDireccionActual);
		lblCoche.setGiro( miDireccionActual );
		lblCoche.repaint();
		
	}
	
	
	
}
