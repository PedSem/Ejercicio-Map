import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
     private static Map<Integer, Ubicacion> ubicaciones;

    public Main(){
        ubicaciones=new HashMap<>();
        ubicaciones.put(0, new Ubicacion(0, "Estás sentado en una clase de programación"));
        ubicaciones.put(1, new Ubicacion(1, "Estás en la cima de una montaña"));
        ubicaciones.put(2, new Ubicacion(2, "Estás bañándote en la playa"));
        ubicaciones.put(3, new Ubicacion(3, "Etsas dentro de un edificio alto"));
        ubicaciones.put(4, new Ubicacion(4, "Estás de pie en un puente"));
        ubicaciones.put(5, new Ubicacion(5, "Estás en un bosque"));

        ubicaciones.get(1).addExit("N", 5);
        ubicaciones.get(1).addExit("S", 4);
        ubicaciones.get(1).addExit("E", 3);
        ubicaciones.get(1).addExit("O", 2);

        ubicaciones.get(2).addExit("N", 5);
         
        ubicaciones.get(3).addExit("O", 1);
         
        ubicaciones.get(4).addExit("E", 2);
        ubicaciones.get(4).addExit("N", 1);
         
        ubicaciones.get(5).addExit("S", 1);
        ubicaciones.get(5).addExit("O", 2);

        ubicaciones.get(0).addExit("Q", 0);
    }

    public static void main(String[] args) {
        Main entradamapa = new Main();
        Scanner scanner = new Scanner(System.in);

        int ubicacionActual = 1;
        boolean continuar = true;
        while (continuar) {
            Ubicacion ubicacion = entradamapa.ubicaciones.get(ubicacionActual);
            System.out.println(ubicacion.getDescripcion());
            System.out.println("Tus entradas válidas son");
            
            for (String direccion : ubicacion.getExits().keySet()) {
                System.out.print(direccion + ", ");
            }
            System.out.println("Q");

            System.out.print("INPUT: ");
            String input = scanner.nextLine().toUpperCase();

            if (ubicacion.getExits().containsKey(input)) {
                ubicacionActual = ubicacion.getExits().get(input);
            } else if (input.equals("Q")) {
                continuar = false;
            } else {
                System.out.println("No se puede ir en esa direccion");
            }
        }
    }
}
