package kr.aterilio.nextstep.techcamp.m1.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {

    public static final String EMPTY_STRING = "";

    private static final int INDEX_NOT_FOUND = -1;
    private static final int IDX_GROUP_1 = 1;
    private static final int UNIT_POW_FOR_FLOOR = 10;

    private static final String REGEX_NUMERIC = "^[0-9-]+$"; // 음수도 숫자이므로 정규식에 - 문자 추가

    public static boolean isEmpty(String data) {
        return data == null || EMPTY_STRING.equals(data.trim());
    }

    public static boolean isExistRegEx(String target, String regex) {
        return findRegEx(target, regex).find();
    }

    public static Matcher findRegEx(String target, String regex) {
        return Pattern.compile(regex).matcher(target);
    }

    public static String[] split(String target, String splitBy) {
        return target.split(splitBy);
    }

    public static String removeAllRegEx(String target, String regex) {
        return target.replaceAll(regex, StringUtil.EMPTY_STRING);
    }

    public static boolean isNumeric(String target) {
        return isExistRegEx(target, REGEX_NUMERIC);
    }

    public static int positionRegEx(String target, String regex) {
        Matcher matcher = findRegEx(target, regex);
        if (matcher.find()) {
            return matcher.start();
        }
        return INDEX_NOT_FOUND;
    }

    public static String extractRegExGroupFirst(String target, String regex) {
        Matcher matcher = findRegEx(target, regex);
        if (!matcher.find()) {
            return StringUtil.EMPTY_STRING;
        }
        return matcher.group(IDX_GROUP_1);
    }

    public static String floorFloatWithPointPosition(float original, int pointPosition) {
        double unit = Math.pow(UNIT_POW_FOR_FLOOR, pointPosition);
        return String.format("%." + pointPosition + "f", Math.floor(original*unit)/unit);
    }
}