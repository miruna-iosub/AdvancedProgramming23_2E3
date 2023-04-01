package org.homework;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

public class ReportCommand extends Command {
    private final Catalog catalog;

    public ReportCommand(Catalog catalog) {
        this.catalog = catalog;
    }

    @Override
    public void execute() {
        Configuration cfg = new Configuration();
        try {
            cfg.setDirectoryForTemplateLoading(new File(ReportCommand.class.getResource("/templates").toURI()));
        } catch (URISyntaxException | IOException exception) {
            exception.printStackTrace();
        }
        try {
            Template template = cfg.getTemplate("report.ftl");
            Map<String, Object> data = new HashMap<String, Object>();
            data.put("title", "HTML Report");
            data.put("documents", catalog.docs);

            Writer file = new FileWriter(new File("./report.html"));
            template.process(data, file);

            File report = new File("./report.html");
            Desktop desktop = Desktop.getDesktop();
            desktop.open(report);
        } catch (IOException | TemplateException exception) {
            exception.printStackTrace();
        }
    }
}