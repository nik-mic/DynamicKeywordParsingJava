import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import parser.FullScanner;
import parser.LiteralScanner;
import parser.ObjectScanner;
import subject.*;

import java.util.ArrayList;
import java.util.List;

public class ScanObjectTest {

    @Test
    public void scan1DSingular(){
        Subject s = new SimpleSubject(42);
        ObjectScanner scanner = new LiteralScanner();
        Assertions.assertEquals("42", scanner.scan(s).get(0));
    }
    @Test
    public void scan1DMultiple(){
        Subject s = new MultipleSubject();
        List<String> expected = new ArrayList<>();

        expected.add("42");
        expected.add("4.2");
        expected.add("zweiundfürzig");

        ObjectScanner scanner = new LiteralScanner();
        Assertions.assertEquals(expected, scanner.scan(s));
    }

    @Test
    public void scan2D(){
        Subject s = new EmbededSubject();
        ObjectScanner scanner = new LiteralScanner();
        Assertions.assertEquals(scanner.scan(s).toString(), "[42, [42, 4.2, zweiundfürzig], Ende]");
    }

    @Test
    public void scanEmpty(){
        Object o = new Object();
        ObjectScanner scanner = new LiteralScanner();
        Assertions.assertTrue(scanner.scan(o).isEmpty());
    }

    @Test
    public void ReflexiveScan(){
        ReflexiveSubject r = new ReflexiveSubject();
       //  System.out.println(new LiteralScanner().scan(r));
        // TODO FIX THIS BULLSHIT
    }
}
