package commands;

import junit.framework.TestCase;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Diana on 22.03.2016.
 */
public class CommandReportTest extends TestCase {
    @Test
    public void testExecute() throws Exception {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFWorkbook spyWorkbook = Mockito.spy(workbook);
            Mockito.doAnswer(new Answer() {
                @Override
                public Object answer(InvocationOnMock invocation) throws Throwable {
                    System.out.println("Report done!");
                    return null;
                }
            }).when(spyWorkbook).write(new FileOutputStream(new File(CommandReport.reportName)));

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        CommandReport report = mock(CommandReport.class);
        when(report.getWorkbook()).thenReturn(spyWorkbook);
        when(report.execute(new String[1])).thenCallRealMethod();
        report.execute(new String[1]);

        String expectedOutput  = "Report done!\r\n";
        assertEquals(outContent.toString(), expectedOutput);
    }
}