package lab.Methods;

import lab.Functions.*;
import lab.Outputs.DrawChart;
import lab.Outputs.PrintTable;

import java.io.FileWriter;
import java.io.IOException;

public class Simple_Iteration_Method {
    double a;
    double b;
    double e;
    boolean flag_file;
    int num_fun;

    All_fun fun = new All_fun();
    PrintTable prT = new PrintTable();
    DrawChart draw = new DrawChart();

    public Simple_Iteration_Method(double a, double b, double e, int num_fun, boolean flag_file){
        this.a = a;
        this.b = b;
        this.e = e;
        this.num_fun = num_fun;
        this.flag_file = flag_file;
    }


    public void start() throws IOException {
        FileWriter writer = new FileWriter("out.txt", false);

        if(flag_file) {
            writer.write("Запущен метод простых итераций\n"+
                    "Решение уравнения на интервале ["+a+";"+b+"]\nС точностью: " + e+ "\n");
        }else{
            System.out.println("Запущен метод простых итераций\n"+
                    "Решение уравнения на интервале ["+a+";"+b+"]\nС точностью: " + e+ "\n");
        }

        double start_X, last_X,lambda,q, save_e, last_abs, abs;
        save_e = e;
        int iterations = 0;

        lambda = -1/fun.getMaxf_(a,b,num_fun);

        last_X = fun.setStartX(a,b,num_fun);
        start_X = fun.Fi(last_X, lambda,num_fun);

        q = fun.setMaxQ(a,b,lambda,num_fun);
        if (!flag_file) {
            System.out.println("Сходимость в точке a = " + a + " q = " + Math.abs(fun.Fi_(a, lambda,num_fun)));
            System.out.println("Сходимость в точке b = " + b + " q = " + Math.abs(fun.Fi_(b, lambda,num_fun)));
        }else{
            writer.write("Сходимость в точке a = " + a + " q = " + Math.abs(fun.Fi_(a, lambda,num_fun)) + "\n");
            writer.write("Сходимость в точке b = " + b + " q = " + Math.abs(fun.Fi_(b, lambda,num_fun)) + "\n");
        }

        if(q < 1){
            if (q > 0.5 && q < 1){
                e = (1 - q) * e / q;
                if (!flag_file) {
                    System.out.println(" 0.5 < q < 1 Критерий окончания итерационного процесса изменён на" +
                            " |Xn - Xn-1| > (1-q)*e/q ");
                }else{
                    writer.write(" 0.5 < q < 1 Критерий окончания итерационного процесса изменён на" +
                            " |Xn - Xn-1| > (1-q)*e/q\n");
                }
            }else if(q > 0 && q <= 0.5){
                if(!flag_file)
                    System.out.println(" 0 < q <= 0.5 Критерий окончания итерационного процесса" +
                        " |Xn - Xn-1| > e");
                else
                    writer.write(" 0 < q <= 0.5 Критерий окончания итерационного процесса" +
                            " |Xn - Xn-1| > e\n");
            }

            if (!flag_file)
                prT.printHead5();
            else
                writer.write(prT.printHead5_file());

            abs = Math.abs(start_X - last_X);

            while (abs > e) {

                if (!flag_file) {
                    prT.printLine5(iterations, last_X, start_X, fun.Fi(start_X,lambda,num_fun),
                            fun.f(start_X,num_fun), Math.abs(start_X - last_X));
                } else {
                    writer.write(prT.printLine5_file(iterations, last_X, start_X, fun.Fi(start_X,lambda,num_fun),
                            fun.f(start_X,num_fun), Math.abs(start_X - last_X)));
                }

                last_X = start_X;
                start_X = fun.Fi(last_X, lambda,num_fun);
                abs = Math.abs(start_X - last_X);
                iterations++;
            }

            if (!flag_file) {
                prT.printLine5(iterations, last_X, start_X, fun.Fi(start_X,lambda,num_fun),
                        fun.f(start_X,num_fun), Math.abs(start_X - last_X));
            } else {
                writer.write(prT.printLine5_file(iterations, last_X, start_X, fun.Fi(start_X,lambda,num_fun),
                        fun.f(start_X,num_fun), Math.abs(start_X - last_X)));
            }
            if (!flag_file) {
                System.out.println("За " + iterations + " итераций был найден ответ. Точночть ответа " + save_e);
                System.out.printf("x* = %.10f%n", start_X);
                System.out.printf("f(x*) = %.10f%n", fun.f(start_X,num_fun));
                System.out.println("");
            }else{
                writer.write("За " + iterations + " итераций был найден ответ. Точночть ответа " +
                        save_e + "\n");
                writer.write(String.format("x* = %.10f%n", start_X));
                writer.write(String.format("f(x*) = %.10f%n", fun.f(start_X,num_fun)));
            }
        }else{
            if (!flag_file)
                System.out.println("Сходимость превышает 1 q = " + q);
            else
                writer.write("Сходимость превышает 1 q = " + q);
        }

        writer.flush();
        draw.drawForIt_main(Math.round(a), Math.round(b), lambda);
    }
}