package Algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Map_ {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("가", 30);
        map.put("나", 10);
        map.put("다", 50);
        map.put("라", 40);
        map.put("마", 20);
        System.out.println(map);

        sortByKeyAscending(map);
        sortByKeyDescending(map);
        sortByValueAscending(map);
        sortByValueDescending(map);
    }

    private static void sortByKeyAscending(Map<String, Integer> map) {
        List<String> keySet = new ArrayList<>(map.keySet());
        Collections.sort(keySet);

        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (int i = 0; i < keySet.size(); i++) {
            String key = keySet.get(i);
            sb.append(key + "=" + map.get(key));
            if (i < keySet.size() - 1) sb.append(", ");
        }
        sb.append("}");
        System.out.println("sort by key ascending " + sb.toString());
    }

    private static void sortByKeyDescending(Map<String, Integer> map) {
        List<String> keySet = new ArrayList<>(map.keySet());
        Collections.sort(keySet);
        Collections.reverse(keySet);

        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (int i = 0; i < keySet.size(); i++) {
            String key = keySet.get(i);
            sb.append(key + "=" + map.get(key));
            if (i < keySet.size() - 1) sb.append(", ");
        }
        sb.append("}");
        System.out.println("sort by key descending " + sb.toString());
    }

    private static void sortByValueAscending(Map<String, Integer> map) {
        List<String> keySet = new ArrayList<>(map.keySet());
        keySet.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return map.get(o1).compareTo(map.get(o2));
            }
        });
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (int i = 0; i < keySet.size(); i++) {
            String key = keySet.get(i);
            sb.append(key + "=" + map.get(key));
            if (i < keySet.size() - 1) sb.append(", ");
        }
        sb.append("}");
        System.out.println("sort by value ascending " + sb.toString());
    }

    private static void sortByValueDescending(Map<String, Integer> map) {
        List<String> keySet = new ArrayList<>(map.keySet());
        keySet.sort((o1, o2) -> map.get(o2).compareTo(map.get(o1)));
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (int i = 0; i < keySet.size(); i++) {
            String key = keySet.get(i);
            sb.append(key + "=" + map.get(key));
            if (i < keySet.size() - 1) sb.append(", ");
        }
        sb.append("}");
        System.out.println("sort by value descending " + sb.toString());
    }
}
