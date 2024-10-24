package test;

import model.Rectangulo;

public class ProgramaCuadrado {

	public static void main(String[] args) {
		Rectangulo rect1 = new Rectangulo(0,0,0,2,2,0,2,2);
		System.out.println("El ancho del rectangulo es "+ rect1.getAncho() + " \nSu longitud es: "+ rect1.getLongitud() + " \nSu perimetro es: " + rect1.getPerimetro()+ "\nSu area es: " + rect1.getArea() + "\nEs cuadrado : " + rect1.esCuadrado());
	}

}
