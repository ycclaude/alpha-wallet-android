package com.alphawallet.app.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.alphawallet.app.interact.FetchTokensInteract;
import com.alphawallet.app.interact.FindDefaultNetworkInteract;
import com.alphawallet.app.interact.GenericWalletInteract;
import com.alphawallet.app.router.TransferTicketDetailRouter;
import com.alphawallet.app.service.AssetDefinitionService;
import com.alphawallet.app.service.TokensService;

/**
 * Created by James on 16/02/2018.
 */

public class TransferTicketViewModelFactory implements ViewModelProvider.Factory {

    private final FindDefaultNetworkInteract findDefaultNetworkInteract;
    private final TokensService tokensService;
    private final GenericWalletInteract genericWalletInteract;
    private final TransferTicketDetailRouter transferTicketDetailRouter;
    private final AssetDefinitionService assetDefinitionService;

    public TransferTicketViewModelFactory(
            TokensService tokensService,
            GenericWalletInteract genericWalletInteract,
            FindDefaultNetworkInteract findDefaultNetworkInteract,
            TransferTicketDetailRouter transferTicketDetailRouter,
            AssetDefinitionService assetDefinitionService) {
        this.tokensService = tokensService;
        this.genericWalletInteract = genericWalletInteract;
        this.findDefaultNetworkInteract = findDefaultNetworkInteract;
        this.transferTicketDetailRouter = transferTicketDetailRouter;
        this.assetDefinitionService = assetDefinitionService;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new TransferTicketViewModel(tokensService, genericWalletInteract, findDefaultNetworkInteract, transferTicketDetailRouter, assetDefinitionService);
    }
}
