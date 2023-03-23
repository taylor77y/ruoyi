package com.ruoyi.system.utils;

import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MessageUtils {
    public static String hash(String... id) {
        List<String> arrayList = new ArrayList<>(Arrays.asList(id));

        arrayList.sort(Comparator.reverseOrder());

        return DigestUtils.md5DigestAsHex(arrayList.toString().getBytes(StandardCharsets.UTF_8));
    }

    public static void main(String[] args) {
        System.out.println(MessageUtils.hash("1", "2"));
        System.out.println(MessageUtils.hash("2", "1"));
    }
}
