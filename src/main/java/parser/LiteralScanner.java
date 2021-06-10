package parser;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LiteralScanner implements ObjectScanner{

    @Override
    public List<Object> scan(Object o) {
        List<Object> result = new ArrayList<>();
        Arrays.stream(o.getClass().getDeclaredFields()).forEach(f -> {
            try {
                if (f.getType().isPrimitive() || f.getType().equals(String.class)) {
                    result.add(f.get(o) + "");
                } else {
                    result.add(scan(f.get(o)));
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        });
        return result;
    }
}
