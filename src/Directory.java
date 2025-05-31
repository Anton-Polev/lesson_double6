import java.util.*;

public class Directory {
    private String family;
    private Map<String, List<String>> numbers;

    public Directory() {
        this.numbers = new HashMap<>();
    }

    public void addNumber(String family, String number) {
        numbers.putIfAbsent(family, new ArrayList<>());
        numbers.get(family).add(number);
    }

    public List<String> getNumbers(String family) {
        return numbers.getOrDefault(family, Collections.emptyList());
    }

    public Map<String, List<String>> getAllNumbers() {
        return numbers;
    }

    public void printAllNumbers() {
        for (Map.Entry<String, List<String>> number : numbers.entrySet()) {
            System.out.println("Фамилия: " + number.getKey() + ", Номера: " + number.getValue());
        }
    }

    public static void main(String[] args) {
        Directory directory = new Directory();

        directory.addNumber("Иванов", "123-456-789");
        directory.addNumber("Иванов", "101-112-131");
        directory.addNumber("Петров", "415-161-718");
        directory.addNumber("Сидоров", "192-021-222");

        System.out.println("Телефоны Иванова: " + directory.getNumbers("Иванов"));
        System.out.println("Телефоны Петрова: " + directory.getNumbers("Петров"));
        System.out.println("Телефоны Сидорова: " + directory.getNumbers("Сидоров"));

        System.out.println("--------------------");
        System.out.println("Все записи:");
        directory.printAllNumbers();
    }
}
