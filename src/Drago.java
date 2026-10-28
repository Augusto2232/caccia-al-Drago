
public class Drago implements Runnable {

    private int battiti;

    public Drago(int battiti) {
        this.battiti = battiti;
    }

    @Override
    public void run() {
        for (int i = 1; i <= battiti; i++) {
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("Il drago è morto!");
                return;
            }

            System.out.println("Il drago vola: battito " + i);

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("Il drago è stato colpito!");
                return;
            }
        }

        System.out.println("Il drago ha terminato di volare.");
    }
}

