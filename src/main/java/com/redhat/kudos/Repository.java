package com.redhat.kudos;

import java.util.HashMap;
import java.util.Map;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Repository {

    public static final Map<String, Integer> KUDOS_DB = new HashMap<String, Integer>();

    public void addKudoTo(String userEmail) {
        var kudos = 1;
        try {
            kudos = KUDOS_DB.get(userEmail).intValue() +1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        KUDOS_DB.put(userEmail, kudos);
    }

    public Map<String, Integer> getAllKudos() {
        return KUDOS_DB;
    }

    public Integer getKudosFrom(String userEmail) {
        return KUDOS_DB.get(userEmail);
    }

    public void deleteKudoFrom(String userEmail) {
        KUDOS_DB.remove(userEmail);
    }

}
