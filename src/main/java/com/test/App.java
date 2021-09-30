package com.test;

import com.servicio.PersonaServiceImplService;
import com.servicio.IPersonaService;
import com.servicio.Persona;
import java.util.List;
import java.util.Scanner;

/**
 * @author julioh
 */
public class App {

    public static void main(String[] args) {

        IPersonaService persona = new PersonaServiceImplService().getPersonaServiceImplPort();

        Scanner sc = new Scanner(System.in);
        String op;

        do {

            System.out.println("Bienvenido a la aplicación cliente CRUD JAX-WS! ");
            System.out.println("Escoja una de las siguinetes opciones del menú: ");
            System.out.println("1. Listar a todas las personas.");
            System.out.println("2. Agregar una nueva persona.");
            System.out.println("3. Actualizar una persona.");
            System.out.println("4. Eliminar una persona.");
            System.out.println("5. Buscar a una persona por id.");
            System.out.println("");
            int op2 = sc.nextInt();
            sc.nextLine();
            switch (op2) {
                case 1:

                    List<Persona> personas2 = persona.listarPersonas();
                    System.out.println(" ** Listado de personas ** ");
                    for (Persona p : personas2) {
                        System.out.println("ID: " + p.getIdPersona());
                        System.out.println("nombre: " + p.getNombre());
                        System.out.println("apellido: " + p.getApellido());
                        System.out.println("email: " + p.getEmail());
                        System.out.println("telefono: " + p.getTelefono());
                        System.out.println("\n");
                    }
                    break;
                case 2:

                    System.out.println(" ** Agregue los datos de la nueva persona ** ");
                    Persona p = new Persona();
                    System.out.println("Nombre de la persona: ");
                    String nombre = sc.nextLine();
                    sc.nextLine();
                    p.setNombre(nombre);
                    System.out.println("Apellido de la persona: ");
                    String apellido = sc.nextLine();
                    sc.nextLine();
                    p.setApellido(apellido);
                    System.out.println("Email de la persona: ");
                    String email = sc.nextLine();
                    sc.nextLine();
                    p.setEmail(email);
                    System.out.println("Telefono de la persona: ");
                    String telefono = sc.nextLine();
                    sc.nextLine();
                    p.setTelefono(telefono);

                    persona.registrarPersona(p);
                    break;
                case 3:

                    System.out.println(" ** Agregar los nuevos datos de la persona ** ");
                    Persona p2 = new Persona();
                    System.out.println("ID de la persona a actualizar: ");
                    Integer id = sc.nextInt();
                    sc.nextLine();
                    p2.setIdPersona(id);
                    System.out.println("Nombre de la persona: ");
                    String nombre2 = sc.nextLine();
                    sc.nextLine();
                    p2.setNombre(nombre2);
                    System.out.println("Apellido de la persona: ");
                    String apellido2 = sc.nextLine();
                    sc.nextLine();
                    p2.setApellido(apellido2);
                    System.out.println("Email de la persona: ");
                    String email2 = sc.nextLine();
                    sc.nextLine();
                    p2.setEmail(email2);
                    System.out.println("Telefono de la persona: ");
                    String telefono2 = sc.nextLine();
                    sc.nextLine();
                    p2.setTelefono(telefono2);

                    persona.modificarPersona(p2);
                    break;
                case 4:
                    sc.nextLine();
                    System.out.println(" ** Agregar el id del registro a eliminar ** ");
                    System.out.println("ID de la persona a eliminar: ");
                    Persona p3 = new Persona();
                    Integer id2 = sc.nextInt();
                    sc.nextLine();
                    p3.setIdPersona(id2);

                    persona.eliminarPersona(p3);
                    break;
                case 5:
                    sc.nextLine();
                    System.out.println(" ** Buscar una persona por el ID ** ");
                    System.out.println("ID de la persona a buscar: ");
                    Persona p4 = new Persona();
                    Integer id3 = sc.nextInt();
                    sc.nextLine();
                    p4.setIdPersona(id3);

                    Persona personas3 = persona.encontrarPersonaPorId(p4);
                    System.out.println(" ** Datos de la persona encontrada ** ");

                    System.out.println("ID: " + personas3.getIdPersona());
                    System.out.println("nombre: " + personas3.getNombre());
                    System.out.println("apellido: " + personas3.getApellido());
                    System.out.println("email: " + personas3.getEmail());
                    System.out.println("telefono: " + personas3.getTelefono());
                    System.out.println("\n");

                    break;

            }

            System.out.println("¿Desea Continuar en el menú?");
            System.out.println("S/N: ");
            op = sc.nextLine();

        } while ("S".equals(op) || "s".equals(op));

    }

}
