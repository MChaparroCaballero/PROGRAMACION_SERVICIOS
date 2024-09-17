package clase_17_9_2024;

public class Libro extends Material {
	private String autor;
	private String ISBN;

	public Libro(String titulo, int año_publicacion, String autor, String ISBN) {
		super(titulo, año_publicacion);
		this.autor = autor;
		this.ISBN = ISBN;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) throws ISBN_NO_ACEPTADO {

		if (ISBN.length() < 6) {
			throw new ISBN_NO_ACEPTADO("ISBN No aceptado");
		} else if (ISBN.length() > 6) {
			throw new ISBN_NO_ACEPTADO("ISBN No aceptado");
		} else {
			ISBN = iSBN;
		}

	}

	@Override
	public String mostrarInfo() {
		String info= "El libro se llama"+ this.getTitulo() + " se publico en el año" + 
	this.getAño_publicacion() + " su autor es " +
	this.getAutor() + " Y su ISBN es " + this.getISBN();
		return info;
		// TODO Auto-generated method stub

	}

}
