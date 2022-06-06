package fis.java.finalproject.repository;

import fis.java.finalproject.model.Evidence;

import java.util.*;

public class EvidenceMemRepository implements IMemRepository<Evidence> {
    private Map<Long , Evidence > evidenceMap= new HashMap<>();
    private static EvidenceMemRepository instance= new EvidenceMemRepository();
    public static EvidenceMemRepository getInstance(){
        return  instance;
    }
    @Override
    public Evidence insertOrUpdate(Evidence evidence) {
        evidenceMap.put(evidence.getId(),evidence);
        return evidence;
    }

    @Override
    public Evidence findById(Long id) {
        Optional<Evidence> opt= Optional.ofNullable(evidenceMap.get(id));
        if(opt.isPresent()) return (Evidence) opt.get();
        else return null;
    }

    @Override
    public List<Evidence> findAll() {
        return new ArrayList<>(evidenceMap.values());
    }

    @Override
    public void deleteById(Long id) {
    evidenceMap.remove(id);
    }
}
