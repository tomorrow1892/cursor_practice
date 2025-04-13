package com.example.cms.application.form;

import javax.validation.constraints.NotBlank;
import com.example.cms.domain.model.Content;

public class ContentForm {
    private Long id;
    @NotBlank(message = "名前は必須です")
    private String name;
    private String description;
    private String origin;
    private String color;
    private String shape;
    private String size;
    private String weight;
    private String material;
    private boolean active;

    public ContentForm() {}

    public ContentForm(Content content) {
        this.id = content.getId();
        this.name = content.getName();
        this.description = content.getDescription();
        this.origin = content.getOrigin();
        this.color = content.getColor();
        this.shape = content.getShape();
        this.size = content.getSize();
        this.weight = content.getWeight();
        this.material = content.getMaterial();
        this.active = content.isActive();
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getOrigin() { return origin; }
    public void setOrigin(String origin) { this.origin = origin; }
    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }
    public String getShape() { return shape; }
    public void setShape(String shape) { this.shape = shape; }
    public String getSize() { return size; }
    public void setSize(String size) { this.size = size; }
    public String getWeight() { return weight; }
    public void setWeight(String weight) { this.weight = weight; }
    public String getMaterial() { return material; }
    public void setMaterial(String material) { this.material = material; }
    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
} 