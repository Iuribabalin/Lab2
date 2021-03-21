package lab.Inputs;

import lab.Functions.*;

public class CheckInterval {
    Main_fun main_fun = null;
    Cos_fun cos_fun = null;
    Parabola_fun parabola_fun = null;
    Sin_fun sin_fun = null;

    public boolean check(double a, double b, int num_fun){
        if(num_fun == 1){
            main_fun = new Main_fun();
            for(double i = a; i <= b-0.001; i=i+0.001){
                if(main_fun.f(i) > 0 && main_fun.f(i+0.001) < 0 || main_fun.f(i) < 0 && main_fun.f(i+0.001) > 0){
                    return true;
                }
            }

            return main_fun.f(a) * main_fun.f(b) < 0;

        }else if(num_fun == 2){
            cos_fun = new Cos_fun();

            for(double i = a; i <= b-0.001; i=i+0.001){
                if(cos_fun.f(i) > 0 && cos_fun.f(i+0.001) < 0 ||
                        cos_fun.f(i) < 0 && cos_fun.f(i+0.001) > 0){
                    return true;
                }
            }

            return cos_fun.f(a) * cos_fun.f(b) < 0;

        }else if(num_fun == 3){
            parabola_fun = new Parabola_fun();

            for(double i = a; i <= b-0.001; i=i+0.001){
                if(parabola_fun.f(i) > 0 && parabola_fun.f(i+0.001) < 0 ||
                        parabola_fun.f(i) < 0 && parabola_fun.f(i+0.001) > 0){
                    return true;
                }
            }

            return parabola_fun.f(a) * parabola_fun.f(b) < 0;

        }else if(num_fun == 4){
            sin_fun = new Sin_fun();

            for(double i = a; i <= b-0.001; i=i+0.001){
                if(sin_fun.f(i) > 0 && sin_fun.f(i+0.001) < 0 ||
                        sin_fun.f(i) < 0 && sin_fun.f(i+0.001) > 0){
                    return true;
                }
            }

            return sin_fun.f(a) * sin_fun.f(b) < 0;
        }

        return false;
    }

    public int checkCntAnswer(double a, double b, int num_fun){
        int cnt = 0;
        if(num_fun == 1){
            main_fun = new Main_fun();
            for(double i = a; i <= b-0.001; i=i+0.001){
                if(main_fun.f(i) > 0 && main_fun.f(i+0.001) < 0 ||
                        main_fun.f(i) < 0 && main_fun.f(i+0.001) > 0){
                    cnt++;
                }
            }
        }else if(num_fun == 2){
            cos_fun = new Cos_fun();

            for(double i = a; i <= b-0.001; i=i+0.001){
                if(cos_fun.f(i) > 0 && cos_fun.f(i+0.001) < 0 ||
                        cos_fun.f(i) < 0 && cos_fun.f(i+0.001) > 0){
                    cnt++;
                }
            }
        }else if(num_fun == 3){
            parabola_fun = new Parabola_fun();

            for(double i = a; i <= b-0.001; i=i+0.001){
                if(parabola_fun.f(i) > 0 && parabola_fun.f(i+0.001) < 0 ||
                        parabola_fun.f(i) < 0 && parabola_fun.f(i+0.001) > 0){
                    cnt++;
                }
            }

        }else if(num_fun == 4){
            sin_fun = new Sin_fun();

            for(double i = a; i <= b-0.001; i=i+0.001){
                if(sin_fun.f(i) > 0 && sin_fun.f(i+0.001) < 0 ||
                        sin_fun.f(i) < 0 && sin_fun.f(i+0.001) > 0){
                    cnt++;
                }
            }
        }

        return cnt;
    }
}
