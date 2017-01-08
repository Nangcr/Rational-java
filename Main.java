/**
 * Created by Nangcr on 2016/12/5.
 */
public class Main {
    public static void main(String args[]) {
        Rational a, b, c, sum;
        a = new Rational(37, 5);
        b = new Rational(63, 49);
        c = new Rational(3, 7);
        sum = Rational.plus(a, b);
        System.out.println(sum.Numerator() + " " + sum.Denominator());
        System.out.print(Rational.equal(a, b));

    }
}
