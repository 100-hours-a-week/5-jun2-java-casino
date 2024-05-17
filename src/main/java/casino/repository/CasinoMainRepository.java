package casino.repository;

import casino.domain.participant.Dealer;
import casino.domain.participant.Participant;
import casino.domain.participant.Player;
import casino.domain.participant.RoleType;
import java.util.LinkedHashMap;
import java.util.Map;

public class CasinoMainRepository implements CasinoRepository {
    private static final CasinoMainRepository instance = new CasinoMainRepository();
    private static final Map<RoleType, Participant> store = new LinkedHashMap<>();

    private CasinoMainRepository() {
    }

    public static CasinoMainRepository getInstance() {
        return instance;
    }

    @Override
    public Participant save(Participant participant) {
        if (participant.isPlayer()) {
            store.put(RoleType.PLAYER, (Player) participant);
            return (Player) participant;
        }
        store.put(RoleType.DEALER, (Dealer) participant);
        return (Dealer) participant;
    }

    @Override
    public Participant update(Participant participant) {
        try {
            if (participant.isPlayer()) {
                Participant findParticipant = store.get(RoleType.PLAYER);
                store.put(RoleType.PLAYER, participant);
                return (Player) participant;
            }
            Participant findParticipant = store.get(RoleType.DEALER);
            store.put(RoleType.DEALER, participant);
            return (Dealer) participant;
        } catch (Exception e) {
            throw new IllegalStateException("[ERROR] 해당 참가자를 찾을 수 없습니다.\n");
        }
    }

    @Override
    public Participant findByRoleType(RoleType roleType) {
        try {
            Participant findParticipant = store.get(roleType);
            if (findParticipant.isPlayer()) {
                return (Player) findParticipant;
            }
            return (Dealer) findParticipant;
        } catch (Exception e) {
            throw new IllegalStateException("[ERROR] 해당 참가자를 찾을 수 없습니다.\n");
        }
    }
}
