import java.util.ArrayList;

public class Polynomial {
    private final ArrayList<Integer> coefficients;

    public Polynomial() {
        this.coefficients = new ArrayList<>();
    }

    public Polynomial(ArrayList<Integer> coefficients) {
        this.coefficients = coefficients;
    }

    public Polynomial(int[] coefficients) {
        this.coefficients = new ArrayList<>();
        for (int coefficient : coefficients) {
            this.coefficients.add(coefficient);
        }
    }

    public int[] getCoefficients() {
        int[] toReturn = new int[coefficients.size()];
        for (int i = 0; i < toReturn.length; i++) {
            toReturn[i] = coefficients.get(i);
        }
        return toReturn;
    }

    public Polynomial add (Polynomial other) {
        int[] result = new int[Math.max(this.coefficients.size(), other.coefficients.size())];
        for (int i = 0; i < result.length; i++) {
            if (this.coefficients.size() > i) result[i] += this.coefficients.get(i);
            if (other.coefficients.size() > i) result[i] += other.coefficients.get(i);
        }
        return new Polynomial(result);
    }

    public Polynomial multiply (Polynomial other) {
        int[] result = new int[(this.coefficients.size() + other.coefficients.size() - 1)];

        for (int i = 0; i < this.coefficients.size(); i++) {
            for (int j = 0; j < other.coefficients.size(); j++) {
                int power = i + j;
                result[power] += this.coefficients.get(i) * other.coefficients.get(j);
            }
        }
        return new Polynomial(result);
    }

    public Polynomial derivative () {
        Polynomial result = new Polynomial();
        for (int i = 1; i < coefficients.size(); i++) {
            result.coefficients.add(coefficients.get(i) * i);
        }
        return result;
    }

    public double evaluate (double x) {
        double result = 0.0;
        for (int i = 0; i < coefficients.size(); i++) {
            result += coefficients.get(i) * Math.pow(x, i);
        }
        return result;
    }
}