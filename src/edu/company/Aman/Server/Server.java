package edu.company.Aman.Server;

import com.sun.net.httpserver.HttpExchange;
import edu.company.Aman.BasicServer.BasicServer;
import edu.company.Aman.BasicServer.ContentType;
import edu.company.Aman.BasicServer.ResponseCodes;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;


public class Server extends BasicServer {
    private final static Configuration freemarker = initFreeMarker();

    public Server(String host, int port) throws IOException {
        super(host, port);
        registerGet("/", this::freemarkerMainHandler);
//        registerGet("/day", this::freemarkerDayHandler);

    }

    private void freemarkerMainHandler(HttpExchange exchange) {
        renderTemplate(exchange,"calendar.ftl",getDataModel());
    }

    private static Configuration initFreeMarker() {
        try {
            Configuration cfg = new Configuration(Configuration.VERSION_2_3_29);
            cfg.setDirectoryForTemplateLoading(new File("C:\\Users\\User\\Desktop\\ContrWork\\Data"));
            cfg.setDefaultEncoding("UTF-8");
            cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
            cfg.setLogTemplateExceptions(false);
            cfg.setWrapUncheckedExceptions(true);
            cfg.setFallbackOnNullLoopVariable(false);
            return cfg;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    protected void renderTemplate(HttpExchange exchange, String templateFile,Object dataModel) {
        try {
            Template temp = freemarker.getTemplate("calendar.ftl");
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            try (OutputStreamWriter writer = new OutputStreamWriter(stream)) {
                temp.process(dataModel, writer);
                writer.flush();
                var data = stream.toByteArray();
                sendByteData(exchange, ResponseCodes.OK, ContentType.TEXT_HTML, data);
            }
        } catch (IOException | TemplateException e) {
            e.printStackTrace();
        }
    }

    private DataModel getDataModel() {
        return new DataModel();}

//    private Day getDayModel() {
//        return new Day();
//    }

}
