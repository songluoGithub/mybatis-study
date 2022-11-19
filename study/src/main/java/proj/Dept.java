package proj;

/**
 * @date: 2022/11/19 15:47
 * @author: luosong
 * @version: 1.0
 * @description: Dept
 */
public class Dept {
    private int id;
    private String name;
    private String tel;


    public Dept(int id, String name, String tel) {
        this.id = id;
        this.name = name;
        this.tel = tel;
    }

    public Dept(){

    }

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

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tel='" + tel + '\'' +
                '}';
    }
}
