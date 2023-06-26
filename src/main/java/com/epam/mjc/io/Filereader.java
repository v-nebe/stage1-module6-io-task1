package com.epam.mjc.io;

import java.io.*;
import java.util.Objects;


public class Filereader {
    static FileReader inputStream =null;
    public Profile getDataFromFile(File file) throws IOException {
        Profile profile = new Profile();
        try{

            inputStream = new FileReader(file);
            BufferedReader reader = new BufferedReader(inputStream);
            String line = reader.readLine();
            while (line != null) {
                System.out.println(line);
                String[] str = line.split(": ");
                if (Objects.equals(str[0], "Name")) {
                    profile.setName(str[1]);
                } else if (Objects.equals(str[0], "Age")) {
                    profile.setAge(Integer.valueOf(str[1]));
                } else if (Objects.equals(str[0], "Email")) {
                    profile.setEmail(str[1]);
                }else{
                    profile.setPhone(Long.valueOf(str[1]));
                }
                line = reader.readLine();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if(inputStream != null){
                inputStream.close();
            }
        }
        return profile;
    }
}
