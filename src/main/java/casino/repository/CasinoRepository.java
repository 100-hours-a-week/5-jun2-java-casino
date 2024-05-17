package casino.repository;

import casino.domain.participant.Participant;
import casino.domain.participant.RoleType;

public interface CasinoRepository {
    Participant save(Participant participant);
    Participant update(Participant participant);
    Participant findByRoleType(RoleType roleType);
}
