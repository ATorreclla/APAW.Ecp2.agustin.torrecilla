package api.dtos;

import api.entities.Conductor;

public class AutobusDto {

    private int capacidad;
    private Conductor conductor;

    public AutobusDto(int capacidad, Conductor conductor){
        this.capacidad = capacidad;
        this.conductor = conductor;
    }

    public int getCapacidad() {
        return capacidad;
    }

    @Override
    public String toString() {
        return "AutobusDto{" +
                "capacidad=" + capacidad +
                ", conductor=" + conductor +
                '}';
    }
}