package casino.service.casino;

import casino.domain.participant.Participant;
import casino.domain.participant.RoleType;

public interface CasinoMainService {
    Participant saveParticipant(Participant participant);
    Participant updateParticipant(Participant participant);
    Participant findParticipantByRoleType(RoleType roleType);
}
