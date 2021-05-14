package kr.ac.jejunu.capstone.exception;

import java.util.function.Supplier;

public class CameraNotFoundException extends RuntimeException {
    public CameraNotFoundException(String message) {
        super(message);
    }
}
