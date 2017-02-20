package fr.client.cacount.services.utils;

/**
 * Created by svirch_n on 20/02/17.
 */
public class CSVLineCreator {

    static String date = "01/01/2017";
    static String time = "13:30:00";
    static String category = "CATEGORY";
    static String label = "LABEL";
    static String price = "12.53";

    public static String date(String day) {
        String[] result = defaultLine();
        result[0] = day;
        return CSVLineCreator.toString(result);
    }

    private static String toString(String[] elements) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < elements.length; i++) {
            String each = elements[i];
            if (i != 0) {
                result.append(", ");
            }
            result.append(each);

        }
        return result.toString();
    }

    private static String[] defaultLine() {
        return new String[]{date, time, category, label, price};
    }

    public static String day(int days) {
        return days + "/01/2017";
    }
}
