package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Pratik on 26-Nov-16.
 */

public class ActorContact {

    private List<Actor> actors = new ArrayList<Actor>();
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     * The actors
     */
    public List<Actor> getActors() {
        return actors;
    }

    /**
     *
     * @param actors
     * The actors
     */
    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
}
