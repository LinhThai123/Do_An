package vn.techmaster.websitenoithat.Entity;

public enum Status {
    CONHANG("Còn hàng") ,
    HETHANG("Hết hàng") ;
    public final String label;
    private Status(String label) {
        this.label = label;
    }
}
