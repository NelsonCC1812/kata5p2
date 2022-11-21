package kata5p2.view;

import java.util.List;

import kata5p2.model.Histogram;
import kata5p2.model.Mail;

public class MailHistogramBuilder {
    static public Histogram<String> build(List<Mail> mails) {

        Histogram<String> histogram = new Histogram<>();

        for (Mail mail : mails)
            histogram.increment(mail.getDomain());

        return histogram;
    }
}
