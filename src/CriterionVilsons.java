import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;

public class CriterionVilsons {
    private static CriterionVilsons instance;
    private int n;
    private ArrayList<Integer> integers = new ArrayList<>();

    public void setN(int n) {
        this.n = n;
    }

    private CriterionVilsons() {

    }


    public static CriterionVilsons getInstance() {
        if (instance == null)
            instance = new CriterionVilsons();
        return instance;
    }

    protected boolean createSieveEratosfena() {
        for (int i = 2; i < n + 1; i++) {
            integers.add(i);
        }
        for (int i = 2; i < n + 1; i++) {
            Iterator iterator = integers.iterator();
            while (iterator.hasNext()) {
                int e = (Integer) iterator.next();
                if (e % i == 0 && e != i)
                    iterator.remove();
            }
        }

        for (int i : integers) {
            if (i == n)
                return true;
        }
        return false;
    }

    protected boolean createVilsonsCriterion() {
        BigInteger t = (calculateFactorial(n - 1).add(BigInteger.valueOf(1)));
        return t.mod(BigInteger.valueOf(n)).equals(BigInteger.valueOf(0)) ? true : false;
    }

    private BigInteger calculateFactorial(int n) {
        BigInteger result = BigInteger.valueOf(1);
        for (int i = 1; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

}
