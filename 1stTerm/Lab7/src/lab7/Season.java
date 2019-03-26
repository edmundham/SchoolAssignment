package lab7;

public enum Season {
    
    winter("December through February"),
    spring("March through May"),
    summer("June Through August"),
    fall("September through November");
    
    private String months;
    
    Season(String months) {
        this.months = months;
    }
    
    public String getSpan() {
        return months;
    }
}
