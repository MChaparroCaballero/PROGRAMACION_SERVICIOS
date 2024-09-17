package clase_17_9_2024;

import java.util.ArrayList;

public class Biblioteca {
	ArrayList<Material> almacenaje = new ArrayList<Material>();

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
		almacenaje.add(e);
		System.out.println("Material agregado con exito");
	}

	public void listarMaterial() {
		for (Material i : almacenaje) {
			System.out.println(i);
		}

	}

	public void BuscarMaterial(String titulo) throws MaterialNoEncontradoException {
		for (Material i : almacenaje) {
			if (i.getTitulo() == titulo) {
				i.mostrarInfo();
			} else {
				throw new MaterialNoEncontradoException("Titulo no encontrado");
			}

		}
	}
}
