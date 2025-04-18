import java.util.ArrayList;
import java.util.List;

public class Persona {

    protected String nombre;
    protected String apellido;
    protected String documento;
    protected int edad;
    protected List<Perro> perrosAdoptados = new ArrayList<>();

    public Persona(String nombre, String apellido, int edad, String documento, List<Perro> perrosAdoptados) {
    }

    public Persona(String nombre, String apellido, String documento, int edad, List<Perro> perrosAdoptados) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.documento = documento;
        this.edad = edad;
        this.perrosAdoptados = perrosAdoptados;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public List<Perro> getPerrosAdoptados() {
        return perrosAdoptados;
    }

    public void setPerrosAdoptados(List<Perro> perrosAdoptados) {
        this.perrosAdoptados = perrosAdoptados;
    }

    @Override
    public String toString() {
        if (perrosAdoptados.isEmpty()) {
            return "Persona{" +
                    "nombre='" + nombre + '\'' +
                    ", apellido='" + apellido + '\'' +
                    ", documento='" + documento + '\'' +
                    ", edad=" + edad +
                    ", perrosAdoptados= Ninguno" +
                    '}';
        }

        String listaPerros = "";
        for (Perro p : perrosAdoptados) {
            listaPerros += "\n  - " + p.toString();
        }

        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", documento='" + documento + '\'' +
                ", edad=" + edad +
                ", perrosAdoptados=" + listaPerros +
                "\n}";
    }

    public boolean adoptarPerro(Perro perro) {
        if (perrosAdoptados.size() < 3) {
            perrosAdoptados.add(perro);
            return true;
        } else {
            return false;
        }
    }

    public Perro perroMasGrande() {
        if (perrosAdoptados.isEmpty()) return null;
        Perro mayor = perrosAdoptados.get(0);
        for (Perro p : perrosAdoptados) {
            if (p.getEdad() > mayor.getEdad()) {
                mayor = p;
            }
        }
        return mayor;
    }
}

