package L04.Ch2_MultiThreading.P04_Volatile.VolatileTest2;

import java.io.*;

public class CopierImpl implements Copier, Cancelable {
    private final static String COPY_MARK = "_copy";

//    private volatile boolean cancelFlag;
    private boolean cancelFlag;

    @Override
    public void cancel() {
        this.cancelFlag = true;
    }

//    @Override
//    public boolean copy(String filePath, String destinationFolderPath) throws IOException {
//        int result = 0;
//        while (!this.cancelFlag) {
//            result++;
//        }
//        System.out.println("result = " + result);
//        return true;
//    }

    @Override
    public boolean copy(String filePath, String destinationFolderPath) throws IOException {
        cancelFlag = false;

        File originalFile = new File(filePath);
        File destinationFolder = getDestinationFolder(destinationFolderPath);
        File newFile = new File(getNewFilePath(originalFile, destinationFolder));

        createNewFile(newFile);

        try(var inputStream = new BufferedInputStream(new FileInputStream(originalFile));
            var outputStream = new BufferedOutputStream(new FileOutputStream(newFile))) {

            int chunk;
            while (!this.cancelFlag) {
//                chunk = inputStream.read();
//                outputStream.write(4);
            }
        }

//        int result = 0;
//        while (!this.cancelFlag) {
//            result++;
//        }
//        System.out.println("result = " + result);

        if (this.cancelFlag) {
            deleteFile(newFile);
            return false;
        }
        return true;
    }


//    @Override
//    public boolean copy(String filePath, String destinationFolderPath) throws IOException {
//        cancelFlag = false;
//
//        File originalFile = new File(filePath);
//        File destinationFolder = getDestinationFolder(destinationFolderPath);
//        File newFile = new File(getNewFilePath(originalFile, destinationFolder));
//
//        createNewFile(newFile);
//
//        try(var inputStream = new BufferedInputStream(new FileInputStream(originalFile));
//            var outputStream = new BufferedOutputStream(new FileOutputStream(newFile))) {
//
//            int chunk;
//            while ((chunk = inputStream.read()) != -1 && !this.cancelFlag) {
//                outputStream.write(chunk);
//            }
//        }
//        if (this.cancelFlag) {
//            deleteFile(newFile);
//            return false;
//        }
//        return true;
//    }

    private File getDestinationFolder(String destinationFolderAddress) throws IOException {

        File destinationFolder = new File(destinationFolderAddress);

        if (!destinationFolder.isDirectory()) {
            throw new IOException("Incorrect destination folder: " + destinationFolderAddress);
        }

        return destinationFolder;
    }

    private String getNewFilePath(File originalFile, File destinationFolder) {
        String originalFilePath = originalFile.getAbsolutePath();
        String newFileName =
                originalFilePath.substring(originalFilePath.lastIndexOf(File.separatorChar));

        int pointIndex = newFileName.indexOf(".");
        if (pointIndex == -1) {
            newFileName = newFileName + COPY_MARK;
        } else {
            newFileName = newFileName.substring(0, pointIndex)
                    + COPY_MARK + newFileName.substring(pointIndex);
        }
        return destinationFolder.getAbsolutePath() + newFileName;
    }

    private void createNewFile(File newFile) throws IOException {
        if (newFile.exists()) {
            deleteFile(newFile);
        }
        var isNewFileCreated = newFile.createNewFile();
        if (!isNewFileCreated) {
            throw new IOException("Failed to create copy: " + newFile.getAbsolutePath());
        }
    }

    private void deleteFile(File file) throws IOException {
        var isDeleted = file.delete();
        if (!isDeleted) {
            throw new IOException("Failed to delete file: " + file.getAbsolutePath());
        }
    }



}
