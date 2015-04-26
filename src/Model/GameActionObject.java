package Model;


import java.io.Serializable;

/**
 * Created by Nilj on 26/04/15.
 */
public class GameActionObject implements Serializable {

    private int id;

    public GameActionObject(int id) {

        this.id = id;

    }

    public int getId() {

        return id;

    }
}
