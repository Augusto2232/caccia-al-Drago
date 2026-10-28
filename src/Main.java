
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner tastiera = new Scanner(System.in);

        System.out.print("Inserisci il numero di battiti: ");
        int battiti = tastiera.nextInt();

        Drago d = new Drago(battiti);
        Thread threadDrago = new Thread(d);

        threadDrago.start();

        Cacciatore c = new Cacciatore();

        for (int i = 1; i <= battiti && threadDrago.isAlive(); i++) {
            System.out.println("Sto osservando il drago");

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Osservazione interrotta.");
                Thread.currentThread().interrupt();
                break;
            }

            if (i == 2 && threadDrago.isAlive()) {
                c.colpisciDrago(threadDrago);
            }
        }

        try {
            threadDrago.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        tastiera.close();
        System.out.println("Programma terminato.");
    }
}
