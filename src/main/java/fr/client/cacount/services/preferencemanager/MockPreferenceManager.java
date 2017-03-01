package fr.client.cacount.services.preferencemanager;

/**
 * Created by svirch_n on 01/03/17.
 */
public class MockPreferenceManager implements PreferenceManagerInterface {


    private Double ratio;



    @Override
    public Double getRatio() {
        return ratio;
    }

    public PreferenceManagerInterface ratio(double ratio) {
        this.ratio = ratio;
        return this;
    }
}
