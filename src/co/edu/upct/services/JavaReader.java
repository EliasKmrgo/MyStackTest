package co.edu.upct.services;

import java.util.List;

public class JavaReader {
    private List<String> javaFileinStrig;
    private ManagerFilesServices mfs = new ManagerFilesServices();
    
    public JavaReader(String fileName) {
        mfs.setFileName(fileName);
        try {
            javaFileinStrig = mfs.extractStrings();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void showInfo(){
        for (String string : javaFileinStrig) {
            System.out.println(string);
        }
    }
}
