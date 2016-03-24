package commands;

import Exception.MyException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import utils.FavouriteSong;
import utils.PathManager;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * Class used for implementing the report command.
 * The report that is created is a excel file that contains all the favourite files.
 */
public class CommandReport extends CommandFav {
    public CommandReport(PathManager pathManager) {
        super(pathManager);
    }
    public static final String reportName = "Report.xlsx";
    public XSSFWorkbook getWorkbook() {
        return new XSSFWorkbook();
    }

    /**
     * Generates users favourite songs report.
     * @param commandArguments i.e user input
     */
    public boolean execute(String[] commandArguments) throws MyException {
        //Create blank workbook
        XSSFWorkbook workbook = getWorkbook();
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
        List<FavouriteSong> favouriteSongs = deserialize(new File(serializedListOfSongs));
        for (FavouriteSong song : favouriteSongs)
        {
            row = spreadsheet.createRow(rowid++);
            row.createCell(0).setCellValue(song.getFile().toString());
            row.createCell(1).setCellValue(song.getMark());
        }
        //Write the workbook in file system
        try {
            FileOutputStream out = new FileOutputStream(new File(CommandReport.reportName));
            workbook.write(out);
            out.close();
            return true;
        }
        catch (IOException ioExeption) {
            throw new MyException("The report was't created.", ioExeption);
        }
    }
}
