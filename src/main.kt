import java.time.LocalDate

// Every list/receipt in this app will have one of the following types
enum class Type(val type: String) {
    GroceryStore("Groceries Purchased"),
    // GroceryList("Groceries To-Buy")
}

interface Name {  // every class will have a name
    val name: String
}

interface Date {
    val date: LocalDate
}

interface RecordListType {  // this type inherits the enum class Type
    fun receiptType(): Type
}

interface MakeRecord {  // every class will be able to do the functions in this interface

    fun makeRecord()  // creates the list/receipt



}

interface Expense {
    var label: String
    var cost: Double
    var quantity: Double
    var subCost: Double
    var formattedSubCost: String
    var essentialRating: Int?

    fun itemize()
}

interface Person {
    var personName: String
    var personID: Int
    var itemResponsibilities: MutableList<ExpenseItem>
    var expenseRating1: Double
    var expenseRating2: Double
    var expenseRating3: Double

    fun listPerson()
}

object ShopName : Name {  // inherits the name interface
    override val name: String = readLine().toString()
}

object RecordDate : Date {
    override val date: LocalDate = LocalDate.now()
}

object GroceryReceipt: RecordListType {  // delegated grocery receipt type
    override fun receiptType() = Type.GroceryStore
}

/*
// delegated grocery list type
object GroceryList: RecordListType{
    override fun receiptType() = Type.GroceryList
}
*/

fun main() {
    val groceryReceipt = Receipt()
    fun makeRecord() = groceryReceipt.makeRecord()
    makeRecord()



    val tripExpense = ExpenseItem("expense", 0.0, 0.0, "0.00")
    fun itemize() = tripExpense.itemize()
    while (tripExpense.label != "") {
        itemize()
    }
    val tripExpenseList = tripExpense.expenseList



    val userAccount = Adult("name", 0)
    fun userList() = userAccount.listPerson()
    while (userAccount.personName != "") {
        userList()
    }
    val userAccountList = userAccount.userParty



    val sortPile = Abacus(tripExpenseList, userAccountList, groceryReceipt)
    fun sortExpenses() = sortPile.divByPersonCost()
    sortExpenses()
    fun charge() = sortPile.chargeTo()
    charge()



    val selfReflection = ReflectionChart(userAccountList)
    fun reflectOnPurchases() = selfReflection.evaluate()
    reflectOnPurchases()
}



