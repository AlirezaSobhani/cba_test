package alirezasobhani.example.com.cba.service.exception;

public class NoConnectivityException extends Exception {

    public NoConnectivityException() {
        super("no internet connection");
    }
}
