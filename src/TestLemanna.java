import java.math.BigInteger;
import java.util.Random;

public class TestLemanna {
    private static TestLemanna instance;
    protected int p;

    private TestLemanna(int p) {
        this.p = p;
    }

    public static TestLemanna getInstance(int p) {
        if (instance == null)
            instance = new TestLemanna(p);
        return instance;
    }

    public void setP(int p) {
        this.p = p;
    }

    protected boolean testLemanna(int n,int tries) {
        int e = (n - 1 )/2;
        int a = new Random().nextInt(n);
        int result = ((int)Math.pow(a,e)) % n;
        int t_ = 0;
        int t = 0;


        while (tries!=0)
        {
            result = ((int)Math.pow(a,e)) % n;


            if(result % n != n - 1)
            //if(result % p != 1 && result % p != p - 1)
            {
                a = new Random().nextInt(n);
                tries--;
                if(result == 1)
                    t++;
                if(result == -1)
                    t_++;
            }
            else
            {

                System.out.println("Число " + n + " не простое");
                return false;
            }
        }
        if (t_ > 0 && t > 0)
            System.out.println("После"+ tries +" тестов можно сказать что число является простым с вероятностью ошибки + " + (1 / Math.pow(2, tries)));
        else
            System.out.println("Число является простым с вероятностью не больше 1/2");
return true;
    }
}
