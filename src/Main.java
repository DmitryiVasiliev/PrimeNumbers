import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;

public class Main {
    protected static boolean flag = false;
    protected static int[] prime_num_list = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41,
            43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89,
            97, 101, 103, 107, 109, 113, 127, 131, 137,
            139, 149, 151, 157, 163, 167, 173, 179, 181,
            191, 193, 197, 199, 211, 223, 227, 229, 233,
            239, 241, 251};

    public static void main(String[] args) {
        System.out.println("Введите количество бит p: ");
        int p = new Scanner(System.in).nextInt();
        int count = 5;
        int c = 0;
        BigInteger bigInteger;
        boolean  test = true;
        while (test) {
            flag = false;
            do {
                bigInteger = generateRandomNumber(p);
            } while (bigInteger.mod(BigInteger.valueOf(2)).equals(BigInteger.valueOf(0)));
           // System.out.println("------------------------------------------------");
            //System.out.println("Проверка делимость n на все простые числа меньше 256 ...");
            for (int i : prime_num_list) {
                if (i != bigInteger.intValue() && !checkPrimeNumbers(i, bigInteger.intValue())) {
                  //  System.out.println("Число " + bigInteger.intValue() + " разделилось на " + i);
                    flag = true;
                    break;
                }
            }
            if (!flag)
                System.out.println("Число " + bigInteger.intValue() + " не разделилось не на одно из простых чисел меньших 256");
            else{ c++; continue;}
            System.out.println("-------------------------------------------------");
            System.out.println("Тест Леманна :");
            TestLemanna testLemanna = TestLemanna.getInstance(p);
            if(!testLemanna.testLemanna(bigInteger.intValue(), 5))
                continue;
            else test = false;
            System.out.println("-------------------------------------------------");
            System.out.println("Решето Эрастофена: ");
            CriterionVilsons criterionVilsons = CriterionVilsons.getInstance();
            criterionVilsons.setN(bigInteger.intValue());
//              if (criterionVilsons.createSieveEratosfena())
//                System.out.println("Число " + bigInteger + " простое ");
//             else
//                System.out.println("Число " + bigInteger + " не является простым");
//            System.out.println("-------------------------------------------------");
//            System.out.println("Критерий Вилсона: ");
//            if (criterionVilsons.createVilsonsCriterion())
//                System.out.println("Число " + bigInteger + " простое ");
//            else
//                System.out.println("Число " + bigInteger + " не является простым");
            c++;
            flag = false;
        }


    }

    protected static int gcd(int x, int y) {
        int g;
        if (x < 0)
            x = -x;
        if (y < 0)
            y = -y;
        if (x + y == 0)
            return 0;
        g = y;
        while (x > 0) {
            g = x;
            x = y % x;
            y = g;
        }
        return g;
    }

    protected static BigInteger generatePrimeNumber(int p) {
        Random random = new Random();
        BigInteger bigInteger = BigInteger.probablePrime(p, random);
        return bigInteger;
    }

    protected static BigInteger generateRandomNumber(int p) {
        Random random = new Random();
        BigInteger bigInteger = new BigInteger(p, random);
        return bigInteger;
    }

    protected static boolean checkPrimeNumbers(int x, int y) {
        int res = gcd(x, y);
        if (res == 1)
            return true;
        else
            return false;
    }


}
