package co.edu.umanizales.tads.model;
import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;



@Data

    public class ListSE {
    private Node head;
    private int size;
    List<Kid> kids=new ArrayList<>();


//all the constructor said getters and setters


    public void add(Kid kid) {
        if (head != null) {
            Node temp = head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            /// Parado en el último
            Node newNode = new Node(kid);
            temp.setNext(newNode);
        } else {
            head = new Node(kid);
        }
        size++;
    }

    /* Adicionar al inicio
    si hay datos
    si
        meto al niño en un costal (nuevocostal)
        le digo a nuevo costal que tome con su brazo a la cabeza
        cabeza es igual a nuevo costal
    no
        meto el niño en un costal y lo asigno a la cabez
     */


    public void addToStart(Kid kid) {
        if (head != null) {
            Node newNode = new Node(kid);
            newNode.setNext(head);
            head = newNode;
        } else {
            head = new Node(kid);
        }
        size++;
    }


    /*algoritmo para adicionar en posicion
    primero saber el tamaño de la lista con un metodo que recorra  la lista hasta que no haya un niño siguiente y en cada vuelta del bucle se va contando
    luego se crea un meotdo donde recive el niño nuevo y en donde se quiere ser agregado
    si la posicion que se quiere es coherente con el tamaño de la lista
      entonces
        se crea el niño
         si la posicion donde se quiere adicionar es 0  lo que sera la cabeza entonces
            entonces  se llamara el metodo que agrega el niño al inicio
         en caso de que sea otra posicion diferente a 0
            entonces se crea un mensajero para que vaya una posicion antes de la pedida
                cuando se llegue a a la posicion entonces
                    se crea un nuevo nodo
                    y el siguiente niño del nuevo nodo sera lo siguiente que teniea el menesajero
                    y lo siguiente del mensjaero sera el nuevo nodo

        en caso de que la posicion no sea posible se agrega al final con un metood agregar

    * */

    public int Size() {
        int size = 0;
        Node temp = head;
        while (temp != null) {
            size++;
            temp = temp.getNext();

        }
        return size;
    }

    public void invert() {
        if (this.head != null) {
            ListSE listCp = new ListSE();
            Node temp = this.head;
            while (temp != null) {
                listCp.addToStart(temp.getData());
                temp = temp.getNext();
            }
            this.head = listCp.getHead();
        }
    }

    public void orderBoysToStart() {
        if (this.head != null) {
            ListSE listCp = new ListSE();
            Node temp = this.head;
            while (temp != null) {
                if (temp.getData().getGender() == 'M') {
                    listCp.addToStart(temp.getData());
                } else {
                    listCp.add(temp.getData());
                }

                temp = temp.getNext();
            }
            this.head = listCp.getHead();
        }
    }


    public void addInPosition(int position, Kid kid) {

        if (Size() >= position) {


            if (position == 0) {
                addToStart(kid);
            } else {
                Node temp = head;
                for (int i = 0; i < position - 1; i++) {
                    temp = temp.getNext();
                }
                Node newNode = new Node(kid);
                newNode.setNext(temp.getNext());
                temp.setNext(newNode);

            }
        } else {
            add(kid);
        }
    }

    /*
     * algoritmo para eliminar por id
     * se crea una mensajero que sea igual a la cabeza
     * y otro nodo el cual sera para indentificar al anterior nodo
     * lugo se recorre la lista solo en caso de que el mensajer tenga algun valor y en caso de no se haya encontrado el niño con ese id
     * a dentro del bucle el segudno nodo sera igual al mensajero y el mensajero para a otra niño asi hasta que termine el ciclo
     * en caso de que el mensajero no haya quedado vacio
     * entonces
     *       si el nodo previous  es null es porque al que se quiere eliminar es a la cabeza  entonces nunca entraron al bulce
     *           entonces la cabeza sera el valor que le seguia al mensajero o sea el valor sigueite a la cabeza
     *
     *
     *    */
//AQUI COMEINZA LOS CODIGOS DEL 1 AL 10
    //Esta parte diseñe este metodo para tener en cuenta
    // el tema de getLength para que no me salga un error (codigo 3)
    public int getLength() {
        Node temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.getNext();
        }
        return count;
    }

    //Este codigo es perteneciente al codigo numero 8
    public int getPosById(String id) {
        Node temp = head;
        int acum = 0;
        if (head != null) {
            while (temp != null && !temp.getData().getIdentification().equals(id)) {
                acum = acum + 1;
                temp = temp.getNext();
            }
        }
        return acum;
    }

    //Este codigo pertenece al codigo numero 8
    public Kid getKidById(String id) {
        Node temp = head;
        while (temp != null && !temp.getData().getIdentification().equals(id)) {
            temp = temp.getNext();
        }
        if (temp != null && temp.getData() != null) {
            Kid kid = new Kid(temp.getData().getIdentification(), temp.getData().getName(),
                    temp.getData().getAge(), temp.getData().getGender(), );
            return kid;
        } else {
            return null;
        }


    }

    public void deleteByIdentification(String identification) {
        Node temp = head;
        Node previousNode = null;

        while ((temp != null) && (temp.getData().getIdentification() != (identification))) {
            previousNode = temp;
            temp = temp.getNext();
        }
        if (temp != null) {
            if (previousNode == null) {
                head = temp.getNext();
            } else {
                previousNode.setNext(temp.getNext());
            }
        }

    }
    public Kid getKidByIdentification(String identification){
        for (Kid kid :kids){
            if (kid.getIdentification().equals(identification)){
                return kid;
            }
        }
        return null;
    }

    //Codigo punto  añadir en posicion para perder (3)
    public void addInPosForLose(Kid kid, int pos2) {
        Node temp = head;
        Node newNode = new Node(kid);
        int listLength = getLength();
        if (pos2 < 0 || pos2 >= listLength)//to do a validation and add the kid in the last position
            add(kid);
        if (pos2 == 0) {
            newNode.setNext(head);//to actualize the head
            head = newNode;

        } else {
            for (int i = 0; temp.getNext() != null && i < pos2 - 1; i++) {
                temp = temp.getNext();
            }
            newNode.setNext(temp.getNext());
            temp.setNext(newNode);
        }
    }

    //Este codigo es promediar todos las edades de los niños punto 5
    public double avergeAge() {
        double averageAge = 0;
        Node temp = this.head;
        if (this.head != null) {
            while (temp != null) {
                averageAge = averageAge + temp.getData().getAge();
                temp = temp.getNext();
            }

        }
        averageAge = averageAge / getLength();
        return averageAge;


    }

    //Aqui empieza el codigo de cantidad por niño en la ciudad 6
    public int getCountKidsByLocationCode(String code) {
        int count = 0;
        if (this.head != null) {
            Node temp = this.head;
            while (temp != null) {
                if (temp.getData().getLocation().getCode().equals(code)) {
                    count++;
                }
                temp = temp.getNext();
            }
        }
        return count;

//Codigo cambio de extremos (1)
        public void changeExtremes(){
            if (this.head != null && this.head.getNext() != null) {
                Node temp = this.head;
                while (temp.getNext() != null) {
                    temp = temp.getNext();
                }//temp está en el último
                Kid copy = this.head.getData();
                this.head.setData(temp.getData());
                temp.setData(copy);
            }


        }
// Codigo de perder posiciones punto 8
        public void losePositions(int lose){
            Node temp = head;
            int sum = 0;
            ListSE listSE1 = new ListSE();
            if (head != null) {
                while (temp != null) {
                    if (!temp.getData().getIdentification().equals(getKidById("123456"))) {
                        listSE1.add(temp.getData());
                        temp = temp.getNext();
                    } else {
                        temp = temp.getNext();
                    }
                }
            }
            sum = lose + getPosById("435");
            listSE1.addInPosForLose(getKidById("1234566"), sum);
            this.head = listSE1.getHead();
        }


        //Este codigo es para eliminar por edad (4)
        public void deleteByAge(byte age){
            Node temp = this.head;
            ListSE listSE = new ListSE();
            if (this.head != null) {
                while (temp != null) {
                    if (temp.getData().getAge() != age) {
                        listSE.addToStart(temp.getData());
                    }
                    temp = temp.getNext();
                }
                this.head = listSE.getHead();
            }
        }
//Cambio de posicion (5)
        public void move (int actualPlace, int finalPlace){
            Node prev = null;
            Node actual = head;

            for (int i = 1; i < actualPlace; i++) {
                prev = actual;
                actual = actual.getNext();

            }
            Node prevEnd = null;
            Node end = head;
            for (int i = 1; i < finalPlace; i++) {
                prevEnd = end;
                end = end.getNext();
            }
            if (prev == null) {
                head = actual.getNext();
            } else {
                prev.setNext(actual.getNext());
            }
            if (prev == null) {
                actual.setNext(end.getNext());
                end.setNext(actual);
            } else {
                prev.setNext(actual.getNext());
                actual.setNext(end.getNext());
                end.setNext(actual);
            }
        }
// añadir al principio (10)
        public void addToStartNameChar (){
            if (head != null) {
                Node temp = head;
                ListSE listSE = new ListSE();
                while (temp != null) {
                    if ((temp.getData().getName().startsWith("0"))) {
                        listSE.add(temp.getData());
                        temp = temp.getNext();

                    } else {
                        listSE.addToStart(temp.getData());
                        temp = temp.getNext();
                    }
                    temp = temp.getNext();

                }
                head = listSE.getHead();
            }
        }
//Este es un cosntructor para no tener error en el codigo 7

        public void addInPostValidations() {
        }
//Ganar posicicones (7)

        public String earnPositions( String id ,int earn){
            int sum=0;
            Node temp = head;
            ListSE listSE = new ListSE();
            if (head != null) {
                while (temp != null) {
                    if (!temp.getData().getIdentification().equals("12345")) {
                        listSE.add(temp.getData());

                    }
                    temp = temp.getNext();


                }
            }
            sum = earn - getPosById(id);
            listSE(getKidById(id), sum);
            this.head = listSE.getHead();

        }

        //Vemos esta parte para el tema de generar un reporte en esto
        public void generateAgeRangeReport(){
            int[] ageRanges = new int[8];
            // The age ranges are: 0-9, 10-19, 20-29, 30-39, 40-49, 50-59, 60-69, 70 or older.

            Node currentNode = head;

            while (currentNode != null) {
                age = currentNode.getData().getAge();

                if (age < 10) {
                    ageRanges[0]++;
                } else if (age < 20) {
                    ageRanges[1]++;
                } else if (age < 30) {
                    ageRanges[2]++;
                } else if (age < 40) {
                    ageRanges[3]++;
                } else if (age < 50) {
                    ageRanges[4]++;
                } else if (age < 60) {
                    ageRanges[5]++;
                } else if (age < 70) {
                    ageRanges[6]++;
                } else {
                    ageRanges[7]++;
                }

                currentNode = currentNode.getNext();
            }


        }
    }

    private void listSE(Kid kidById, int sum) {

    }
}







        







