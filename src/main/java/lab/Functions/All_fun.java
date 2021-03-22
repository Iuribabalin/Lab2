package lab.Functions;

public class All_fun {
    public double f(double x, int num_fun){
        if(num_fun == 1)
            return Math.pow(x,3) + 2.84*Math.pow(x,2) - 5.606*x - 14.766;
        else if(num_fun == 2)
            return Math.cos(Math.pow(x,2));
        else if(num_fun == 3)
            return 5*Math.pow(x,2)+2*x-3;
        else
            return Math.sin(x);
    }

    public double f_(double x, int num_fun){
        if(num_fun == 1)
            return 3*Math.pow(x,2) + 5.68*x - 5.606;
        else if(num_fun == 2)
            return -2*x*Math.sin(Math.pow(x,2));
        else if(num_fun == 3)
            return 10*x + 2;
        else
            return Math.cos(x);
    }

    public double f__(double x, int num_fun){
        if(num_fun == 1)
            return 6*x+5.68;
        else if(num_fun == 2)
            return -4*Math.pow(x,2)*Math.cos(Math.pow(x,2))-2*Math.sin(Math.pow(x,2));
        else if(num_fun == 3)
            return 10;
        else
            return -1*Math.sin(x);
    }


    public double Fi(double x, double lambda, int num_fun){return x+lambda*f(x,num_fun);}
    public double Fi_(double x, double lambda, int num_fun){return 1+lambda*f_(x,num_fun);}

    public double chord_step(double a, double b, int num_fun){return a -  ((b-a)/(f(b,num_fun) - f(a,num_fun)))*f(a,num_fun);}

    public double newton_step(double x, int num_fun){return x - (f(x,num_fun)/f_(x,num_fun));}

    public double getMaxf_(double a, double b, int num_fun){return Math.max(f_(a,num_fun), f_(b,num_fun));}

    public double setStartX(double a, double b, int num_fun){
        if(f(a,num_fun)*f__(a,num_fun) > 0){
            return a;
        }else if(f(b,num_fun)*f__(b,num_fun) > 0){
            return b;
        }else{
            return a;
        }
    }
    public double setMaxQ(double a, double b, double lambda, int num_fun){
        return Math.max(Math.abs(Fi_(a,lambda,num_fun)), Math.abs(Fi_(b,lambda,num_fun)));
    }
}
