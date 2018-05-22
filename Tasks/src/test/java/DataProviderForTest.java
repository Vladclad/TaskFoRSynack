import org.testng.ITest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;


public class DataProviderForTest implements ITest {
    String csvFile = "./Data.csv";
    private String test_name = "";
    public String getTestName() {return test_name;}
    private void setTestName(String a) {test_name=a;}
    @BeforeMethod (alwaysRun=true)
    public void bm (Method method, Object[] parameters) {
        setTestName (method.getName());
        Override a = method.getAnnotation (Override.class);
        String testCaseId = (String) parameters[a.id()];
        setTestName(testCaseId);}


    @DataProvider(name = "data")
    public Iterator<String[]> data() throws IOException {
        String cvsLine = "";
        String[] a = null;
        ArrayList<String[]> al = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(csvFile));
        while ((cvsLine = br.readLine()) != null) {a = cvsLine.split(","); al.add(a);}
        br.close();
        return al.iterator();}

}