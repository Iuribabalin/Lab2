package lab.Methods;

import lab.Functions.*;
import lab.Outputs.DrawChart;
import lab.Outputs.PrintTable;

import java.io.FileWriter;
import java.io.IOException;

public class Chord_Method {
    double a;
    double b;
    double e;
    boolean flag_file;
    int num_fun;

    All_fun fun = new All_fun();
    PrintTable prT = new PrintTable();
    DrawChart draw = new DrawChart();

    public Chord_Method(double a, double b, double e, int num_fun, boolean flag_file){
        this.a = a;
        this.b = b;
        this.e = e;
        this.num_fun = num_fun;
        this.flag_file = flag_file;
    }

    public void start() throws IOException {
        FileWriter writer = new FileWriter("out.txt", false);

        if(flag_file) {
            writer.write("Запущен метод хорд\n" +
                    "Решение уравнения на интервале [" + a + ";" + b + "]\nС точностью: " + e + "\n");
        }else{
            System.out.println("Запущен метод хорд\n" +
                    "Решение уравнения на интервале [" + a + ";" + b + "]\nС точностью: " + e + "\n");
        }

        double start_X,end_X,current_X, last_X, abs;
        boolean flag_a = false;
        last_X = 0;

        start_X = fun.setStartX(a,b,num_fun);

        if(start_X == a){
            System.out.println("a = " + start_X);
            System.out.println("f(a) = " + fun.f(a,num_fun));
            System.out.println("f__(a) = " + fun.f__(a,num_fun));
            System.out.println("\nВыбрано занчение a\n");
            System.out.println("f(b) = " + fun.f(b,num_fun));
            System.out.println("f__(b) = " + fun.f__(b,num_fun));
        }else{
            flag_a = true;
            System.out.println("b = " + start_X);
            System.out.println("f(b) = " + fun.f(b,num_fun));
            System.out.println("f__(b) = " + fun.f__(b,num_fun));
            System.out.println("\nВыбрано занчение b\n");
            System.out.println("f(a) = " + fun.f(a,num_fun));
            System.out.println("f__(a) = " + fun.f__(a,num_fun));
        }

        if(start_X == a)
            end_X = b;
        else
            end_X = a;

        current_X = fun.chord_step(start_X,end_X,num_fun);
        abs = Math.abs(current_X - last_X);

        int iterations = 0;

        if(!flag_file)
            prT.printHead2();
        else
            writer.write(prT.printHead2_File());

        while (true){
            if(iterations == 0){
                if(!flag_file)
                    prT.printLine2(iterations,start_X,end_X,current_X,fun.f(start_X,num_fun),
                            fun.f(end_X,num_fun),fun.f(current_X,num_fun),0);
                else
                    writer.write(prT.printLine2_File(iterations,start_X,end_X,current_X,fun.f(start_X,num_fun),
                            fun.f(end_X,num_fun),fun.f(current_X,num_fun),0));
            }else{
                if(!flag_file)
                    prT.printLine2(iterations,start_X,end_X,current_X,fun.f(start_X,num_fun),
                            fun.f(end_X,num_fun),fun.f(current_X,num_fun),abs);
                else
                    writer.write(prT.printLine2_File(iterations,start_X,end_X,current_X,fun.f(start_X,num_fun),
                            fun.f(end_X,num_fun),fun.f(current_X,num_fun),abs));
            }

            if (flag_a) {
                end_X = current_X;
            }else{
                start_X = current_X;
            }

            last_X = current_X;

            current_X = fun.chord_step(start_X,end_X,num_fun);

            abs = Math.abs(current_X - last_X);
            iterations++;


           if(abs < e && Math.abs(fun.f(current_X,num_fun)) < e){
                break;
           }

        }

        if(!flag_file)
            prT.printLine2(iterations,start_X,end_X,current_X,fun.f(start_X,num_fun),
                    fun.f(end_X,num_fun),fun.f(current_X,num_fun),abs);
        else
            writer.write(prT.printLine2_File(iterations,start_X,end_X,current_X,fun.f(start_X,num_fun),
                    fun.f(end_X,num_fun),fun.f(current_X,num_fun),abs));

        if(!flag_file) {
            System.out.println("За " + iterations + " итераций был найден ответ. Точночть ответа " + e);
            System.out.println(abs);
            System.out.printf("x* = %.13f%n", current_X);
            System.out.printf("f(x*) = %.13f%n", fun.f(current_X,num_fun));
            System.out.println("");
        }else{
            writer.write("За " + iterations + " итераций был найден ответ. Точночть ответа " + e + "\n");
            writer.write(String.format("x* = %.13f%n", current_X));
            writer.write(String.format("f(x*) = %.13f%n", fun.f(current_X,num_fun)));
        }
        writer.flush();
    }

}