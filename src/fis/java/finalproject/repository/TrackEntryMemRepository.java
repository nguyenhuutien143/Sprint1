package fis.java.finalproject.repository;

import fis.java.finalproject.model.Evidence;
import fis.java.finalproject.model.Storage;
import fis.java.finalproject.model.TrackEntry;

import java.util.*;

public class TrackEntryMemRepository implements IMemRepository<TrackEntry> {
    private Map<Long, TrackEntry> trackEntryMap= new HashMap<>();
    private static TrackEntryMemRepository instance= new TrackEntryMemRepository();
    public static TrackEntryMemRepository getInstance(){
        return instance;
    }
    @Override
    public TrackEntry insertOrUpdate(TrackEntry trackEntry) {
        trackEntryMap.put(trackEntry.getId(), trackEntry);
        return trackEntry;
    }

    @Override
    public TrackEntry findById(Long id) {
        Optional<TrackEntry> opt= Optional.ofNullable(trackEntryMap.get(id));
        if(opt.isPresent()) return (TrackEntry) opt.get();
        else return null;
    }

    @Override
    public List<TrackEntry> findAll() {

        return new ArrayList<>(trackEntryMap.values());
    }

    @Override
    public void deleteById(Long id) {

        trackEntryMap.remove(id);
    }
}
