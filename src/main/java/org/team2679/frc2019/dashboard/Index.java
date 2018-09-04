package org.team2679.frc2019.dashboard;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import org.team2679.dashboard.Dashboard;
import org.team2679.dashboard.Views.View;
import spark.Request;
import spark.Response;

import java.io.StringReader;
import java.io.StringWriter;

public class Index implements View {

    @Override
    public String address(){
        return "/";
    }

    @Override
    public Object handle(Request request, Response response) throws Exception {
        Configuration cfg = new Configuration();
        cfg.setObjectWrapper(new DefaultObjectWrapper());

        Template tmp = new Template("templateName", new StringReader(Dashboard.INSTANCE.loadResource("dashboard/templates/index.html")), cfg);

        StringWriter out = new StringWriter();

        tmp.process(null, out);
        return out.toString();
    }
}