package mastertransmedia.datalife;

/**
 * Created by chloemolle on 03/07/2018.
 */

public class Cards {

    private String type;
    private String id;
    private String text;

    public Cards(String _type, String _id, String _text) {
        type = _type;
        id = _id;
        text = _text;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
