import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {

        System.out.println("Введите выражение в одну строку без пробела " +
                "\n арабскими от 1 до 10 " +
                "или римскими от I до X включительно:");
        Scanner sc = new Scanner(System.in);
        int num1 = 0;
        int num2 = 0;
        int result;
        String op;
       do {
            String input = sc.nextLine();
            String[] strings = input.split("\\W");
            String[] operator = input.split("\\w");
            boolean flag = false;
            try {
                num1 = Integer.parseInt(strings[0]);
                num2 = Integer.parseInt(strings[1]);

                if (num1 < 1 || num1 > 10 || num2 < 1 || num2 > 10) {
                    System.out.println("Неверный формат ввода.");
                    break;
                }

                op = operator[operator.length - 1];
                result = operation(num1, num2, op);

                System.out.println(result);
                System.exit(0);

            } catch (Exception e) {
                try {
                    num1 = Converter.toArabic(strings[0]);
                    num2 = Converter.toArabic(strings[1]);
                    flag = true;
                    if (num1 < 1 || num1 > 10 || num2 < 1 || num2 > 10) {
                        System.out.println("Неверный формат ввода.");
                        break;
                    }
                } catch (Exception e1) {
                    System.out.println("Ошибка ввода, внимательно прочитай условия.");
                    System.exit(0);
                }
                op = operator[operator.length - 1];
                result = operation(num1, num2, op);

                String roman = Converter.toRoman(result);
                System.out.println(roman);
                System.exit(0);
            }
        } while (true) ;

    }

    private static int operation(int a, int b, String op) {
        switch (op) {
            case "*":
                return a * b;
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "/":
                return a / b;
            default:
                return 0;
        }
    }
}
