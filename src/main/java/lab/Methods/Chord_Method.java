package lab.Methods;

import lab.Functions.Cos_fun;
import lab.Functions.Main_fun;
import lab.Functions.Parabola_fun;
import lab.Functions.Sin_fun;
import lab.Outputs.DrawChart;
import lab.Outputs.PrintTable;

import java.io.FileWriter;
import java.io.IOException;

public class Chord_Method {
    double a;
    double b;
    double e;
    boolean flag_file;

    Main_fun main_fun = null;
    Cos_fun cos_fun = null;
    Parabola_fun parabola_fun = null;
    Sin_fun sin_fun = null;
    PrintTable prT = new PrintTable();
    DrawChart draw = new DrawChart();

    public Chord_Method(double a, double b, double e, int num_fun, boolean flag_file){
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
            writer.write("Запущен метод хорд\n" +
                    "Решение уравнения на интервале [" + a + ";" + b + "]\nС точностью: " + e + "\n");
        }else{
            System.out.println("Запущен метод хорд\n" +
                    "Решение уравнения на интервале [" + a + ";" + b + "]\nС точностью: " + e + "\n");
        }

        double start_X,end_X,current_X, last_X, abs;
        last_X = 0;

        start_X = main_fun.setStartX(a,b);

        if(start_X == a)
            end_X = b;
        else
            end_X = a;

        current_X = main_fun.chord_step(start_X,end_X);
        abs = Math.abs(current_X - last_X);

        int iterations = 0;

        if(!flag_file)
            prT.printHead2();
        else
            writer.write(prT.printHead2_File());

        while (main_fun.f(current_X) > e || abs > e){
            if(iterations == 0){
                if(!flag_file)
                    prT.printLine2(iterations,start_X,end_X,current_X,main_fun.f(start_X),
                            main_fun.f(end_X),main_fun.f(current_X),0);
                else
                    writer.write(prT.printLine2_File(iterations,start_X,end_X,current_X,main_fun.f(start_X),
                            main_fun.f(end_X),main_fun.f(current_X),0));
            }else{
                if(!flag_file)
                    prT.printLine2(iterations,start_X,end_X,current_X,main_fun.f(start_X),
                            main_fun.f(end_X),main_fun.f(current_X),abs);
                else
                    writer.write(prT.printLine2_File(iterations,start_X,end_X,current_X,main_fun.f(start_X),
                            main_fun.f(end_X),main_fun.f(current_X),abs));
            }

            if (main_fun.f(start_X) > 0 && main_fun.f(current_X) < 0 ||
                    main_fun.f(start_X) < 0 &&main_fun.f(current_X) > 0) {
                end_X = current_X;
            }else if (main_fun.f(end_X) > 0 && main_fun.f(current_X) < 0 ||
                    main_fun.f(end_X) < 0 && main_fun.f(current_X) > 0) {
                start_X = current_X;
            }
            last_X = current_X;
            current_X = main_fun.chord_step(start_X,end_X);
            abs = Math.abs(current_X - last_X);
            iterations++;
        }

        if(!flag_file)
            prT.printLine2(iterations,start_X,end_X,current_X,main_fun.f(start_X),
                    main_fun.f(end_X),main_fun.f(current_X),abs);
        else
            writer.write(prT.printLine2_File(iterations,start_X,end_X,current_X,main_fun.f(start_X),
                    main_fun.f(end_X),main_fun.f(current_X),abs));

        if(!flag_file) {
            System.out.println("За " + iterations + " итераций был найден ответ. Точночть ответа " + e);
            System.out.printf("x* = %.13f%n", current_X);
            System.out.printf("f(x*) = %.13f%n", main_fun.f(current_X));
            System.out.println("");
        }else{
            writer.write("За " + iterations + " итераций был найден ответ. Точночть ответа " + e + "\n");
            writer.write(String.format("x* = %.13f%n", current_X));
            writer.write(String.format("f(x*) = %.13f%n", main_fun.f(current_X)));
        }
        writer.flush();
        draw.draw_main(Math.round(a), Math.round(b));
    }

    private void start_to_cos() throws IOException {
        FileWriter writer = new FileWriter("out.txt", false);

        if(flag_file) {
            writer.write("Запущен метод хорд\n" +
                    "Решение уравнения на интервале [" + a + ";" + b + "]\nС точностью: " + e + "\n");
        }else{
            System.out.println("Запущен метод хорд\n" +
                    "Решение уравнения на интервале [" + a + ";" + b + "]\nС точностью: " + e + "\n");
        }

        double start_X,end_X,current_X, last_X, abs;
        last_X = 0;

        start_X = cos_fun.setStartX(a,b);

        if(start_X == a)
            end_X = b;
        else
            end_X = a;

        current_X = cos_fun.chord_step(start_X,end_X);
        abs = Math.abs(current_X - last_X);

        int iterations = 0;

        if(!flag_file)
            prT.printHead2();
        else
            writer.write(prT.printHead2_File());

        while (cos_fun.f(current_X) > e || abs > e){
            if(iterations == 0){
                if(!flag_file)
                    prT.printLine2(iterations,start_X,end_X,current_X,cos_fun.f(start_X),
                            cos_fun.f(end_X),cos_fun.f(current_X),0);
                else
                    writer.write(prT.printLine2_File(iterations,start_X,end_X,current_X,cos_fun.f(start_X),
                            cos_fun.f(end_X),cos_fun.f(current_X),0));
            }else{
                if(!flag_file)
                    prT.printLine2(iterations,start_X,end_X,current_X,cos_fun.f(start_X),
                            cos_fun.f(end_X),cos_fun.f(current_X),abs);
                else
                    writer.write(prT.printLine2_File(iterations,start_X,end_X,current_X,cos_fun.f(start_X),
                            cos_fun.f(end_X),cos_fun.f(current_X),abs));
            }

            if (cos_fun.f(start_X) > 0 && cos_fun.f(current_X) < 0 ||
                    cos_fun.f(start_X) < 0 &&cos_fun.f(current_X) > 0) {
                end_X = current_X;
            }else if (cos_fun.f(end_X) > 0 && cos_fun.f(current_X) < 0 ||
                    cos_fun.f(end_X) < 0 && cos_fun.f(current_X) > 0) {
                start_X = current_X;
            }
            last_X = current_X;
            current_X = cos_fun.chord_step(start_X,end_X);
            abs = Math.abs(current_X - last_X);
            iterations++;
        }

        if(!flag_file)
            prT.printLine2(iterations,start_X,end_X,current_X,cos_fun.f(start_X),
                    cos_fun.f(end_X),cos_fun.f(current_X),abs);
        else
            writer.write(prT.printLine2_File(iterations,start_X,end_X,current_X,cos_fun.f(start_X),
                    cos_fun.f(end_X),cos_fun.f(current_X),abs));

        if(!flag_file) {
            System.out.println("За " + iterations + " итераций был найден ответ. Точночть ответа " + e);
            System.out.printf("x* = %.13f%n", current_X);
            System.out.printf("f(x*) = %.13f%n", cos_fun.f(current_X));
            System.out.println("");
        }else{
            writer.write("За " + iterations + " итераций был найден ответ. Точночть ответа " + e + "\n");
            writer.write(String.format("x* = %.13f%n", current_X));
            writer.write(String.format("f(x*) = %.13f%n", cos_fun.f(current_X)));
        }
        writer.flush();
        draw.draw_cos(Math.round(a), Math.round(b));
    }

    private void start_to_parabola() throws IOException{
        FileWriter writer = new FileWriter("out.txt", false);

        if(flag_file) {
            writer.write("Запущен метод хорд\n" +
                    "Решение уравнения на интервале [" + a + ";" + b + "]\nС точностью: " + e + "\n");
        }else{
            System.out.println("Запущен метод хорд\n" +
                    "Решение уравнения на интервале [" + a + ";" + b + "]\nС точностью: " + e + "\n");
        }

        double start_X,end_X,current_X, last_X, abs;
        last_X = 0;

        start_X = parabola_fun.setStartX(a,b);

        if(start_X == a)
            end_X = b;
        else
            end_X = a;

        current_X = parabola_fun.chord_step(start_X,end_X);
        abs = Math.abs(current_X - last_X);

        int iterations = 0;

        if(!flag_file)
            prT.printHead2();
        else
            writer.write(prT.printHead2_File());

        while (parabola_fun.f(current_X) > e || abs > e){
            if(iterations == 0){
                if(!flag_file)
                    prT.printLine2(iterations,start_X,end_X,current_X,parabola_fun.f(start_X),
                            parabola_fun.f(end_X),parabola_fun.f(current_X),0);
                else
                    writer.write(prT.printLine2_File(iterations,start_X,end_X,current_X,parabola_fun.f(start_X),
                            parabola_fun.f(end_X),parabola_fun.f(current_X),0));
            }else{
                if(!flag_file)
                    prT.printLine2(iterations,start_X,end_X,current_X,parabola_fun.f(start_X),
                            parabola_fun.f(end_X),parabola_fun.f(current_X),abs);
                else
                    writer.write(prT.printLine2_File(iterations,start_X,end_X,current_X,parabola_fun.f(start_X),
                            parabola_fun.f(end_X),parabola_fun.f(current_X),abs));
            }

            if (parabola_fun.f(start_X) > 0 && parabola_fun.f(current_X) < 0 ||
                    parabola_fun.f(start_X) < 0 &&parabola_fun.f(current_X) > 0) {
                end_X = current_X;
            }else if (parabola_fun.f(end_X) > 0 && parabola_fun.f(current_X) < 0 ||
                    parabola_fun.f(end_X) < 0 && parabola_fun.f(current_X) > 0) {
                start_X = current_X;
            }
            last_X = current_X;
            current_X = parabola_fun.chord_step(start_X,end_X);
            abs = Math.abs(current_X - last_X);
            iterations++;
        }

        if(!flag_file)
            prT.printLine2(iterations,start_X,end_X,current_X,parabola_fun.f(start_X),
                    parabola_fun.f(end_X),parabola_fun.f(current_X),abs);
        else
            writer.write(prT.printLine2_File(iterations,start_X,end_X,current_X,parabola_fun.f(start_X),
                    parabola_fun.f(end_X),parabola_fun.f(current_X),abs));

        if(!flag_file) {
            System.out.println("За " + iterations + " итераций был найден ответ. Точночть ответа " + e);
            System.out.printf("x* = %.13f%n", current_X);
            System.out.printf("f(x*) = %.13f%n", parabola_fun.f(current_X));
            System.out.println("");
        }else{
            writer.write("За " + iterations + " итераций был найден ответ. Точночть ответа " + e + "\n");
            writer.write(String.format("x* = %.13f%n", current_X));
            writer.write(String.format("f(x*) = %.13f%n", parabola_fun.f(current_X)));
        }
        writer.flush();
        draw.draw_parabola(Math.round(a), Math.round(b));
    }

    private void start_to_sin() throws IOException{
        FileWriter writer = new FileWriter("out.txt", false);

        if(flag_file) {
            writer.write("Запущен метод хорд\n" +
                    "Решение уравнения на интервале [" + a + ";" + b + "]\nС точностью: " + e + "\n");
        }else{
            System.out.println("Запущен метод хорд\n" +
                    "Решение уравнения на интервале [" + a + ";" + b + "]\nС точностью: " + e + "\n");
        }

        double start_X,end_X,current_X, last_X, abs;
        last_X = 0;

        start_X = sin_fun.setStartX(a,b);

        if(start_X == a)
            end_X = b;
        else
            end_X = a;

        current_X = sin_fun.chord_step(start_X,end_X);
        abs = Math.abs(current_X - last_X);

        int iterations = 0;

        if(!flag_file)
            prT.printHead2();
        else
            writer.write(prT.printHead2_File());

        while (sin_fun.f(current_X) > e || abs > e){
            if(iterations == 0){
                if(!flag_file)
                    prT.printLine2(iterations,start_X,end_X,current_X,sin_fun.f(start_X),
                            sin_fun.f(end_X),sin_fun.f(current_X),0);
                else
                    writer.write(prT.printLine2_File(iterations,start_X,end_X,current_X,sin_fun.f(start_X),
                            sin_fun.f(end_X),sin_fun.f(current_X),0));
            }else{
                if(!flag_file)
                    prT.printLine2(iterations,start_X,end_X,current_X,sin_fun.f(start_X),
                            sin_fun.f(end_X),sin_fun.f(current_X),abs);
                else
                    writer.write(prT.printLine2_File(iterations,start_X,end_X,current_X,sin_fun.f(start_X),
                            sin_fun.f(end_X),sin_fun.f(current_X),abs));
            }

            if (sin_fun.f(start_X) > 0 && sin_fun.f(current_X) < 0 ||
                    sin_fun.f(start_X) < 0 &&sin_fun.f(current_X) > 0) {
                end_X = current_X;
            }else if (sin_fun.f(end_X) > 0 && sin_fun.f(current_X) < 0 ||
                    sin_fun.f(end_X) < 0 && sin_fun.f(current_X) > 0) {
                start_X = current_X;
            }
            last_X = current_X;
            current_X = sin_fun.chord_step(start_X,end_X);
            abs = Math.abs(current_X - last_X);
            iterations++;
        }

        if(!flag_file)
            prT.printLine2(iterations,start_X,end_X,current_X,sin_fun.f(start_X),
                    sin_fun.f(end_X),sin_fun.f(current_X),abs);
        else
            writer.write(prT.printLine2_File(iterations,start_X,end_X,current_X,sin_fun.f(start_X),
                    sin_fun.f(end_X),sin_fun.f(current_X),abs));

        if(!flag_file) {
            System.out.println("За " + iterations + " итераций был найден ответ. Точночть ответа " + e);
            System.out.printf("x* = %.13f%n", current_X);
            System.out.printf("f(x*) = %.13f%n", sin_fun.f(current_X));
            System.out.println("");
        }else{
            writer.write("За " + iterations + " итераций был найден ответ. Точночть ответа " + e + "\n");
            writer.write(String.format("x* = %.13f%n", current_X));
            writer.write(String.format("f(x*) = %.13f%n", sin_fun.f(current_X)));
        }
        writer.flush();
        draw.draw_sin(Math.round(a), Math.round(b));
    }
}
