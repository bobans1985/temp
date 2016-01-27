package ru.round.Utils;

import javax.swing.*;
import java.io.File;

/**
 * Created by GrishukovVM on 27.01.2016.
 */
public interface IPrefSettingsReadme {

    static final String DIRFROMREADME  = "dirfromreadme";
    static final String DIRTOREADME  = "dirtoreadme";
    static final String DEFAULTDIR = new File(".").toString();

    String GetDirFromReadme();
    String GetDirToReadme();
    void SetDirFromReadme(JFileChooser chooser);
    void SetDirToReadme(JFileChooser chooser);
    void SetDirFromReadme(String pathfrom);
    void SetDirToReadme(String pathto);

}
