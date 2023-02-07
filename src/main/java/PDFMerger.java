import org.apache.pdfbox.multipdf.PDFMergerUtility;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class PDFMerger {
    public static void mergePDF(File pathFrom, String pathTo) throws IOException {
        String[] listOfFolders = pathFrom.list();

        assert listOfFolders != null;
        for (String dir : listOfFolders) {
            String files = pathFrom + "/" + dir;
            String name = files + ".pdf";

            boolean t1 = false, t2 = false;
            File folder = new File(files);
            File[] listOfFiles = folder.listFiles();

            for (File file : listOfFiles) {
                System.out.println(file);
                if (file.isFile() & file.getName().contains("KM_1")) {
                    t1 = true;
                }
                if (file.isFile() & file.getName().contains("KM_2")) {
                    t2 = true;
                }
            }

            System.out.println(t1);
            System.out.println(t2);

            if (t1) {
                filesForMerging(files);
                String dest2 = pathTo + dir + "/Креслення PDF/" + dir + ".pdf";

                File g = new File(pathTo + dir + "/Креслення PDF");
                if (!(g).exists()) {
                    g.mkdir();
                }
                Files.move(Path.of(name), Path.of(dest2), StandardCopyOption.REPLACE_EXISTING);
                System.out.println(files);
            }

            if (t2) {
                filesForMerging2(files);
                String dest = pathTo + dir + "/Ескізи для менеджера/" + dir + ".pdf";

                File p = new File(pathTo + dir + "/Ескізи для менеджера");
                if (!(p).exists()) {
                    p.mkdir();
                }
                Files.move(Path.of(name), Path.of(dest), StandardCopyOption.REPLACE_EXISTING);
            }

            deleteDirectory(new File(files));
        }
    }

    public static void filesForMerging(String path) throws IOException {
        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();

        PDFMergerUtility ut = new PDFMergerUtility();

        assert listOfFiles != null;
        for (File file : listOfFiles) {
            if (file.isFile() & !file.getName().contains("KM_2")) {
                ut.addSource(path + "/" + file.getName());
            }
        }

        ut.setDestinationFileName(path + ".pdf");
        ut.mergeDocuments();
        System.out.println("Created  " + path + ".pdf");
    }

    public static void filesForMerging2(String path) throws IOException {
        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();

        PDFMergerUtility ut = new PDFMergerUtility();

        assert listOfFiles != null;

        for (File file : listOfFiles) {
            if (file.isFile() & file.getName().contains("KM_2")) {
                ut.addSource(path + "/" + file.getName());
            }
        }

        ut.setDestinationFileName(path + ".pdf");
        ut.mergeDocuments();
        System.out.println("Created  " + path + ".pdf");
    }

    static public boolean deleteDirectory(File path) {
        if (path.exists()) {
            File[] files = path.listFiles();
            for (int i = 0; i < files.length; i++) {
                if (files[i].isDirectory()) {
                    deleteDirectory(files[i]);
                } else {
                    files[i].delete();
                }
            }
        }
        return (path.delete());
    }
}
