package org.team2679.frc2019

import freemarker.template.Configuration
import freemarker.template.DefaultObjectWrapper
import freemarker.template.Template
import org.team2679.dashboard.Dashboard
import org.team2679.dashboard.Views.View
import spark.Request
import spark.Response

import java.io.StringReader
import java.io.StringWriter
import java.io.Writer
import java.util.HashMap

class Index : View {
    override fun address(): String {
        return "/"
    }

    @Throws(Exception::class)
    override fun handle(request: Request, response: Response): Any {
        val model = Unit
        val cfg = Configuration()
        cfg.setObjectWrapper(DefaultObjectWrapper())

        val t = Template("templateName", StringReader(Dashboard.INSTANCE.loadResource("templates/index.html")), cfg)

        val out = StringWriter()
        t.process(model, out)
        return out.toString()
    }
}