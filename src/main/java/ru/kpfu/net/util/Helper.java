package ru.kpfu.net.util;

import jakarta.xml.bind.DatatypeConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
        Stream<String> lines = Files.lines(Paths.get(path));
        String avatar = lines.collect(Collectors.joining(System.lineSeparator()));
        return avatar;
    }

    public static void createFile(Part avatarFile, HttpServletRequest req) throws ServletException, IOException {
        String fileName = avatarFile.getSubmittedFileName();
        for (Part part : req.getParts()) {
            part.write("D:\\uploadImages\\" + fileName);
        }
        System.out.println("File uploaded");
    }

//    public static boolean checkFields(String name, String email, String login, String password, String day, String month, String year, String sex){
//        boolean temp = true;
//        if(name.length() > 2){
//
//        }
//    }
}
