import java.io.*;
import java.util.*;

//8
//50 7 25 3632 A
//14 23 52 212372 S
//15 0 5 3632 C
//14 21 30 212372 A
//50 7 26 3632 C
//14 21 30 3632 A
//14 21 40 212372 B
//14 23 52 3632 B

//156 142

public class Main {
    static int eventType;
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());
            Map<Integer, Map<Integer, Integer>> eventsById = new TreeMap<>();

            for (int i = 0; i < n; i++) {
                String[] data = br.readLine().split(" ");
                int day = Integer.parseInt(data[0]);
                int hour = Integer.parseInt(data[1]);
                int minute = Integer.parseInt(data[2]);
                int rId = Integer.parseInt(data[3]);
                String event = data[4];

                if(event.equals("A")) {
                    eventType = 0;
                } else if (event.equals("C") || event.equals("S")) {
                    eventType = 1;
                } else if (event.equals("B")) {
                    continue;
                }
                hour = day * 24 + hour;
                minute = hour * 60 + minute;
                if(!eventsById.containsKey(rId)) {
                    eventsById.put(rId, new TreeMap<>());
                }
                eventsById.get(rId).put(minute, eventType);
            }
            System.out.println();
            System.out.println(eventsById);
            for (var el : eventsById.values()){
                int ans = 0;
                int prevTime = 0;
                for(var elem : el.entrySet()) {
                    if(elem.getValue() == 0) {
                        prevTime = elem.getKey();
                    } else if (elem.getValue() == 1) {
                        ans += elem.getKey() - prevTime;
                    }
                }
                System.out.print(ans + " ");
            }
        }


    }
}