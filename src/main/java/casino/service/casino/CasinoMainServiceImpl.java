package casino.service.casino;

import casino.domain.participant.Participant;
import casino.domain.participant.RoleType;
import casino.repository.CasinoRepository;

public class CasinoMainServiceImpl implements CasinoMainService {
    private final CasinoRepository repository;

    public CasinoMainServiceImpl(CasinoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Participant saveParticipant(Participant participant) {
        return repository.save(participant);
    }

    @Override
    public Participant updateParticipant(Participant participant) {
        return repository.update(participant);
    }

    @Override
    public Participant findParticipantByRoleType(RoleType roleType) {
        return repository.findByRoleType(roleType);
    }
}
