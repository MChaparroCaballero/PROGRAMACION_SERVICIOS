package clase_17_9_2024;

import java.util.ArrayList;

public class Biblioteca {
ArrayList<Material> almacenaje= new ArrayList<Material>();

public Biblioteca(ArrayList<Material> almacenaje) {
	this.almacenaje = almacenaje;
}

public ArrayList<Material> getAlmacenaje() {
	return almacenaje;
}

public void setAlmacenaje(ArrayList<Material> almacenaje) {
	this.almacenaje = almacenaje;
}

public void agregarMaterial(Material e) {
	almacenaje.add(Material e);
}
}
