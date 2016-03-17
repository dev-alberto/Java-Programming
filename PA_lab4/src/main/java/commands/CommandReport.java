<<<<<<< 65e416ee5d382d004dea1ceae70ab86e4b0af3b6
package commands;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import utils.FavouriteSong;
import utils.PathManager;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import Exception.*;

/**
 *
 */
public class CommandReport extends CommandFav {
    public CommandReport(PathManager pathManager) {
        super(pathManager);
    }

    /**
     *
     * @param commandArguments i.e user input
     */

    public void execute(String[] commandArguments) {
        //Create blank workbook
        XSSFWorkbook workbook = new XSSFWorkbook();
        //Create a blank sheet
        XSSFSheet spreadsheet = workbook.createSheet("Favourite Songs");
        //Create row object
        int rowid = 0;
        XSSFRow row = spreadsheet.createRow(rowid++);;
        row.createCell(0).setCellValue("Path");
        row.createCell(1).setCellValue("Mark");

        //Iterate over data and write to sheet
        List<FavouriteSong> favouriteSongs = deserialize();
        for (FavouriteSong song : favouriteSongs)
        {
            row = spreadsheet.createRow(rowid++);
            row.createCell(0).setCellValue(song.getFile().toString());
            row.createCell(1).setCellValue(song.getMark());
        }
        //Write the workbook in file system
        try {
            FileOutputStream out = new FileOutputStream(new File("Report.xlsx"));
            workbook.write(out);
            out.close();
            System.out.println("Report.xlsx written successfully");
        }
        catch (IOException ioExeption) {
            // TODO: 13.03.2016 Ceva exceptie iar
            System.out.println("Nu a putut fi creat raportul " + ioExeption.getCause());
        }
    }
}
=======
package commands;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import utils.FavouriteSong;
import utils.PathManager;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import Exception.*;

/**
 *
 */
public class CommandReport extends CommandFav {
    public CommandReport(PathManager pathManager) {
        super(pathManager);
    }

    /**
     * Generates users favourite songs report.
     * @param commandArguments i.e user input
     */
    public void execute(String[] commandArguments) {
        //Create blank workbook
        XSSFWorkbook workbook = new XSSFWorkbook();
        //Create a blank sheet
        XSSFSheet spreadsheet = workbook.createSheet("Favourite Songs");
        //Create row object
        int rowid = 0;
        XSSFRow row = spreadsheet.createRow(rowid++);;
        row.createCell(0).setCellValue("Path");
        spreadsheet.setColumnWidth(0, 40*250);
        row.createCell(1).setCellValue("Mark");
        spreadsheet.setColumnWidth(1, 10*250);

        //Iterate over data and write to sheet
        List<FavouriteSong> favouriteSongs = deserialize();
        for (FavouriteSong song : favouriteSongs)
        {
            row = spreadsheet.createRow(rowid++);
            row.createCell(0).setCellValue(song.getFile().toString());
            row.createCell(1).setCellValue(song.getMark());
        }
        //Write the workbook in file system
        try {
            FileOutputStream out = new FileOutputStream(new File("Report.xlsx"));
            workbook.write(out);
            out.close();
            System.out.println("Report.xlsx written successfully");
        }
        catch (IOException ioExeption) {
            // TODO: 13.03.2016 Ceva exceptie iar
            System.out.println("Nu a putut fi creat raportul " + ioExeption.getCause());
        }
    }
}
>>>>>>> Refactoring
