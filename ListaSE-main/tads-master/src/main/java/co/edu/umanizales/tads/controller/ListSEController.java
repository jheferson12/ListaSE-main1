package co.edu.umanizales.tads.controller;
import co.edu.umanizales.tads.model.Kid;
import co.edu.umanizales.tads.service.ListSEService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/lists")
public class ListSEController {


   List<Kid>listKid1=new ArrayList<>();

//En esta parte del codigo vemos que el getMaping sirve para enviar el HTTP o la url
    @GetMapping(path = "/kid/{age}")
    
    public ResponseEntity<Void>addKid(@PathVariable byte age){
        listKid1.add(new Kid("123456","Jose",(byte)12,"Manizales",'M'));
        return ResponseEntity.ok().build();
    }
    private ListSEService listKid;
    //En este codigo vamos a ver
    @GetMapping(path = "/Average-age")
    public ResponseEntity<Double> getaverageAge() {
         double averageAge = listKid.averageAge();
        return ResponseEntity.ok(averageAge);

    }

    @GetMapping(path = "/CountskidByCity")
    public Map<String,Integer>countKidsByCity(){
        Map<String,Integer>Result=countKidsByCity();
        return Result;
    }



    }











