package lab.Functions;

public class Parabola_fun {
    public double f(double x){return 5*Math.pow(x,2)+2*x-3;}
    public double f_(double x){return 10*x + 2;}
    public double f__(double x){return 10;}

    public double Fi(double x, double lambda){return x+lambda*f(x);}
    public double Fi_(double x, double lambda){return 1+lambda*f_(x);}

    public double chord_step(double a, double b){return a -  ((b-a)/(f(b) - f(a)))*f(a);}

    public double newton_step(double x){return x - (f(x)/f_(x));}

    public double getMaxf_(double a, double b){return Math.max(f_(a), f_(b));}

    public double setStartX(double a, double b){
        if(f(a)*f__(a) > 0){
            return a;
        }else if(f(b)*f__(b) > 0){
            return b;
        }else{
            return a;
        }
    }
    public double setMaxQ(double a, double b, double lambda){
        return Math.max(Math.abs(Fi_(a,lambda)), Math.abs(Fi_(b,lambda)));
    }
}
