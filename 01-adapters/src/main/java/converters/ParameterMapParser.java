package main.java.converters;

import main.java.entities.MatType;

import java.util.List;
import java.util.Map;

public class ParameterMapParser {
    private final Map<String, Object> parameterMap;

    public ParameterMapParser(Map<String, Object> parameterMap) {
        this.parameterMap = parameterMap;
    }

    public MatType parseMatType(final String key){
        return parseSimpleType(key, MatType.class);
    }

    public String parseString(final String key){
        return parseSimpleType(key, String.class);
    }

    public Integer parseInteger(final String key){
        return parseSimpleType(key, Integer.class);
    }

    public List<Integer> parseIntegerList(final String key){
        Object value = getFromMap(key);
        checkCorrectType(value instanceof List<?>);
        return checkCorrectContainerType((List<?>) value, Integer.class);
    }


    private <T> T parseSimpleType(final String key, Class<T> expected){
        Object value = getFromMap(key);
        return getCorrectType(value, expected);
    }

    private Object getFromMap(final String key){
        if (!parameterMap.containsKey(key))
            throw new RuntimeException("Parameter map does not contain object with type " + key + "!");
        return parameterMap.get(key);
    }

    private <T> T getCorrectType(Object value, Class<T> type){
        checkCorrectType(type.isInstance(value));
        return (T) value;
    }

    private void checkCorrectType(boolean correct){
        if (!correct) throw new RuntimeException("Invalid type provided...");
    }

    private <T> List<T> checkCorrectContainerType(List<?> list, Class<?> expectedValueType){
        if (list.isEmpty()) return (List<T>) list;
        if (expectedValueType.isInstance(list.stream().findAny().get())){
            return (List<T>) list;
        }
        throw new RuntimeException("Invalid type provided...");
    }

}
