package controllers;

import com.google.api.services.calendar.model.Event;
import dto.Category;
import dto.EventType;
import models.Accessory;
import models.Entry;
import models.Tent;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import services.GoogleAPI;
import services.Util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.avaje.ebean.Expr.eq;

/**
 * Created by MiHu on 11.1.2015.
 */
@Security.Authenticated(LoggedStoremanOrAdmin.class)
public class Documents extends Controller {

    public static final String PATH_TO_REPO = System.getenv("OPENSHIFT_REPO_DIR") == null ? "" : System.getenv("OPENSHIFT_REPO_DIR") + "";

    public static Result priceOffer(String eventType, String id) throws IOException {
        EventType type = EventType.valueOf(eventType);
        response().setContentType("application/vnd.ms-excel");
        List<Entry> entries = Entry.find.where().eq("eventType", type).eq("eventId", id).findList();
        if (type.equals(EventType.SELFTRANSPORT)) {
            response().setHeader("Content-disposition", "attachment; filename=ponuka_dasa_VD.xlsx");
            return ok(excel(PATH_TO_REPO + "public/docs/ponuka_dasa_VD.xlsx", entries, 18, 0, 5).toByteArray());
        } else {
            response().setHeader("Content-disposition", "attachment; filename=ponuka_dasa.xlsx");
            return ok(excel(PATH_TO_REPO + "public/docs/ponuka_dasa.xlsx", entries, 18, 0, 5).toByteArray());
        }
    }

    public static Result contract(String eventType, String id) throws IOException {
        EventType type = EventType.valueOf(eventType);
        response().setContentType("application/vnd.ms-excel");
        List<Entry> entries = Entry.find.where().eq("eventType", type).eq("eventId", id).not(eq("item.category", Category.TOOL)).findList();
        Event e = GoogleAPI.findEvent(type, id);
        String eventName =  e.getSummary();
        String fileName = eventName.substring(0, Math.min(eventName.length(), 20));
        if (type.equals(EventType.SELFTRANSPORT)) {
            response().setHeader("Content-disposition", "attachment; filename=Z_" + fileName + ".xlsx");
            return ok(excel(PATH_TO_REPO + "public/docs/zmluva-vlastna_doprava.xlsx", entries, 11, 1, 2).toByteArray());
        } else {
            response().setHeader("Content-disposition", "attachment; filename=V_" + fileName + ".xlsx");
            return ok(excel(PATH_TO_REPO + "public/docs/vykaz_na_akciu_NEW.xlsx", entries, 9, 0, 5).toByteArray());
        }
    }

    public static Result loadingList(String eventType, String id) throws IOException {
        EventType type = EventType.valueOf(eventType);
        response().setContentType("application/vnd.ms-excel");
        List<Entry> entries = Entry.find.where().eq("eventType", type).eq("eventId", id).findList();
        List<Entry> loadListEntries = new ArrayList<>();
        for (Entry entry : entries){
            if(entry.item.category !=  Category.TENT){
                loadListEntries.add(entry);
                continue;
            }
            Tent tent = (Tent) entry.item;
            for(Accessory a : tent.accessories){
                Entry tentE = new Entry();
                tentE.item = a.item;
                tentE.amount = entry.amount.multiply(a.amount);
                loadListEntries.add(tentE);
            }
        }
        Event e = GoogleAPI.findEvent(type, id);
        String eventName =  e.getSummary();
        String fileName = eventName.substring(0, Math.min(eventName.length(), 20));
        response().setHeader("Content-disposition", "attachment; filename=N_" + fileName + ".xlsx");
        return ok(excel(PATH_TO_REPO + "public/docs/nakladaci_list.xlsx", loadListEntries, 0, 0, 1).toByteArray());
    }

    public static ByteArrayOutputStream excel(String fileName, List<Entry> entries, int beginRownum, int nameColnum, int amountColnum) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook(fileName);
        XSSFSheet sheet = workbook.getSheetAt(0);
        int rowCounter = beginRownum;
        for (Entry e : entries) {
            XSSFRow row = sheet.getRow(rowCounter);
            XSSFCell cell = row.getCell(nameColnum);
            cell.setCellValue(e.item.name);
            cell = row.getCell(amountColnum);
            cell.setCellValue(Util.df.format(e.amount));
            rowCounter++;
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        workbook.write(out);
        out.close();
        return out;
    }
}
