import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        List<Perro> lstperrosDisponibles = new ArrayList<>();
        List<Persona> lstpersonas = new ArrayList<>();

        Scanner teclado = new Scanner(System.in);
        int op;
        boolean estado=true;

        do {
            System.out.println("""
                    SISTEMA DE ADOPCION DE PERROS
                    1. REGISTRAR PERSONA
                    2. REGISTRAR PERROS
                    3. VER PERSONAS REGISTRADAS
                    4. VER PERROS DISPONIBLES
                    5. ADOPTAR PERRO 
                    6. PERRO MAS VIEJO ADOPTADO
                    7 SALIR 
                    """);

            op = teclado.nextInt();

            switch (op) {
                case 1 -> {
                    System.out.print("Nombre: ");
                    String nombre = teclado.next(); teclado.nextLine();
                    System.out.print("Apellido: ");
                    String apellido = teclado.next(); teclado.nextLine();
                    System.out.print("Edad: ");
                    int edad = teclado.nextInt(); teclado.nextLine();
                    System.out.print("Documento: ");
                    String documento = teclado.next(); teclado.nextLine();
                    List<Perro>perrosAdoptados = new ArrayList<>();

                    Persona persona = new Persona(nombre, apellido, documento, edad, perrosAdoptados);
                    lstpersonas.add(persona);

                    System.out.println("REGISTRO EXITOSO");
                }

                case 2 -> {
                    System.out.print("Placa: ");
                    String placa = teclado.next();
                    System.out.print("Nombre del perro: ");
                    String nombre = teclado.next();
                    System.out.print("Raza: ");
                    String raza = teclado.next();
                    System.out.print("Edad: ");
                    int edad = teclado.nextInt();
                    System.out.print("Tamaño: ");
                    String tamanio = teclado.next();

                    Perro perro = new Perro(placa, nombre, raza, tamanio, edad);
                    lstperrosDisponibles.add(perro);
                    System.out.println("REGISTRO EXITOSO");
                }

                case 3 -> {
                    if (lstpersonas.isEmpty()) {
                        System.out.println("NO HAY PERSONAS REGISTRADAS");
                    } else {
                        for (Persona p : lstpersonas) {
                            System.out.println(p);
                        }
                    }
                }

                case 4 -> {
                    if (lstperrosDisponibles.isEmpty()) {
                        System.out.println("NO HAY PERROS DISPONIBLES");
                    } else {
                        for (Perro p : lstperrosDisponibles) {
                            System.out.println(p);
                        }
                    }
                }

                case 5 -> {
                    System.out.print("DOCUMENTO DE LA PERSONA: ");
                    String doc = teclado.next();
                    Persona personaEncontrada = null;

                    for (Persona p : lstpersonas) {
                        if (p.getDocumento().equalsIgnoreCase(doc)) {
                            personaEncontrada = p;
                            break;
                        }
                    }

                    if (personaEncontrada == null) {
                        System.out.println("PERSONA NO ENCONTRADA");
                        break;
                    }

                    if (personaEncontrada.getPerrosAdoptados().size() >= 3) {
                        System.out.println("YA ADOPTASTE EL MAXIMO DE PERROS PERMITIDO");
                        break;
                    }

                    System.out.print("PLACA DEL PERRO A ADOPOTAR: ");
                    String placa = teclado.next();
                    Perro perroEncontrado = null;

                    for (Perro p : lstperrosDisponibles) {
                        if (p.getPlaca().equalsIgnoreCase(placa)) {
                            perroEncontrado = p;
                            break;
                        }
                    }

                    if (perroEncontrado == null) {
                        System.out.println("PERRO NO DISPONIBLE");
                        break;
                    }

                    if (personaEncontrada.adoptarPerro(perroEncontrado)) {
                        lstperrosDisponibles.remove(perroEncontrado);
                        System.out.println("ADOPCION EXITOSA");
                    } else {
                        System.out.println("NO SE PUDO ADOPTAR EL PERRO");
                    }
                }

                case 6 -> {
                    System.out.print("DOCUMENTO DE LA PERSONA: ");
                    String doc = teclado.next();
                    Persona personaEncontrada = null;

                    for (Persona p : lstpersonas) {
                        if (p.getDocumento().equalsIgnoreCase(doc)) {
                            personaEncontrada = p;
                            break;
                        }
                    }

                    if (personaEncontrada == null) {
                        System.out.println("PERSONA NO ENCONTRADA");
                        break;
                    }

                    Perro masViejo = null;
                    for (Perro p : personaEncontrada.getPerrosAdoptados()) {
                        if (masViejo == null || p.getEdad() > masViejo.getEdad()) {
                            masViejo = p;
                        }
                    }

                    if (masViejo != null) {
                        System.out.println("EL PERRO MAS VIEJO ADOPTADO ES: " + masViejo);
                    } else {
                        System.out.println("ESTA PERSONA NO HA ADOPTADO A NINGUN PERRO");
                    }
                }

                case 7 -> {
                    estado = false;
                    System.out.println("HASTA PRONTO");
                }

                default -> System.out.println("OPCION NO VALIDA");
            }
        } while (estado);
    }
}