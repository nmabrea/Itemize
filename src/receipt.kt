import java.time.LocalDate

// class that inherits a delegation by GroceryReceipt, and functions from MakeItemize and Expense()
open class Receipt(private var shop: String = "",
                   private var date: LocalDate? = null,
                   var personInCharge: Adult? = null) : RecordListType by GroceryReceipt, MakeRecord {


    override fun makeRecord() {

        println("Enter store name:")
        shop = ShopName.name
        println(shop)

        date = RecordDate.date
        println(date)

        println("Record Type: ${GroceryReceipt.receiptType().type}")
    }
}


