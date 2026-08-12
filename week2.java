public class week2 {
    //InventoryCSVParser

    static void parseInventoryRecord(String csvLine) {

        String[] fields = csvLine.split(",");

        if (fields.length != 3) {

            System.out.println("Invalid Record");

        } else {

            String product = fields[0];
            String sku = fields[1];
            String quantity = fields[2];

            System.out.println(
                "Product: " + product +
                " | SKU: " + sku +
                " | Qty: " + quantity
            );
        }
    }

    public static void main(String[] args) {

        String csvLine =
            "Wireless Mouse,WM-2201,150";

        parseInventoryRecord(csvLine);
    }
}


    
