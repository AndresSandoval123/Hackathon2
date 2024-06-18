public class AgendaTelefonica {
//Limita a 10 contact
private static final int MAX_CONTACTS = 10;
//Arreglo que almacena los maximos de contact
private Contacto[] contactos = new Contacto[MAX_CONTACTS];
//Contador
private int contador = 0;

/* Metodos */

//  Metodo agregar Contacto
public boolean agregarContacto(Contacto contact) {
  if (isFull()) {
    System.out.println("La lista de contact está llena.");
    return false;
  }
  if (contactExists(contact.getNombre())) {
    System.out.println("El contacto ya existe.");
    return false;
  }
  contactos[contador] = contact;
  contador++;
  return true;
}

//Metodo eliminar contacto
public boolean elimiContacto(String nombre) {
  int index = bucarContacto(nombre);
  if (index >= 0) {
    contactos[index] = contactos[contador - 1];
    contactos[contador - 1] = null;
    contador--;
    return true;
  }
  return false;
}

// Buscar contact
  public int bucarContacto(String nombre) {
    for (int i = 0; i < contador; i++) {
      if (contactos[i].getNombre().equals(nombre)) {
        return i;
      }
    }
    return -1;
  }

// Contactos existentes
  public boolean contactExists(String nombre) {
    return bucarContacto(nombre) >= 0;
  }

//  Retorna si la agenda esta llena
  public boolean isFull() {
    return contador >= MAX_CONTACTS;
  }

//  Retorna espacios vacios
  public int freeSpaces() {
    return MAX_CONTACTS - contador;
  }

//  Nos muestra toda la lista
  public void verContactos() {
    System.out.println("Contactos almacenados:");
    for (int i = 0; i < contador; i++) {
      System.out.println((i + 1) + ". " + contactos[i]);
    }
  }

  public Contacto[] getContacts() {
    return contactos;
  }
}
