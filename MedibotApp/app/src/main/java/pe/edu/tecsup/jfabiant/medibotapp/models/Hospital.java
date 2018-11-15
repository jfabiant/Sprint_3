package pe.edu.tecsup.jfabiant.medibotapp.models;

public class Hospital {

    private String nombre;
    private String c_distrito;
    private  String hosp_img;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getC_distrito() {
        return c_distrito;
    }

    public void setC_distrito(String c_distrito) {
        this.c_distrito = c_distrito;
    }

    public String getHosp_img() {
        return hosp_img;
    }

    public void setHosp_img(String hosp_img) {
        this.hosp_img = hosp_img;
    }

    @Override
    public String toString() {
        return "Hospital{" +
                "nombre='" + nombre + '\'' +
                ", c_distrito='" + c_distrito + '\'' +
                ", hosp_img='" + hosp_img + '\'' +
                '}';
    }
}
