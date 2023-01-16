# MA_Capstone_VendingMachine
Virtual vending machine application with command-line interface allowing users to deposit money, choose a product, and return the correct change. Inventory is loaded via a text file and transactions are logged to a separate text file.

## Module 1 Capstone - Vending Machine Software

An application developed for the newest vending machine distributor,
Umbrella Corp. They've released a new vending machine, Vendo-Matic 800, that's integrated
with everyone's bank accounts, allowing customers to purchase products from their computers for their convenience.

### Application features

1. The vending machine dispenses beverages, candy, chips, and gum.
2. A main menu displays when the software runs, presenting the following options:
    ```
    (1) Display Vending Machine Items
    (2) Purchase
    (3) Exit
    ```
3. The vending machine reads its inventory from an input file when the vending machine
starts.
4. The vending machine is automatically restocked each time the application runs.
5. When the customer selects "(1) Display Vending Machine Items", they're presented
with a list of all items in the vending machine with its quantity remaining:
    - Each vending machine product has a slot identifier and a purchase price.
    - Each slot in the vending machine has enough room for 5 of that product.
    - Every product is initially stocked to the maximum amount.
    - A product that has run out indicates that it's SOLD OUT.
6. When the customer selects "(2) Purchase", they're guided through the purchasing
process menu:
    ```
    Current Money Provided: $2.00
    
    (1) Feed Money
    (2) Select Product
    (3) Finish Transaction
    ```
7. The purchase process flow is as follows:
    1. Selecting "(1) Feed Money" allows the customer to repeatedly feed money into the
    machine in whole dollar amounts.
        - The "Current Money Provided" indicates how much money the customer
        has fed into the machine.
    2. Selecting "(2) Select Product" allows the customer to select a product to
    purchase.
        - Shows the list of products available and allows the customer to enter
        a code to select an item.
        - If the product code doesn't exist, the vending machine informs the customer and returns them
        to the Purchase menu.
        - If a product is currently sold out, the vending machine informs the customer and returns them to the
        Purchase menu.
        - If a customer selects a valid product, it's dispensed to the customer.
        - Dispensing an item prints the item name, cost, and the money
        remaining. Dispensing also returns a message:
          - All chip items print "Crunch Crunch, Yum!"
          - All candy items print "Munch Munch, Yum!"
          - All drink items print "Glug Glug, Yum!"
          - All gum items print "Chew Chew, Yum!"
        - After the machine dispenses the product, the machine updates its balance
        accordingly and return the customer to the Purchase menu.
    3. Selecting "(3) Finish Transaction" allows the customer to complete the
    transaction and receive any remaining change.
        - The machine returns the customer's money using nickels, dimes, and quarters
        (using the smallest amount of coins possible).
        - The machine's current balance updates to $0 remaining.
    4. After completing their purchase, the user returns to the "Main" menu to
    continue using the vending machine.
8. The vending machine logs all transactions to prevent theft from the vending machine.
   - Each purchase generates a line in a file called `Log.txt`.
   - The lines follow the format shown in the following example.
       - The first dollar amount is the amount deposited, spent, or given as change.
       - The second dollar amount is the new balance.
        ```
        01/01/2019 12:00:00 PM FEED MONEY: $5.00 $5.00 
        01/01/2019 12:00:15 PM FEED MONEY: $5.00 $10.00 
        01/01/2019 12:00:20 PM Crunchie B4 $1.75 $8.25 
        01/01/2019 12:01:25 PM Cowtales B2 $1.50 $6.75 
        01/01/2019 12:01:35 PM GIVE CHANGE: $6.75 $0.00
        ```
9. Classes are created to be "testable" classes. Console
input and output are limited to as few classes as possible. (WIP)
10. Sales Report
    - A "hidden" menu option on the main menu ("4") that writes to a sales
    report that shows the total sales since the machine started. The name of the
    file includes the date and time so each sales report is uniquely named.
11. Unit tests demonstrating that the code works correctly.
___
### Vending machine data file
The input file that stocks the vending machine products is a pipe `|` delimited file. Each line is a separate product in the file and follows this format:

| Column Name   | Description |
----------------|-------------|
| Slot Location | The slot location in the vending machine containing the product.   |
| Product Name  | The display name of the vending machine product.                   |
| Price         | The purchase price for the product.                                |
| Type          | The product type for this row.                                     |

For example:

```
A1|Potato Crisps|3.05|Chip
B1|Moonpie|1.80|Candy
B2|Cowtales|1.50|Candy
C1|Cola|1.25|Drink
```

**Input file in repository: `vendingmachine.csv`.**

 ---
### Sales report
The output sales report file is also pipe-delimited for consistency. Each line is a separate product with the number of sales for the applicable product. At the end of the report is a blank line followed by the **TOTAL SALES** dollar amount indicating the gross sales from the vending machine.
