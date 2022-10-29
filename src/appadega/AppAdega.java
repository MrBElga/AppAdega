
package appadega;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class AppAdega {

    public static void main(String[] args) {
        Adega adega=new Adega();
        Vinho v1= new Vinho("tinto", "Sangue de boi", 900);
        Vinho v2 = new Vinho("branco","Chapinha",750,LocalDate.of(1970, 9, 8),8.99);
        adega.addVinho(0, 1, v1);
        adega.addVinho(2, 2, v2);
        for(int i=0;i<100;i++)
           adega.addVinho(new Vinho("branco","Forqueta",3600));
        System.out.println(adega);
//        List <Vinho> vinhos=new ArrayList();
//        vinhos.add(new Vinho("branco","Forqueta",3600));
//        vinhos.add(v2);
//        vinhos.add(v1);
//
//        //System.out.println(vinhos.indexOf(v2));
//        Collections.sort(vinhos);
//        for (Vinho v : vinhos)
//            System.out.println(v);
//        System.out.println(Collections.max(vinhos));
    }
    
}
