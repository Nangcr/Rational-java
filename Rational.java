/**
 * Created by Nangcr on 2016/12/5.
 */
public class Rational {
    private int numerator;
    private int denominator;

    public int Numerator(){
        return numerator;
    }
    public int Denominator(){
        return denominator;
    }
    public Rational() {
        numerator = IntegralDomain.one();
        denominator = IntegralDomain.one();
    }

    public Rational(int numerator) {
        this.numerator = numerator;
        denominator = IntegralDomain.one();
    }

    public Rational(int numerator, int denominator) {
        if (denominator > IntegralDomain.zero()) {
            this.numerator = IntegralDomain.divide(numerator, IntegralDomain.GreatestCommonDivisor(numerator, denominator));
            this.denominator = IntegralDomain.divide(denominator, IntegralDomain.GreatestCommonDivisor(numerator, denominator));
        } else if (denominator == IntegralDomain.zero()) {
            throw new ArithmeticException();
        } else if (denominator < IntegralDomain.zero()) {
            this.numerator = IntegralDomain.negate(IntegralDomain.divide(numerator, IntegralDomain.GreatestCommonDivisor(numerator, denominator)));
            this.denominator = IntegralDomain.negate(IntegralDomain.divide(denominator, IntegralDomain.GreatestCommonDivisor(numerator, denominator)));
        }
    }

    static Rational zero() {
        return new Rational(IntegralDomain.zero(), IntegralDomain.one());
    }

    static Rational one() {
        return new Rational(IntegralDomain.one(), IntegralDomain.one());
    }

    static Rational negate(Rational a) {
        return new Rational(IntegralDomain.negate(a.numerator), a.denominator);
    }

    static Rational reciprocal(Rational a) {
        return new Rational(a.denominator, a.numerator);
    }

    static Rational plus(Rational a, Rational b) {
        return new Rational(IntegralDomain.plus(IntegralDomain.times(a.numerator, b.denominator), IntegralDomain.times(b.numerator, a.denominator)), IntegralDomain.times(a.denominator, b.denominator));
    }

    static Rational minus(Rational a, Rational b) {
        return plus(a, negate(b));
    }

    static Rational times(Rational a, Rational b) {
        return new Rational(IntegralDomain.times(a.numerator, b.numerator), IntegralDomain.times(a.denominator, b.denominator));
    }

    static Rational divide(Rational a, Rational b) {
        return times(a, reciprocal(b));
    }

    static boolean equal(Rational a, Rational b) {
        if (IntegralDomain.equal(IntegralDomain.times(a.numerator, b.denominator), IntegralDomain.times(a.denominator, b.numerator)))
            return true;
        else
            return false;
    }
}
