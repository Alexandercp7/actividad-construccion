package model;

public class Rectangulo {
	private float longitud;
	private float ancho;
	private float perimetro;
	private float area;
	
	Coordenada cor1 = new Coordenada();
	Coordenada cor2 = new Coordenada();
	Coordenada cor3 = new Coordenada();
	Coordenada cor4 = new Coordenada();	
	
	public Rectangulo(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
		cor1.setAbsOrd(x1, y1);	
		cor2.setAbsOrd(x2, y2);
		cor3.setAbsOrd(x3, y3);
		cor4.setAbsOrd(x4, y4);
		VerificarCuadrantes();
		VerificarTamanio();
		VerificarRectangulo();
		CalcAreayPerimetro();
	}
	
	public Rectangulo() {
		CalcAreayPerimetro();
	}
	
	public void VerificarCuadrantes() {
		if ((cor1.getAbscisa()>=0 && cor1.getOrdenada()>=0) && (cor2.getAbscisa()>=0 && cor2.getOrdenada()>=0) && (cor3.getAbscisa()>=0 && cor3.getOrdenada()>=0) && (cor4.getAbscisa()>=0 && cor4.getOrdenada()>=0)) {

		}else {
			cor1.setAbsOrd(0,0);	
			cor2.setAbsOrd(0,1);
			cor3.setAbsOrd(1,0);
			cor4.setAbsOrd(1,1);
		}
	}
	public void VerificarRectangulo() {
		if ((cor3.getOrdenada() ==cor1.getOrdenada()&& cor2.getOrdenada() ==cor4.getOrdenada() && cor1.getAbscisa() == cor2.getAbscisa() && cor3.getAbscisa() ==cor4.getAbscisa()) ) {

		}else {
			cor1.setAbsOrd(0,0);	
			cor2.setAbsOrd(0,1);
			cor3.setAbsOrd(1,0);
			cor4.setAbsOrd(1,1);
		}
	}
	public void VerificarTamanio() {
		if (cor1.getAbscisa()<20 && cor1.getOrdenada()<20 && cor2.getAbscisa()<20 && cor2.getOrdenada()<20 && cor3.getAbscisa()<20 && cor3.getOrdenada()<20 && cor4.getAbscisa()<20 && cor4.getOrdenada()<20) {

		}else {
			cor1.setAbsOrd(0,0);	
			cor2.setAbsOrd(0,1);
			cor3.setAbsOrd(1,0);
			cor4.setAbsOrd(1,1);
		}
	}
	public void crearAnchoyLongitud() {
		if (cor2.getOrdenada()-cor1.getOrdenada()<cor3.getAbscisa()-cor1.getAbscisa()) {
			ancho= cor2.getOrdenada()-cor1.getOrdenada();
			longitud= cor3.getAbscisa()-cor1.getAbscisa();
		}else {
			if(cor2.getOrdenada()-cor1.getOrdenada()>cor3.getAbscisa()-cor1.getAbscisa()) {

			}else {
				longitud= cor2.getOrdenada()-cor1.getOrdenada();
				ancho= cor3.getAbscisa()-cor1.getAbscisa();
			}
		}
	}

	public boolean notASquare() {
		if (ancho==longitud) {
			return true;
		}else {
			return false;
		}
	}
	public void CalcAreayPerimetro() {
		crearAnchoyLongitud();
		perimetro=(ancho*2) + (longitud * 2);
		area=(ancho*2) + (longitud * 2);
	}
	public float getAncho() {
		return ancho;
	}
	public float getLongitud() {
		return longitud;
	}
	public float getArea() {
		return area;
	}
	public float getPerimetro() {
		return perimetro;
	}
}