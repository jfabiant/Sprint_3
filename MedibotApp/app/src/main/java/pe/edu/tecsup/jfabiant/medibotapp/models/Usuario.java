package pe.edu.tecsup.jfabiant.medibotapp.models;

public class Usuario {

    private Integer id;
    private String nombre;
    private String email;
    private Integer telefono;
    private String usu_img;
    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public String getUsu_img() {
        return usu_img;
    }

    public void setUsu_img(String usu_img) {
        this.usu_img = usu_img;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", telefono=" + telefono +
                ", usu_img='" + usu_img + '\'' +
                ", password='"+ password +'\'' +
                '}';
    }
}
