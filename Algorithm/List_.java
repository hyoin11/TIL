package Algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class List_ {
    static List<Map<String, Object>> mapList = new ArrayList<>();

    public static void main(String[] args) {
        setData();

        sortByMapAscending();
        sortByMapDescending();
    }

    private static void setData() {
        for (int i = 5; i > 0; i--) {
            Map<String, Object> data = new HashMap<>();
            data.put("id", i);
            data.put("name", i + "번");
            mapList.add(data);
        }
    }

    private static void sortByMapAscending() {
        // map key 값으로 오름차순
        Collections.sort(mapList, new Comparator<Map<String, Object>>() {
            @Override
            public int compare(Map<String, Object> o1, Map<String, Object> o2) {
                return ((Integer) o1.get("id")) - ((Integer) o2.get("id"));
            }
        });
        System.out.println(mapList);
    }

    private static void sortByMapDescending() {
        // map key 값으로 내림차순
        Collections.sort(mapList, new Comparator<Map<String, Object>>() {
            @Override
            public int compare(Map<String, Object> o1, Map<String, Object> o2) {
                return ((Integer) o2.get("id")) - ((Integer) o1.get("id"));
            }
        });
        System.out.println(mapList);
    }
}
