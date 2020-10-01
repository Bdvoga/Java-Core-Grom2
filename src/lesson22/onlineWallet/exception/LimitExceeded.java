package lesson22.onlineWallet.exception;

public class LimitExceeded extends BadRequestException {

    public LimitExceeded(String message) {
        super(message);
    }
}
