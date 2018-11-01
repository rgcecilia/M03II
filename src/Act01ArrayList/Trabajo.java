package Act01ArrayList;

public class Trabajo {

	//Atributos de la clase//
	
	private int idTrabajo = -1;
	private String descripcion;
	private double precio;
	private double horas;
	private double material;
	private boolean finalizado;
	
	//Valores Necesarios//
	
	private static int id = -1;
	private int fijo = 30;
	
	
	//Constructores//
	
	public Trabajo() {}	
	
	public Trabajo(String descripcion, double precio, double horas, double material, boolean finalizado) {
		id++;
		this.idTrabajo = id;
		this.descripcion = descripcion;
		this.precio = precio;
		this.horas = horas;
		this.material = material;
		this.finalizado = finalizado;
	}

	//Getters and Setters//
	
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public int getFijo() {
		return fijo;
	}
	
	public void setFijo(int fijo) {
		this.fijo = fijo;
	}
	
	public double getPrecio() {
		return precio;
	}
	
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	public double getHoras() {
		return horas;
	}
	
	public void setHoras(double horas) {
		if(this.finalizado == true) {
			System.out.println("Trabajo finalizado, no puedes asignarle mas horas");
		}else {
			this.horas = horas;
		}
	}
	
	public double getMaterial() {
		return material;
	}
	
	public void setMaterial(double material) {
		this.material = material;
	}
	
	public boolean getFinalizado() {
		return finalizado;
	}
	
	public void setFinalizado(boolean finalizado) {
		this.finalizado = finalizado;
	}
	
    @Override 
    public Object clone() throws CloneNotSupportedException{
        id++;
        return super.clone();
    }
    
    public int getContadorIds(){
        return Trabajo.id;
    }
       
    public int getId(){
        return Trabajo.id;
    }
    
    public int getIdTrabajo(){
        return this.idTrabajo;
    }
	
}
