package fr.client.cacount.services.account;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by svirch_n on 07/03/17.
 */
public class SharedEntries extends ArrayList<SharedEntry> {
    public SharedEntries(SharedEntry[] sharedEntries) {
        super(Arrays.asList(sharedEntries));
    }

    public SharedEntries() {

    }
}
