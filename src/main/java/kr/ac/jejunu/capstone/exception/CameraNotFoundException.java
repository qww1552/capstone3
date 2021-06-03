package kr.ac.jejunu.capstone.exception;

public class CameraNotFoundException extends RuntimeException {
    public CameraNotFoundException(String message) {
        super(message);
    }
}
