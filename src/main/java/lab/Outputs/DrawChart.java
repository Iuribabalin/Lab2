package lab.Outputs;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import java.io.File;
import java.io.IOException;

public class DrawChart {
    public double f_cos(double x){return Math.cos(Math.pow(x,2));}
    public double f_main(double x){return Math.pow(x,3) + 2.84*Math.pow(x,2) - 5.606*x - 14.766;}
    public double f_parabola(double x){return 5*Math.pow(x,2)+2*x-3;}
    public double f_sin(double x){return Math.sin(x);}

    public void draw_main(long a, long b){
        a -= 1;
        b += 1;
        DefaultCategoryDataset line_chart_dataset = new DefaultCategoryDataset();
        for(long i = a; i <= b; i++){
            line_chart_dataset.addValue( f_main(i),
                    "function", String.valueOf(i));
        }
        int x = 0;
        JFreeChart lineChartObject = ChartFactory.createLineChart(
                "fun(x)","x",
                "y",
                line_chart_dataset, PlotOrientation.VERTICAL,
                true,true,false);
        int width = 1920;    /* Width of the image */
        int height = 1080;   /* Height of the image */
        File lineChart = new File( "Chart.jpeg" );
        try {
            ChartUtilities.saveChartAsJPEG(lineChart ,lineChartObject, width ,height);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw_cos(long a, long b){
        a -= 1;
        b += 1;
        DefaultCategoryDataset line_chart_dataset = new DefaultCategoryDataset();
        for(long i = a; i <= b; i++){
            line_chart_dataset.addValue( f_cos(i),
                    "function", String.valueOf(i));
        }
        int x = 0;
        JFreeChart lineChartObject = ChartFactory.createLineChart(
                "fun(x)","x",
                "y",
                line_chart_dataset, PlotOrientation.VERTICAL,
                true,true,false);
        int width = 1920;    /* Width of the image */
        int height = 1080;   /* Height of the image */
        File lineChart = new File( "Chart.jpeg" );
        try {
            ChartUtilities.saveChartAsJPEG(lineChart ,lineChartObject, width ,height);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw_parabola(long a, long b){
        a -= 1;
        b += 1;
        DefaultCategoryDataset line_chart_dataset = new DefaultCategoryDataset();
        for(long i = a; i <= b; i++){
            line_chart_dataset.addValue( f_parabola(i),
                    "function", String.valueOf(i));
        }
        int x = 0;
        JFreeChart lineChartObject = ChartFactory.createLineChart(
                "fun(x)","x",
                "y",
                line_chart_dataset, PlotOrientation.VERTICAL,
                true,true,false);
        int width = 1920;    /* Width of the image */
        int height = 1080;   /* Height of the image */
        File lineChart = new File( "Chart.jpeg" );
        try {
            ChartUtilities.saveChartAsJPEG(lineChart ,lineChartObject, width ,height);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw_sin(long a, long b){
        a -= 1;
        b += 1;
        DefaultCategoryDataset line_chart_dataset = new DefaultCategoryDataset();
        for(long i = a; i <= b; i++){
            line_chart_dataset.addValue( f_sin(i),
                    "function", String.valueOf(i));
        }
        int x = 0;
        JFreeChart lineChartObject = ChartFactory.createLineChart(
                "fun(x)","x",
                "y",
                line_chart_dataset, PlotOrientation.VERTICAL,
                true,true,false);
        int width = 1920;    /* Width of the image */
        int height = 1080;   /* Height of the image */
        File lineChart = new File( "Chart.jpeg" );
        try {
            ChartUtilities.saveChartAsJPEG(lineChart ,lineChartObject, width ,height);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void drawForIt_main(long a, long b, double lambda){
        a -= 1;
        b += 1;
        DefaultCategoryDataset line_chart_dataset = new DefaultCategoryDataset();
        for(long i = a; i <= b; i++){
            line_chart_dataset.addValue( i-lambda*f_main(i),
                    "function", String.valueOf(i));
        }
        for(long i = a; i <= b; i++){
            line_chart_dataset.addValue( i,
                    "x=y", String.valueOf(i));
        }
        JFreeChart lineChartObject = ChartFactory.createLineChart(
                "fun(x)","x",
                "y",
                line_chart_dataset, PlotOrientation.VERTICAL,
                true,true,false);
        int width = 1920;
        int height = 1080;
        File lineChart = new File( "Chart.jpeg" );
        try {
            ChartUtilities.saveChartAsJPEG(lineChart ,lineChartObject, width ,height);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void drawForIt_cos(long a, long b, double lambda){
        a -= 1;
        b += 1;
        DefaultCategoryDataset line_chart_dataset = new DefaultCategoryDataset();
        for(long i = a; i <= b; i++){
            line_chart_dataset.addValue( i-lambda*f_cos(i),
                    "function", String.valueOf(i));
        }
        for(long i = a; i <= b; i++){
            line_chart_dataset.addValue( i,
                    "x=y", String.valueOf(i));
        }
        JFreeChart lineChartObject = ChartFactory.createLineChart(
                "fun(x)","x",
                "y",
                line_chart_dataset, PlotOrientation.VERTICAL,
                true,true,false);
        int width = 1920;
        int height = 1080;
        File lineChart = new File( "Chart.jpeg" );
        try {
            ChartUtilities.saveChartAsJPEG(lineChart ,lineChartObject, width ,height);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void drawForIt_parabola(long a, long b, double lambda){
        a -= 1;
        b += 1;
        DefaultCategoryDataset line_chart_dataset = new DefaultCategoryDataset();
        for(long i = a; i <= b; i++){
            line_chart_dataset.addValue( i-lambda*f_parabola(i),
                    "function", String.valueOf(i));
        }
        for(long i = a; i <= b; i++){
            line_chart_dataset.addValue( i,
                    "x=y", String.valueOf(i));
        }
        JFreeChart lineChartObject = ChartFactory.createLineChart(
                "fun(x)","x",
                "y",
                line_chart_dataset, PlotOrientation.VERTICAL,
                true,true,false);
        int width = 1920;
        int height = 1080;
        File lineChart = new File( "Chart.jpeg" );
        try {
            ChartUtilities.saveChartAsJPEG(lineChart ,lineChartObject, width ,height);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void drawForIt_sin(long a, long b, double lambda){
        a -= 1;
        b += 1;
        DefaultCategoryDataset line_chart_dataset = new DefaultCategoryDataset();
        for(long i = a; i <= b; i++){
            line_chart_dataset.addValue( i-lambda*f_sin(i),
                    "function", String.valueOf(i));
        }
        for(long i = a; i <= b; i++){
            line_chart_dataset.addValue( i,
                    "x=y", String.valueOf(i));
        }
        JFreeChart lineChartObject = ChartFactory.createLineChart(
                "fun(x)","x",
                "y",
                line_chart_dataset, PlotOrientation.VERTICAL,
                true,true,false);
        int width = 1920;
        int height = 1080;
        File lineChart = new File( "Chart.jpeg" );
        try {
            ChartUtilities.saveChartAsJPEG(lineChart ,lineChartObject, width ,height);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
