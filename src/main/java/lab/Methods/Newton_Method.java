package lab.Methods;

import lab.Functions.Cos_fun;
import lab.Functions.Main_fun;
import lab.Functions.Parabola_fun;
import lab.Functions.Sin_fun;
import lab.Outputs.DrawChart;
import lab.Outputs.PrintTable;

import java.io.FileWriter;
import java.io.IOException;

public class Newton_Method {
    boolean flag_file;
    double a;
    double b;
    double e;

    Main_fun main_fun = null;
    Cos_fun cos_fun = null;
    Parabola_fun parabola_fun = null;
    Sin_fun sin_fun = null;
    PrintTable prT = new PrintTable();
    DrawChart draw = new DrawChart();

    public Newton_Method(double a, double b, double e, int num_fun, boolean flag_file){
        this.a = a;
        this.b = b;
        this.e = e;
        if(num_fun == 1){
            main_fun = new Main_fun();
        }else if (num_fun == 2) {
            cos_fun = new Cos_fun();
        }else if (num_fun == 3) {
            parabola_fun = new Parabola_fun();
        }else if (num_fun == 4) {
            sin_fun = new Sin_fun();
        }
        this.flag_file = flag_file;
    }


    public void start() throws IOException {
        if(main_fun != null){
            start_to_main();
        }else if(cos_fun != null){
            start_to_cos();
        }else if(parabola_fun != null){
            start_to_parabola();
        }else if(sin_fun != null){
            start_to_sin();
        }
    }

    private void start_to_main() throws IOException {

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

        if(main_fun.f(a)*main_fun.f(b) > 0){
            System.out.println("Условие сходимости не выполнено");
        }else{
            last_X = main_fun.setStartX(a,b);

            current_X = main_fun.newton_step(last_X);

            abs = Math.abs(current_X - last_X);

            if(!flag_file)
                prT.printHead3();
            else
                writer.write(prT.printHead3_file());

            while (abs > e ||
                    Math.abs(main_fun.f(current_X)/main_fun.f_(current_X)) > e ||
                    Math.abs(main_fun.f(current_X)) > e){

                if(iterations == 0){
                    if(!flag_file)
                        prT.printLine3(iterations,last_X,main_fun.f(last_X),main_fun.f_(last_X),current_X,0);
                    else
                        writer.write(prT.printLine3_file(iterations,last_X,
                                main_fun.f(last_X),main_fun.f_(last_X),current_X,0));
                }else{
                    if(!flag_file)
                        prT.printLine3(iterations,last_X,main_fun.f(last_X),
                                main_fun.f_(last_X),current_X,abs);
                    else
                        writer.write(prT.printLine3_file(iterations,last_X,
                                main_fun.f(last_X),main_fun.f_(last_X),current_X,abs));
                }

                last_X = current_X;
                current_X = main_fun.newton_step(last_X);
                abs = Math.abs(current_X - last_X);
                iterations++;
            }

            if(!flag_file)
                prT.printLine3(iterations,last_X,main_fun.f(last_X),
                        main_fun.f_(last_X),current_X,abs);
            else
                writer.write(prT.printLine3_file(iterations,last_X,
                        main_fun.f(last_X),main_fun.f_(last_X),current_X,abs));

            if(!flag_file) {
                System.out.println("За " + iterations + " итераций был найден ответ. Точночть ответа " + e);
                System.out.printf("x* = %.13f%n", last_X);
                System.out.printf("f(x*) = %.13f%n", main_fun.f(last_X));
                System.out.println("");
            }else{
                writer.write("За " + iterations + " итераций был найден ответ. Точночть ответа " + e + "\n");
                writer.write(String.format("x* = %.13f%n", last_X));
                writer.write(String.format("f(x*) = %.13f%n", main_fun.f(last_X)));
            }

            writer.flush();
            draw.draw_main(Math.round(a), Math.round(b));
        }
    }

    private void start_to_cos() throws IOException {
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

        if(cos_fun.f(a)*cos_fun.f(b) > 0){
            System.out.println("Условие сходимости не выполнено");
        }else{
            last_X = cos_fun.setStartX(a,b);

            current_X = cos_fun.newton_step(last_X);

            abs = Math.abs(current_X - last_X);

            if(!flag_file)
                prT.printHead3();
            else
                writer.write(prT.printHead3_file());

            while (abs > e ||
                    Math.abs(cos_fun.f(current_X)/cos_fun.f_(current_X)) > e ||
                    Math.abs(cos_fun.f(current_X)) > e){

                if(iterations == 0){
                    if(!flag_file)
                        prT.printLine3(iterations,last_X,cos_fun.f(last_X),cos_fun.f_(last_X),current_X,0);
                    else
                        writer.write(prT.printLine3_file(iterations,last_X,
                                cos_fun.f(last_X),cos_fun.f_(last_X),current_X,0));
                }else{
                    if(!flag_file)
                        prT.printLine3(iterations,last_X,cos_fun.f(last_X),
                                cos_fun.f_(last_X),current_X,abs);
                    else
                        writer.write(prT.printLine3_file(iterations,last_X,
                                cos_fun.f(last_X),cos_fun.f_(last_X),current_X,abs));
                }

                last_X = current_X;
                current_X = cos_fun.newton_step(last_X);
                abs = Math.abs(current_X - last_X);
                iterations++;
            }

            if(!flag_file)
                prT.printLine3(iterations,last_X,cos_fun.f(last_X),
                        cos_fun.f_(last_X),current_X,abs);
            else
                writer.write(prT.printLine3_file(iterations,last_X,
                        cos_fun.f(last_X),cos_fun.f_(last_X),current_X,abs));

            if(!flag_file) {
                System.out.println("За " + iterations + " итераций был найден ответ. Точночть ответа " + e);
                System.out.printf("x* = %.13f%n", last_X);
                System.out.printf("f(x*) = %.13f%n", cos_fun.f(last_X));
                System.out.println("");
            }else{
                writer.write("За " + iterations + " итераций был найден ответ. Точночть ответа " + e + "\n");
                writer.write(String.format("x* = %.13f%n", last_X));
                writer.write(String.format("f(x*) = %.13f%n", cos_fun.f(last_X)));
            }

            writer.flush();
            draw.draw_cos(Math.round(a), Math.round(b));
        }
    }

    private void start_to_parabola() throws IOException {
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

        if(parabola_fun.f(a)*parabola_fun.f(b) > 0){
            System.out.println("Условие сходимости не выполнено");
        }else{
            last_X = parabola_fun.setStartX(a,b);

            current_X = parabola_fun.newton_step(last_X);

            abs = Math.abs(current_X - last_X);

            if(!flag_file)
                prT.printHead3();
            else
                writer.write(prT.printHead3_file());

            while (abs > e ||
                    Math.abs(parabola_fun.f(current_X)/parabola_fun.f_(current_X)) > e ||
                    Math.abs(parabola_fun.f(current_X)) > e){

                if(iterations == 0){
                    if(!flag_file)
                        prT.printLine3(iterations,last_X,parabola_fun.f(last_X),parabola_fun.f_(last_X),current_X,0);
                    else
                        writer.write(prT.printLine3_file(iterations,last_X,
                                parabola_fun.f(last_X),parabola_fun.f_(last_X),current_X,0));
                }else{
                    if(!flag_file)
                        prT.printLine3(iterations,last_X,parabola_fun.f(last_X),
                                parabola_fun.f_(last_X),current_X,abs);
                    else
                        writer.write(prT.printLine3_file(iterations,last_X,
                                parabola_fun.f(last_X),parabola_fun.f_(last_X),current_X,abs));
                }

                last_X = current_X;
                current_X = parabola_fun.newton_step(last_X);
                abs = Math.abs(current_X - last_X);
                iterations++;
            }

            if(!flag_file)
                prT.printLine3(iterations,last_X,parabola_fun.f(last_X),
                        parabola_fun.f_(last_X),current_X,abs);
            else
                writer.write(prT.printLine3_file(iterations,last_X,
                        parabola_fun.f(last_X),parabola_fun.f_(last_X),current_X,abs));

            if(!flag_file) {
                System.out.println("За " + iterations + " итераций был найден ответ. Точночть ответа " + e);
                System.out.printf("x* = %.13f%n", last_X);
                System.out.printf("f(x*) = %.13f%n", parabola_fun.f(last_X));
                System.out.println("");
            }else{
                writer.write("За " + iterations + " итераций был найден ответ. Точночть ответа " + e + "\n");
                writer.write(String.format("x* = %.13f%n", last_X));
                writer.write(String.format("f(x*) = %.13f%n", parabola_fun.f(last_X)));
            }

            writer.flush();
            draw.draw_parabola(Math.round(a), Math.round(b));
        }
    }

    private void start_to_sin() throws IOException {
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

        if(sin_fun.f(a)*sin_fun.f(b) > 0){
            System.out.println("Условие сходимости не выполнено");
        }else{
            last_X = sin_fun.setStartX(a,b);

            current_X = sin_fun.newton_step(last_X);

            abs = Math.abs(current_X - last_X);

            if(!flag_file)
                prT.printHead3();
            else
                writer.write(prT.printHead3_file());

            while (abs > e ||
                    Math.abs(sin_fun.f(current_X)/sin_fun.f_(current_X)) > e ||
                    Math.abs(sin_fun.f(current_X)) > e){

                if(iterations == 0){
                    if(!flag_file)
                        prT.printLine3(iterations,last_X,sin_fun.f(last_X),sin_fun.f_(last_X),current_X,0);
                    else
                        writer.write(prT.printLine3_file(iterations,last_X,
                                sin_fun.f(last_X),sin_fun.f_(last_X),current_X,0));
                }else{
                    if(!flag_file)
                        prT.printLine3(iterations,last_X,sin_fun.f(last_X),
                                sin_fun.f_(last_X),current_X,abs);
                    else
                        writer.write(prT.printLine3_file(iterations,last_X,
                                sin_fun.f(last_X),sin_fun.f_(last_X),current_X,abs));
                }

                last_X = current_X;
                current_X = sin_fun.newton_step(last_X);
                abs = Math.abs(current_X - last_X);
                iterations++;
            }

            if(!flag_file)
                prT.printLine3(iterations,last_X,sin_fun.f(last_X),
                        sin_fun.f_(last_X),current_X,abs);
            else
                writer.write(prT.printLine3_file(iterations,last_X,
                        sin_fun.f(last_X),sin_fun.f_(last_X),current_X,abs));

            if(!flag_file) {
                System.out.println("За " + iterations + " итераций был найден ответ. Точночть ответа " + e);
                System.out.printf("x* = %.13f%n", last_X);
                System.out.printf("f(x*) = %.13f%n", sin_fun.f(last_X));
                System.out.println("");
            }else{
                writer.write("За " + iterations + " итераций был найден ответ. Точночть ответа " + e + "\n");
                writer.write(String.format("x* = %.13f%n", last_X));
                writer.write(String.format("f(x*) = %.13f%n", sin_fun.f(last_X)));
            }

            writer.flush();
            draw.draw_main(Math.round(a), Math.round(b));
        }
    }

}
