package ua.goit.java.exception;

public class InvalidKeyException extends Exception {
    private String detailError;

    public InvalidKeyException(String detailError) {
        this.detailError = detailError;
    }

    @Override
    public String toString() {
        return detailError;
    }
}
