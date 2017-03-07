package fr.client.cacount.services.account;

import fr.client.cacount.services.utils.OwnerData;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by svirch_n on 07/03/17.
 */
public class SharedAccountCalculator {

    private final SharedEntries entries;
    private Map<String, BigDecimal> owners;

    public SharedAccountCalculator(SharedEntries entries) {
        this.entries = entries;
    }

    public Map<String, BigDecimal> getOwners() {
        Map<String, BigDecimal> result = new HashMap<>();
        for (SharedEntry entry : entries) {
            if (!result.containsKey(entry.owner)) {
                result.put(entry.owner, new BigDecimal(entry.value));
            } else {
                BigDecimal oldValue = result.get(entry.owner);
                BigDecimal newValue = oldValue.add(new BigDecimal(entry.value));
                result.remove(entry.owner);
                result.put(entry.owner, newValue);
            }
        }
        return result;
    }


    public OwnerData getLower() throws NoOwnerException {
        owners = getOwners();
        if (owners.size() == 0) {
            throw new NoOwnerException();
        }
        Iterator<Map.Entry<String, BigDecimal>> iterator = owners.entrySet().iterator();
        Map.Entry<String, BigDecimal> one = iterator.next();
        if (owners.size() == 1) {
            return new OwnerData("Not " + one.getKey(), one.getValue(), one.getValue());
        }
        Map.Entry<String, BigDecimal> two = iterator.next();
        if (one.getValue().doubleValue() > two.getValue().doubleValue()) {
            return new OwnerData(two.getKey(), two.getValue(), one.getValue().subtract(two.getValue()));
        } else {
            return new OwnerData(one.getKey(), one.getValue(), two.getValue().subtract(one.getValue()));
        }
    }

    public class NoOwnerException extends Throwable {
    }
}
