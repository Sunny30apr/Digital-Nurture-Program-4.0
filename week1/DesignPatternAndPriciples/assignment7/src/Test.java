public class Test {
    public static void main(String[] args) throws Exception {
        StockMarket stockMarket = new StockMarket();

        Observer mobile1 = new MobileApp("Mobile_1");
        Observer mobile2 = new MobileApp("Mobile_2");
        Observer web1 = new WebApp("Web_1");
        Observer web2 = new WebApp("Web_2");

        stockMarket.register(web1);
        stockMarket.register(web2);
        stockMarket.register(mobile1);
        stockMarket.register(mobile2);

        stockMarket.setStockPrice(179.23);

        stockMarket.deregister(web2);

        stockMarket.setStockPrice(201.01);
    }
}
