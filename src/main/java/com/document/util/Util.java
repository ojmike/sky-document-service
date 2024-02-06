package com.document.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Util {

    public static String getFileHash(byte[] file) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(file);
        byte[] hash = md.digest();
        StringBuilder sb = new StringBuilder();
        for (byte b : hash) {
//            sb.append(StringUtils.substring(Integer.toString((b & 0xff) + 0x100, 16), 1));
        }

        return sb.toString();
    }

}
