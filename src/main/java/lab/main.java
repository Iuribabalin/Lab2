package lab;

import lab.Functions.Main_fun;
import lab.Functions.Sin_fun;
import lab.Inputs.CheckInterval;
import lab.Inputs.InputParams;
import lab.Methods.Chord_Method;
import lab.Methods.Newton_Method;
import lab.Methods.Simple_Iteration_Method;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws IOException{
        InputParams input = new InputParams();
        CheckInterval checker = new CheckInterval();

        System.out.println("Программа начала свою работу");
        while (true){
            if(input.InputFlagFile()){
                System.out.print("Введите имя файла (файл должен быть формата .txt): ");
                Scanner in = new Scanner(System.in);
                String fileName = in.nextLine().trim();
                try {
                    FileReader fr = new FileReader("src/main/resources/" + fileName + ".txt");
                    Scanner scan = new Scanner(fr);
                    int num_fun = Integer.parseInt(scan.nextLine().trim());
                    double a = Double.parseDouble(scan.nextLine().trim().replaceAll(",", "\\."));
                    double b = Double.parseDouble(scan.nextLine().trim().replaceAll(",", "\\."));
                    if (checker.check(a, b, num_fun)) {
                        int cnt_answer = checker.checkCntAnswer(a, b, num_fun);
                        if (cnt_answer <= 1) {
                            double e = Double.parseDouble(scan.nextLine().trim().replaceAll(",", "\\."));
                            int num_method = Integer.parseInt(scan.nextLine().trim());
                            boolean flag_file = Boolean.parseBoolean(scan.nextLine().trim());
                            if (num_method == 1) {
                                Chord_Method method = new Chord_Method(a, b, e, num_fun, flag_file);
                                method.start();
                            } else if (num_method == 2) {
                                Newton_Method method = new Newton_Method(a, b, e, num_method, flag_file);
                                method.start();
                            } else if (num_method == 3) {
                                Simple_Iteration_Method method = new Simple_Iteration_Method(a, b, e, num_fun, flag_file);
                                method.start();
                            }
                        } else {
                            System.out.println("Сейчас в интервале " + cnt_answer + " корней");
                        }
                    } else {
                        System.out.println("Извините программа не нашла корней");
                    }
                }catch (FileNotFoundException ex) {
                    System.out.println("Ошибка в имени файла, его не существует");
                }
            }else{
                int num_fun = input.InputNumFun();
                double a = input.InputA();
                double b = input.InputB();
                if(checker.check(a,b, num_fun)){
                    int cnt_answer = checker.checkCntAnswer(a,b,num_fun);
                    if(cnt_answer <= 1){
                        double e = input.InputE();
                        int num_method = input.InputMethod();
                        input.stay();
                        boolean flag_file = input.OutputFlagFile();
                        if(num_method == 1){
                            Chord_Method method = new Chord_Method(a,b,e,num_fun,flag_file);
                            method.start();
                        }else if(num_method == 2){
                            Newton_Method method = new Newton_Method(a,b,e,num_method,flag_file);
                            method.start();
                        }else if(num_method == 3){
                            Simple_Iteration_Method method = new Simple_Iteration_Method(a,b,e,num_fun,flag_file);
                            method.start();
                        }
                    }else{
                        System.out.println("Сейчас в интервале " + cnt_answer + " корней");
                    }
                }else{
                    System.out.println("Извините программа не нашла корней");
                }
            }
        }
    }
}