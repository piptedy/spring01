public class Book {
    private Integer id;
    private String author;
    private String title;
    private double price;
    private Integer sales;

    public Book() {
        System.out.println("对象被创建");
    }

    public Book(Integer id, String author, String title, double price, Integer sales) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.price = price;
        this.sales = sales;
    }

    public Book(Integer id, String author, String title, Integer sales) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.sales = sales;
    }

    public Book(Integer id, String author, String title, double price) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        System.out.println("对象被赋值");
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }

//    @Override
//    public String toString() {
//        return "Book{" +
//                "id=" + id +
//                ", author='" + author + '\'' +
//                ", title='" + title + '\'' +
//                ", price=" + price +
//                ", sales=" + sales +
//                '}';
//    }
    public void init(){
        System.out.println("对象被初始化了");
    }
    public void destory(){
        System.out.println("对象被销毁");
    }
}
