import java.util.Scanner;

public class Main {
  public static void main(String[] args) {

//    Se declara la clase
    AgendaTelefonica agenda = new AgendaTelefonica();
    Scanner scanner = new Scanner(System.in);
//    Almacenar la entrada del usuario
    String command;


//    Opciones a seleccionar
    do {
      System.out.println("\nIngrese el número de la acción deseada: ");
      System.out.println("1. Añadir contacto"); //añade y veriica si el contacto existe y si la agenda esta llena. ok
      System.out.println("2. Eliminar contacto"); // Elimina y verifica contacto existente y muestra si no existe. ok
      System.out.println("3. Buscar contacto"); // Busca el contacto, verifica contacto existente y muestra si no existe. ok
      System.out.println("4. Mostrar todos los contactos y ver espacios libres");
      System.out.println("5. Salir");
      command = scanner.nextLine().trim(); // Eliminar espacios en blanco alrededor



      switch (command) {
        case "1":
          System.out.println("Ingrese el nombre del contacto:");
          String nombre = scanner.nextLine();
          System.out.println("Ingrese el número de teléfono del contacto:");
          String numTelefono = scanner.nextLine();
          if (agenda.agregarContacto(new Contacto(nombre, numTelefono))) {
            System.out.println("Contacto agregado.");
          } else {
            System.out.println("No se pudo agregar el contacto.");
          }
          break;

        case "2":
          System.out.println("Ingrese el nombre del contacto a eliminar:");
          nombre = scanner.nextLine();
          if (agenda.elimiContacto(nombre)) {
            System.out.println("Contacto eliminado.");
          } else {
            System.out.println("El contacto no existe o no se pudo eliminar.");
          }
          break;

        case "3":
          System.out.println("Ingrese el nombre del contacto a buscar:");
          nombre = scanner.nextLine();
          int index = agenda.bucarContacto(nombre);
          if (index >= 0) {
            Contacto foundContact = agenda.getContacts()[index];
            System.out.println("Contacto encontrado: \n Nombre:" + foundContact.getNombre() + " \n Numero de telefono: " + foundContact.getNumTelefono());
          } else {
            System.out.println("Contacto no existe.");
          }
          break;
//Muestra todos los contactos y espacios libres
        case "4":
          agenda.verContactos();
          System.out.println("Espacios libres en la agenda: " + agenda.freeSpaces());
          break;

        case "5":
          System.out.println("Saliendo...");
          break;

        default:
          System.out.println("Comando no válido.");
          break;
      }
    } while (!command.equals(5));
    scanner.close();
  }
}