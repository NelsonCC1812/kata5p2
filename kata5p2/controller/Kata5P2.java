package kata5p2.controller;

import kata5p2.view.HistogramDisplay;
import kata5p2.view.MailHistogramBuilder;
import kata5p2.view.MailListReaderBD;

public class Kata5P2 {
    public static void main(String[] args) {

        HistogramDisplay<String> hDisplay = new HistogramDisplay<>(
                MailHistogramBuilder.build(MailListReaderBD.read("jdbc:sqlite:email.db")), "Histograma");

        hDisplay.execute();
    }
}