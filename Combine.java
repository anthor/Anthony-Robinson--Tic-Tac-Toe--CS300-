/* Copyright (c) 2009, Anthony Robinson
 * All Rights Reserved.
 *
 * FILE: Combine.java
 * 
 * This was originally meant to combine Logic.java and GUI.java
 * so they could interact with each other but now it serves simply
 * as a class to create an instance of the GUI. I am not as familiar
 * with Java as C++, but this is the only way i could get the import tttpackage
 * to work so that GUI.java could import Logic.java.
 *
 */

import tttpackage.*;

public class Combine {

public Combine()
    {

    }

public static void main(String[] args)
    {
    tttpackage.GUI test = new tttpackage.GUI();
    test.setVisible(true);
    }
}