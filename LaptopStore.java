import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class LaptopStore {
    public static void main(String[] args) {
        Set<Laptop> laptops = new HashSet<>();
        laptops.add(new Laptop("Dell", 8, 256, "Windows", "Black"));
        laptops.add(new Laptop("HP", 16, 512, "Windows", "Silver"));
        laptops.add(new Laptop("MacBook", 8, 256, "MacOS", "Gray"));
        laptops.add(new Laptop("Asus", 16, 1024, "Linux", "Black"));

        Scanner scanner = new Scanner(System.in);
        Map<String, String> criteria = new HashMap<>();

        System.out.println("Введите цифру, соответствующую необходимому критерию:");
        System.out.println("1 - ОЗУ");
        System.out.println("2 - Объем ЖД");
        System.out.println("3 - Операционная система");
        System.out.println("4 - Цвет");

        int criterion = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (criterion) {
            case 1:
                System.out.println("Введите минимальное значение ОЗУ (в ГБ):");
                criteria.put("ram", scanner.nextLine());
                break;
            case 2:
                System.out.println("Введите минимальное значение объема ЖД (в ГБ):");
                criteria.put("storage", scanner.nextLine());
                break;
            case 3:
                System.out.println("Введите операционную систему:");
                criteria.put("os", scanner.nextLine());
                break;
            case 4:
                System.out.println("Введите цвет:");
                criteria.put("color", scanner.nextLine());
                break;
            default:
                System.out.println("Неверный критерий");
                return;
        }

        filterAndPrintLaptops(laptops, criteria);
    }

    private static void filterAndPrintLaptops(Set<Laptop> laptops, Map<String, String> criteria) {
        for (Laptop laptop : laptops) {
            boolean matches = true;

            for (Map.Entry<String, String> entry : criteria.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();

                switch (key) {
                    case "ram":
                        if (laptop.getRam() < Integer.parseInt(value)) {
                            matches = false;
                        }
                        break;
                    case "storage":
                        if (laptop.getStorage() < Integer.parseInt(value)) {
                            matches = false;
                        }
                        break;
                    case "os":
                        if (!laptop.getOs().equalsIgnoreCase(value)) {
                            matches = false;
                        }
                        break;
                    case "color":
                        if (!laptop.getColor().equalsIgnoreCase(value)) {
                            matches = false;
                        }
                        break;
                }
                if (!matches) break;
            }

            if (matches) {
                System.out.println(laptop);
            }
        }
    }
}
