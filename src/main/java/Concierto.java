package org.Omar;

import java.util.Scanner;

public class Concierto
{
    // ===== ESCRIBE AQUÍ LA EDAD MÍNIMA PARA EL DESCUENTO (ej. 60) =====
    static Integer EDAD_MINIMA_DESCUENTO = null;
    // ===================================================================

    // ===== ESCRIBE AQUÍ EL PORCENTAJE DE DESCUENTO (ej. 50 para 50%) =====
    static Double PORCENTAJE_DESCUENTO = null;
    // =====================================================================

    // Precio de la entrada general
    static final double PRECIO_ENTRADA = 500.0;

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int entradasVendidas = 0;
        double ventasTotales = 0;
        int opcion = 0;

        while (opcion != 2)
        {
            System.out.println("================================");
            System.out.println("        VENTA DE ENTRADAS");
            System.out.println("================================");
            System.out.println("1. Vender entrada");
            System.out.println("2. Salir");
            System.out.println("================================");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion)
            {
                case 1:
                    System.out.print("\nNombre del comprador: ");
                    String nombre = sc.nextLine();

                    System.out.print("Edad del comprador: ");
                    int edad = sc.nextInt();
                    sc.nextLine();

                    // Si falta la edad mínima o el porcentaje, no hay descuento
                    boolean tieneDescuento = EDAD_MINIMA_DESCUENTO != null
                            && PORCENTAJE_DESCUENTO != null
                            && edad >= EDAD_MINIMA_DESCUENTO;

                    double porcentaje = tieneDescuento ? PORCENTAJE_DESCUENTO : 0;
                    double descuento = PRECIO_ENTRADA * porcentaje / 100;
                    double total = PRECIO_ENTRADA - descuento;

                    System.out.println("\n================================");
                    System.out.println("          BOLETO");
                    System.out.println("================================");
                    System.out.println("Comprador: " + nombre);
                    System.out.println("Edad: " + edad);
                    System.out.printf("Precio: $%.2f%n", PRECIO_ENTRADA);
                    if (tieneDescuento)
                    {
                        System.out.printf("Descuento (%.0f%%): -$%.2f%n", porcentaje, descuento);
                    }
                    else
                    {
                        System.out.println("Descuento: no aplica");
                    }
                    System.out.printf("Total a pagar: $%.2f%n", total);
                    System.out.println("================================\n");

                    entradasVendidas++;
                    ventasTotales += total;
                    break;

                case 2:
                    System.out.println("\nEntradas vendidas: " + entradasVendidas);
                    System.out.printf("Ventas totales: $%.2f%n", ventasTotales);
                    System.out.println("¡Gracias por usar el sistema!");
                    break;

                default:
                    System.out.println("Opción no válida\n");
            }
        }

        sc.close();
    }
}
