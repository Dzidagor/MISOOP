package model;

public class Specimen {
    private Long id;
    private String texture;
    private String structure;
    private String composition;
    private String area;
    private String paleo;

    public Specimen() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTexture() {
        return texture;
    }

    public void setTexture(String texture) {
        this.texture = texture;
    }

    public String getStructure() {
        return structure;
    }

    public void setStructure(String structure) {
        this.structure = structure;
    }

    public String getComposition() {
        return composition;
    }

    public void setComposition(String composition) {
        this.composition = composition;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getPaleo() {
        return paleo;
    }

    public void setPaleo(String paleo) {
        this.paleo = paleo;
    }
}
