package com.epam.mjc.io;

import java.io.*;

public class Filereader {
    public Profile getDataFromFile(File file) {
        String name = null;
        int age = 0;
        String email = null;
        Long phone = null;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Name:")) {
                    name = line.substring(6).trim();
                } else if (line.startsWith("Age:")) {
                    age = Integer.parseInt(line.substring(5).trim());
                } else if (line.startsWith("Email:")) {
                    email = line.substring(7).trim();
                } else if (line.startsWith("Phone:")) {
                    phone = Long.parseLong(line.substring(7).trim());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new Profile(name, age, email, phone);
    }
}
