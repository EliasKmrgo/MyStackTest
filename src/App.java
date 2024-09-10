import co.edu.upct.services.JavaReader;

public class App {
    public static void main(String[] args) throws Exception {
        JavaReader jr = new JavaReader("src\\JavaFileTest.java");
        jr.showInfo();
        System.out.println("---------------------------------------------------------");
        System.out.println(" Fin del archivo");


    }
}
