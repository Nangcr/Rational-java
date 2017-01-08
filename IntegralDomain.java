/**
 * Created by Nangcr on 2016/12/5.
 */
public class IntegralDomain {
    static final int PlusUnit = 0;

    static final int MultipleUnit = 1;

    static int zero() {
        return PlusUnit;
    }

    static int one() {
        return MultipleUnit;
    }

    static int negate(int a) {
        return zero() - a;
    }

    static int plus(int a, int b) {
        return a + b;
    }

    static int minus(int a, int b) {
        return a + negate(b);
    }

    static int times(int a, int b) {
        return a * b;
    }

    static int divide(int a, int b) {
        return a / b;
    }

    static int mod(int a, int b) {
        return a % b;
    }

    static boolean equal(int a, int b) {
        if (a == b)
            return true;
        else
            return false;
    }

    static int GreatestCommonDivisor(int a, int b) {
        if (equal(b, zero()))
            return a;
        else
            return GreatestCommonDivisor(b, mod(a, b));
    }
}
