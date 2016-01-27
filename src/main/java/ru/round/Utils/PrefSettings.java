package ru.round.Utils;

import javax.swing.*;
import java.util.prefs.Preferences;

/**
 * Created by GrishukovVM on 27.01.2016.
 */
public class PrefSettings implements IPrefSettingsReadme{

    Preferences userPrefs = Preferences.userNodeForPackage(PrefSettings.class);
    static final String ROOTNODEPREF = "bankround";
    public PrefSettings() {
        this.userPrefs = Preferences.userRoot().node(ROOTNODEPREF);
        System.out.println("Constructor PrefSettings is init");
    }

    public String GetDirFromReadme() {
        System.out.println("GetDirFromReadme = " + userPrefs.get(DIRFROMREADME,DEFAULTDIR));
        return userPrefs.get(DIRFROMREADME,DEFAULTDIR).length()>0 ? userPrefs.get(DIRFROMREADME,DEFAULTDIR) :  DEFAULTDIR;
    }

    public String GetDirToReadme() {
        System.out.println("GetDirToReadme = " + userPrefs.get(DIRTOREADME,DEFAULTDIR));
        return userPrefs.get(DIRTOREADME,DEFAULTDIR).length()>0 ? userPrefs.get(DIRTOREADME,DEFAULTDIR) :  DEFAULTDIR;
    }

    public void SetDirFromReadme(JFileChooser chooser) {
        System.out.println("SetDirFromReadmeJ = " + (chooser.getSelectedFile()!=null ?  chooser.getSelectedFile().getParent() : "null, usage old dir") );
        if (chooser.getSelectedFile()!=null) {
            userPrefs.put(DIRFROMREADME, chooser.getSelectedFile().getParent());
        }
    }

    public void SetDirToReadme(JFileChooser chooser) {
        System.out.println("SetDirToReadmeJ = " + (chooser.getSelectedFile()!=null ?  chooser.getSelectedFile().getAbsolutePath() : "null, usage old dir") );
        if (chooser.getSelectedFile()!=null) {
            userPrefs.put(DIRTOREADME, chooser.getSelectedFile().getAbsolutePath());
        }
    }

    public void SetDirFromReadme(String pathfrom) {
        userPrefs.put(DIRFROMREADME,pathfrom);
    }

    public void SetDirToReadme(String pathto) {
        userPrefs.put(DIRTOREADME,pathto);
    }
}
