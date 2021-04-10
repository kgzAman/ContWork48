package edu.company.Aman.Server;

import com.sun.net.httpserver.HttpExchange;
import edu.company.Aman.BasicServer.BasicServer;
import edu.company.Aman.BasicServer.ContentType;
import edu.company.Aman.BasicServer.ResponseCodes;
import edu.company.Aman.Generator;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;


public class Server extends BasicServer {
    private final static Configuration freemarker = initFreeMarker();

    public Server(String host, int port) throws IOException {
        super(host, port);
        registerGet("/days", this::handleQueryRequest);
        registerGet("/", this::GetDayHolder);

    }
    private void GetDayHolder(HttpExchange httpExchange) {
        renderTemplate(httpExchange,"main.ftl",getCalendarDataModel((TaskForDay(makeDays(),eventsImg()))));
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
    private void handleQueryRequest(HttpExchange httpExchange) {
        String queryParams = getQueryParams(httpExchange);
        Map<String, String> params = Utils.parseUrlEncoded(queryParams, "&");
        int day = 0;
        for (Map.Entry<String, String> k : params.entrySet()) {
            day = Integer.parseInt(k.getValue());
        }
        Day byDay = CalendarDataModel.findByDay(day);
        if (byDay.getNumber() == -1) {
            redirect303(httpExchange, "/error");
        } else {
            renderTemplate(httpExchange, "calendar.ftl", byDay);
        }
    }

    public static List<Task> eventsImg(){
        List<Task> events = new ArrayList<>();
        events.add(new Task(Generator.makeName(), "/images/gen.png", Generator.makeDescription(), Category.SHOPPING));
        events.add(new Task(Generator.makeName(), "/images/urgent.png", Generator.makeDescription(), Category.ORDINARY));
        events.add(new Task(Generator.makeName(), "/images/work.png", Generator.makeDescription(), Category.WORK));
        events.add(new Task(Generator.makeName(), "/images/shop.png", Generator.makeDescription(), Category.PURCHASES));
        events.add(new Task(Generator.makeName(), "/images/oth.png", Generator.makeDescription(), Category.OTHER));
        return events;
    }

    public static List<Day> makeDays(){
        List<Day> day = new ArrayList<>();
        for (int i = 1; i < 31; i++) {
            day.add(new Day(i));
        }
        return day;
    }

    public static List<Day> TaskForDay(List<Day> days, List<Task> events){
        Random rnd = new Random();
        for (Day day: days) {
            int num = rnd.nextInt(5) + 1;
            for (int i = 0; i < num; i++) {
                int cases = rnd.nextInt(events.size());
                day.getTasks().add(events.get(cases));
            }
        }
        return days;
    }

    private String getQueryParams(HttpExchange exchange) {
        String query = exchange.getRequestURI().getQuery();
        return Objects.nonNull(query) ? query : "";
    }

    protected void renderTemplate(HttpExchange exchange, String templateFile,Object dataModel) {
        try {
            Template temp = freemarker.getTemplate(templateFile);
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
    protected void redirect303(HttpExchange exchange, String path) {
        try {
            exchange.getResponseHeaders().add("Location", path);
            exchange.sendResponseHeaders(303, 0);
            exchange.getResponseBody().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private CalendarDataModel getCalendarDataModel(List<Day> dayList) {
        return new CalendarDataModel(dayList);}


}
