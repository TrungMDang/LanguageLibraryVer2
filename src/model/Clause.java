package model;

/**
 * Clause.
 * @author Viktoriya Celik
 * @version 12/02/15
 *
 */
public class Clause {
    
    private String title;
    private String keyword;
    private String description;
    private String text;
    
    
    public Clause(String title, String keyword, String description, String text){
        super();
        this.title = title;
        this.keyword = keyword;
        this.description = description;
        this.text = text;      
    }


    public String gettitle() {
        return title;
    }

    public void settitle(String title) {
        this.title = title;
    }

    public String getkeyword() {
        return keyword;
    }

    public void setkeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getdescription() {
        return description;
    }

    public void setdescription(String description) {
        this.description = description;
    }

    public String gettext() {
        return text;
    }

    public void settext(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return String
                .format("Title [title=%s, keyword=%s, description=%s, text=%s]",
                        title, keyword, description, text);
    }
        
}
