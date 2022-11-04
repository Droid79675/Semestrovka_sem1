package ru.kpfu.net.util;

import jakarta.xml.bind.DatatypeConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Helper {

    private static final Logger LOGGER = LoggerFactory.getLogger(Helper.class);

    public static String encrypt(String password) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] digest = md.digest();
            return DatatypeConverter.printHexBinary(digest).toUpperCase();
        } catch (NoSuchAlgorithmException e) {
            LOGGER.warn("Cannot find algorithm", e);
            return null;
        }
    }

    public static boolean checkEmailOrLogin(String emailOrLogin){
        boolean check = Pattern.matches("^(.+)@(\\S+)$", emailOrLogin);
        return check;
    }

    public static String transphereFileToString(Part avatarFile) throws IOException {
        String fileName = avatarFile.getSubmittedFileName();
        String path = "D:\\uploadImages\\" + fileName;
        return new String(Files.readAllBytes(Paths.get(path)));
    }

    public static void createFile(Part avatarFile) throws IOException {
        String fileName = avatarFile.getSubmittedFileName();
        OutputStream out;
        InputStream filecontent;
        out = Files.newOutputStream(new File("D:\\uploadImages\\" + File.separator
                + fileName).toPath());
        filecontent = avatarFile.getInputStream();

        int read = 0;
        final byte[] bytes = new byte[1048576];

        while ((read = filecontent.read(bytes)) != -1) {
            out.write(bytes, 0, read);
        }
    }

    public static String transphereBytesToString(byte[] bytes){
        return Base64.getEncoder().encodeToString(bytes);
    }

    public static byte[] transphereStringToBytes(String string){
        return string.getBytes();
    }

}
