package lab.Methods;

import lab.Functions.All_fun;
import lab.Outputs.DrawChart;
import lab.Outputs.PrintTable;

import java.io.FileWriter;
import java.io.IOException;

public class Newton_Method {
    boolean flag_file;
    double a;
    double b;
    double e;
    int num_fun;

    All_fun fun = new All_fun();
    PrintTable prT = new PrintTable();
    DrawChart draw = new DrawChart();

    public Newton_Method(double a, double b, double e, int num_fun, boolean flag_file){
        this.a = a;
        this.b = b;
        this.e = e;
        this.num_fun = num_fun;
        this.flag_file = flag_file;
    }

    public void start() throws IOException {

        FileWriter writer = new FileWriter("out.txt", false);

        if(flag_file) {
            writer.write("Запущен метод Ньютона\n"+
                    "Решение уравнения на интервале ["+a+";"+b+"]\nС точностью: " + e+ "\n");
        }else{
            System.out.println("Запущен метод Ньютона\n"+
                    "Решение уравнения на интервале ["+a+";"+b+"]\nС точностью: " + e+ "\n");
        }

        double current_X, last_X, abs;
        int iterations = 0;

        if(fun.f(a,num_fun)*fun.f(b,num_fun) > 0){
            System.out.println("Условие сходимости не выполнено");
        }else{
            last_X = fun.setStartX(a,b,num_fun);

            if(last_X == a){
                System.out.println("Начальным приближением выбран a = " + a);
            }else{
                System.out.println("Начальным приближением выбран b = " + b);
            }

            current_X = fun.newton_step(last_X,num_fun);

            abs = Math.abs(current_X - last_X);

            if(!flag_file)
                prT.printHead3();
            else
                writer.write(prT.printHead3_file());

            while (abs > e ||
                    Math.abs(fun.f(current_X,num_fun)/fun.f_(current_X,num_fun)) > e ||
                    Math.abs(fun.f(current_X,num_fun)) > e){

                if(iterations == 0){
                    if(!flag_file)
                        prT.printLine3(iterations,last_X,fun.f(last_X,num_fun),fun.f_(last_X,num_fun),current_X,0);
                    else
                        writer.write(prT.printLine3_file(iterations,last_X,
                                fun.f(last_X,num_fun),fun.f_(last_X,num_fun),current_X,0));
                }else{
                    if(!flag_file)
                        prT.printLine3(iterations,last_X,fun.f(last_X,num_fun),
                                fun.f_(last_X,num_fun),current_X,abs);
                    else
                        writer.write(prT.printLine3_file(iterations,last_X,
                                fun.f(last_X,num_fun),fun.f_(last_X,num_fun),current_X,abs));
                }

                last_X = current_X;
                current_X = fun.newton_step(last_X,num_fun);
                abs = Math.abs(current_X - last_X);
                iterations++;
            }

            if(!flag_file)
                prT.printLine3(iterations,last_X,fun.f(last_X,num_fun),
                        fun.f_(last_X,num_fun),current_X,abs);
            else
                writer.write(prT.printLine3_file(iterations,last_X,
                        fun.f(last_X,num_fun),fun.f_(last_X,num_fun),current_X,abs));

            if(!flag_file) {
                System.out.println("За " + iterations + " итераций был найден ответ. Точночть ответа " + e);
                System.out.printf("x* = %.13f%n", last_X);
                System.out.printf("f(x*) = %.13f%n", fun.f(last_X,num_fun));
                System.out.println("");
            }else{
                writer.write("За " + iterations + " итераций был найден ответ. Точночть ответа " + e + "\n");
                writer.write(String.format("x* = %.13f%n", last_X));
                writer.write(String.format("f(x*) = %.13f%n", fun.f(last_X,num_fun)));
            }

            writer.flush();
        }
    }
}