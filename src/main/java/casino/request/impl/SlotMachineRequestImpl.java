package casino.request.impl;

import casino.request.view.GameInputView;
import casino.request.SlotMachineRequest;

class SlotMachineRequestImpl implements SlotMachineRequest {

    private final GameInputView gameInputView;

    public SlotMachineRequestImpl(GameInputView gameInputView) {
        this.gameInputView = gameInputView;
    }

    // Slot Machine
    @Override
    public boolean getSlotMachinePayment() {
        return gameInputView.readSlotMachinePayment();
    }

    @Override
    public boolean getRetryGame() {
        return gameInputView.readRetryGame();
    }

}