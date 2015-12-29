package ru.round.Utils;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

/**
 * Created by GrishukovVM on 29.12.2015.
 */
public class fileOperations {

    /*copy files*/
    public static void copyFile(File sourceFile, File destFile) throws IOException {
        if(!destFile.exists()) {
            destFile.createNewFile();
        }

        FileChannel source = null;
        FileChannel destination = null;
        try {
            source = new RandomAccessFile(sourceFile,"rw").getChannel();
            destination = new RandomAccessFile(destFile,"rw").getChannel();

            long position = 0;
            long count    = source.size();

            source.transferTo(position, count, destination);
        }
        finally {
            if(source != null) {
                source.close();
            }
            if(destination != null) {
                destination.close();
            }
        }
    }
}
