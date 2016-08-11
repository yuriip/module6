package ua.goit.java.exception;

public class InvalidKey extends Exception {
    private String detailError;

    public InvalidKey(String detailError) {
        this.detailError = detailError;
    }

    @Override
    public String toString() {
        return detailError;
    }
}
