
public class Cacciatore {

    public void colpisciDrago(Thread drago) {
        System.out.println("Il cacciatore colpisce il drago!");
        drago.interrupt();
    }
}

