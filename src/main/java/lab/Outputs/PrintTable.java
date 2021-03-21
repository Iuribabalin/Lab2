package lab.Outputs;

public class PrintTable {
    public void printHead2(){
        System.out.println("--------------------------------------------------" +
                "-------------------------------------------------------------------------------");
        System.out.printf("|%-15s|%-15s|%-15s|%-15s|%-15s|%-15s|%-15s|%-15s|\n",
                "№","a","b","x","F(a)","F(b)","F(x)"," |xn+1 - xn| ");
        System.out.println("+---------------+---------------+---------------+" +
                "---------------+---------------+---------------+---------------+---------------+");
    }

    public void printLine2(int i, double a, double b, double x, double f_a, double f_b,
                           double f_x, double abs){
        System.out.printf("|%-15d|%-15f|%-15f|%-15f|%-15f|%-15f|%-15f|%-15f|\n",
                i,a,b,x,f_a,f_b,f_x,abs);
        System.out.println("|---------------+---------------+---------------+" +
                "---------------+---------------+---------------+---------------+---------------|");
    }

    public String printHead2_File(){
        String str = "--------------------------------------------------" +
                "-------------------------------------------------------------------------------\n";
        str += String.format("|%-15s|%-15s|%-15s|%-15s|%-15s|%-15s|%-15s|%-15s|\n",
                "№","a","b","x","F(a)","F(b)","F(x)"," |xn+1 - xn| ");
       str += "+---------------+---------------+---------------+" +
                "---------------+---------------+---------------+---------------+---------------+\n";
       return str;
    }

    public String printLine2_File(int i, double a, double b, double x, double f_a, double f_b,
                           double f_x, double abs){
        String str = String.format("|%-15d|%-15f|%-15f|%-15f|%-15f|%-15f|%-15f|%-15f|\n",
                i,a,b,x,f_a,f_b,f_x,abs);
        str += "|---------------+---------------+---------------+" +
                "---------------+---------------+---------------+---------------+---------------|\n";
        return str;
    }


    public void printHead3(){
        System.out.println("--------------------------------------------------" +
                "-----------------------------------------------");
        System.out.printf("|%-15s|%-15s|%-15s|%-15s|%-15s|%-15s|\n",
                "№","xn","f(xn)","f|(xn)","xn+1"," |xn+1 - xn| ");
        System.out.println("+---------------+---------------+---------------+" +
                "---------------+---------------+---------------+");
    }

    public void printLine3(int i, double xn, double f_xn, double f__xn, double xn1, double abs){
        System.out.printf("|%-15d|%-15f|%-15f|%-15f|%-15f|%-15f|\n",
                i,xn,f_xn,f__xn,xn1,abs);
        System.out.println("|---------------+---------------+---------------+" +
                "---------------+---------------+---------------|");
    }

    public String printHead3_file(){
        String str = "--------------------------------------------------" +
                "-----------------------------------------------\n";
        str += String.format("|%-15s|%-15s|%-15s|%-15s|%-15s|%-15s|\n",
                "№","xn","f(xn)","f|(xn)","xn+1"," |xn+1 - xn| ");
        str += "+---------------+---------------+---------------+" +
                "---------------+---------------+---------------+\n";
        return str;
    }

    public String printLine3_file(int i, double xn, double f_xn, double f__xn, double xn1, double abs){
        String str = String.format("|%-15d|%-15f|%-15f|%-15f|%-15f|%-15f|\n",
                i,xn,f_xn,f__xn,xn1,abs);
        str += "|---------------+---------------+---------------+" +
                "---------------+---------------+---------------|\n";
        return str;
    }

    public void printHead5(){
        System.out.println("--------------------------------------------------" +
                "-----------------------------------------------");
        System.out.printf("|%-15s|%-15s|%-15s|%-15s|%-15s|%-15s|\n",
                "№","xi","xi+1","Fi(xi+1)","f(xi+1)"," |xi+1 - xi| ");
        System.out.println("+---------------+---------------+---------------+" +
                "---------------+---------------+---------------+");
    }

    public void printLine5(int i, double xi, double xi_1, double Fi, double f, double abs){
        System.out.printf("|%-15d|%-15f|%-15f|%-15f|%-15f|%-15f|\n",
                i,xi,xi_1,Fi,f,abs);
        System.out.println("|---------------+---------------+---------------+" +
                "---------------+---------------+---------------|");
    }

    public String printHead5_file(){
        String str = "--------------------------------------------------" +
                "-----------------------------------------------\n";
        str += String.format("|%-15s|%-15s|%-15s|%-15s|%-15s|%-15s|\n",
                "№","xi","xi+1","Fi(xi+1)","f(xi+1)"," |xi+1 - xi| ");
        str += "+---------------+---------------+---------------+" +
                "---------------+---------------+---------------+\n";
        return str;
    }

    public String printLine5_file(int i, double xi, double xi_1, double Fi, double f, double abs){
        String str = String.format("|%-15d|%-15f|%-15f|%-15f|%-15f|%-15f|\n",
                i,xi,xi_1,Fi,f,abs);
        str += "|---------------+---------------+---------------+" +
                "---------------+---------------+---------------|\n";
        return str;
    }

}
