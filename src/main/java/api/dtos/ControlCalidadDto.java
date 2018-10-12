package api.dtos;

public class ControlCalidadDto {

    private String texto;

    private Boolean valoracion;

    public ControlCalidadDto(String texto , Boolean valoracion ){
        this.texto  = texto ;
        this.valoracion  = valoracion ;
    }

    public ControlCalidadDto(String texto){
        this(texto,null);
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Boolean getValoracion() {
        return valoracion;
    }

    public void setValoracion(Boolean valoracion) {
        this.valoracion = valoracion;
    }

    @Override
    public String toString() {
        return "ControlCalidadDto{" +
                "texto='" + texto + '\'' +
                ", valoracion=" + valoracion +
                '}';
    }
}