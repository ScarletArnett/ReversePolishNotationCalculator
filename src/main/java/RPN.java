import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by Alexandre BAPTISTE on 01/01/2017.
 */

public class RPN {
    private LinkedList<Double> stack = new LinkedList<>();

    /*
    @String expression: L'expression saisie pour l'utilisateur
    La méthode "évaluer" est utilisée quand un string est passé en arguments
    Enlève les espaces de l'expression puis itère, ajoute et traite les calculs
     */
    private void evaluer(String expression) {
        for (String token : expression.split("\\s")) {
            Double tokenNum = null;
            try {
                tokenNum = Double.parseDouble(token);
            } catch (NumberFormatException ignored) {
            }
            if (tokenNum != null) {
                stack.add(Double.parseDouble(token + ""));
            } else {
                Operand(token);
            }
        }
        System.out.println("Réponse: " + stack.removeLast());
    }

    /*
    @String op: L'opérande utilisée
    Utilsation d'un ou deux doubles prenant leur valeur de la fin de la pile,
    puis ajout du résultat à la pile
     */
    private void Operand(String op) {
        double secondOperand;
        double firstOperand;

        switch (op) {
            case "*":
                secondOperand = stack.removeLast();
                firstOperand = stack.removeLast();
                stack.add(firstOperand * secondOperand);
                break;
            case "/":
                secondOperand = stack.removeLast();
                firstOperand = stack.removeLast();
                stack.add(firstOperand / secondOperand);
                break;
            case "+":
                secondOperand = stack.removeLast();
                firstOperand = stack.removeLast();
                stack.add(firstOperand + secondOperand);
                break;
            case "-":
                secondOperand = stack.removeLast();
                firstOperand = stack.removeLast();
                stack.add(firstOperand - secondOperand);
                break;
            case "^":
                secondOperand = stack.removeLast();
                firstOperand = stack.removeLast();
                stack.add(Math.pow(firstOperand, secondOperand));
                break;
            case "sqrt":
                firstOperand = stack.removeLast();
                stack.add(Math.sqrt(firstOperand));
                break;
            case "carré":
                firstOperand = stack.removeLast();
                stack.add(firstOperand * firstOperand);
                break;
            case "sin":
                firstOperand = stack.removeLast();
                stack.add(Math.sin(firstOperand));
                break;
            case "cos":
                firstOperand = stack.removeLast();
                stack.add(Math.cos(firstOperand));
                break;
            case "tan":
                firstOperand = stack.removeLast();
                stack.add(Math.tan(firstOperand));
                break;
            case "opp":
                firstOperand = stack.removeLast();
                stack.add(firstOperand * -1);
                break;
            case "inv":
                firstOperand = stack.removeLast();
                stack.add(1 / firstOperand);
                break;
            case "!":
                firstOperand = stack.removeLast();
                stack.add((double) factorial((int) firstOperand));
                break;
        }
    }

    /*
    @int n: le nombre à "factoriser"
    Petite méthode pour le factoriel d'un entier
     */
    private static int factorial(int n) {
        int fact = 0;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }

    /*
    Utilisée lors du mode sans argument du programme
    Scanner pour gestion de l'entrée utilisateur
    Gestion du mode trace/notrace
     */
    private void entree() {
        Boolean trace = false;
        System.out.println("--- MODE ENTRÉE ---");
        Scanner scanner = new Scanner(System.in);
        try {
            while (true) {
                if (!trace){
                    if ( scanner.hasNextInt() ) {
                        stack.add((double) scanner.nextInt());
                        System.out.println("Valeur ajoutée");
                    } else {
                        String s = scanner.next();
                        switch (s) {
                            case "pile":
                                System.out.println(stack);
                                break;
                            case "close":
                                return;
                            case "trace":
                                trace = true;
                                System.out.println("--- TRACE ON ---");
                                break;
                            case "notrace":
                                trace = false;
                                System.out.println("--- TRACE OFF ---");
                                break;
                            default:
                                Operand(s);
                                System.out.println("Opérande ajoutée");
                                break;
                        }
                    }
                } else {
                    if ( scanner.hasNextInt() ) {
                        stack.add((double) scanner.nextInt());
                        System.out.println("Valeur ajoutée");
                        System.out.println("État de la pile: " + stack);
                    } else {
                        String s = scanner.next();
                        switch (s) {
                            case "pile":
                                System.out.println(stack);
                                break;
                            case "close":
                                return;
                            case "trace":
                                trace = true;
                                System.out.println("--- TRACE ON ---");
                                break;
                            case "notrace":
                                trace = false;
                                System.out.println("--- TRACE OFF ---");
                                break;
                            default:
                                Operand(s);
                                System.out.println("Opérande ajoutée");
                                System.out.println("État de la pile: " + stack);
                                break;
                        }
                    }
                }

            }
        } catch(IllegalStateException e) {
            System.out.println("System.in was closed; exiting");
        }
    }


    public static void main(String[] args) {
        RPN rpn = new RPN();
        if(args.length != 0){
            rpn.evaluer(args[0]);
        } else {
            rpn.entree();
        }
    }
}
