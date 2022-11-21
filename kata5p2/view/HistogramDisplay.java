package kata5p2.view;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import java.awt.Dimension;

import kata5p2.model.Histogram;

public class HistogramDisplay<T> extends ApplicationFrame {

    private final Histogram<T> histogram;

    public HistogramDisplay(Histogram<T> histogram, String title) {
        super(title);
        this.histogram = histogram;
        this.setContentPane(createPanel());
        this.pack();
    }

    public void execute() {
        this.setVisible(true);
    }

    private JPanel createPanel() {
        ChartPanel chartPanel = new ChartPanel(createChart(createDataset()));
        chartPanel.setPreferredSize(new Dimension(500, 400));
        return chartPanel;
    }

    private JFreeChart createChart(DefaultCategoryDataset dataset) {
        JFreeChart chart = ChartFactory.createBarChart("Histogram", "Dominios emails", "Nº emails",
                dataset, PlotOrientation.VERTICAL, false, false, rootPaneCheckingEnabled);

        return chart;
    }

    private DefaultCategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (T key : this.histogram.keySet()) {
            dataset.addValue(this.histogram.get(key), "", key.toString());
        }

        return dataset;
    }

}
