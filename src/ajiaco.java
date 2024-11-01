
import java.util.Scanner;

class AjiacoPreparation implements Runnable {
    private String task;

    public AjiacoPreparation(String task) {
        this.task = task;
    }

    @Override
    public void run() {
        try {
            switch (task) {
                case "Lavar ingredientes":
                    System.out.println("Lavando ingredientes...");
                    Thread.sleep(2000);
                    System.out.println("Ingredientes lavados.");
                    break;
                case "Cortar papas":
                    System.out.println("Cortando papas...");
                    Thread.sleep(3000);
                    System.out.println("Papas cortadas.");
                    break;
                case "Cocinar ajiaco":
                    System.out.println("Cocinando el ajiaco...");
                    Thread.sleep(5000);
                    System.out.println("Ajiaco cocinado.");
                    break;
                case "Servir ajiaco":
                    System.out.println("Sirviendo el ajiaco...");
                    Thread.sleep(1000);
                    System.out.println("Ajiaco servido.");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class ajiaco {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String option;

        do {
            System.out.println("---- Menú para preparar ajiaco ----");
            System.out.println("1. Lavar ingredientes");
            System.out.println("2. Cortar papas");
            System.out.println("3. Cocinar ajiaco");
            System.out.println("4. Servir ajiaco");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            option = scanner.nextLine();
            String task = "";

            switch (option) {
                case "1":
                    task = "Lavar ingredientes";
                    break;
                case "2":
                    task = "Cortar papas";
                    break;
                case "3":
                    task = "Cocinar ajiaco";
                    break;
                case "4":
                    task = "Servir ajiaco";
                    break;
                case "5":
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida, intente de nuevo.");
            }

            if (!task.isEmpty()) {
                Thread thread = new Thread(new AjiacoPreparation(task));
                thread.start();
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } while (!option.equals("5"));

        scanner.close();
    }
}
