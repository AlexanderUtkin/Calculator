import java.util.Scanner;

public class RomanArabianCalc {
    static Scanner scanner = new Scanner(System.in);
    static char operator;

    public static void main (String[] args) throws FormatException {

        System.out.println("Введите выражение арабскими (от 0 до 10) или римскими (от I до X)  цифрами и нажмите Enter");

        String userInput = scanner.nextLine();

        char[] charOfString = new char[10];

        for (int i = 0; i < userInput.length(); i++) {
            charOfString[i] = userInput.charAt(i);
            if (charOfString[i] == '+') {
                operator = '+';
            }
            if (charOfString[i] == '-') {
                operator = '-';
            }
            if (charOfString[i] == '*') {
                operator = '*';
            }
            if (charOfString[i] == '/') {
                operator = '/';
            }
        }
        String stringOfChar = String.valueOf(charOfString);
        String[] stringBlocks = stringOfChar.split("[+-/*=%^!@,<>.?_)(&$#]");
        if(stringBlocks.length>2){
            throw new FormatException("Неверный формат.Проверь вводимое выражение");
        }
        String stringBlock1 = stringBlocks[0].trim();
        String stringBlock2 = stringBlocks[1].trim();


        if(stringBlock1.matches("[0-9]+") && stringBlock2.matches("[0-9]+")) {
            int arabNum1 = Integer.parseInt(stringBlock1);
            int arabNum2 = Integer.parseInt(stringBlock2);
            Calculate cl = new Calculate();
            System.out.println((cl.calculated(arabNum1,arabNum2, operator)));
        }else {
            if(stringBlock1.matches("[0-9]+") || stringBlock2.matches("[0-9]+")){
                throw new FormatException("Неверный формат.Проверь вводимое выражение");
            }else {
                RomanToDecimal rn = new RomanToDecimal();
                int num1 = rn.romanToDecimal(stringBlock1);
                int num2 = rn.romanToDecimal(stringBlock2);
                Calculate cl = new Calculate();
                int result = cl.calculated(num1, num2, operator);
                DecimalToRoman dr = new DecimalToRoman();
                System.out.println(dr.IntegerToRomanNumeral(result));
            }
    }

    }

}
