package com.worstbuy.model;

import java.util.*;

public class Tags {
    private Map<String, PriorityQueue<Tag>> tagsMap;

    public Tags(Map<String, PriorityQueue<Tag>> tagsMap) {
        this.tagsMap = tagsMap;
    }

    public boolean addTag(String type, Tag tag){
        if(tagsMap.containsKey(type)){
            tagsMap.get(type).add(tag);
            return true;
        }

        return false;
    }

    public List<Tag> getMostUsedByType(String type, int num){
        List<Tag> temp = new ArrayList<>();
        PriorityQueue<Tag> pq = tagsMap.get(type);
        num = Math.min(num, pq.size());
        for(int i = 0; i < num; i++){
            temp.add(pq.poll());
        }

        return temp;
    }

    public void removeTag(String type, Tag tag){
        if(tagsMap.containsKey(type))
            tagsMap.get(type).remove(tag);
    }

    public void addTagList(String type, Collection<Tag> tags){
        if(tagsMap.containsKey(type)) {
            for (Tag tag : tags) {
                addTag(type, tag);
            }
        }else{
            PriorityQueue<Tag> pq = new PriorityQueue<>(Comparator.comparingLong(Tag::getVal));
            pq.addAll(tags);
            tagsMap.put(type, pq);
        }
    }

}
