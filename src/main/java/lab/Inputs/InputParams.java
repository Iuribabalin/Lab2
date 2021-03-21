package lab.Inputs;

import java.util.Scanner;

public class InputParams {
    Scanner in = new Scanner(System.in);

    public void stay() {
        in.nextLine();
    }

    public int InputNumFun(){
        while (true) {
            System.out.print("""
                    Выбирите функцию:
                    1. x^3 + 2.84*x^2 - 5.606*x - 14.766
                    2. cos(x^2)
                    3. 5*x^(2) + 2*x - 3
                    4. sin(x)
                    номер функции:\s""");
            try {
                int num_fun = Integer.parseInt(in.next().trim());
                if(num_fun == 1 || num_fun == 2 || num_fun == 3 || num_fun == 4)
                    return num_fun;
            } catch (NumberFormatException ignored) {
            }
        }
    }

    public int InputMethod(){
        while (true) {
            System.out.print("""
                    Выбирите метод:
                    1. Метод хорд
                    2. Метод Ньютона
                    3. Метод простой итерации
                    номер метода:\s""");
            try {
                int num_method = Integer.parseInt(in.next().trim());
                if(num_method == 1 || num_method == 2 || num_method == 3)
                    return num_method;
            } catch (NumberFormatException ignored) {
            }
        }
    }

    public double InputA(){
        while (true) {
            System.out.print("Введите a = ");
            try {
                return Double.parseDouble(in.next().trim().replaceAll(",", "\\."));
            } catch (NumberFormatException ignored) {
            }
        }
    }

    public double InputB(){
        while (true) {
            System.out.print("Введите b = ");
            try {
                return Double.parseDouble(in.next().trim().replaceAll(",", "\\."));
            } catch (NumberFormatException ignored) {
            }
        }
    }

    public double InputE(){
        while (true) {
            System.out.print("Введите e (точность) = ");
            try {
                return Double.parseDouble(in.next().trim().replaceAll(",", "\\."));
            } catch (NumberFormatException ignored) {
            }
        }
    }

    public boolean InputFlagFile(){
        while (true) {
            System.out.print("Ввести данные из файла?y/n ");
            String input = in.nextLine().trim();
            if(input.equals("y") || input.equals("")){
                return true;
            }else if(input.equals("n")){
                return false;
            }
        }
    }

    public boolean OutputFlagFile(){
        while (true) {
            System.out.print("Вывести данные в файл?y/n ");
            String input = in.nextLine().trim();
            if(input.equals("y") || input.equals("")){
                return true;
            }else if(input.equals("n")){
                return false;
            }
        }
    }
}
