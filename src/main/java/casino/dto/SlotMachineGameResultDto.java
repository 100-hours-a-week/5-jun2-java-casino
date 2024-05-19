package casino.dto;

import casino.domain.game.slotmachine.SlotMachineResult;

public record SlotMachineGameResultDto(SlotMachineResult result, int[] numbers) {
}
