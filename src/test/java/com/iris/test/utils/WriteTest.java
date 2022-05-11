package com.iris.test.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class WriteTest {

  private static File file;

  public static boolean createFile(String country) throws IOException {

    String path = "src/test/resources/"+country+new Date().getTime()+".txt";
    file = new File(path);

    return file.createNewFile();
  }

  public static void the(String any) throws IOException {
    FileWriter fw = new FileWriter(file, true);
    BufferedWriter bw = new BufferedWriter(fw);
    bw.append(any);
    bw.close();
  }

}
