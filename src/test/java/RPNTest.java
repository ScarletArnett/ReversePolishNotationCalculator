import java.util.LinkedList;
import static org.junit.Assert.*;

/**
 * Created by Alexandre BAPTISTE on 06/01/17.
 * Étudiant LPRO D.A.S.I
 * Projet: rpn-app
**/


public class RPNTest {

    private RPN rpn = new RPN();

    @org.junit.Test
    public void EvaluateAddTest() {
        System.out.println("---- ADDITION TEST ----");
        double expected = 4.0;
        double result = rpn.evaluer("2 2 +");
        assertEquals(expected, result,0);
    }

    @org.junit.Test
    public void EvaluateMultiplicationTest() {
        System.out.println("---- MULTIPLICATION TEST ----");
        double expected = 4.0;
        double result = rpn.evaluer("2 2 *");
        assertEquals(expected, result,0);
    }

    @org.junit.Test
    public void EvaluateSubTest() {
        System.out.println("---- SUBSTRACTION TEST ----");
        double expected = 0.0;
        double result = rpn.evaluer("2 2 -");
        assertEquals(expected, result,0);
    }

    @org.junit.Test
    public void EvaluateDivTest() {
        System.out.println("---- ADDITION TEST ----");
        double expected = 1.0;
        double result = rpn.evaluer("2 2 /");
        assertEquals(expected, result,0);
    }

    @org.junit.Test
    public void EvaluatePowTest() {
        System.out.println("---- POW TEST ----");
        double expected = 4.0;
        double result = rpn.evaluer("2 2 ^");
        assertEquals(expected, result,0);
    }

    @org.junit.Test
    public void EvaluateSqrtTest() {
        System.out.println("---- SQRT TEST ----");
        double expected = 2.0;
        double result = rpn.evaluer("4 sqrt");
        assertEquals(expected, result,0);
    }

    @org.junit.Test
    public void EvaluateUpTest() {
        System.out.println("---- ² TEST ----");
        double expected = 4.0;
        double result = rpn.evaluer("2 carré");
        assertEquals(expected, result,0);
    }

    @org.junit.Test
    public void EvaluateSinTest() {
        System.out.println("---- SINUS TEST ----");
        double expected = 0.8414709848;
        double result = rpn.evaluer("1 sin");
        assertEquals(expected, result,0.0000000001);
    }

    @org.junit.Test
    public void EvaluateCosTest() {
        System.out.println("---- COSINUS TEST ----");
        double expected = 0.54030230586;
        double result = rpn.evaluer("1 cos");
        assertEquals(expected, result,0.0000000001);
    }

    @org.junit.Test
    public void EvaluateTanTest() {
        System.out.println("---- TANGEANTE TEST ----");
        double expected = 1.55740772465;
        double result = rpn.evaluer("1 tan");
        assertEquals(expected, result,0.0000000001);
    }

    @org.junit.Test
    public void EvaluateOppTest() {
        System.out.println("---- OPP TEST ----");
        double expected = -1;
        double result = rpn.evaluer("1 opp");
        assertEquals(expected, result,0.0000000001);
    }

    @org.junit.Test
    public void EvaluateInvTest() {
        System.out.println("---- INVERSE TEST ----");
        double expected = 0.5;
        double result = rpn.evaluer("2 inv");
        assertEquals(expected, result,0.0000000001);
    }

    @org.junit.Test
    public void EvaluateClassicFactorialTest() {
        System.out.println("---- CLASSIC FACTORIAL TEST ----");
        double expected = 120;
        double result = rpn.evaluer("5 !");
        assertEquals(expected, result,0.0000000001);
    }

    @org.junit.Test
    public void EvaluateGammaFactorialTest() {
        System.out.println("---- APACHE GAMMA FACTORIAL TEST ----");
        double expected = 24.000000000000004 ;
        double result = rpn.evaluer("5 !G");
        assertEquals(expected, result,0.000000000000001);
    }

    @org.junit.Test
    public void EvaluateFactorialMethod() {
        System.out.println("---- FACTORIAL METHOD ----");
        double expected = 120 ;
        double result = rpn.factorial(5);
        assertEquals(expected, result,0);
    }

    @org.junit.Test
    public void stackEmptyAfterEvaluating() {
        System.out.println("---- STACK EMPTY ----");
        rpn.evaluer("2 2 +");
        LinkedList<Double> expected = new LinkedList<>();
        LinkedList<Double> stack = rpn.getStack();
        assertEquals(expected.isEmpty(), stack.isEmpty());
    }



}