package Characters;

import Robots.Robot;

public class User extends Guys {
    public Robot[] roboto;

    public User(String name) {
        super(name);
        roboto = new Robot[1]; // Initialize the array with one element

    }

}
