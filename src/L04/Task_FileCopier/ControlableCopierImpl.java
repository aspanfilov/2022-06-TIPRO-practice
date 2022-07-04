package L04.Task_FileCopier;

import java.io.*;

public class ControlableCopierImpl implements Copier, Progressable, Cancelable{
    private final static String COPY_MARK = "_copy";

    private volatile int progress;
    private volatile boolean cancelFlag;

    @Override
    public int getProgress() {
        return this.progress;
    }

    @Override
    public void cancel() {
        this.cancelFlag = true;
    }

    @Override
    public boolean copy(String filePath, String destinationFolderPath) throws IOException {
        cancelFlag = false;
        progress = 0;

        File originalFile = new File(filePath);
        File destinationFolder = getDestinationFolder(destinationFolderPath);
        File newFile = new File(getNewFilePath(originalFile, destinationFolder));

        createNewFile(newFile);

        try(var inputStream = new BufferedInputStream(new FileInputStream(originalFile));
            var outputStream = new BufferedOutputStream(new FileOutputStream(newFile))) {

            long totalSize = originalFile.length();
            long onePercentStepCount = totalSize / 100;
            long stepCounter = 0;

            int chunk;
            while ((chunk = inputStream.read()) != -1 && !this.cancelFlag) {
                outputStream.write(chunk);
                stepCounter++;
                setProgress(stepCounter, onePercentStepCount);
            }
        }
        if (this.cancelFlag) {
            deleteFile(newFile);
            return false;
        }
        return true;
    }

    private void setProgress(long stepCounter, long onePercentStepCount) {
        if (stepCounter % onePercentStepCount == 0) {
            this.progress = (int) (stepCounter / onePercentStepCount);
        }
    }

    private File getDestinationFolder(String destinationFolderAddress) throws IOException {

        File destinationFolder = new File(destinationFolderAddress);

        if (!destinationFolder.isDirectory()) {
            throw new IOException("Incorrect destination folder: " + destinationFolderAddress);
        }

        return destinationFolder;
    }

    private String getNewFilePath(File originalFile, File destinationFolder) {
        String originalFilePath = originalFile.getAbsolutePath();
        String newFileName = originalFilePath.substring(originalFilePath.lastIndexOf(File.separatorChar));

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
