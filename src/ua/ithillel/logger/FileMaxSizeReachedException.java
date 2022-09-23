package ua.ithillel.logger;

public class FileMaxSizeReachedException extends RuntimeException {
    public FileMaxSizeReachedException(long currentSize, long maxSize) {
        super(String.format("Allowed file size: %d kb. Current file size: %d kb.", maxSize, currentSize));
    }
}
