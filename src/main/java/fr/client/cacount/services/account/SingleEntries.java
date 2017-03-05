package fr.client.cacount.services.account;

import fr.client.cacount.services.io.file.SingleEntry;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


/**
 * Created by svirch_n on 05/03/17.
 */
public class SingleEntries extends LinkedList<SingleEntry> {

    public SingleEntries(SingleEntry[] singleEntries) {
        super(Arrays.asList(singleEntries));
    }

    public SingleEntries() {
        super();
    }

    public List<SingleEntry> getEntries() {
        return Collections.unmodifiableList(this);
    }
}
