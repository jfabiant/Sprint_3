package pe.edu.tecsup.jfabiant.medibotapp.models;

public class Login {

    private Integer pk;
    private String username;
    private String password;
    private String key;

    public Integer getPk() {
        return pk;
    }

    public void setPk(Integer pk) {
        this.pk = pk;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "Login{" +
                "pk=" + pk +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", key='" + key + '\'' +
                '}';
    }
}
