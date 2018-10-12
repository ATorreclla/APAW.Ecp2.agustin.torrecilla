package api.dtos;

public class ConductorDto {

    private String nombre;

    private String telefono;

    public ConductorDto(String nombre, String telefono){
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public ConductorDto(String nombre){
        this(nombre,null);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "ConductorDto{" +
                "nombre='" + nombre + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}