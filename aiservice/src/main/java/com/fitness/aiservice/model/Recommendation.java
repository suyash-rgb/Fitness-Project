package com.fitness.aiservice.model;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "recommendations")
public class Recommendation {

    @Id
    private String id;
    private String activityId;
    private String userId;
    private String actiityType;
    private String recommendation;
    private List<String> improvements;
    private List<String> suggestions;
    private List<String> safety;

    @CreatedDate
    private LocalDateTime createdAt;

    private Recommendation(RecommendationBuilder builder){
        this.id = builder.id;
        this.activityId = builder.actiityType;
        this.userId = builder.userId;
        this.actiityType = builder.actiityType;
        this.recommendation = builder.recommendation;
        this.improvements = builder.improvements;
        this.suggestions = builder.suggestions;
        this.safety = builder.safety;
    }

    //builder
    public static class RecommendationBuilder{
        private String id;
        private String activityId;
        private String userId;
        private String actiityType;
        private String recommendation;
        private List<String> improvements;
        private List<String> suggestions;
        private List<String> safety;
        private LocalDateTime createdAt;

        public RecommendationBuilder id(String id) {
            this.id = id;
            return this;
        }

        public RecommendationBuilder activityId(String activityId) {
            this.activityId = activityId;
            return this;
        }

        public RecommendationBuilder userId(String userId) {
            this.userId = userId;
            return this;
        }

        public RecommendationBuilder recommendation(String recommendation) {
            this.recommendation = recommendation;
            return this;
        }

        public RecommendationBuilder improvements(List<String> improvements) {
            this.improvements = improvements;
            return this;
        }
        public RecommendationBuilder suggestions(List<String> suggestions) {
            this.suggestions = suggestions;
            return this;
        }
        public RecommendationBuilder safety(List<String> safety) {
            this.safety = safety;
            return this;
        }

        public RecommendationBuilder createdAt(LocalDateTime createdAt){
            this.createdAt = createdAt;
            return this;
        }
    }

    public static RecommendationBuilder builder() {
        return new RecommendationBuilder();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getActiityType() {
        return actiityType;
    }

    public void setActiityType(String actiityType) {
        this.actiityType = actiityType;
    }

    public String getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(String recommendation) {
        this.recommendation = recommendation;
    }

    public List<String> getImprovements() {
        return improvements;
    }

    public void setImprovements(List<String> improvements) {
        this.improvements = improvements;
    }

    public List<String> getSuggestions() {
        return suggestions;
    }

    public void setSuggestions(List<String> suggestions) {
        this.suggestions = suggestions;
    }

    public List<String> getSafety() {
        return safety;
    }

    public void setSafety(List<String> safety) {
        this.safety = safety;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Recommendation() {
    }

    public Recommendation(String id, String activityId, String userId, String actiityType, String recommendation, List<String> improvements, List<String> suggestions, List<String> safety, LocalDateTime createdAt) {
        this.id = id;
        this.activityId = activityId;
        this.userId = userId;
        this.actiityType = actiityType;
        this.recommendation = recommendation;
        this.improvements = improvements;
        this.suggestions = suggestions;
        this.safety = safety;
        this.createdAt = createdAt;
    }


}
