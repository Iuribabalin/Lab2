package lab.Inputs;

import lab.Functions.All_fun;

public class CheckInterval {
    All_fun fun = new All_fun();

    public boolean check(double a, double b, int num_fun){

        for(double i = a; i <= b-0.001; i=i+0.001){
            if(fun.f(i,num_fun) > 0 && fun.f(i+0.001, num_fun) < 0 ||
                    fun.f(i,num_fun) < 0 && fun.f(i+0.001, num_fun) > 0){
                return true;
            }
        }

        return fun.f(a,num_fun) * fun.f(b,num_fun) < 0;
    }

    public int checkCntAnswer(double a, double b, int num_fun){
        int cnt = 0;

        for(double i = a; i <= b-0.001; i=i+0.001){
            if(fun.f(i,num_fun) > 0 && fun.f(i+0.001,num_fun) < 0 ||
                    fun.f(i,num_fun) < 0 && fun.f(i+0.001,num_fun) > 0){
                cnt++;
            }
        }

        return cnt;
    }
}
