package kasad0r.petclinic.services.map;

import kasad0r.petclinic.model.BaseEntity;

import java.util.*;

public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> {

    protected Map<Long, T> map = new HashMap<>();

    Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    T findById(ID id) {
        return map.get(id);
    }

    T save(T t) {
        if (t != null) {
            if (t.getId() == null)
                t.setId(getNextId());

            map.put(t.getId(), t);
        } else throw new RuntimeException("Object can`t be null");
        return t;
    }

    void deleteById(ID id) {
        map.remove(id);
    }

    void delete(T obj) {
        map.entrySet().removeIf(ent -> ent.getValue().equals(obj));
    }

    private Long getNextId() {
        return Collections.max(map.keySet()) + 1;
    }
}
