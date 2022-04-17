package com.company;

import java.awt.event.*;
class WindowCloser extends WindowAdapter{
    public void windowClosing(WindowEvent evt) {
        System.exit(0);
    }
}
