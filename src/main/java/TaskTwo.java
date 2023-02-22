import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class TaskTwo {
    public static void main(String[] args) {
        HashMap<String, Integer> workerMap = new HashMap<>();
        String names = "Иван Иванов " +
                "Светлана Петрова " +
                "Кристина Белова " +
                "Анна Мусина " +
                "Анна Крутова " +
                "Иван Юрин " +
                "Петр Лыков " +
                "Павел Чернов " +
                "Петр Чернышов " +
                "Мария Федорова " +
                "Марина Светлова " +
                "Мария Савина " +
                "Мария Рыкова " +
                "Марина Лугова " +
                "Анна Владимирова " +
                "Иван Мечников " +
                "Петр Петин " +
                "Иван Ежов ";

        String[] listWorker = names.split(" ");
        for (int i = 0; i < listWorker.length; i += 2) {
            if (workerMap.containsKey(listWorker[i])) {
                workerMap.replace(listWorker[i], workerMap.get(listWorker[i]) + 1);
            } else {
                workerMap.put(listWorker[i], 1);
            }
        }

        LinkedHashMap<String, Integer> sortedWorkerMap = new LinkedHashMap<>();
        int max = 1;
        for (int value : workerMap.values()) {
            if (value > max) {
                max = value;
            }
        }
        for (int i = max; i > 0; i--) {
            for (Map.Entry<String, Integer> entry : workerMap.entrySet()) {
                String key = entry.getKey();
                if (workerMap.get(key) == i) {
                    sortedWorkerMap.put(key, workerMap.get(key));
                }
            }
        }
        System.out.println(sortedWorkerMap);
    }
}
