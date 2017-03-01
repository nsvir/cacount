package fr.client.cacount.services.preferencemanager;

/**
 * Created by svirch_n on 01/03/17.
 */
public class EmptyPreferenceManager implements PreferenceManagerInterface {
    @Override
    public Double getRatio() {
        return 0d;
    }
}
