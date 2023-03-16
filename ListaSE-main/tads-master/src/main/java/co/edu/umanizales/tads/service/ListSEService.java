package co.edu.umanizales.tads.service;
import co.edu.umanizales.tads.model.Kid;
import co.edu.umanizales.tads.model.ListSE;
import lombok.Data;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

import java.util.List;

@Service
@Data
public class ListSEService {


    private ListSE kids;


    public ListSEService() {


        ListSE listSE = new ListSE();
        List<Kid>kidList=new ArrayList<>();

        kids.add(new Kid("12", "Jheferson", (byte) 18, "Manizales",'M'));
        kids.add(new Kid("13", "Santiago", (byte) 20, "pereira",'M'));
        kids.add(new Kid("1178", "Ana", (byte) 19, "Medellin",'F'));
        kids.add(new Kid("189", "Sebastian", (byte) 40, "Santander",'M'));
        kids.add(new Kid("847", "Nicolas", (byte) 35, "Bogota",'M'));
        kids.add(new Kid("678", "Tomas", (byte) 80, "Armenia",'M'));
        kids.add(new Kid("1234", "Gabriel", (byte) 12, "Cartagena",'M'));


    }

    public double averageAge() {
        return kids.averageAge();


    }
}







