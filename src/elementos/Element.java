package elementos;

import java.util.Objects;

public class Element {
	//ATRIBUTOS
	protected ElementType elemento;

	//CONTRUCTOR
	public Element(ElementType elemento) {
		super();
		this.elemento = elemento;
	}

	//GETTER
	public ElementType getType() {
		return elemento;
	}

	//HASHCODE
	@Override
	public int hashCode() {
		return Objects.hash(elemento);
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
		Element other = (Element) obj;
		return elemento == other.elemento;
	}
	//TO STRING
	@Override
	public String toString() {
		return "Element [elemento=" + elemento + "]";
	}



	}


