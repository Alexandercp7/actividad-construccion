package model;

public class Coordenada {
private int x;
private int y;

public Coordenada(int x, int y) {
	this.x=x;
	this.y=y;
}
public Coordenada() {
	x=0;
	y=0;
}
public void SetOrdenada(int cOrdenada) {
	y=cOrdenada;
}
public void setAbscisa(int cAbscisa) {
	x=cAbscisa;
}
public void setAbsOrd(int abs, int ord) {
	x=abs;
	y=ord;
}

public int getOrdenada() {
	return y;
}
public int getAbscisa() {
	return x;
}
}
