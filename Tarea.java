public class Tarea {
	private String descricion;
	private boolean completada;

	public Tarea(String descricion) {
		super();
		this.descricion = descricion;
		this.completada = false;
	}

	public boolean iscompletada() {
		return completada;
	}

	public void marcarComoCompletada() {
		this.completada = true;
		}

	@Override
	public String toString() {
		String estado;
		if (completada) {
		    estado = "Completada";
		} else {
		    estado = "Pendiente";
		}
		return descricion + " - " + estado;
		}
		

	}
	

