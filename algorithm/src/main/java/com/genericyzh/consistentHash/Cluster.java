package com.genericyzh.consistentHash;

import java.util.ArrayList;
import java.util.List;

/**
 * @author genericyzh
 * @date 2018/6/24 21:24
 */
public abstract class Cluster {
    protected List<Node> nodes;

    public Cluster() {
        this.nodes = new ArrayList<>();
    }

    public abstract void addNode(Node node);

    public abstract void removeNode(Node node);

    public abstract Node getNode(String key);
}
