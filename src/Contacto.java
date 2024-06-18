public class Contacto {
  private String nombre;
  private String NumTelefono;

//Constructor vació
  public  Contacto(){
  };

  /* Constructor */
  public Contacto(String nombre, String NumTelefono) {
    this.nombre = nombre;
    this.NumTelefono = NumTelefono;
  }

//  Métodos get y set
  public String getNombre() {
    return nombre;
  }

  public String getNumTelefono() {
    return NumTelefono;
  }


//  Motodo para unir los datos en cadena
  @Override
  public String toString() {
    return nombre + " - " + NumTelefono;
  }


//  Metodo validacion de datos admitidos, y trasforma la inf al formato admitido, nos retorna si ya existe el valor
  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    Contacto contact = (Contacto) obj;
    return nombre.equals(contact.nombre);
  }
//Almacena los datos
  @Override
  public int hashCode() {
    return nombre.hashCode();
  }
}