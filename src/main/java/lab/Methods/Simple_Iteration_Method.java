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

    Main_fun main_fun = null;
    Cos_fun cos_fun = null;
    Parabola_fun parabola_fun = null;
    Sin_fun sin_fun = null;
    PrintTable prT = new PrintTable();
    DrawChart draw = new DrawChart();

    public Simple_Iteration_Method(double a, double b, double e, int num_fun, boolean flag_file){
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
            writer.write("Запущен метод простых итераций\n"+
                    "Решение уравнения на интервале ["+a+";"+b+"]\nС точностью: " + e+ "\n");
        }else{
            System.out.println("Запущен метод простых итераций\n"+
                    "Решение уравнения на интервале ["+a+";"+b+"]\nС точностью: " + e+ "\n");
        }

        double start_X, last_X,lambda,q, save_e, last_abs, abs;
        save_e = e;
        int iterations = 0;

        lambda = -1/main_fun.getMaxf_(a,b);

        last_X = main_fun.setStartX(a,b);
        start_X = main_fun.Fi(last_X, lambda);

        q = main_fun.setMaxQ(a,b,lambda);
        if (!flag_file) {
            System.out.println("Сходимость в точке a = " + a + " q = " + Math.abs(main_fun.Fi_(a, lambda)));
            System.out.println("Сходимость в точке b = " + b + " q = " + Math.abs(main_fun.Fi_(b, lambda)));
        }else{
            writer.write("Сходимость в точке a = " + a + " q = " + Math.abs(main_fun.Fi_(a, lambda)) + "\n");
            writer.write("Сходимость в точке b = " + b + " q = " + Math.abs(main_fun.Fi_(b, lambda)) + "\n");
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
                    prT.printLine5(iterations, last_X, start_X, main_fun.Fi(start_X,lambda),
                            main_fun.f(start_X), Math.abs(start_X - last_X));
                } else {
                    writer.write(prT.printLine5_file(iterations, last_X, start_X, main_fun.Fi(start_X,lambda),
                            main_fun.f(start_X), Math.abs(start_X - last_X)));
                }

                last_X = start_X;
                start_X = main_fun.Fi(last_X, lambda);
                abs = Math.abs(start_X - last_X);
                iterations++;
            }

            if (!flag_file) {
                prT.printLine5(iterations, last_X, start_X, main_fun.Fi(start_X,lambda),
                        main_fun.f(start_X), Math.abs(start_X - last_X));
            } else {
                writer.write(prT.printLine5_file(iterations, last_X, start_X, main_fun.Fi(start_X,lambda),
                        main_fun.f(start_X), Math.abs(start_X - last_X)));
            }
            if (!flag_file) {
                System.out.println("За " + iterations + " итераций был найден ответ. Точночть ответа " + save_e);
                System.out.printf("x* = %.10f%n", start_X);
                System.out.printf("f(x*) = %.10f%n", main_fun.f(start_X));
                System.out.println("");
            }else{
                writer.write("За " + iterations + " итераций был найден ответ. Точночть ответа " +
                        save_e + "\n");
                writer.write(String.format("x* = %.10f%n", start_X));
                writer.write(String.format("f(x*) = %.10f%n", main_fun.f(start_X)));
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

    private void start_to_cos() throws IOException {
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

        lambda = -1/cos_fun.getMaxf_(a,b);

        last_X = cos_fun.setStartX(a,b);
        start_X = cos_fun.Fi(last_X, lambda);

        q = cos_fun.setMaxQ(a,b,lambda);
        if (!flag_file) {
            System.out.println("Сходимость в точке a = " + a + " q = " + Math.abs(cos_fun.Fi_(a, lambda)));
            System.out.println("Сходимость в точке b = " + b + " q = " + Math.abs(cos_fun.Fi_(b, lambda)));
        }else{
            writer.write("Сходимость в точке a = " + a + " q = " + Math.abs(cos_fun.Fi_(a, lambda)) + "\n");
            writer.write("Сходимость в точке b = " + b + " q = " + Math.abs(cos_fun.Fi_(b, lambda)) + "\n");
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
                    prT.printLine5(iterations, last_X, start_X, cos_fun.Fi(start_X,lambda),
                            cos_fun.f(start_X), Math.abs(start_X - last_X));
                } else {
                    writer.write(prT.printLine5_file(iterations, last_X, start_X, cos_fun.Fi(start_X,lambda),
                            cos_fun.f(start_X), Math.abs(start_X - last_X)));
                }

                last_X = start_X;
                start_X = cos_fun.Fi(last_X, lambda);
                abs = Math.abs(start_X - last_X);
                iterations++;
            }

            if (!flag_file) {
                prT.printLine5(iterations, last_X, start_X, cos_fun.Fi(start_X,lambda),
                        cos_fun.f(start_X), Math.abs(start_X - last_X));
            } else {
                writer.write(prT.printLine5_file(iterations, last_X, start_X, cos_fun.Fi(start_X,lambda),
                        cos_fun.f(start_X), Math.abs(start_X - last_X)));
            }
            if (!flag_file) {
                System.out.println("За " + iterations + " итераций был найден ответ. Точночть ответа " + save_e);
                System.out.printf("x* = %.10f%n", start_X);
                System.out.printf("f(x*) = %.10f%n", cos_fun.f(start_X));
                System.out.println("");
            }else{
                writer.write("За " + iterations + " итераций был найден ответ. Точночть ответа " +
                        save_e + "\n");
                writer.write(String.format("x* = %.10f%n", start_X));
                writer.write(String.format("f(x*) = %.10f%n", cos_fun.f(start_X)));
            }
        }else{
            if (!flag_file)
                System.out.println("Сходимость превышает 1 q = " + q);
            else
                writer.write("Сходимость превышает 1 q = " + q);
        }

        writer.flush();
        draw.drawForIt_cos(Math.round(a), Math.round(b), lambda);
    }

    private void start_to_parabola() throws IOException {
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

        lambda = -1/parabola_fun.getMaxf_(a,b);

        last_X = parabola_fun.setStartX(a,b);
        start_X = parabola_fun.Fi(last_X, lambda);

        q = parabola_fun.setMaxQ(a,b,lambda);
        if (!flag_file) {
            System.out.println("Сходимость в точке a = " + a + " q = " + Math.abs(parabola_fun.Fi_(a, lambda)));
            System.out.println("Сходимость в точке b = " + b + " q = " + Math.abs(parabola_fun.Fi_(b, lambda)));
        }else{
            writer.write("Сходимость в точке a = " + a + " q = " + Math.abs(parabola_fun.Fi_(a, lambda)) + "\n");
            writer.write("Сходимость в точке b = " + b + " q = " + Math.abs(parabola_fun.Fi_(b, lambda)) + "\n");
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
                    prT.printLine5(iterations, last_X, start_X, parabola_fun.Fi(start_X,lambda),
                            parabola_fun.f(start_X), Math.abs(start_X - last_X));
                } else {
                    writer.write(prT.printLine5_file(iterations, last_X, start_X, parabola_fun.Fi(start_X,lambda),
                            parabola_fun.f(start_X), Math.abs(start_X - last_X)));
                }

                last_X = start_X;
                start_X = parabola_fun.Fi(last_X, lambda);
                abs = Math.abs(start_X - last_X);
                iterations++;
            }

            if (!flag_file) {
                prT.printLine5(iterations, last_X, start_X, parabola_fun.Fi(start_X,lambda),
                        parabola_fun.f(start_X), Math.abs(start_X - last_X));
            } else {
                writer.write(prT.printLine5_file(iterations, last_X, start_X, parabola_fun.Fi(start_X,lambda),
                        parabola_fun.f(start_X), Math.abs(start_X - last_X)));
            }
            if (!flag_file) {
                System.out.println("За " + iterations + " итераций был найден ответ. Точночть ответа " + save_e);
                System.out.printf("x* = %.10f%n", start_X);
                System.out.printf("f(x*) = %.10f%n", parabola_fun.f(start_X));
                System.out.println("");
            }else{
                writer.write("За " + iterations + " итераций был найден ответ. Точночть ответа " +
                        save_e + "\n");
                writer.write(String.format("x* = %.10f%n", start_X));
                writer.write(String.format("f(x*) = %.10f%n", parabola_fun.f(start_X)));
            }
        }else{
            if (!flag_file)
                System.out.println("Сходимость превышает 1 q = " + q);
            else
                writer.write("Сходимость превышает 1 q = " + q);
        }

        writer.flush();
        draw.drawForIt_parabola(Math.round(a), Math.round(b), lambda);
    }

    private void start_to_sin() throws IOException {
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

        lambda = -1/sin_fun.getMaxf_(a,b);

        last_X = sin_fun.setStartX(a,b);
        start_X = sin_fun.Fi(last_X, lambda);

        q = sin_fun.setMaxQ(a,b,lambda);
        if (!flag_file) {
            System.out.println("Сходимость в точке a = " + a + " q = " + Math.abs(sin_fun.Fi_(a, lambda)));
            System.out.println("Сходимость в точке b = " + b + " q = " + Math.abs(sin_fun.Fi_(b, lambda)));
        }else{
            writer.write("Сходимость в точке a = " + a + " q = " + Math.abs(sin_fun.Fi_(a, lambda)) + "\n");
            writer.write("Сходимость в точке b = " + b + " q = " + Math.abs(sin_fun.Fi_(b, lambda)) + "\n");
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
                    prT.printLine5(iterations, last_X, start_X, sin_fun.Fi(start_X,lambda),
                            sin_fun.f(start_X), Math.abs(start_X - last_X));
                } else {
                    writer.write(prT.printLine5_file(iterations, last_X, start_X, sin_fun.Fi(start_X,lambda),
                            sin_fun.f(start_X), Math.abs(start_X - last_X)));
                }

                last_X = start_X;
                start_X = sin_fun.Fi(last_X, lambda);
                abs = Math.abs(start_X - last_X);
                iterations++;
            }

            if (!flag_file) {
                prT.printLine5(iterations, last_X, start_X, sin_fun.Fi(start_X,lambda),
                        sin_fun.f(start_X), Math.abs(start_X - last_X));
            } else {
                writer.write(prT.printLine5_file(iterations, last_X, start_X, sin_fun.Fi(start_X,lambda),
                        sin_fun.f(start_X), Math.abs(start_X - last_X)));
            }
            if (!flag_file) {
                System.out.println("За " + iterations + " итераций был найден ответ. Точночть ответа " + save_e);
                System.out.printf("x* = %.10f%n", start_X);
                System.out.printf("f(x*) = %.10f%n", sin_fun.f(start_X));
                System.out.println("");
            }else{
                writer.write("За " + iterations + " итераций был найден ответ. Точночть ответа " +
                        save_e + "\n");
                writer.write(String.format("x* = %.10f%n", start_X));
                writer.write(String.format("f(x*) = %.10f%n", sin_fun.f(start_X)));
            }
        }else{
            if (!flag_file)
                System.out.println("Сходимость превышает 1 q = " + q);
            else
                writer.write("Сходимость превышает 1 q = " + q);
        }

        writer.flush();
        draw.drawForIt_sin(Math.round(a), Math.round(b), lambda);
    }
}
