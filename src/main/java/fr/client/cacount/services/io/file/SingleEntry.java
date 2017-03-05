package fr.client.cacount.services.io.file;

/**
 * Created by svirch_n on 12/02/17.
 */
public class SingleEntry {

    public String date;
    public String time;
    public String category;
    public String label;
    public double value;

    public SingleEntry price(double price) {
        value = price;
        return this;
    }
}
