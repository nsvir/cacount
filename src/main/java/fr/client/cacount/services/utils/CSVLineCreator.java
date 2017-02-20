package fr.client.cacount.services.utils;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by svirch_n on 20/02/17.
 */
public class CSVLineCreator {

    public static String date(String date) {
        return new LineCreator().date(date).toString();
    }

    public static String day(int days) {
        return days + "/01/2017";
    }

    public static String price(String price) {
        return new LineCreator().price(price).toString();
    }

    public static class LineCreator extends ArrayList<String> {

        ArrayList<String> defaultLine = new ArrayList<>(Arrays.asList(new String[] {
            "01/01/2017",
            "13:30:00",
            "CATEGORY",
            "LABEL",
            "12.5",
        }));

        public LineCreator date(String date) {
            defaultLine.set(0, date);
            return this;
        }

        public LineCreator time(String time) {
            defaultLine.set(1, time);
            return this;
        }

        public LineCreator category(String category) {
            defaultLine.set(2, category);
            return this;
        }

        public LineCreator label(String label) {
            defaultLine.set(3, label);
            return this;
        }

        public LineCreator price(String price) {
            defaultLine.set(4, price);
            return this;
        }

        public String toString() {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < defaultLine.size(); i++) {
                String each = defaultLine.get(i);
                if (i != 0) {
                    result.append(",");
                }
                result.append(each);
            }
            return result.toString();
        }
    }
}
