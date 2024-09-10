package co.edu.upct.services;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class ManagerFilesServices {

    private BufferedWriter bw;
    private BufferedReader br;
    private String fileName;
    private String fileNameToWrite;
    public String charsetName;

    public ManagerFilesServices() {
        this.charsetName = "UTF-8";
    }

    public void setCharsetName(String charsetName) {
        this.charsetName = charsetName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setFileNameToWrite(String fileNameToWrite) {
        this.fileNameToWrite = fileNameToWrite;
    }

    public List<String> extractStrings() throws Exception {
        this.openFile("r");
        List<String> list = this.readFile();
        this.close();
        return list;
    }

    public void writeFile(List<String> listToWrite) {
        try {
            File file = new File(fileNameToWrite);
            FileOutputStream fos = new FileOutputStream(file);
            OutputStreamWriter osw = new OutputStreamWriter(fos, this.charsetName);
            bw = new BufferedWriter(osw);
            for (String string : listToWrite) {
                bw.write(string + "\n");
            }
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private List<String> readFile() throws IOException {
        List<String> result = new ArrayList<>();

        String line;
        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(this.fileName), this.charsetName));
            while ((line = br.readLine()) != null) {
                result.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    private void openFile(String mode) throws UnsupportedEncodingException, FileNotFoundException {
        File file = new File(fileName);
        if (!file.exists()) {
            try {
                throw new Exception("NO EXISTE");
            } catch (Exception var3) {
                var3.printStackTrace();
            }
        } else {
            if (mode.equals("r")) {
                this.br = new BufferedReader(new InputStreamReader(new FileInputStream(file), this.charsetName));
            } else if (mode.equals("w")) {
                File fileToWrite = new File(fileNameToWrite);
                this.bw = new BufferedWriter(
                        new OutputStreamWriter(new FileOutputStream(fileToWrite), this.charsetName));
            }
        }
    }

    private void close() throws IOException {
        try {
            if (br != null) {
                br.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}