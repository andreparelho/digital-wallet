package br.com.digital_wallet.app.wallet.controller;

import br.com.digital_wallet.app.wallet.model.request.RequestAddAmountWallet;
import br.com.digital_wallet.app.wallet.model.response.ResponseAddAmountWallet;
import br.com.digital_wallet.app.wallet.service.WalletService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static br.com.digital_wallet.app.wallet.constants.WalletConstants.WALLET_ENDPOINT;

@RestController
@RequestMapping(WALLET_ENDPOINT)
public class WalletController {
    private final WalletService walletService;

    public WalletController(WalletService walletService) {
        this.walletService = walletService;
    }

    @PostMapping
    public ResponseEntity<ResponseAddAmountWallet> addAmountToWallet(@RequestBody RequestAddAmountWallet request) {
        var response = this.walletService.addAmount(request);

        return new ResponseEntity<>(response);
    }

}
