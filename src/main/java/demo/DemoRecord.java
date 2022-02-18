package demo;

public class DemoRecord {

    public static void main(String[] args) {
//        Data data = new Data(1, "Yuranan");
        Data data2 = new Data();
        data2.setId(1);
    }
}

//record Data(int id, String name){
//    this.id = id;
//}

class Data {
    int id;
    String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}