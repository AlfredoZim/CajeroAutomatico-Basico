package cajeroautomatico;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class CajeroAutomatico {

    static String pin = "1234";
    static Cuenta cuenta = new Cuenta();
    static Boolean acceso = false;
    static String separador = "\n\n\n\n\n\n\n\n\n\n\n\n═══════════════════════════════════════════════════════════╣\n\n\n\n";
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int limite = 0;
        System.out.print(separador + "Bienvenido Usuario\n\nPor favor, ingrese su contraseña: ");
        String pinIn = sc.nextLine();
        while (!pinIn.equals(pin)) {
            if (limite == 2) {
                System.out.println("Se ha llegado al límite de intentos.");
                System.exit(0);
            }
            System.out.print(separador + "Contraseña invalida, por favor, ingresela nuevamente: ");
            pinIn = sc.nextLine();
            limite++;
        }
        opciones();
    }

    public static void opciones() {
        while (true) {
            switch (menu()) {
                case 1:
                    System.out.println(separador);
                    System.out.println(cuenta.getConsulta());
                    salir();
                    break;
                case 2:
                    System.out.println(separador);
                    System.out.print("Monto a retirar: $");
                    System.out.println(cuenta.retiroEfectivo(sc.nextDouble()));
                    waitTime();
                    salir();
                    break;
                case 3:
                    
                    System.out.println(separador);
                    System.out.println(cuenta.getMovimientos());
                    salir();
                    break;
                case 4:
                    endSession();
                    System.exit(0);
            }
        }
    }

    public static int menu() {
        System.out.print(separador + "\n\nSelecciona una opción del menú:\n1. Consultar saldo\n2. Retirar efectivo\n3. Consulta de movimientos\n4. Salir\n\nOpción:");
        return sc.nextInt();
    }

    public static void salir() {
        System.out.print("\n\n\n¿Desea continuar al menú principal?\n1. Sí\n2. No\nSelección: ");
        int opcion = sc.nextInt();
        if (opcion == 2) {
            endSession();
            waitTime();
            System.exit(0);
        }
    }

    public static void waitTime() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    
    public static void endSession(){
        System.out.println(separador);
        System.out.println("Cerrando sesión...");
    }
}
