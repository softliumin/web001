package cc.sharper.bootdemo002.domain;

import java.io.Serializable;

public class User  implements Serializable{

    private static final long serialVersionUID = 4919105134123672727L;

    private int age;
    private String name;

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}
