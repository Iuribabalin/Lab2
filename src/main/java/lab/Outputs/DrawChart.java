package lab.Outputs;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;

public class DrawChart {
    public double f_cos(double x){return Math.cos(Math.pow(x,2));}
    public double f_main(double x){return Math.pow(x,3) + 2.84*Math.pow(x,2) - 5.606*x - 14.766;}
    public double f_parabola(double x){return 5*Math.pow(x,2)+2*x-3;}
    public double f_sin(double x){return Math.sin(x);}


    public void draw_all_fun(int num_fun,double a, double b){
        if(num_fun == 1)
            draw_main(Math.round(a), Math.round(b));
        else if(num_fun == 2)
            draw_cos(Math.round(a), Math.round(b));
        else if(num_fun == 3)
            draw_parabola(Math.round(a), Math.round(b));
        else if(num_fun == 4)
            draw_sin(Math.round(a), Math.round(b));
    }

    public void draw_main(long a, long b){
        XYSeries series = new XYSeries("x^3 + 2.84*x^2 - 5.606*x - 14.766");

        for(double i = a; i <= b; i+=0.01){
            series.add(i, f_main(i));
        }

        XYDataset xyDataset = new XYSeriesCollection(series);
        JFreeChart chart = ChartFactory
                .createXYLineChart("y = x^3 + 2.84*x^2 - 5.606*x - 14.766", "x", "y",
                        xyDataset,
                        PlotOrientation.VERTICAL,
                        true, true, true);
        JFrame frame =
                new JFrame("MinimalStaticChart");
        // Помещаем график на фрейм
        frame.getContentPane()
                .add(new ChartPanel(chart));
        frame.setSize(400,300);
        frame.show();
    }

    public void draw_cos(long a, long b){
        XYSeries series = new XYSeries("cos(x^2)");

        for(double i = a; i <= b; i+=0.01){
            series.add(i, f_cos(i));
        }

        XYDataset xyDataset = new XYSeriesCollection(series);
        JFreeChart chart = ChartFactory
                .createXYLineChart("y = cos(x^2)", "x", "y",
                        xyDataset,
                        PlotOrientation.VERTICAL,
                        true, true, true);
        JFrame frame =
                new JFrame("MinimalStaticChart");
        // Помещаем график на фрейм
        frame.getContentPane()
                .add(new ChartPanel(chart));
        frame.setSize(400,300);
        frame.show();
    }

    public void draw_parabola(long a, long b){
        XYSeries series = new XYSeries("5*x^(2) + 2*x - 3");

        for(double i = a; i <= b; i+=0.01){
            series.add(i, f_parabola(i));
        }

        XYDataset xyDataset = new XYSeriesCollection(series);
        JFreeChart chart = ChartFactory
                .createXYLineChart("y = 5*x^(2) + 2*x - 3", "x", "y",
                        xyDataset,
                        PlotOrientation.VERTICAL,
                        true, true, true);
        JFrame frame =
                new JFrame("MinimalStaticChart");
        // Помещаем график на фрейм
        frame.getContentPane()
                .add(new ChartPanel(chart));
        frame.setSize(400,300);
        frame.show();
    }

    public void draw_sin(long a, long b){
        XYSeries series = new XYSeries("sin(x)");

        for(double i = a; i <= b; i+=0.01){
            series.add(i, f_sin(i));
        }

        XYDataset xyDataset = new XYSeriesCollection(series);
        JFreeChart chart = ChartFactory
                .createXYLineChart("y = sin(x)", "x", "y",
                        xyDataset,
                        PlotOrientation.VERTICAL,
                        true, true, true);
        JFrame frame =
                new JFrame("MinimalStaticChart");
        // Помещаем график на фрейм
        frame.getContentPane()
                .add(new ChartPanel(chart));
        frame.setSize(400,300);
        frame.show();
    }


    public void drawForIt(double a, double b, double lambda, int num_fun){
        XYSeries series = new XYSeries("Fi(x)");
        XYSeries series1 = new XYSeries("x=y");
        XYSeriesCollection dataset = new XYSeriesCollection();

        if(num_fun == 1) {
            for(double i = a; i <= b; i+=0.01){
                series.add(i, i - lambda * f_main(i));
            }
        }else if(num_fun == 2){
            for(double i = a; i <= b; i+=0.01){
                series.add(i, i - lambda * f_cos(i));
            }
        }else if(num_fun == 3){
            for(double i = a; i <= b; i+=0.01){
                series.add(i, i - lambda * f_parabola(i));
            }
        }else if(num_fun == 4){
            for(double i = a; i <= b; i+=0.01){
                series.add(i, i - lambda * f_sin(i));
            }
        }

        for(double i = a; i <= b; i+=0.01){
            series1.add(i, i);
        }

        dataset.addSeries(series);
        dataset.addSeries(series1);

        JFreeChart chart = ChartFactory.createXYLineChart("Fi(x)","x",
                "Y", dataset, PlotOrientation.VERTICAL,
                true, true, false);

        JFrame frame =
                new JFrame("MinimalStaticChart");
        // Помещаем график на фрейм
        frame.getContentPane()
                .add(new ChartPanel(chart));
        frame.setSize(400,300);
        frame.show();
    }
}
