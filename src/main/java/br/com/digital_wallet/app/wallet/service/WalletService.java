package br.com.digital_wallet.app.wallet.service;

import br.com.digital_wallet.app.user.service.UserService;
import br.com.digital_wallet.app.wallet.model.request.RequestAddAmountWallet;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class WalletService {
    private final UserService userService;

    public WalletService(UserService userService) {
        this.userService = userService;
    }

    public HttpStatus addAmount(RequestAddAmountWallet request) {
        return HttpStatus.ACCEPTED;
    }
}
