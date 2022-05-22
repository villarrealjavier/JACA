package elementos;

import java.util.Objects;
import java.util.Random;

import logicaJuego.Constantes;

public class Coordenada {
	//Atributos
	private Integer x;
	private Integer y;
	
	public Coordenada() {
		super();
		Random numRandom =new Random();
		this.x=(numRandom.nextInt(Constantes.TAMANNO));
		this.y=(numRandom.nextInt(Constantes.TAMANNO));
	}
	public Coordenada(int x, int y) {
		super();
		if (x>=0 && x<=Constantes.TAMANNO-1 && y>=0 && y<=Constantes.TAMANNO-1 ) {
			this.x = x;
			this.y = y;
			}else {
			this.x=0;
			this.y=0;
		}

	}
	
	//GETTERS DE LOS ATRIBUTOS
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	
	//METODOS
	public boolean goRight () {
		boolean moverse=true;
		if (x==Constantes.TAMANNO-1) {
			moverse=false;
		}else {
			x++;
		}
		return moverse;
	}
	public boolean goLeft() {
		boolean moverse=true;
		if (x==0) {
			moverse=false;
		}else {
			x--;
		}
		return moverse;
	}
	public boolean goUp() {
		boolean moverse=true;
		if (y==0) {
			moverse=false;
		}else {
			y--;
		}
		return moverse;
	}
	public boolean goDown() {
		boolean moverse=true;
		if (y==Constantes.TAMANNO-1) {
			moverse=false;
		}else {
			y++;
		}
		return moverse;
	}
	
	//HASHCODE
	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}
	//EQUALS
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coordenada other = (Coordenada) obj;
		return x == other.x && y == other.y;
	}
	
	@Override
	public Coordenada clone() throws CloneNotSupportedException {
		return new Coordenada(this.x,this.y);
	}
	
	//TO STRING
	@Override
	public String toString() {
		return "Coordenada [x=" + x + ", y=" + y + "]";
	}

}
