package list;

public class CharLink {
    public char data;
    public CharLink next;
    public CharLink prev;

    public CharLink(char data) {
        this.data = data;
    }

    public CharLink() {
    }

    @Override
    public String toString() {
        return "CharLink [data=" + data + ", next=" + next + ", prev=" + prev + "]";
    }

}
