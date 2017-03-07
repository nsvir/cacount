package fr.client.cacount.services.account;

import fr.client.cacount.services.io.file.SingleEntry;

/**
 * Created by svirch_n on 07/03/17.
 */
public class SharedEntry extends SingleEntry {

    public String owner;

    public SharedEntry owner(String owner) {
        this.owner = owner;
        return this;
    }

}
