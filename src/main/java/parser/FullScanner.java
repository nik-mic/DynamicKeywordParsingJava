package parser;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FullScanner implements ObjectScanner{
    @Override
    public List<Object> scan(Object o) {
        System.out.println(Arrays.asList(o.getClass().getFields()));

        return new ArrayList<>(Arrays.asList(Arrays.stream(o.getClass().getFields())));
    }
}
