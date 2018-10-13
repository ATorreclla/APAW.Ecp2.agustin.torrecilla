package api.entities;

import java.util.Set;

import java.util.HashSet;

public class Autobus {

    private String id;
    private int capacidad;
    private Conductor conductor;
    private LineaRegular lineaRegular;
    private Set<Pasajero> pasajeros;

    public Autobus(int capacidad, Conductor conductor){
        this.capacidad = capacidad;
        this.conductor = conductor;
    }

    public Autobus(int capacidad, Conductor conductor, Set<Pasajero> pasajeros){
        this(capacidad, conductor);
        this.pasajeros = new HashSet<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public Conductor getConductor() {
        return conductor;
    }

    public void setConductor(Conductor conductor) {
        this.conductor = conductor;
    }

    public LineaRegular getLineaRegular() {
        return lineaRegular;
    }

    public void setLineaRegular(LineaRegular lineaRegular) {
        this.lineaRegular = lineaRegular;
    }

    public Set<Pasajero> getPasajeros(){
        return pasajeros;
    }

    private boolean viaja(Pasajero pasajero){
        return this.pasajeros.contains(pasajero);
    }

    private boolean sube(Pasajero pasajero){
        return this.pasajeros.add(pasajero);
    }

    private boolean baja(Pasajero pasajero){
        return this.pasajeros.remove(pasajero);
    }

    private boolean subenTodos(Set<Pasajero> pasajeros){
        return this.pasajeros.addAll(pasajeros);
    }

    private boolean bajanTodos(Set<Pasajero> pasajeros){
        return this.pasajeros.removeAll(pasajeros);
    }

    @Override
    public String toString() {
        return "Autobus{" +
                "id='" + id + '\'' +
                ", capacidad=" + capacidad +
                ", conductor=" + conductor +
                ", lineaRegular=" + lineaRegular +
                ", pasajeros=" + pasajeros +
                '}';
    }
}