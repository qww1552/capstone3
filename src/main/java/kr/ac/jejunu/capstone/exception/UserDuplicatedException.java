package kr.ac.jejunu.capstone.exception;

public class UserDuplicatedException extends RuntimeException{
    public UserDuplicatedException(String message) {
        super(message);
    }
}
