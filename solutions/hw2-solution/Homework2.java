package cse41321.homework.homework2;

import cse41321.containers.SinglyLinkedList;

/**
 * Demonstrates representing polynomials using a singly-linked list.
 *
 * Program output:
 * 1.000000x + 1.000000 = 2.000000 with x = 1.000000
 * 1.000000x^2 - 1.000000 = 0.000000 with x = 2.030000
 * -3.000000x^3 + 0.500000x^2 - 2.000000x = -562.500000 with x = 5.000000
 * -0.312500x^4 - 9.915000x^2 - 7.750000x - 40.000000 = -13465542707.016651 with x = 123.450000
 */
public class Homework2 {
    public static void main(String[] args) {
        testPolynomial(buildPolynomial1(), 1.0);
        testPolynomial(buildPolynomial2(), 2.03);
        testPolynomial(buildPolynomial3(), 5.0);
        testPolynomial(buildPolynomial4(), 123.45);
    }

    /**
     * Add a new term with the given coefficient to the end of the polynomial.
     * @param polynomial to which a term will be appended.
     * @param coefficient of the new term.
     */
    private static void appendTerm(SinglyLinkedList<Double> polynomial,
                                   Double coefficient) {
        polynomial.insertTail(coefficient);
    }

    /**
     * Pretty-prints the polynomial.
     * @param polynomial to be pretty-printed.
     */
    private static void display(SinglyLinkedList<Double> polynomial) {

        int power = polynomial.getSize() - 1;
        boolean firstTermPrinted = false;

        // Print terms
        for (SinglyLinkedList<Double>.Element element = polynomial.getHead();
                element != null;
                element = element.getNext()) {

            // Print term
            Double coefficient = element.getData();
            if (coefficient != 0) {
                String sign = firstTermPrinted
                        ? (coefficient < 0 ? " - " : " + ")
                        : (coefficient < 0 ? "-" : "");
                coefficient = Math.abs(coefficient);
                String x = power > 0 ? "x" : "";
                String exponent = power > 1
                        ? String.format("^%d", power)
                        : "";

                System.out.print(String.format("%s%f%s%s",
                        sign,
                        coefficient,
                        x,
                        exponent));
                firstTermPrinted = true;
            }

            --power;
        }
    }

    /**
     * Evaluates the polynomial for the given value of x and returns the result.
     * @param polynomial to be evaluated.
     * @param x value to be used to evaluate the polynomial.
     * @return the value of polynomial for value x.
     */
    private static Double evaluate(SinglyLinkedList<Double> polynomial,
                                   Double x) {
        int power = polynomial.getSize() - 1;
        double sum = 0.0;

        // Sum terms
        for (SinglyLinkedList<Double>.Element element = polynomial.getHead();
                element != null;
                element = element.getNext()) {
            sum += element.getData() * Math.pow(x, power);
        }

        return sum;
    }

    private static void testPolynomial(SinglyLinkedList<Double> polynomial,
                                       Double x) {
        display(polynomial);
        System.out.print(String.format(" = %f", evaluate(polynomial, x)));
        System.out.println(String.format(" with x = %f", x));
    }

    private static SinglyLinkedList<Double> buildPolynomial1() {
        SinglyLinkedList<Double> polynomial = new SinglyLinkedList<>();
        appendTerm(polynomial, 1.0);
        appendTerm(polynomial, 1.0);
        return polynomial;
    }

    private static SinglyLinkedList<Double> buildPolynomial2() {
        SinglyLinkedList<Double> polynomial = new SinglyLinkedList<>();
        appendTerm(polynomial, 1.0);
        appendTerm(polynomial, 0.0);
        appendTerm(polynomial, -1.0);
        return polynomial;
    }

    private static SinglyLinkedList<Double> buildPolynomial3() {
        SinglyLinkedList<Double> polynomial = new SinglyLinkedList<>();
        appendTerm(polynomial, -3.0);
        appendTerm(polynomial, 0.5);
        appendTerm(polynomial, -2.0);
        appendTerm(polynomial, 0.0);
        return polynomial;
    }

    private static SinglyLinkedList<Double> buildPolynomial4() {
        SinglyLinkedList<Double> polynomial = new SinglyLinkedList<>();
        appendTerm(polynomial, -0.3125);
        appendTerm(polynomial, 0.0);
        appendTerm(polynomial, -9.915);
        appendTerm(polynomial, -7.75);
        appendTerm(polynomial, -40.0);
        return polynomial;
    }
}
