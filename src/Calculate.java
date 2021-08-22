
public class Calculate {
    public int calculated(int num1, int num2, char op) throws FormatException {
        if(num1>10 || num2>10) throw new FormatException("Неверный формат.Проверь вводимое выражение");

            int result =0 ;
            switch (op) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    if(num1 ==0 || num2 == 0) {
                        throw new ArithmeticException("Деление на ноль недопустимо");
                    }else result = num1 / num2;

                     break;
                default:
                    throw new IllegalArgumentException("Не верный знак операции");
            }
            return result;
        }


    }
